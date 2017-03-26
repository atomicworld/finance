package com.mf.bsnsmng.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsZyService;
import com.mf.client.entity.ClntClient;
import com.mf.client.service.ClntClientService;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.util.NOSUtil;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/pledge")
public class BsnsZyController {
    /**
     * 
     * 跳转到质押信息新增页面
     */
	@Autowired
	private BsnsApplyService bsnsApplyService;
	@Autowired
	private BsnsZyService bsnsZyService;
	@Autowired
	private CompanyInfoServiceImpl companyInfoServiceImpl;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private ClntClientService clientService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	/**
	 * 跳转到质押新增页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="pledgeAdd")
	public String pledgeAdd(Model model,HttpServletRequest request){
		String applyNo = request.getParameter("applyNo");
		String clntType=request.getParameter("clntType");
		BsnsZhiya bsnsZhiya= bsnsZyService.getById(applyNo);
		if(bsnsZhiya==null){
			BsnsApply bsnsApply = bsnsApplyService.getById(applyNo);
			model.addAttribute("bsnsApply", bsnsApply);
			model.addAttribute("clntType",clntType);
			return "/mf/bsnsmng/Application/pledgeAdd";    
		}else{
			return  "redirect:/mf/pledge/view.html?applyNo="+applyNo+"&clntType="+clntType;
		}
		
	}
	
	   /**
	    * 保存质押申请信息
	    */
	   @RequestMapping(value="add")
	   public String add(Model model,BsnsZhiya bsnsZhiya,HttpServletResponse response){
		   String result="{\"msg\":\"suc\"}";
		   try{
		   bsnsZyService.add(bsnsZhiya);
		   }catch(Exception e){
			   e.printStackTrace();
			   result="{\"msg\":\"false\"}";
		   }
		   WebTool.writeJson(result, response);
		   return null;
	     }
	  
	   /**
	    * 跳转到查看页面
	    * {@link Autowired}shengd
	    * 
	    */
	   @RequestMapping(value="view")
	   public String view(Model model ,HttpServletRequest request){
		      String applyNo = request.getParameter("applyNo");
		      String clntType=request.getParameter("clntType");
		      BsnsZhiya bsnsZhiya = bsnsZyService.getById(applyNo);
		      model.addAttribute("bsnsZhiya", bsnsZhiya);
		      model.addAttribute("clntType",clntType);//客户类型
		      return "/mf/bsnsmng/Application/pledgeView";
	   }
	   /**
	    * 跳转到修改页面
	    */
	   @RequestMapping(value="edit")
	   public String edit(Model model,HttpServletRequest request){
		   String applyNo = request.getParameter("applyNo"); 
		   BsnsZhiya bsnsZhiya = bsnsZyService.getById(applyNo);
		  
		   model.addAttribute("bsnsZhiya", bsnsZhiya);
		   String clntType=request.getParameter("clntType");
		   model.addAttribute("clntType",clntType);//客户类型
		   return "/mf/bsnsmng/Application/pledgeEdit";
	   }
	   /**
	    * 保存修改的信息
	    */
	   @RequestMapping(value="editUi")
	   public String editUI(Model model,BsnsZhiya bsnsZhiya,HttpServletResponse response){
		   String result="{\"msg\":\"suc\"}";
		   bsnsZyService.modify(bsnsZhiya);
		   System.out.println("---------------修改质押申请信息成功-------------------");
		   WebTool.writeJson(result, response);
		   return null;
	     }
	   
