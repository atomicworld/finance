package com.mf.flowmng.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.bsnsmng.service.BsnsDiyaService;
import com.mf.bsnsmng.service.BsnsZyService;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.common.util.WaterIdGener;
import com.mf.flowmng.entity.FlowApplystep;
import com.mf.flowmng.entity.FlowApprlcmmnts;
import com.mf.flowmng.entity.FlowApprler;
import com.mf.flowmng.service.FlowApprlcmmntsService;
import com.mf.flowmng.service.FlowApprlerService;
import com.mf.org.entity.Operator;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/flowcmmnit/")
public class FlowApprlCmmnitController {
     @Autowired
     private FlowApprlerService flowApprlerService;
     @Autowired
     private BsnsApplydtlService bsnsApplydtlService;
     @Autowired
     private BsnsApplyService bsnsApplyService;
     @Autowired
     private FlowApprlcmmntsService   flowApprlcmmntsService;
     @Autowired
     private BsnsCntrctService  bsnsCntrctService;
     @Autowired
     private com.mf.flowmng.service.FlowApplystepService  flowApplystepService;
 	@Autowired
	private SysDictionaryService sysDictionaryService;
	@Autowired
	private BsnsDiyaService bsnsDiyaService;
	@Autowired
	private BsnsZyService bsnsZyService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService; 
	
   /**
    * 获取当前用户所能够审批的贷款申请
    *   通过当前用户的id获取能够审批的步骤，然后跟申请审批详情表的当前审批步骤进行匹配查询
    */
	@RequestMapping(value="query")
	public String query(Model model,HttpServletRequest request){
		return "/mf/flowmng/commnitList";
	}
	/**
	 * 跳转到审批列表页面
	 */
	@RequestMapping(value="commnitInfo")
	public String commnitInfo(Model model,HttpServletRequest request){
		String apprvstt = request.getParameter("apprvstt");
		model.addAttribute("apprvstt", apprvstt);
		return "/mf/flowmng/commnitInfo";
	}
	
	/**
	 * post方式分页查询 
	 * 1、通过用户id查询出来当前登陆人的审批步骤
	 * 2、通过审批步骤和申请审批详情表的当前审批步骤查询出来贷款申请信息
	 * @param model
	 * @param combo
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsApplydtl bsnsApplydtl,HttpServletRequest request){
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		String userno = operator.getEmplyno();
		
	    /**
	     * 查询当前登陆人的审批步骤
	     */
		Map<String, Object> map=new HashMap<String, Object>();
	    FlowApprler flowApprler = flowApprlerService.getById(userno); 
	    if(flowApprler != null){
	    	String apprvstt = request.getParameter("apprvstt");
		    String flowsteps =  flowApprler.getAppsteps();//审批步骤
		    if(flowsteps.indexOf("@")>0){
		           flowsteps = flowsteps.replace("@", ",");
		    }   
		    bsnsApplydtl.setApprvprcss(flowsteps);
		    bsnsApplydtl.setApprvstt(apprvstt);
		    PageView pageView = null;
			String pageNow=request.getParameter("pager.pageNo");
			String pageSize=request.getParameter("pager.pageSize");
			if(Common.isEmpty(pageNow)){
				pageView = new PageView(1);
			}else{
				pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
			}
		
			pageView = bsnsApplydtlService.query(pageView, bsnsApplydtl);
			List<BsnsApplydtl> list=pageView.getRecords();
			map.put("rows", list); 
			map.put("pager.pageNo", pageView.getPageNow());
			map.put("pager.totalRows", pageView.getRowCount());
	    }
	    
