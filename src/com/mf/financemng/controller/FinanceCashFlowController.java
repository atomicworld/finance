/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.financemng.entity.FinanceCashFlow;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.service.FinanceCashFlowService;
import com.mf.financemng.service.FinreportService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-21
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financecashflow/")
public class FinanceCashFlowController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	@Autowired
	FinreportService finreportService;
	@Autowired
	private FinanceCashFlowService financeCashFlowService;
	
	/**
	 * 跳到list页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/xjll/list1";
		return "/mf/financemng/xjll/list";
	}
	/**
	 * 提供list展示界面的数据
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model,FinanceCashFlow financeCashFlow, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = financeCashFlowService.query(pageView, financeCashFlow);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}

	@RequestMapping(value = "view")
	public String view(String id,String reportMonth, HttpServletRequest request, Model model) {
		//FinanceCashFlow f=new FinanceCashFlow();f.
	//	f.setRptid(id);
		//f.setDeleteflag(0);
		List<FinanceCashFlow> list = financeCashFlowService.getByReportview(reportMonth);
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
		return "/mf/financemng/xjll/view";
	}

	@RequestMapping(value = "addUI")
	public String addUI() {
		return "/mf/financemng/xjll/add";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(FinanceCashFlow financeCashFlow, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			String []itemvales=request.getParameterValues("name1");
			// add finreport table
			String id;
			int[] itemcodes={40001,40002,40003,40004,40005,40006,40007,40008,
							 40009,40010,40011,40012,40013,40014,40015,40016,40017,40018,
							 40019,40020,40021,40022,40023,40024,40025,40026,
							 40027,40028,40029,40030,40031,40032,40033};//33
			// get orgcode
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			String orgcode=companyInfo.getOrgcode();
			Finreport fixedasset=new Finreport();
			fixedasset.setOrgcode(orgcode);
			fixedasset.setCurrency("人民币");//币种
			fixedasset.setDeleteflag(0);
			fixedasset.setRptnote("现金流量表");//报表信息描述
			fixedasset.setRpttype("D");//报表类型
			fixedasset.setRptmonth(financeCashFlow.getRptmonth());//报表年月
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			Date date2 = new Date();
			String key_name = "Ak";//现金流量表
			//java.sql.Date upd_date = new java.sql.Date(date2.getTime());
			String tooldate=sf.format(date2);
			String ids = mappingtoolService.getSerialnumber(tooldate, "AB");
			String opname = (String)request.getSession().getAttribute("opname");
			//主键  也是下面的 外键		rptid   ==ids  
			fixedasset.setRptid(ids);
			fixedasset.setCreateby(opname);
			fixedasset.setCreatedate(tooldate);
			fixedasset.setUpdatedate(tooldate);//add  update==createdate
			fixedasset.setAuditstatus(0);
			financeCashFlow.setRpttype("D");
			financeCashFlow.setOrgcode(orgcode);
			financeCashFlow.setDeleteflag(0);
			financeCashFlow.setRptid(ids);
			for(int i=0;i<itemvales.length;i++){
					//itemvalue  nullable
				financeCashFlow.setItemvalue(itemvales[i]);
				//id = mappingtoolService.getSerialnumber(tooldate, key_name);
				id=UUID.randomUUID().toString(); 
				financeCashFlow.setCashid(id);
				financeCashFlow.setItemcode(itemcodes[i]);
				financeCashFlowService.add(financeCashFlow);
			}
			// 先   add 财务报表信息   
			finreportService.add(fixedasset);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value = "editUI")
	public String editUI(String id,Model model) {
		FinanceCashFlow f=new FinanceCashFlow();
		f.setRptid(id);
		f.setDeleteflag(0);
		List list = financeCashFlowService.queryAll(f);
		for(int i=0;i<list.size();i++){
			model.addAttribute("financeCashFlow"+i,list.get(i));
		}
		return "/mf/financemng/xjll/edit";
	}
	@RequestMapping(value="edit")
	@ResponseBody
	public String edit(FinanceCashFlow financeCashFlow, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			Date date = new Date();
			Finreport finreport=new Finreport();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			String opname = (String)request.getSession().getAttribute("opname");
			finreport.setUpdatedate(sf.format(date));
			finreport.setUpdateby(opname);
			finreport.setRptid(financeCashFlow.getRptid());
			finreportService.modify(finreport);//update table finreport by rptid  set updatedate,updateby
			
			String []itemvalues=request.getParameterValues("itemvalues");
			String []ids=request.getParameterValues("ids");
			for(int i=0;i<itemvalues.length;i++){
				financeCashFlow.setItemvalue(itemvalues[i]);
				financeCashFlow.setCashid(ids[i]);
				financeCashFlowService.modify(financeCashFlow);
			}
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public String delete(String id, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			//delete  finreport   and financecashflow  two table
			finreportService.deleteByRptid(id);
			financeCashFlowService.deleteByFlag(id);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value="checkReportMonth")
	@ResponseBody
	public String checkReportMonth(String reportMonth, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			FinanceCashFlow financeCashFlow = financeCashFlowService.getByReport(reportMonth);
			if (financeCashFlow==null) {
				result = "{\"msg\":\"suc\"}";
			}else {
				result = "{\"msg\":\"fail\"}";
			}
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
}

