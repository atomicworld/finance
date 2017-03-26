package com.mf.bsnsmng.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.aftrmng.entity.AfterSurveydoc;
import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsDiyaService;
import com.mf.client.entity.ClntClient;
import com.mf.client.service.ClntClientService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.common.util.NOSUtil;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/diya")
public class BsnsDiyaController {
     
	@Autowired
	private BsnsApplyService bsnsApplyService;
	@Autowired
	private BsnsDiyaService bsnsDiyaService;
	@Autowired
	private CompanyInfoServiceImpl companyInfoServiceImpl;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private ClntClientService clientService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	/**
	 * 跳转到抵押新增页面
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model ,HttpServletRequest request){
		String applyNo = request.getParameter("applyNo");
		String clntType=request.getParameter("clntType");
		BsnsDiya bsnsDiya = bsnsDiyaService.getById(applyNo);
		if(bsnsDiya==null){
			BsnsApply bsnsApply = bsnsApplyService.getById(applyNo);
			model.addAttribute("bsnsApply", bsnsApply);
			model.addAttribute("clntType",clntType);
			return "/mf/bsnsmng/diya/diyaAdd";
		}else{
			return  "redirect:/mf/diya/view.html?applyNo="+applyNo+"&clntType="+clntType;
		}
		
		
	}
	/**
	 * 保存抵押信息
	 */
	 @RequestMapping(value="addUi")
	   public String add(Model model,BsnsDiya bsnsDiya,HttpServletResponse response){
		   
		   String result="{\"msg\":\"suc\"}";
		   bsnsDiyaService.add(bsnsDiya);
		   System.out.println("---------------保存抵押押信息成功-------------------");
		   WebTool.writeJson(result, response);
		   return null;
	     }
	 /**
	  * 跳转到查看页面
	  * 
	  */
	 @RequestMapping(value="view")
	 public String view(Model model,HttpServletRequest request){
		 String applyNo = request.getParameter("applyNo");
		 BsnsDiya bsnsDiya = bsnsDiyaService.getById(applyNo);
		 model.addAttribute("bsnsDiya", bsnsDiya);
		 String clntType=request.getParameter("clntType");
		 model.addAttribute("clntType",clntType);
		 return "/mf/bsnsmng/diya/diyaView";
	 }
	 
	 /**
	  * 跳转到合同附属信息查看页面
	  * 
	  */
	 @RequestMapping(value="CntrctView")
	 public String CntrctView(Model model,HttpServletRequest request){
		 String cntrctno = request.getParameter("cntrctno");
		 BsnsDiya bsnsDiya = bsnsDiyaService.getByCntrctno(cntrctno);
		 model.addAttribute("bsnsDiya", bsnsDiya);
		 return "/mf/cntrtmng/bsnscntrct/agreement/edit/diya/diyaView";
	 }

	   /**
	    * 删除抵押信息
	    */
	   @RequestMapping(value="del")
	   public String del(Model model,HttpServletRequest request,HttpServletResponse response){
		   String result ="{\"status\":true,\"message\":\"删除成功！\"}";
		   String applyNo = request.getParameter("applyNo");
		   bsnsDiyaService.delete(applyNo);
		   WebTool.writeJson(result, response);
		   return null;
	   }
	   /**
	    * 删除抵押信息
	    */
	   @RequestMapping(value="CntrctnoDel")
	   public String CntrctnoDel(Model model,HttpServletRequest request,HttpServletResponse response){
		   String result ="{\"status\":true,\"message\":\"删除成功！\"}";
		   String cntrctno = request.getParameter("cntrctno");
		   bsnsDiyaService.deleteCntrctno(cntrctno);
		   WebTool.writeJson(result, response);
		   return null;
	   }
	   
