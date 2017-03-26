/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.businessInfo.entity.Fileupdown;
import com.mf.businessInfo.service.FileupdownService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.financemng.entity.AuditReport;
import com.mf.financemng.entity.FinanceCashFlow;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.entity.Fnnzcfz;
import com.mf.financemng.entity.Profit;
import com.mf.financemng.service.AuditReportService;
import com.mf.financemng.service.FinanceCashFlowService;
import com.mf.financemng.service.FinreportService;
import com.mf.financemng.service.FnnzcfzService;
import com.mf.financemng.service.ProfitService;
import com.mf.shareholder.entity.ShareholderList;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-18
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/auditreport/")
public class AuditReportController {
	
	
	@Autowired
	private AuditReportService auditReportService;
	
	@Autowired
	private FnnzcfzService fnnzcfzService;
	
	@Autowired
	private ProfitService profitService;
	
	@Autowired
	private FinanceCashFlowService financeCashFlowService;
	
	@Autowired
	private FileupdownService fileupdownService;
	
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	
	@Autowired
	private CompanyInfoServiceImpl  companyInfoService;
	
	@Autowired
	private FinreportService finreportService;
	
	
	
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/auditreport/list1";
		return "/mf/financemng/auditreport/list";
	}
	
	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model, String search,AuditReport auditReport, 
			HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView =auditReportService.query(pageView,search,auditReport);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/financemng/auditreport/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param auditreport
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,AuditReport auditreport,HttpServletResponse response,HttpServletRequest request){
		String result=null;
		try {
			String date = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
			String key_name = "AE";//前缀角色表的
			String reportid = mappingtoolService.getSerialnumber(date, key_name);
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			auditreport.setOrgcode(companyInfo.getOrgcode());
			auditreport.setReportid(reportid);
			auditreport.setDeleteflag(0);
			auditreport.setZstatus(0);
			auditreport.setPstatus(0);
			auditreport.setXstatus(0);
			auditReportService.add(auditreport);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 *checkYear
	 * @param model
	 * @param year
	 * @return
	 */
	@RequestMapping(value="checkYear")
	@ResponseBody
	public String checkYear(Model model,String reportyear,HttpServletResponse response){
		String result=null;
		try {
			AuditReport auditReport = auditReportService.getByYear(reportyear);
			if(auditReport==null){
				result = "{\"msg\":\"suc\"}";
			}else{
				result = "{\"msg\":\"fail\"}";
			}
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 *checkTime
	 * @param model
	 * @param time
	 * @return
	 */
	@RequestMapping(value="checkTime")
	@ResponseBody
	public String checkTime(Model model,String updatedate,HttpServletResponse response){
		String result=null;
		try {
			DateFormat format1 = new SimpleDateFormat("yyyyMMdd");
			String t = format1.format(new Date());
			updatedate = updatedate.replace("-", "");
			if(Integer.parseInt(updatedate)<=Integer.parseInt(t)){
				result = "{\"msg\":\"suc\"}";
			}else{
				result = "{\"msg\":\"fail\"}";
			}
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	
	
	
	/**
	 * 根据id删除
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteById(Model model,String reportid, HttpServletResponse response,HttpServletRequest request){
		String result=null;
		try{
			List<Fileupdown> list = fileupdownService.getByReportid(reportid);
			for (Fileupdown fileupdown : list) {
				String	filepath = request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator+fileupdown.getFilename();
				File file = new File(filepath);
				if(file!= null && file.exists()){
					file.delete();
				}
			}
			fileupdownService.deleteByReportid(reportid);
			AuditReport auditreport = auditReportService.getById(reportid);
			Finreport f1 = new Finreport();
			f1.setRpttype("A");
			f1.setRptmonth(Integer.parseInt(auditreport.getReportyear()));
			finreportService.deleteByRptmonth(f1);
			fnnzcfzService.deleteFnnzcfz(auditreport.getReportyear());
			Finreport f2 = new Finreport();
			f2.setRpttype("B");
			f2.setRptmonth(Integer.parseInt(auditreport.getReportyear()));
			finreportService.deleteByRptmonth(f2);
			profitService.deleteProfit(auditreport.getReportyear());
			Finreport f3 = new Finreport();
			f3.setRpttype("D");
			f3.setRptmonth(Integer.parseInt(auditreport.getReportyear()));
			finreportService.deleteByRptmonth(f3);
			financeCashFlowService.deleteCashflow(auditreport.getReportyear());
			auditreport.setDeleteflag(1);
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		}catch(Exception e){
			result = "{\"msg\":\"fail\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 修改单条记录
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String reportid){
		AuditReport auditreport = auditReportService.getById(reportid);
		model.addAttribute("auditreport", auditreport);
		return "/mf/financemng/auditreport/edit";
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param auditreport
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateAuditReport(Model model,AuditReport auditreport,HttpServletResponse response){		
		String result=null;
		try {			
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	/**
	 * 查看单条记录
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="view")
	public String view(Model model,String reportid){
		AuditReport auditreport = auditReportService.getById(reportid);
		model.addAttribute("auditreport", auditreport);
		return "/mf/financemng/auditreport/view";
	}
	
	/**
	 * 跳到资产负债表新增页面
	 * @return
	 */
	@RequestMapping(value="addzcfzUI")
	public String addzcfzUI(Model model,String year,String aid){
		model.addAttribute("year", year);
		model.addAttribute("aid", aid);
		return "/mf/financemng/auditreport/zcfzadd";
	}
	
	/**
	 * 保存新增资产负债表
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="addzcfz")
	public String addzcfz(Model model,String aid,Fnnzcfz fnnzcfz,HttpServletResponse response,HttpServletRequest request){
		int[] itemcode1={20001,20002,20003,20004,20005,20006,20007,20008,20009,20010,
				20011,20012,20013,20014,20015,20016,20017,20042,20018};
		int[] itemcode11={20019,20020,20021,20022,20023,20024,20025,20026,20027,20028,
				20029,20030,20031,20032,20033,20035,20036,20037,20038,20039,20040,20041};
		String result=null;
		try {
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			String reportyear = request.getParameter("reportyear");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String time = format.format(new Date());
			String date1 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
			String key_name1 = "AB";//前缀角色表的
			String rptid = mappingtoolService.getSerialnumber(date1, key_name1);
			String opname = (String)request.getSession().getAttribute("opname");
			String[] name1=request.getParameterValues("name1");
			String[] name11=request.getParameterValues("name11");
			Finreport fixedasset=new Finreport();
			if(name1[18].equals(name11[21])){
				fixedasset.setIsbalance(1);
			}else{
				fixedasset.setIsbalance(0);
			}
			fixedasset.setOrgcode(companyInfo.getOrgcode());
			fixedasset.setCurrency("人民币");//币种
			fixedasset.setDeleteflag(0);
			fixedasset.setRptnote("资产负债信息表");//报表信息描述
			fixedasset.setRpttype("A");//报表类型
			fixedasset.setRptmonth(Integer.parseInt(reportyear));//报表年月
			fixedasset.setRptid(rptid);
			fixedasset.setCreateby(opname);
			fixedasset.setCreatedate(time);
			fixedasset.setUpdatedate(time);
			fixedasset.setAuditstatus(1);
			finreportService.add(fixedasset);
			fnnzcfz.setRpttype("A");
			fnnzcfz.setRptdate(time);
			fnnzcfz.setDeleteflag(0);
			fnnzcfz.setOrgcode(companyInfo.getOrgcode());
			fnnzcfz.setRptid(rptid);
			for(int i=0;i<name1.length;i++){
				if(name1[i]==null ||name1[i]==""){
					fnnzcfz.setItemvalue("0");
				}else{
					fnnzcfz.setItemvalue(name1[i]);
				}
				fnnzcfz.setItemcode(itemcode1[i]);
				String date2 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				String key_name2 = "AC";//前缀角色表的
				String assetid = mappingtoolService.getSerialnumber(date2, key_name2);
				fnnzcfz.setAssetid(assetid);
				fnnzcfz.setRptmonth(Integer.parseInt(reportyear));
				fnnzcfzService.add(fnnzcfz);
			}
			for(int i=0;i<name11.length;i++){
				//itemvalue not null  colunm
				if(name11[i]==null ||name11[i]==""){
					fnnzcfz.setItemvalue("0");
				}else{
					fnnzcfz.setItemvalue(name11[i]);
				}
				fnnzcfz.setItemcode(itemcode11[i]);
				String date3 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				String key_name3 = "AC";//前缀角色表的
				String assetid = mappingtoolService.getSerialnumber(date3, key_name3);
				fnnzcfz.setAssetid(assetid);
				fnnzcfz.setRptmonth(Integer.parseInt(reportyear));
				fnnzcfzService.add(fnnzcfz);
				}
			AuditReport auditreport = new AuditReport();
			auditreport.setReportid(aid);
			auditreport.setZstatus(1);
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}		 
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 查询&修改资产负债表记录
	 * @param model
	 * @param id
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="getFnnzcfz")
	public String getFnnzcfz(Model model,String reportMonth,int typeKey){
		Fnnzcfz fnnzcfz = new Fnnzcfz();
		fnnzcfz.setRptmonth(Integer.parseInt(reportMonth));
		List list=fnnzcfzService.queryAll(fnnzcfz);
		for(int i=1;i<list.size()+1;i++)
		model.addAttribute("fnnzcfz"+i,list.get(i-1));
		if(typeKey==1){
			return "/mf/financemng/auditreport/zcfzedit";
		}else{
			return "/mf/financemng/auditreport/zcfzview";
		}
		
	}
	
	/**
	 * 更新资产负债表修改的信息
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="updateFnnzcfz",method=RequestMethod.POST)
	public String updateFnnzcfz(Model model,Fnnzcfz fnnzcfz,HttpServletResponse response,HttpServletRequest request){		
		String result=null;
		try {		
			String[] assetids=request.getParameterValues("assetids");
			String[] name1=request.getParameterValues("name1");//19
			String[] name11=request.getParameterValues("name11");//22
			Date date = new Date();
			Finreport finreport=new Finreport();
			if(name1[18].equals(name11[21])){
				finreport.setIsbalance(1);
			}else{
				finreport.setIsbalance(0);
			}
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			finreport.setUpdatedate(sf.format(date));
			String opname = (String)request.getSession().getAttribute("opname");
			finreport.setUpdateby(opname);
			finreport.setRptid(fnnzcfz.getRptid());
			finreportService.modify(finreport);
			
			for(int i=0;i<name1.length;i++){
				//itemvalue not null  colunm
				if(name1[i]==null ||name1[i]==""){
					fnnzcfz.setItemvalue("0");
				}else{
					fnnzcfz.setItemvalue(name1[i]);
				}
				fnnzcfz.setAssetid(assetids[i]);
				fnnzcfzService.modify(fnnzcfz);
			}
			for(int i=19;i<name11.length+19;i++){
				//itemvalue not null  colunm
				if(name11[i-19]==null ||name11[i-19]==""){
					fnnzcfz.setItemvalue("0");
				}else{
					fnnzcfz.setItemvalue(name11[i-19]);
				}
				fnnzcfz.setAssetid(assetids[i]);
				fnnzcfzService.modify(fnnzcfz);
			}
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	/**
	 * 删除资产负债表记录
	 * @param model
	 * @param profitId
	 * @return
	 */
	@RequestMapping(value="deleteFnnzcfz",method=RequestMethod.POST)
	public String deleteFnnzcfz(Model model,String aid,String reportMonth, HttpServletResponse response){
		String result=null;
		try{
			Finreport f = new Finreport();
			f.setRpttype("A");
			f.setRptmonth(Integer.parseInt(reportMonth));
			finreportService.deleteByRptmonth(f);
			fnnzcfzService.deleteFnnzcfz(reportMonth);
			AuditReport auditreport = new AuditReport();
			auditreport.setReportid(aid);
			auditreport.setZstatus(0);
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		}catch(Exception e){
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	
	/**
	 * 跳到利润表新增页面
	 * @return
	 */
	@RequestMapping(value="addprofitUI")
	public String addprofitUI(Model model,String year,String aid){		
		model.addAttribute("year", year);
		model.addAttribute("aid", aid);
		return "/mf/financemng/auditreport/profitadd";
	}
	
	/**
	 * 保存新增利润表
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="addprofit")
	public String addprofit(Model model,String aid,ShareholderList profitlist,HttpServletResponse response,HttpServletRequest request){
		String result=null;
		try {
			String isbalance = request.getParameter("isbalance");
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			String reportyear = request.getParameter("reportyear");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String time = format.format(new Date());
			Finreport finreport = new Finreport();
			String date1 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
			String key_name1 = "AB";//前缀角色表的
			String rptid = mappingtoolService.getSerialnumber(date1, key_name1);
			finreport.setRptid(rptid);
			finreport.setOrgcode(companyInfo.getOrgcode());
			finreport.setRpttype("B");
			finreport.setRptmonth(Integer.parseInt(reportyear));
			finreport.setCurrency("人民币");
			finreport.setIsbalance(Integer.parseInt(isbalance));
			finreport.setRptnote("利润表");
			finreport.setDeleteflag(0);
			finreport.setCreatedate(time);
			finreport.setUpdatedate(time);
			finreport.setAuditstatus(1);
			finreportService.add(finreport);
			for(int i=0;i<profitlist.getProfitlist().size();i++){
				Profit profit = new Profit();
				String date2 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				String key_name2 = "AD";//前缀角色表的
				String profitid = mappingtoolService.getSerialnumber(date2, key_name2);
				profit.setProfitid(profitid);
				profit.setRptid(rptid);
				profit.setRptmonth(Integer.parseInt(reportyear));
				profit.setItemcode(profitlist.getProfitlist().get(i).getItemcode());
				profit.setOrgcode(companyInfo.getOrgcode());
				profit.setRpttype("B");
				if(profitlist.getProfitlist().get(i).getItemvalue()!=null&&!"".equals(profitlist.getProfitlist().get(i).getItemvalue())){
					profit.setItemvalue(profitlist.getProfitlist().get(i).getItemvalue());
				}
				profit.setDeleteflag(0);
				profitService.add(profit);
			}
			AuditReport auditreport = new AuditReport();
			auditreport.setReportid(aid);
			auditreport.setPstatus(1);
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}		 
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 查询&修改利润表记录
	 * @param model
	 * @param id
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="getProfit")
	public String getProfit(Model model,String rptmonth,int typeKey){
		List<Profit> list = profitService.getByRptmonth(rptmonth);
		for(int i=0;i<list.size();i++){
			model.addAttribute("profit"+i, list.get(i));
		}
		Finreport finreport1 = new Finreport();
		finreport1.setRpttype("B");
		finreport1.setRptmonth(Integer.parseInt(rptmonth));
		Finreport finreport = finreportService.getByRptmonth(finreport1);
		model.addAttribute("finreport", finreport);
		if(typeKey==1){
			return "/mf/financemng/auditreport/profitedit";
		}else{
			return "/mf/financemng/auditreport/profitview";
		}
		
	}
	
	/**
	 * 更新利润表修改的信息
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="updateprofit",method=RequestMethod.POST)
	public String updateProfit(Model model,ShareholderList profitlist,HttpServletResponse response,HttpServletRequest request){		
		String result=null;
		try {		
			String rptid = request.getParameter("rptid");
			for(int i=0;i<profitlist.getProfitlist().size();i++){
				Profit profit = profitlist.getProfitlist().get(i);
				profit.setRptid(rptid);
				profitService.modify(profit);
			}
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	/**
	 * 删除利润表记录
	 * @param model
	 * @param profitId
	 * @return
	 */
	@RequestMapping(value="deleteProfit",method=RequestMethod.POST)
	public String deleteProfit(Model model,String aid,String rptmonth, HttpServletResponse response){
		String result=null;
		try{
			Finreport f = new Finreport();
			f.setRpttype("B");
			f.setRptmonth(Integer.parseInt(rptmonth));
			finreportService.deleteByRptmonth(f);
			profitService.deleteProfit(rptmonth);
			AuditReport auditreport = new AuditReport();
			auditreport.setReportid(aid);
			auditreport.setPstatus(0);
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		}catch(Exception e){
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 *checkProfit
	 * @param model
	 * @param montime
	 * @return
	 *//*
	@RequestMapping(value="checkProfit")
	@ResponseBody
	public String checkProfit(Model model,String montime,HttpServletResponse response){
		String result="{\"msg\":\"fail\"}";
		try {
			Profit p = new Profit();
			p.setMontime(montime);
			p.setParentId(1);
			Profit profit = profitService.getProfit(p);
			if(profit==null){
				result = "{\"msg\":\"suc\"}";
			}else{
				result = "{\"msg\":\"fail\"}";
			}
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}*/
	
	/**
	 * 跳到现金流量表新增页面
	 * @return
	 */
	@RequestMapping(value="addcashUI")
	public String addcashUI(Model model,String year,String aid){
		model.addAttribute("year", year);
		model.addAttribute("aid", aid);
		return "/mf/financemng/auditreport/cashadd";
	}
	
	/**
	 * 保存新增现金流量表
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="addcash")
	public String addcash(Model model,String aid,FinanceCashFlow financeCashFlow,HttpServletResponse response,HttpServletRequest request){
		String result=null;
		try {
			String []itemvales=request.getParameterValues("name1");
			int[] itemcodes={40001,40002,40003,40004,40005,40006,40007,40008,
							 40009,40010,40011,40012,40013,40014,40015,40016,40017,40018,
							 40019,40020,40021,40022,40023,40024,40025,40026,
							 40027,40028,40029,40030,40031,40032,40033};
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			String reportyear = request.getParameter("reportyear");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String time = format.format(new Date());
			String orgcode=companyInfo.getOrgcode();
			Finreport fixedasset=new Finreport();
			fixedasset.setOrgcode(orgcode);
			fixedasset.setCurrency("人民币");//币种
			fixedasset.setDeleteflag(0);
			fixedasset.setRptnote("现金流量表");//报表信息描述
			fixedasset.setRpttype("D");//报表类型
			fixedasset.setRptmonth(Integer.parseInt(reportyear));
			String date1 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
			String key_name1 = "AB";//前缀角色表的
			String rptid =mappingtoolService.getSerialnumber(date1, key_name1);
			String opname = (String)request.getSession().getAttribute("opname");
			fixedasset.setRptid(rptid);
			fixedasset.setCreateby(opname);
			fixedasset.setCreatedate(time);
			fixedasset.setUpdatedate(time);
			fixedasset.setAuditstatus(1);
			finreportService.add(fixedasset);
			
			financeCashFlow.setRpttype("D");
			financeCashFlow.setOrgcode(orgcode);
			financeCashFlow.setDeleteflag(0);
			financeCashFlow.setRptid(rptid);
			for(int i=0;i<itemvales.length;i++){
				if(itemvales[i]==""||itemvales[i]==null){
					financeCashFlow.setItemvalue("0");
				}else{
					financeCashFlow.setItemvalue(itemvales[i]);
					}
				String date2 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				String key_name2 = "AK";//前缀角色表的
				String cashid = mappingtoolService.getSerialnumber(date2, key_name2);
				financeCashFlow.setCashid(cashid);
				financeCashFlow.setItemcode(itemcodes[i]);
				financeCashFlow.setRptmonth(Integer.parseInt(reportyear));
				financeCashFlowService.add(financeCashFlow);
			}
			AuditReport auditreport = new AuditReport();
			auditreport.setReportid(aid);
			auditreport.setXstatus(1);
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}		 
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 查询&修改现金流量表记录
	 * @param model
	 * @param id
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="getCashflow")
	public String getCashflow(Model model,String reportMonth){
		FinanceCashFlow f=new FinanceCashFlow();
		f.setRptmonth(Integer.parseInt(reportMonth));
		f.setDeleteflag(0);
		List list = financeCashFlowService.queryAll(f);
		for(int i=0;i<list.size();i++){
			model.addAttribute("financeCashFlow"+i,list.get(i));
		}
		
		return "/mf/financemng/auditreport/cashedit";
		
		
	}
	
	/**
	 * 查询&修改现金流量表记录
	 * @param model
	 * @param id
	 * @param parentId
	 * @return
	 */
	@RequestMapping(value="viewCashflow")
	public String viewCashflow(Model model,String reportMonth){
		FinanceCashFlow financeCashFlow = new FinanceCashFlow();
		financeCashFlow.setRptmonth(Integer.parseInt(reportMonth));
		financeCashFlow.setRpttype("D");
		List<FinanceCashFlow> list = financeCashFlowService.getCashflow(financeCashFlow);
		int t=list.size();
		if(list.size()==33){
			for(int i=0;i<list.size();i++){
				model.addAttribute("financeCashFlow"+i,list.get(i));
			}
		}else{
		list.get(33).setOrgcode(list.get(0).getRptmonth()+"");// 只有一个 bean 有另一个  rptmonth
		for(int j=33;j<list.size();j++){//从第33个开始另一个 月份开始   只为了少几回MODEL  而压在同一个BEAN  cashid==next month itemvalue
			list.get(j).setCashid(list.get(j-33).getItemvalue());
		}
		for(int i=33;i<list.size();i++){
			model.addAttribute("financeCashFlow"+(i-33),list.get(i));
		}
		}
		return "/mf/financemng/auditreport/cashview";
		
		
	}
	
	/**
	 * 更新现金流量表修改的信息
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="updateCashflow",method=RequestMethod.POST)
	public String updateCashflow(Model model,FinanceCashFlow financeCashFlow,HttpServletResponse response,HttpServletRequest request){		
		String result=null;
		try {		
			Date date = new Date();
			Finreport finreport=new Finreport();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			String opname = (String)request.getSession().getAttribute("opname");
			finreport.setUpdatedate(sf.format(date));
			finreport.setUpdateby(opname);
			finreport.setRptid(financeCashFlow.getRptid());
			finreportService.modify(finreport);
			String []itemvalues=request.getParameterValues("itemvalues");
			String []ids=request.getParameterValues("ids");
			for(int i=0;i<itemvalues.length;i++){
				financeCashFlow.setItemvalue(itemvalues[i]);
				financeCashFlow.setCashid(ids[i]);
				financeCashFlowService.modify(financeCashFlow);
			}
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	/**
	 * 删除现金流量表记录
	 * @param model
	 * @param profitId
	 * @return
	 */
	@RequestMapping(value="deleteCashflow",method=RequestMethod.POST)
	public String deleteCashflow(Model model,String aid,String reportMonth, HttpServletResponse response){
		String result=null;
		try{
			Finreport f = new Finreport();
			f.setRpttype("D");
			f.setRptmonth(Integer.parseInt(reportMonth));
			finreportService.deleteByRptmonth(f);
			financeCashFlowService.deleteCashflow(reportMonth);
			AuditReport auditreport = new AuditReport();
			auditreport.setReportid(aid);
			auditreport.setXstatus(0);
			auditReportService.modify(auditreport);
			result = "{\"msg\":\"suc\"}";
		}catch(Exception e){
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 跳到上传页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "upFileUI")
	public String upFileUI(Model model,String reportid) {
		model.addAttribute("reportid", reportid);
		return "/mf/financemng/auditreport/upfile";
	}
	
	/**
	 * 上传
	 * 
	 * @return
	 */
	@RequestMapping(value = "upLoadFile")
	@ResponseBody
	public String upLoadFile(Model model,String reportid,Fileupdown fd ,HttpServletResponse response,HttpServletRequest request) {
		String result=null;
		String time = Common.fromDateY();
		fd.setUpday(time);
		fd.setReportid(reportid);
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();  
		      // 当上传文件太大时，因为虚拟机能使用的内存是有限的，所以此时要通过临时文件来实现上传文件的保存  
		      // 此方法是设置是否使用临时文件的临界值（单位：字节）  
		      factory.setSizeThreshold(10000);  
		      ServletFileUpload upload = new ServletFileUpload(factory); 
		      upload.setHeaderEncoding("utf-8");
		      List<File> items;
		      Map<String,String> map = new HashMap<String, String>();
				items = upload.parseRequest(request);
				Iterator iter = items.iterator(); 
				
			      while (iter.hasNext()) {  
			          FileItem item = (FileItem) iter.next(); 
			          if (item.isFormField()) {  
			              //如果是普通表单字段  
			              String name = item.getFieldName();
			              String value= item.getString("utf-8");
						  map.put(name, value);
			          } else {  
			        	    //删除原文件
							String url = map.get("url");
							String filePath = request.getSession().getServletContext().getRealPath("/")+url;
							File file = new File(filePath);
							if(file!= null && file.exists()){
								file.delete();
							}
							
							//添加新文件
			                  String fileName = item.getName();
			                  DateFormat format1 = new SimpleDateFormat("yyyyMMddHHmmss");
			  				  String t = format1.format(new Date());
			  				  fileName = t +"_" +fileName;
			                  fd.setFilename(fileName);
			                  long filesize = item.getSize();
			                  fd.setFilesize(filesize);
			                  String filetype = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
			                  fd.setFiletype(filetype);
			                  FileOutputStream fos;
								String path=request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator+fileName;
								String path1="/upload/"+fileName;
								fd.setFilepath(path1);
								fos = new FileOutputStream(path);
								map.put("url",path1);
								if(item.isInMemory()){
										fos.write(item.get());
										fos.close();
								}else{
								    InputStream is=item.getInputStream();
								   	byte[] buffer=new byte[1024];
								   	int len;
							    	while((len=is.read(buffer))>0){
								    	fos.write(buffer,0,len);
								    }	
								    is.close();
								    fos.close();
								}
			            }  
			          }	      
			      fileupdownService.add(fd);
			      result = "{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 查询附件记录
	 * @param model
	 * @param fileupdown
	 * @return map
	 */
	@RequestMapping(value="queryFile")
    @ResponseBody
	public Map<String, Object> queryFile(Model model,String reportid,Fileupdown fileupdown,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		fileupdown.setReportid(reportid);
		pageView = fileupdownService.query(pageView, fileupdown);
		List<Fileupdown> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除附件记录
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="deleteFile")
	public String deleteFile(Model model,String filename, String id, HttpServletResponse response,HttpServletRequest request){
		String result=null;
		try{
			String	filepath = request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator+filename;
			File file = new File(filepath);
			if(file!= null && file.exists()){
				file.delete();
			}
			fileupdownService.delete(id);
			result = "{\"msg\":\"suc\"}";
		}catch(Exception e){
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 下载
	 * 
	 * @return
	 */
	@RequestMapping(value="upload")
	public void upload(String filename, HttpServletRequest request, HttpServletResponse response){
		try {			 
			 String path = request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator;
		        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
		        response.setContentType("multipart/form-data");  
		        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
		        response.setHeader( "Content-Disposition", "attachment;filename=" + new String( filename.getBytes("gb2312"), "ISO8859-1" )+ "" );  
		        ServletOutputStream out;
		        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
		        
		        File file = new File(path +filename );
		        
		        try {  
		        	FileInputStream inputStream = new FileInputStream(file);  
		            //3.通过response获取ServletOutputStream对象(out)  
		            out = response.getOutputStream();  
		            int b = 0;  
		            byte[] buffer = new byte[1024];  
		            while ((b= inputStream.read(buffer)) != -1){ 
		                
		                //4.写到输出流(out)中  
		                out.write(buffer,0,b);  
		                
		            } 
			            out.flush();
		                inputStream.close();
						out.close();
		            
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
}

