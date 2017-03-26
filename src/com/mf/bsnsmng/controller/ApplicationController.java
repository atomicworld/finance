package com.mf.bsnsmng.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
























import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.bsnsmng.entity.BsnsZhengxin;
import com.mf.bsnsmng.entity.Client;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.bsnsmng.service.BsnsZhengxinService;
import com.mf.bsnsmng.service.ClientService;
import com.mf.businessParam.entity.BaseRate;
import com.mf.businessParam.service.impl.BaseRateServiceImpl;
import com.mf.client.entity.ClntEe;
import com.mf.client.entity.ClntEeReg;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntEeRegService;
import com.mf.client.service.ClntEeService;
import com.mf.client.service.ClntPersonService;
import com.mf.common.util.StringUtil;
import com.mf.org.entity.Operator;
import com.mf.sys.entity.Banknames;
import com.mf.sys.service.BanknamesService;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.BlackListQueryClient;
import com.mf.util.QueryClient;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/application")
public class ApplicationController {
	  @Autowired
	  private ClientService clientService;  
	  @Autowired
	  private BsnsApplyService bsnsApplyService; 
	  @Autowired
	  private BaseRateServiceImpl baseRateServiceImpl;
	  @Autowired
	  private BsnsZhengxinService bsnsZhengxinService;
	  @Autowired
	  private ClntPersonService clntPersonService;
	  @Autowired
	  private ClntEeRegService clntEeRegService;
	  @Autowired
	  private BsnsApplydtlService bsnsApplydtlService;
	  @Autowired
	  private BanknamesService banknamesService;
	  @Autowired
	  public MappingtoolServiceImpl mappingtoolService;
	  
	/**
	 * 跳转到贷款办理页面
	 * @author shenguangdong
	 * @param request
	 * @return
	 */
   @RequestMapping(value="applicationList")
   public String ApplicationList(Model model,HttpServletRequest request){
	       String clntId = request.getParameter("clntId");
	    
	       model.addAttribute("clntId", clntId);
	  
	       return "/mf/bsnsmng/Application/application";
   }
   /**
    * 跳转到贷款申请页面
    * @param model
    * @param request
    * @return
    */
   @RequestMapping(value="applicationAdd")
   public String ApplicationAdd(Model model,HttpServletRequest request,HttpServletResponse response){
	      Operator op = (Operator)request.getSession().getAttribute("operator");
	      String id = request.getParameter("clntId");
	    
	      /**
	       * 根据客户编号取申请信息，如果没有的话跳转到applicationadd页面
	       * 否则跳转到applicationView页面
	       */
	      List<BsnsApply> list = bsnsApplyService.queryAll(id);
	      if(list==null||list.size()==0){
	    	  Client client= clientService.getById(id);
	 	      /**
	 	       * 获取申请编号
	 	       */
	    	  //edit by hw
	 	      /*String applyNo = bsnsApplyService.getByClntNo(id);
	 	      if(applyNo==null){
	 	    	  applyNo=id+"0000";
	 	      }*/
	    	  String date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
	    	  String preKey = "SQ";
	    	  String waterID = mappingtoolService.getSerialnumber(date, preKey);
	    	  String applyNo = preKey + waterID;
    		  
	    	  model.addAttribute("client", client);
	    	  /*System.out.println("client"+client.getClntType());*/
		      model.addAttribute("applyNo", applyNo);
		      
		      model.addAttribute("op", op);
		      return "/mf/bsnsmng/Application/applicationAdd";
	      }else{
	    	   BsnsApply bsnsApply = list.get(0); 
	    	   String applyNo = bsnsApply.getApplyno();
	    	   return  "redirect:/mf/application/view.html?applyNo="+applyNo+"&clntId="+id;
	      }
	     
   }
   