	   /**
	    * 调转到抵押修改页面
	    */
	   @RequestMapping(value="edit")
	   public String edit(Model model,HttpServletRequest request){
		   String applyNo = request.getParameter("applyNo");
		   BsnsDiya bsnsDiya = bsnsDiyaService.getById(applyNo);
		   model.addAttribute("bsnsDiya", bsnsDiya);
		   String clntType=request.getParameter("clntType");
		   model.addAttribute("clntType",clntType);
		   return "/mf/bsnsmng/diya/diyaEdit";
	   }
	   /**
	    * 调转到抵押修改页面
	    */
	   @RequestMapping(value="CntrctEdit")
	   public String CntrctEdit(Model model,HttpServletRequest request){
		   String cntrctno = request.getParameter("cntrctno");
		   BsnsDiya bsnsDiya = bsnsDiyaService.getByCntrctno(cntrctno);
		   model.addAttribute("bsnsDiya", bsnsDiya);
		   return "/mf/cntrtmng/bsnscntrct/agreement/edit/diya/diyaEdit";
	   }
	   
	   /**
	    * 保存修改的信息
	    */
	   @RequestMapping(value="editUi")
	   public String editUI(Model model,BsnsDiya bsnsDiya,HttpServletResponse response){
		   String result="{\"msg\":\"suc\"}";
		   bsnsDiyaService.modify(bsnsDiya);  
		   System.out.println("---------------修改抵押申请信息成功-------------------");
		   WebTool.writeJson(result, response);
		   return null;
	     }
	   