	   /**
	    * 删除质押信息
	    */
	   @RequestMapping(value="del")
	   public String del(Model model,HttpServletRequest request,HttpServletResponse response){
		   String result ="{\"status\":true,\"message\":\"删除成功！\"}";
		   String applyNo = request.getParameter("applyNo");
		   bsnsZyService.delete(applyNo);
		   WebTool.writeJson(result, response);
		   return null;
	   }
	   /**
	 		 * 下载功能
	 		 */
	 		@RequestMapping(value = "/downFile")
	 		public String downFile(Model model,String cntrctno, HttpServletRequest request,HttpServletResponse response) {
	 			System.out.println("------进入downFile方法--------"+cntrctno);
	 			StringBuffer params=new StringBuffer();
	 			CompanyInfo companyInfo = companyInfoServiceImpl.getCompanyInfo(new CompanyInfo());
	 			BsnsZhiya bsnsZhiya = bsnsZyService.getByCntrctno(cntrctno);
	 			BsnsCntrct bsnsCntrct = bsnsCntrctService.getById(cntrctno);
	 			BsnsApply bsnsApply = bsnsApplyService.getById(bsnsZhiya.getApplyno());
	 			ClntClient clntClient = clientService.getById(bsnsCntrct.getClntno());
	 			String syear = "";
	 			String smonth ="";
	 			String sday ="";
	 			if (bsnsCntrct.getCntrctsdate()!=null && bsnsCntrct.getCntrctsdate()!="" ) {
	 				smonth = bsnsCntrct.getCntrctsdate().substring(4,6);
	 				sday= bsnsCntrct.getCntrctsdate().substring(6);
	 				syear = bsnsCntrct.getCntrctsdate().substring(0,4);
	 			}
	 			String clntnm = bsnsCntrct.getClntnm();
	 			String outamnt =NOSUtil.change(bsnsCntrct.getOutamnt().doubleValue());
	 			String eyear="";
	 			String emonth="";
	 			String eday="";
	 			if (bsnsCntrct.getCntrctedate()!=null && bsnsCntrct.getCntrctedate()!="") {
	 				eyear= bsnsCntrct.getCntrctedate().substring(0,4);
	 				emonth = bsnsCntrct.getCntrctedate().substring(4,6);
	 				eday = bsnsCntrct.getCntrctedate().substring(6);
	 			}
	 			String months ="";
	 			if (bsnsApply!=null) {
	 				months = bsnsApply.getTrmmnth().toString();
	 			}
	 			params.append("cntrctno,"+cntrctno+";");
	 			params.append("ownernm,"+bsnsZhiya.getOwnernm()+";");
	 			params.append("zhiyarendz,"+isNull(bsnsZhiya.getZhiyarendz())+";");
	 			params.append("zhiyafaren,"+isNull(bsnsZhiya.getZhiyafaren())+";");
	 			params.append("cmpnm,"+isNull(companyInfo.getCmpnm())+";");
	 			params.append("cmpaddr,"+ isNull(companyInfo.getCmpaddr())+";");
	 			params.append("cmpfaren,"+ isNull(companyInfo.getCmpfaren())+";");
	 			params.append("syear,"+isNull(syear)+";");
	 			params.append("smonth,"+isNull(smonth)+";");
	 			params.append("sday,"+isNull(sday)+";");
	 			params.append("clntnm,"+isNull(clntnm)+";");
	 			params.append("cntrctno1,"+isNull(cntrctno)+";");
	 			params.append("outamnt,"+isNull(outamnt)+";");
	 			params.append("year1,"+isNull(syear)+";");
	 			params.append("month1,"+isNull(smonth)+";");
	 			params.append("day1,"+isNull(sday)+";");
	 			params.append("eyear,"+isNull(eyear)+";");
	 			params.append("emonth,"+isNull(emonth)+";");
	 			params.append("eday,"+isNull(eday)+";");
	 			params.append("months,"+isNull(months)+";");
	 			params.append("qdclntno,"+isNull(bsnsZhiya.getClntno())+";");
	 			params.append("qdclntnm,"+isNull(bsnsZhiya.getClntnm())+";");
	 			params.append("qdapplyno,"+isNull(bsnsZhiya.getApplyno())+";");
	 			String clnttype = "";
				if (clntClient.getClnttype()=="1") {
					clnttype ="企业";
				}else {
					clnttype = "个人";
				}
				params.append("qdclnttype,"+clnttype+";");
	 			params.append("qdownernm,"+isNull(bsnsZhiya.getOwnernm())+";");
	 			params.append("qdownerno,"+isNull(bsnsZhiya.getOwnerno())+";");
	 			params.append("qdzhiyarendz,"+isNull(bsnsZhiya.getZhiyarendz())+";");
	 			params.append("qdzhiyafaren,"+isNull(bsnsZhiya.getZhiyafaren())+";");
	 			params.append("qdzhiyanm,"+isNull(bsnsZhiya.getZhiyanm())+";");
	 			String zhiyatyp = "";
	 			SysDictionary sysDictionary = new SysDictionary();
	 			sysDictionary.setCode("2008");
	 			sysDictionary.setSdvalue(bsnsZhiya.getZhiyatyp());
	 			SysDictionary sysDictionary2 = sysDictionaryService.findByCodeAndValue(sysDictionary);
	 			zhiyatyp = sysDictionary2.getSdkey();
	 			params.append("qdzhiyatyp,"+isNull(zhiyatyp)+";");
	 			params.append("qddscrb,"+isNull(bsnsZhiya.getDscrb())+";");
	 			String currncy = "";
	 			if (bsnsZhiya.getCurrncy()=="CNY") {
					currncy = "人民币";
				}
	 			params.append("qdcurrncy,"+isNull(currncy)+";");
	 			params.append("qdzhiyaregorg,"+isNull(bsnsZhiya.getZhiyaregorg())+";");
	 			params.append("qdzhiyaamnt,"+isNull(bsnsZhiya.getZhiyaamnt())+";");
	 			params.append("qdevltmthd,"+isNull(bsnsZhiya.getEvltmthd())+";");
	 			params.append("qdzhiyavlu,"+bsnsZhiya.getZhiyavlu()+";");
	 			params.append("qdvludate,"+isNull(bsnsZhiya.getVludate())+";");
	 			params.append("qdzhiyart,"+isNull(bsnsZhiya.getZhiyart())+";");
	 			params.append("qdassrrt,"+bsnsZhiya.getAssrrt()+";");
	 			params.append("qdexpiredate,"+isNull(bsnsZhiya.getExpiredate())+";");
	 			params.append("qdntrztnorg,"+isNull(bsnsZhiya.getNtrztnorg())+";");
	 			params.append("qdntrztndate,"+isNull(bsnsZhiya.getNtrztndate())+";");
	 			params.append("qdntrztnno,"+isNull(bsnsZhiya.getNtrztnno())+";");
	 			params.append("qdremark,"+isNull(bsnsZhiya.getRemark())+";");
	 			model.addAttribute("params", params.toString());
	 			System.out.println("============"+params.toString());
	 			return "/mf/bsnsmng/Application/word";
	 		}
	 		
	 		public String isNull(String str){
	 			if (str==null) {
	 				str = "";
	 			}
	 			return str;
	 		}
	 		public String checknull(BigDecimal arg0){
	 			String s="";
	 			if (arg0 == null) {
	 			  s ="";
	 			}else {
	 				s = arg0+"";
	 			}
	 			return s;
	 		}
}