   /**
    * 保存贷款申请信息
    */
   @RequestMapping(value="add")
   public String add(Model model,BsnsApply bsnsApply,HttpServletRequest request,HttpServletResponse response){
	   String result="{\"msg\":\"suc\"}";
	   BsnsApply old=bsnsApplyService.getById(bsnsApply.getApplyno());
	   if(old!=null){
		   result="{\"msg\":\"false\"}";
		   WebTool.writeJson(result, response);
		   return null;
	   }
	   try{
	   Operator operator = (Operator)request.getSession().getAttribute("operator");
	   bsnsApply.setBsnsopno(operator.getEmplyno());
	   bsnsApply.setBsnsopnm(operator.getOpnm());
	   /**
	    * 增加利率按年计算
	    *  bsrtyp若为1 代表年利率，为2代表月利率，为3代表天利率
	    *  add by shengd
	    */
	   String bsrtyp = request.getParameter("bsrtyp");
	   BigDecimal applyrt =new BigDecimal(request.getParameter("applyrt").trim());//申请利率
	   if("1".equals(bsrtyp)){
		  applyrt=applyrt;   
	   }else if("2".equals(bsrtyp)){
		   applyrt = applyrt.multiply(new BigDecimal(12)).divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_EVEN);
	   }else if("3".equals(bsrtyp)){
		   applyrt= applyrt.multiply(new BigDecimal(360)).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_EVEN);
	   }
	   bsnsApply.setApplyrt(applyrt);
	   
	   //银行名称的问题
	   String bnknm = request.getParameter("bnknm");
	   Banknames banknames = banknamesService.getById1(Integer.valueOf(bnknm));
	   if(banknames!=null){
		   bnknm = banknames.getBankname();
	   }
	   bsnsApply.setBnknm(bnknm);
	   
