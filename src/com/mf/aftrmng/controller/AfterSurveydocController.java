package com.mf.aftrmng.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.aftrmng.entity.AfterSurveydoc;
import com.mf.aftrmng.service.AfterSurveydocService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnout;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnoutService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.NOSUtil;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.service.FnncAccntitemService;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author chenenze
 * @2015-01-20
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value = "/mf/aftermng/aftersurveydoc/")
public class AfterSurveydocController {

	@Autowired
	private AfterSurveydocService afterSurveydocService;

	@Autowired
	private BsnsBillService bsnsBillService;

	@Autowired
	private FnncAccntitemService fnncAccntitemService;
	
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	private BsnsLnoutService bsnsLnoutService;
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value = "list")
	public String list() {
		return "/mf/aftrmng/aftrsdoc/list";
	}

	/**
	 * 跳到新增页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "addUI")
	public String addUI(Model model, String cntrctno) {
//		BsnsBill bsnsbill = bsnsBillService.findByCntrctno(cntrctno);
		BsnsCntrct bsnsCntrct =  bsnsCntrctService.getById(cntrctno);
		model.addAttribute("bsnsCntrct", bsnsCntrct);
		return "/mf/aftrmng/aftrsdoc/add";
	}

	/**
	 * 保存新增
	 * 
	 * @param model
	 * @param aftersurveydoc
	 * @return
	 */
	@RequestMapping(value = "add")
	public String add(Model model, AfterSurveydoc aftersurveydoc,HttpServletResponse response, HttpServletRequest request) {
		String result = "{\"msg\":\"suc\"}";
		try {
			afterSurveydocService.add(aftersurveydoc, request);
		} catch (Exception e) {
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	/**
	 * 保存新增--for 即时编辑
	 * 
	 * @param model
	 * @param aftersurveydoc
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		
		String result="";
		try {
			AfterSurveydoc aftersurveydoc = new AfterSurveydoc();
			afterSurveydocService.addAll(aftersurveydoc);
			result="{\"id\":" + aftersurveydoc.getSrlno() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 分页查询跳转
	 * @param model
	 * @param aftersurveydoc
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,AfterSurveydoc aftersurveydoc,String pageNow, String pageSize){
		return "/mf/aftermng/aftersurveydoc/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param aftersurveydoc
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,AfterSurveydoc aftersurveydoc,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = afterSurveydocService.query(pageView, aftersurveydoc);
		List<AfterSurveydoc> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param aftersurveydocId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String delete(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			afterSurveydocService.delete(ids);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param srlno
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String srlno,int typeKey){
		AfterSurveydoc aftersurveydoc = afterSurveydocService.getById(srlno);
		model.addAttribute("aftersurveydoc", aftersurveydoc);
		if(typeKey == 1){
			return "/mf/aftrmng/aftrsdoc/edit";
		} else if (typeKey == 2) {
			return "/mf/aftrmng/aftrsdoc/view";
		} else {
			return "/mf/aftrmng/aftrsdoc/view_1";
		}
	}

	/**
	 * 更新修改的信息
	 * 
	 * @param model
	 * @param aftersurveydoc
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateAfterSurveydoc(Model model,
			AfterSurveydoc aftersurveydoc, HttpServletResponse response) {
		String result = "{\"msg\":\"suc\"}";
		try {
			afterSurveydocService.modify(aftersurveydoc);
		} catch (Exception e) {
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;

	}

	
	/**
	 * 批量删除数据
	 * 
	 * @param model
	 * @param String
	 *            [] ids
	 * @return
	 */
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String[] ids, Model model,
			HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				afterSurveydocService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result = "{\"status\":0,\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	/**
	 * 下载功能
	 */
	@RequestMapping(value = "downFile")
	public String downFile(Model model, String srlno,String cntrctno, HttpServletRequest request,HttpServletResponse response) {
		AfterSurveydoc aftersurveydoc = afterSurveydocService.getById(srlno);
		System.out.println("------进入--------");
		StringBuffer params=new StringBuffer();
		System.out.println("cntrctno======"+cntrctno+"======srlno====="+srlno);
		BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(cntrctno);
		String money=NOSUtil.change(bsnsCntrct.getOutamnt().doubleValue());
		params.append("clntnm,"+aftersurveydoc.getClntnm()+";");//借款人姓名
		params.append("money,"+money);
		StringBuffer params1 = new StringBuffer();
		StringBuffer params2 = new StringBuffer();
		params2.append("clntinf,"+"借款企业或个人基本情况");
		String clntinf = aftersurveydoc.getClntinf();
		if (clntinf==null || clntinf=="") {
			clntinf="";
		}else{
			clntinf= replace(aftersurveydoc.getClntinf());
		}
		params1.append("clntinf,"+clntinf+";");
		params2.append("useinf,"+"借款企业或个人贷款使用情况");
		String useinf = aftersurveydoc.getUseinf();
		if (useinf==null||useinf=="") {
			useinf ="";
		}else{
			useinf = replace(aftersurveydoc.getUseinf());
		}
		params1.append("useinf,"+useinf+";");
		params2.append("liabilityinf,"+"借款企业或个人负债情况");
		String liabilityinf = aftersurveydoc.getLiabilityinf();
		if (liabilityinf == null || liabilityinf=="") {
			liabilityinf="";
		}else {
			liabilityinf = replace(aftersurveydoc.getLiabilityinf());
		}
		params1.append("liabilityinf,"+liabilityinf+";");
		params2.append("runinf,"+"借款企业个人经营情况");
		String runinf = aftersurveydoc.getRuninf();
		if (runinf == null || runinf == "") {
			runinf="";
		}else {
			runinf = replace(aftersurveydoc.getRuninf());
		}
		params1.append("runinf,"+runinf+";");
		String vouchinf =aftersurveydoc.getVouchinf();
		if (vouchinf==null || vouchinf =="") {
			vouchinf ="";
		}else {
			vouchinf = replace(aftersurveydoc.getVouchinf());
		}
		params1.append("vouchinf,"+vouchinf+";");
		
		String conclusion = aftersurveydoc.getConclusion();
		if (conclusion==null || conclusion =="") {
			conclusion ="";
		}else {
			conclusion = replace(aftersurveydoc.getConclusion());
		}
		String conclusion1 = conclusion+"m&    检查人："+"m&                                         _____年____月____日";
		System.out.println("====================="+ params.toString());
		System.out.println("========clntinf============"+ clntinf);
		String clntinf2 = "*$*"+clntinf;
		model.addAttribute("params1",replace(clntinf2.toString().trim()));
		String useinf2 = "*$*"+useinf;
		model.addAttribute("params2",replace(useinf2.toString().trim()));
		String liabilityinf2 ="*$*"+liabilityinf;
		model.addAttribute("params3",replace(liabilityinf2.toString().trim()));
		String runinf2 ="*$*"+runinf;
		model.addAttribute("params4",replace(runinf2.toString().trim()));
		String vouchinf2 ="*$*"+vouchinf;
		model.addAttribute("params5",replace(vouchinf2.toString().trim()));
		String conclusion12 ="*$*"+conclusion1;
		model.addAttribute("params6",replace(conclusion12.toString().trim()));
		model.addAttribute("params", params.toString());
		return "/mf/aftrmng/aftrsdoc/word";
	}
	
	public String replace(String str){
		String newStr = str.replaceAll(",","，");
		String newStr1 = newStr.replaceAll(";","。");
		String newStr2 = newStr1.replaceAll("\\n", "m&");
		return newStr2;
	}
	
	
/*	//add by hw
	@RequestMapping(value="showDtllist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showDtllist(Model model,BsnsCntrct bsnscntrct,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsCntrctService.queryAfterDtl(pageView, bsnscntrct);
		List<BsnsCntrct> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}*/
	
}