	   /**
	    * 保存修改的信息
	    */
	   @RequestMapping(value="CntrctEditUi")
	   public String CntrctEditUi(Model model,BsnsDiya bsnsDiya,HttpServletResponse response){
		   String result="{\"msg\":\"suc\"}";
		   bsnsDiyaService.modifyCntrct(bsnsDiya);  
		   System.out.println("---------------修改抵押申请信息成功-------------------");
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
			BsnsDiya bsnsDiya = bsnsDiyaService.getByCntrctno(cntrctno);
			BsnsCntrct bsnsCntrct = bsnsCntrctService.getById(cntrctno);
			ClntClient clntClient = clientService.getById(bsnsCntrct.getClntno());
			System.out.println("=====该客户类型是======="+clntClient.getCerttype());
			System.out.println("======Applyno========="+bsnsCntrct.getApplyno());
			BsnsApply bsnsApply = bsnsApplyService.getById(bsnsDiya.getApplyno());
			System.out.println("==========bsnsCntrct============="+bsnsCntrct);
			System.out.println("===========bsnsDiya============"+bsnsDiya);
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
			String clnttype = "";
			if (clntClient.getClnttype()=="1") {
				clnttype ="企业";
			}else {
				clnttype = "个人";
			}
			SysDictionary sysDictionary = new SysDictionary();
			sysDictionary.setCode("1115");
			sysDictionary.setSdvalue(bsnsDiya.getDiyatyp());
			
			String diyatyp = sysDictionaryService.findByCodeAndValue(sysDictionary).getSdkey();
			SysDictionary sysDictionary2 = new SysDictionary();
			sysDictionary2.setCode("2014");
			String usetyp = null;
			if(bsnsDiya.getUsetyp() != null && !"".equals(bsnsDiya.getUsetyp())){
				sysDictionary2.setSdvalue(bsnsDiya.getUsetyp());
				usetyp = sysDictionaryService.findByCodeAndValue(sysDictionary2).getSdkey();
			}
			
			
			SysDictionary sysDictionary3 = new SysDictionary();
			sysDictionary3.setCode("2015");
			sysDictionary3.setSdvalue(bsnsDiya.getOther());
			String other = sysDictionaryService.findByCodeAndValue(sysDictionary3).getSdkey();
			params.append("cntrctno,"+cntrctno+";");
			params.append("qdclnttype,"+clnttype+";");
			params.append("ownernm,"+bsnsDiya.getOwnernm()+";");
			params.append("diyarendz,"+isNull(bsnsDiya.getDiyarendz())+";");
			params.append("diyafaren,"+isNull(bsnsDiya.getDiyafaren())+";");
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
			params.append("qdclntno,"+isNull(bsnsDiya.getClntno())+";");
			params.append("qdclntnm,"+isNull(bsnsDiya.getClntnm())+";");
			params.append("qdapplyno,"+isNull(bsnsDiya.getApplyno())+";");
			params.append("qdownernm,"+isNull(bsnsDiya.getOwnernm())+";");
			params.append("qdownerno,"+isNull(bsnsDiya.getOwnerno())+";");
			params.append("qddiyarendz,"+isNull(bsnsDiya.getDiyarendz())+";");
			params.append("qddiyafaren,"+isNull(bsnsDiya.getDiyafaren())+";");
			params.append("qddiyashare,"+isNull(bsnsDiya.getDiyashare())+";");
			params.append("qddiyanm,"+isNull(bsnsDiya.getDiyanm())+";");
			params.append("qddiyatyp,"+isNull(diyatyp)+";");
			params.append("qddiyalctn,"+isNull(bsnsDiya.getDiyalctn())+";");
			params.append("qdusetyp,"+isNull(usetyp)+";");
			params.append("qdother,"+isNull(other)+";");
			params.append("qddscp,"+ isNull(bsnsDiya.getDscp())+";");
			params.append("qdkeeper,"+isNull(bsnsDiya.getKeeper())+";");
			params.append("qdkeepdate,"+isNull(bsnsDiya.getKeepdate())+";");
			params.append("qdprvfile,"+isNull(bsnsDiya.getPrvfile())+";");
			params.append("qdpwnno,"+isNull(bsnsDiya.getPwnno())+";");
			params.append("qdorgnlval,"+checknull(bsnsDiya.getOrgnlval())+";");
			params.append("qdorgnldate,"+isNull(bsnsDiya.getOrgnldate())+";");
			params.append("qdamnt,"+checknull(bsnsDiya.getAmnt())+";");
			params.append("qdlmtyr,"+isNull(bsnsDiya.getLmtyr())+";");
			params.append("qdrmnyr,"+isNull(bsnsDiya.getRmnyr())+";");
			params.append("qddprctnrt,"+checknull(bsnsDiya.getDprctnrt())+";");
			params.append("qdregorg,"+isNull(bsnsDiya.getRegorg())+";");
			params.append("qdpreevlval,"+checknull(bsnsDiya.getPreevlval())+";");
			params.append("qdevlmthd,"+isNull(bsnsDiya.getEvlmthd())+";");
			params.append("qdpreevaldate,"+isNull(bsnsDiya.getPreevaldate())+";");
			params.append("qdevlval,"+checknull(bsnsDiya.getEvlval())+";");
			params.append("qdevaldate,"+isNull(bsnsDiya.getEvaldate())+";");
			params.append("qdevlorg,"+isNull(bsnsDiya.getEvlorg())+";");
			params.append("qdmrtggrt,"+checknull(bsnsDiya.getMrtggrt())+";");
			params.append("qdassrrt,"+checknull(bsnsDiya.getAssrrt())+";");
			params.append("qdntrztnorg,"+isNull(bsnsDiya.getNtrztnorg())+";");
			params.append("qdntrztndate,"+isNull(bsnsDiya.getNtrztndate())+";");
			params.append("qdntrztnno,"+isNull(bsnsDiya.getNtrztnno())+";");
			params.append("qddiyaregdate,"+isNull(bsnsDiya.getDiyaregdate())+";");
			params.append("qddiyaedate,"+isNull(bsnsDiya.getDiyaedate())+";");
			params.append("qdpolno,"+isNull(bsnsDiya.getPolno())+";");
			params.append("qdpolamnt,"+checknull(bsnsDiya.getPolamnt())+";");
			params.append("qdremark,"+isNull(bsnsDiya.getRemark())+";");
			
			
			model.addAttribute("params", params.toString());
			System.out.println("============"+params.toString());
			return "/mf/bsnsmng/diya/word";
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