	   bsnsApplyService.add(bsnsApply);
	   }catch(Exception e){
		   e.printStackTrace();
		   result="{\"msg\":\"false\"}";
	   }
	   WebTool.writeJson(result, response);
	   return null;
     }
   /**
    * 保存贷款申请的查看页面（返回页面）
    */
   @RequestMapping(value="view")
   public String view(Model model,HttpServletRequest request){
	      String applyNo = request.getParameter("applyNo");
	      String clntId=request.getParameter("clntId");
	      //System.out.println("applyNo"+applyNo);
	      BsnsApply bsnsApply= bsnsApplyService.getById(applyNo);
	      //补充资料页面提交过来的98，根据申请编号查询审批状态
	      BsnsApplydtl bsnsApplydtl = bsnsApplydtlService.getByApplyno(applyNo);
	      String bsrtyp = bsnsApply.getBsrtyp();
		   BigDecimal applyrt = bsnsApply.getApplyrt();
		   if("2".equals(bsrtyp)){
			   applyrt = applyrt.multiply(new BigDecimal(10)).divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_EVEN);
		   }
		   if("3".equals(bsrtyp)){
			   applyrt= applyrt.multiply(new BigDecimal(100)).divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_EVEN);
		   }
		   bsnsApply.setApplyrt(applyrt);
	      model.addAttribute("bsnaApply", bsnsApply);
	      model.addAttribute("BsnsApplydtl", bsnsApplydtl);
	     // System.out.println("lllllllll"+bsnsApply.getKndno());
	      
	      Client client= clientService.getById(clntId);
	      model.addAttribute("client",client);
	    //  System.out.println(client.getClntType()+"ooooooooooooo");
	      return "/mf/bsnsmng/Application/applicationView";
   }
   /**
    * 跳转到贷款申请的修改页面
    * @param model
    * @param request
    * @return
    */
   @RequestMapping(value="edit")
   public String edit(Model model,HttpServletRequest request){
	   String applyNo = request.getParameter("applyNo");
	   String clntType=request.getParameter("clntType");
	   BsnsApply bsnsApply= bsnsApplyService.getById(applyNo);
	   if(bsnsApply.getApplyrt()!=null){
		  BigDecimal applyrt=bsnsApply.getApplyrt().setScale(2,BigDecimal.ROUND_HALF_UP);
		  bsnsApply.setApplyrt(applyrt);
	   }
	   String bsrtyp = bsnsApply.getBsrtyp();
	   BigDecimal applyrt = bsnsApply.getApplyrt();
	   if("2".equals(bsrtyp)){
		   applyrt = applyrt.multiply(new BigDecimal(10)).divide(new BigDecimal(12),2,BigDecimal.ROUND_HALF_EVEN);
	   }
	   if("3".equals(bsrtyp)){
		   applyrt= applyrt.multiply(new BigDecimal(100)).divide(new BigDecimal(360),2,BigDecimal.ROUND_HALF_EVEN);
	   }
	   /**
	    * 根据期限种类查询出来
	    */
	   String termtyp = bsnsApply.getTermtyp();
	   BaseRate baseRate = baseRateServiceImpl.getRateByRtno(termtyp);
	   String basert = baseRate.getBasert(); 
	   
	   bsnsApply.setApplyrt(applyrt);
	   model.addAttribute("bsnsApply", bsnsApply);
	   model.addAttribute("clntType",clntType);
	   model.addAttribute("basert", basert);
	   return "/mf/bsnsmng/Application/applicationEdit";
   }
   
   /**
    * 修改贷款申请信息
    */
   @RequestMapping(value="editUI")
   public String editUI(Model model,BsnsApply bsnsApply,HttpServletResponse response,HttpServletRequest request){
	   String result="{\"msg\":\"suc\"}";
	   /**
	    * 增加利率按年计算
	    *  
	    *  bsrtyp若为1 代表年利率，为2代表月利率，为3代表天利率
	    *  add by shengd
	    */
	   String bsrtyp = request.getParameter("bsrtyp");
	  // System.out.println(">>>>>>>>>>>"+bsrtyp);
	   BigDecimal applyrt =new BigDecimal(request.getParameter("applyrt").trim());//申请利率
	   System.out.println("applyrt="+applyrt);
	   if("1".equals(bsrtyp)){
		  applyrt=applyrt;   
	   }else if("2".equals(bsrtyp)){
		  // System.out.println("11111111111111");
		   applyrt = applyrt.multiply(new BigDecimal(12)).divide(new BigDecimal(10),2,BigDecimal.ROUND_HALF_EVEN);
	   }else if("3".equals(bsrtyp)){
		   applyrt= applyrt.multiply(new BigDecimal(360)).divide(new BigDecimal(100),2,BigDecimal.ROUND_HALF_EVEN);
	   }
	  // System.out.println(">>>>>>>!"+applyrt);
	   bsnsApply.setApplyrt(applyrt);
	   
	   //银行名称的问题
	   String bnknm = request.getParameter("bnknm");
	   Banknames banknames = banknamesService.getById1(Integer.valueOf(bnknm));
	   if(banknames!=null){
		   bnknm = banknames.getBankname();
	   }
	   bsnsApply.setBnknm(bnknm);
	   
	   bsnsApplyService.modify(bsnsApply);
	   System.out.println("---------------修改贷款申请信息成功-------------------");
	   WebTool.writeJson(result, response);
	   return null;
     }
   /**
    * 删除贷款申请信息
    */
   
   @RequestMapping(value="del")
   public String del(Model model,HttpServletRequest request,HttpServletResponse response){
	   String result ="{\"status\":true,\"message\":\"删除成功！\"}";
	   String applyNo = request.getParameter("applyNo");
	   bsnsApplyService.delete(applyNo);
	   WebTool.writeJson(result, response);
	   return null;
   }
   /**
    * 判断是否有权限去填质押、抵押、保证、贷前调查、贷前查询信息
    * 1、根据客户编号（clntNo）查询申请编号是否存在
    *    如果存在跳转到相应的页面进行填写。否则不能填写
    * 2、根据type参数判断跳的相应页面
    *    type=1跳到质押信息，
    *    type=2跳到抵押信息
    *    type=3跳到保证信息
    *    type=4跳到贷前调查报告
    *    
    *    type=5跳到贷款资料表格下载     //HW
    */
   
   @RequestMapping(value="judge")
   public String judge(Model model,HttpServletRequest request){
	   String clntId = request.getParameter("clntId");
	   String type = request.getParameter("type");
	   List<BsnsApply> list = bsnsApplyService.queryAll(clntId);
	   String applyNo="";
	   if(list!=null&&list.size()>0){
		   applyNo = list.get(0).getApplyno();
	   }
	   Client client=clientService.getById(clntId);
	   model.addAttribute("clntType",client.getClntType());//客户类型
	   model.addAttribute("applyNo", applyNo);
	   model.addAttribute("type", type);
	   return "/mf/bsnsmng/Application/judge";
   }
   /**
    * 贷款审批补充资料，
    */
   @RequestMapping(value="judge1")
   public String judge1(Model model,HttpServletRequest request){
	   String clntId = request.getParameter("clntId");
	   String type = request.getParameter("type");
	   String applyNo = request.getParameter("applyNo");
	   Client client=clientService.getById(clntId);
	   model.addAttribute("clntType",client.getClntType());//客户类型
	   model.addAttribute("applyNo", applyNo);
	   model.addAttribute("type", type);
	   return "/mf/bsnsmng/Application/judge";
   }
   /**
    * 跟据期限种类获取基准利率
    */
   @RequestMapping(value="getLv")
	public String getLv(Model model,HttpServletResponse response,HttpServletRequest request){
	   String qxzl = request.getParameter("qxzl");
	   String result ="{\"status\":true,\"message\":\"删除成功！\"}";
	   String basert="";
	   try {
		   BaseRate baseRate = baseRateServiceImpl.getRateByRtno(qxzl);
		    basert = baseRate.getBasert();
		    result ="{\"status\":true,\"message\":\""+basert+"\"}";
	 } catch (Exception e) {
		 result ="{\"status\":false,\"message\":\"删除成功！\"}";
	 }
	  WebTool.writeJson(result, response);
	   return null;
   }   
   
   /**
    * 跳转到征信信息页面
    * @param model
    * @param request
    * @return
    */
   @RequestMapping(value="zhengxin")
   public String zhengxin(Model model,HttpServletRequest request,HttpServletResponse response){
	      String id = request.getParameter("clntId");
	      Client client= clientService.getById(id);
		  model.addAttribute("client", client);
	      
	    	BsnsZhengxin bsnsZhengxin = bsnsZhengxinService.getById(id);
		    if(bsnsZhengxin != null){
		    	model.addAttribute("bsnsZhengxin", bsnsZhengxin);
		    }
		    model.addAttribute("clntno", id);
		  return "/mf/bsnsmng/Application/zhengxin";
	     
   }
   
   @SuppressWarnings("unchecked")
   @RequestMapping(value="searchZhengxin")
   public String searchZhengxin(Model model,HttpServletRequest request){
	   String clntno = request.getParameter("clntno");
	   Client client= clientService.getById(clntno);
	   model.addAttribute("client", client);
	   String mobile = "";
  	   if("1".equals(client.getClntType())){
  		   //对公客户
  		   ClntEeReg cer = clntEeRegService.getById(clntno);
  		   mobile = cer.getPhone1();
  	   }else{
  		   //对私客户
  		   ClntPerson clntPerson = clntPersonService.findByClntno(clntno);
  		   mobile = clntPerson.getMobiletel();
  	   }
	   
	   try {
		   //查询黑名单
		   //String rs = BlackListQueryClient.testBlacklistSearch("张三","342122198010100102");
		   //String rs = BlackListQueryClient.testBlacklistSearch("张聪","42060219911113252X");
			String rs = BlackListQueryClient.testBlacklistSearch(client.getClntName(),client.getCertNo());
			JSONArray jsonArray = JSONArray.fromObject(rs);
			List<BsnsZhengxin> list = (List<BsnsZhengxin>)JSONArray.toList(jsonArray, new BsnsZhengxin(), new JsonConfig());
			BsnsZhengxin bsnsZhengxin = new BsnsZhengxin();
			if(list.size() != 0){
				bsnsZhengxin = list.get(0);
				String createTime = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				bsnsZhengxin.setCreateTime(createTime);
				bsnsZhengxin.setAppliedAt(bsnsZhengxin.getApplied_at());
				bsnsZhengxin.setConfirmDetails(bsnsZhengxin.getConfirm_details());
				bsnsZhengxin.setConfirmedAt(bsnsZhengxin.getConfirmed_at());
				bsnsZhengxin.setConfirmType(bsnsZhengxin.getConfirm_type());
				bsnsZhengxin.setLoanType(bsnsZhengxin.getLoan_type());
			}
			bsnsZhengxin.setClntno(clntno);
			//查询反欺诈信息
			String ph = QueryClient.sendQueryUrl(client.getCertNo(),client.getClntName());
			if(ph.startsWith("{")){
				//身份证号码错误
				bsnsZhengxin.setIdStatus("2");
			}else{
				JSONArray phArray = JSONArray.fromObject(ph);
				List<BsnsZhengxin> phList = (List<BsnsZhengxin>)JSONArray.toList(phArray, new BsnsZhengxin(), new JsonConfig());
				BsnsZhengxin phZhengxin = phList.get(0);
				bsnsZhengxin.setIdStatus(phZhengxin.getId_status());
			}
			
			bsnsZhengxinService.add(bsnsZhengxin);
		    model.addAttribute("bsnsZhengxin", bsnsZhengxin);
			model.addAttribute("clntno", clntno);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//zhangcong修改
			model.addAttribute("msg", "查询失败！");
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("msg", "查询失败！");
		} 
	   return "/mf/bsnsmng/Application/zhengxin";
   }
   
}          