		return map;
	}
	
	/**
	 * 跳转到审批页面
	 */
	@RequestMapping(value="add")
	public String add(Model model,HttpServletRequest request){
		String rcrdid = request.getParameter("rcrdid");
		BsnsApplydtl bsnsApplydtl = bsnsApplydtlService.getById(rcrdid);
		BsnsApply bsnsApply = bsnsApplyService.getById(bsnsApplydtl.getApplyno());
		model.addAttribute("bsnsApply", bsnsApply);
		model.addAttribute("bsnsApplydtl", bsnsApplydtl);
		return "/mf/flowmng/commnitAdd";
	}
	
	/**
	 * 保存审批信息
	 * 1、保存到审批意见表里
	 * 2、修改申请审批详情表（当前审批步骤、当前审批状态）
	 * 3、修改业务申请表的审批状态位
	 *   
	 */
	@RequestMapping(value="addUI")	
	public String addUI(Model model,FlowApprlcmmnts flowApprlcmmnts,HttpServletRequest request,HttpServletResponse response){
		 String result="{\"msg\":\"suc\"}";
		String applyno = request.getParameter("applyno");//申请编号
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		//String userno = operator.getEmplyno();
		//System.out.println("applyno=============="+applyno);
		String srlno = WaterIdGener.getWaterId();//流水号
		
		String cmmntypeno = request.getParameter("cmmntypeno");//审批意见类型编号
		String appredamnt = request.getParameter("appredamnt");//审批金额
		String appredrt = request.getParameter("appredrt");//审批利率
		String cmmntdes = request.getParameter("cmmntdes");//审批说明内容
		String curstep = request.getParameter("curstep");//当前审批步骤
		String apprvprcss = request.getParameter("apprvprcss");//审批步骤
		//System.out.println(apprvprcss+"----------------");
		String nextstep = "";//下一个步骤
		String prestep = "";//上一个步骤
		/**
		 * 取下一个审批步骤
		 *   审批步骤形如  3@5@7@9
		 *   当前步骤为5
		 */
		 String[] steps = apprvprcss.split("@");
		 
		 if(steps.length>0){
			 for(int j=0;j<steps.length;j++){
					if(steps[j].equals(curstep)&&!steps[steps.length-1].equals(curstep)){
						nextstep= steps[j+1];
					}
					if(steps[j].equals(curstep)&&!steps[0].equals(curstep)){
						prestep= steps[j-1];
					}
				}
	  
		 }
		 /**
		 * 当审批意见是同意并且审批不是最后一部审批
		 *   那么把“申请审批详情表的apprstt”设置成1 代表在审批中
		 *     否则把把“申请审批详情表的apprstt”设置成9代表审批”完全“通过
		 */
		 String  apprstt = request.getParameter("apprstt");//流程审批状态
		 String [] steps1 = apprvprcss.split(curstep);
		 if("9".equals(request.getParameter("apprstt"))&&steps1.length>1){
			 apprstt="1";
		 }
		 
		 //zhangcong修改（当审批发回重审时退回上一个步骤）
		 if("98".equals(request.getParameter("apprstt"))){
			nextstep = prestep;
		 }
			 
		 String apprerno = operator.getEmplyno();
		 String apprernm=operator.getOpnm();
		 String apprerdptno=operator.getDptno();
		 flowApprlcmmnts.setNextstep(nextstep);
		 flowApprlcmmnts.setApprerno(apprerno);
		 flowApprlcmmnts.setApprernm(apprernm);
		 flowApprlcmmnts.setApprerdptno(apprerdptno);
		 flowApprlcmmnts.setSrlno(srlno);
		 flowApprlcmmnts.setApprstt(apprstt);
		 flowApprlcmmnts.setCmmntdes(cmmntdes);
		 flowApprlcmmntsService.add(flowApprlcmmnts);    
		 System.out.println("-------------------保存审批表成功");
		 
		 BsnsApplydtl bsnsApplydtl = new BsnsApplydtl();
		 bsnsApplydtl.setApplyno(applyno);
		
		 
		 bsnsApplydtl.setApprvstt(apprstt);
		 bsnsApplydtl.setCurstep(nextstep);
		 bsnsApplydtlService.modify(bsnsApplydtl);
		 System.out.println("---------------修改申请审批详情表"); 
		 BsnsApply bsnsApply = new BsnsApply();
		 bsnsApply.setApplyno(applyno);
		 bsnsApply.setApprvlstt(apprstt);
		 bsnsApplyService.modify(bsnsApply);
		 System.out.println("---------------修改业务申请表成功"); 
		 if("9".equals(request.getParameter("apprstt"))&&steps1.length==1){
			 //保存合同信息start
			  BsnsCntrct  bsnsCntrct = new BsnsCntrct();
	          bsnsCntrct.setApplyno(applyno);//申请编号
	          // xjh start 20150203
	          BsnsApply bsnsApplyEntity = bsnsApplyService.getById(applyno);
	          bsnsCntrct.setClntno(bsnsApplyEntity.getClntno()); // 客户编号
	          bsnsCntrct.setClntnm(bsnsApplyEntity.getClntnm()); // 客户名称
	          bsnsCntrct.setKndno(bsnsApplyEntity.getKndno()); // 业务总类编号
	          bsnsCntrct.setBsnstyp(bsnsApplyEntity.getBsnstyp()); // 发生类型
	          bsnsCntrct.setCntrctamnt(new BigDecimal(appredamnt)); // 合同金额
	          bsnsCntrct.setOutamnt(BigDecimal.ZERO); // 已放款金额
	          bsnsCntrct.setCurrncy(bsnsApplyEntity.getCurrncy()); // 币种
	          bsnsCntrct.setBsrtyp(bsnsApplyEntity.getBsrtyp()); // 基准利率类型
	          bsnsCntrct.setBsnsrt(bsnsApplyEntity.getApplyrt()); // 执行利率
	          bsnsCntrct.setIntrstmd(bsnsApplyEntity.getIntrstmd()); // 计息方式
	          bsnsCntrct.setRpmntway(bsnsApplyEntity.getRpmntway()); // 还款方式
	          bsnsCntrct.setTermtyp(bsnsApplyEntity.getTermtyp()); // 期限种类
	          bsnsCntrct.setTrmyr(bsnsApplyEntity.getTrmyr()); // 期限年
	          bsnsCntrct.setTrmmnth(bsnsApplyEntity.getTrmmnth()); // 期限月
	          bsnsCntrct.setTrmday(bsnsApplyEntity.getTrmday()); // 期限日
	          bsnsCntrct.setGrtway(bsnsApplyEntity.getGrtway()); // 主担保方式
	          bsnsCntrct.setGrtwaydtl(bsnsApplyEntity.getGrtwaydtl()); // 具体担保类型
	          bsnsCntrct.setUseno(bsnsApplyEntity.getUseno()); // 贷款用途编号
	          bsnsCntrct.setMngopno(bsnsApplyEntity.getBsnsopno()); // 管户人编号
	          bsnsCntrct.setBsnsopno(bsnsApplyEntity.getBsnsopno()); // 操作员员工编号
	          bsnsCntrct.setLnamnt(new BigDecimal(appredamnt)); // 贷款剩余金额
	          bsnsCntrct.setApplyamnt(bsnsApplyEntity.getApplyamnt()); //　贷款申请金额
	          bsnsCntrct.setApplyrt(bsnsApplyEntity.getApplyrt()); // 申请利率
	//		              bsnsCntrct.setApplydate(""); // 贷款申请日期
	          bsnsCntrct.setRegdptno(operator.getDptno()); // 机构编码
	          bsnsCntrct.setRegopno(operator.getEmplyno()); // 操作员编号
	          bsnsCntrct.setRegdate(FormatDateUtil.getFormatDate("yyyyMMdd")); // 登记日期
	          bsnsCntrct.setCntrctyp(bsnsApplyEntity.getPctyp()); // 合同类型
	         
	          bsnsCntrct.setOutflg(PubConstants.OUTFLG_NO); // 放款标志
	          bsnsCntrct.setCntrctedflg(PubConstants.CNTRCTEDFLG_NO); // 合同结束标志
	          // xjh end 20150203
	          bsnsCntrct.setCntrctstt("1");//合同状态(1-新审批通过合同、 9-历史补录合同、  99-撤销合同
	          bsnsCntrct.setFnshflg("0");//结束位标示
	          
	          //edit by hw 
	          /*String a = bsnsCntrctService.getByClntNo(FormatDateUtil.getFormatDate("yyyyMMdd"));
			  String cntrctno=null;
			  if(a==null){
				  a="000001";
				  cntrctno =  apprerdptno+FormatDateUtil.getFormatDate("yyyyMMdd")+a;//合同编号
			  }else{
				  cntrctno=apprerdptno+FormatDateUtil.getFormatDate("yyyyMMdd")+a.substring(2);
			  }
			  //获取合同编号首字符串
			  SysDictionary sysDictionary = sysDictionaryService.findByCode("8000");			    
			  cntrctno=sysDictionary.getSdkey()+cntrctno;*/
	          String date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
	    	  String preKey = "HT";
	    	  String waterID = mappingtoolService.getSerialnumber(date, preKey);
	    	  String cntrctno = preKey + waterID;
	    	  BsnsApply bsnsApply_1 = bsnsApplyService.getById(applyno);
	    	  if(bsnsApply_1.getGrtway().equals("240001")){//信用
	    		  cntrctno = cntrctno+"A";
	    	  }else if(bsnsApply_1.getGrtway().equals("240002")){//抵押
	    		  cntrctno = cntrctno+"B";
	    	  }else if(bsnsApply_1.getGrtway().equals("240003")){//质押
	    		  cntrctno = cntrctno+"C";
	    	  }else if(bsnsApply_1.getGrtway().equals("240004")){//保证
	    		  cntrctno = cntrctno+"D";
	    	  }
	    	  
			  bsnsCntrct.setCntrctno(cntrctno);
			  bsnsCntrctService.add(bsnsCntrct);
			 
			  //wangzhi start通过申请号查询抵押表，质押表信息是否存在，如果存在添加合同号进去
			  BsnsDiya bsnsDiya = bsnsDiyaService.getById(applyno); 
			  if (bsnsDiya != null) {
				  bsnsDiya.setCntrctno(cntrctno);
				  bsnsDiyaService.modify(bsnsDiya);
			  }
			  BsnsZhiya bsnsZhiya = bsnsZyService.getById(applyno);
			  if (bsnsZhiya != null) {
				  bsnsZhiya.setCntrctno(cntrctno);
				  bsnsZyService.modify(bsnsZhiya);
			  }
			  //wangzhi end
			  //保存合同信息end
		 }
		 WebTool.writeJson(result, response);
		 return null;
	} 
	/**
	 * 申请状态查询
	 * 
	 */
	@RequestMapping(value="view")
	public String View(Model model,HttpServletRequest request){
		String apprvstt = request.getParameter("apprvstt");
		model.addAttribute("apprvstt", apprvstt);
		if("9".equals(apprvstt)){
			return "/mf/flowmng/commnitOver";
		}else if("99".equals(apprvstt)){
			return "/mf/flowmng/commnitView";
		}else{
			return "/mf/flowmng/commnitView";
		}
		
	}
	
	/**
	 * post方式分页查询 
	 * @param model
	 * @param combo
	 * @return map
	 */
	@RequestMapping(value="showlist1",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist1(Model model,BsnsApplydtl bsnsApplydtl,HttpServletRequest request){
	    PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		String userno = operator.getEmplyno();
		
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		bsnsApplydtl.setRegopno(userno);
		pageView = bsnsApplydtlService.query1(pageView, bsnsApplydtl);
		List<BsnsApplydtl> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	/**
	 * 获取流程步骤的详情
	 * 
	 */
	@RequestMapping(value="flowBase")
	public String flowBase(Model model,HttpServletResponse response,HttpServletRequest request){
		String result = "{\"status\":true,\"message\":\"保存成功\"}";
		String apprlno = request.getParameter("apprlno");//流程编号
		String curstep = request.getParameter("curstep");//当前步骤
		       apprlno =apprlno.replaceAll("@", ",");
	     List<FlowApplystep>	list= flowApplystepService.findByapprlno(apprlno);
	     
	     String message = "";
	     for(int i=0;i<list.size();i++){
	    	 if(curstep.equals(list.get(i).getApprlno())){
	    		 message=message+"-&gt;"+"<span style='color:red'>"+list.get(i).getStepnm()+"</span>";
	    	 }else{
	    	     message=message+"-&gt;"+list.get(i).getStepnm();
	    	     }
	     }
	    message= message.substring(5, message.length());
	   //  System.out.println(message+"--------------------------");
	     result = "{\"status\":true,\"message\":\""+message+"\"}";
	     System.out.println(result);
	     WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 获取流程步骤的详情
	 * 
	 */
	@RequestMapping(value="flowBase1")
	public String flowBase1(Model model,HttpServletResponse response,HttpServletRequest request){
		String result = "{\"status\":true,\"message\":\"保存成功\"}";
		String apprlno = request.getParameter("steps");//流程编号
		//String curstep = request.getParameter("curstep");//当前步骤
		       apprlno =apprlno.replaceAll("@", ",");
	     List<FlowApplystep>	list= flowApplystepService.findByapprlno(apprlno);
	     
	     String message = "";
	    // System.out.println(list.size()+"#3333333333333333#");
	     for(int i=0;i<list.size();i++){
	    		 message=message+"-&gt;"+"<span >"+list.get(i).getStepnm()+"</span>";
	     }
	     message= message.substring(5, message.length());
	   //  System.out.println(message+"--------------------------");
	     result = "{\"status\":true,\"message\":\""+message+"\"}";
	     System.out.println(result);
	     WebTool.writeJson(result, response);
		 return null;
	}
	/**
	 * 查询客户编号
	 * 
	 * 申请日期
	 */
	@RequestMapping(value="getKhMc")
	public String getOpnm(Model model, HttpServletRequest request ,HttpServletResponse response ){
		String type = request.getParameter("type");
		String applyno = request.getParameter("applyno");
		//System.out.println(applyno+"--------------1");
		BsnsApplydtl bsnsApplydtl = bsnsApplydtlService.getByApplyno(applyno);
		String clntnm = bsnsApplydtl.getClntnm();
		String subdate = bsnsApplydtl.getSubdate();
		BigDecimal amt = bsnsApplydtl.getApplyamnt();
		String lntmdy =bsnsApplydtl.getLntmdy(); 
		String result="";
		if("1".equals(type)){
			result = "{\"status\":true,\"message\":\""+clntnm+"\"}";
		}
		if("2".equals(type)){
			result = "{\"status\":true,\"message\":\""+subdate+"\"}";
		}
		if("3".equals(type)){
			result = "{\"status\":true,\"message\":\""+amt+"\"}";
		}
		if("4".equals(type)){
			result = "{\"status\":true,\"message\":\""+lntmdy+"\"}";
		}
	   
	    
	     WebTool.writeJson(result, response);
		 return null;
	}
	/**
	 * 查询流程审批历史和基本申请信息
	 */
	@RequestMapping(value="getApplyInfo")
	public String getApplyInfo(Model model,HttpServletRequest request){
		String applyno = request.getParameter("applyno");
		String type="1";
		BsnsApply bsnsApply = bsnsApplyService.getById(applyno);
		model.addAttribute("bsnaApply", bsnsApply);
		model.addAttribute("type", type);
		return "/mf/bsnsmng/Application/applicationView";
	}
	
	/**
	 * 查询流程审批历史数据
	 */
	
	@RequestMapping(value="getCmmntsInfo")
	public String getCmmntsInfo(Model model,HttpServletRequest request){
		String applyno = request.getParameter("applyno");
		System.out.println(applyno+"..............");
		model.addAttribute("applyno", applyno);
		return "/mf/flowmng/apprlcmmntsList";
	}
	
	/**
	 * post方式分页查询 
	 * @param model
	 * @param combo
	 * @return map
	 */
	@RequestMapping(value="showlist2",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist2(Model model,HttpServletRequest request){
		//System.out.println("111111111111111111111111111");
		//User u = (User)request.getSession().getAttribute("userSession");
		String applyno = request.getParameter("applyno");
		System.out.println("............."+applyno);
	    PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = flowApprlcmmntsService.query1(pageView, applyno);
		List<FlowApprlcmmnts> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
}
