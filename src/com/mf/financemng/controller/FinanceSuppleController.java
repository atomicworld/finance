/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.financemng.entity.FinanceSupple;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.service.FinanceSuppleService;
import com.mf.financemng.service.FinreportService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financesupple/")
public class FinanceSuppleController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	@Autowired
	FinreportService finreportService;
	@Autowired
	private FinanceSuppleService financeSuppleService;
	/**
	 * 跳到list页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/cwbc/list1";
		return "/mf/financemng/cwbc/list";
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
	public Map<String, Object> showList(Model model,FinanceSupple financeSupple, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = financeSuppleService.query(pageView, financeSupple);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}

	@RequestMapping(value = "view")
	public String view(String id, HttpServletRequest request, Model model) {
		FinanceSupple f=new FinanceSupple();
		f.setRptid(id);
		f.setDeleteflag(0);
		List list = financeSuppleService.queryAll(f);
		for(int i=0;i<list.size();i++){
			model.addAttribute("financeSupple"+i,list.get(i));
		}
		return "/mf/financemng/cwbc/view";
	}

	@RequestMapping(value = "addUI")
	public String addUI() {
		return "/mf/financemng/cwbc/add";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(FinanceSupple financeSupple,String rptmonth, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			String id;
			int[] itemcodes={30001,30002,30003,30004,30005,30006,30007,30008,
							30009,30010,30011,30014,30015};
			String[] itemvalues=request.getParameterValues("itemvalues");
			// get orgcode
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			String orgcode=companyInfo.getOrgcode();
			Finreport fixedasset=new Finreport();
			fixedasset.setOrgcode(orgcode);
			fixedasset.setCurrency("人民币");//币种
			fixedasset.setDeleteflag(0);
			fixedasset.setRptnote("财务补充表");//报表信息描述
			fixedasset.setRpttype("F");//报表类型
			fixedasset.setRptmonth(Integer.parseInt(rptmonth));//报表年月
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			Date date2 = new Date();
			String key_name = "AF";//财务补充表
			//java.sql.Date upd_date = new java.sql.Date(date2.getTime());
			String tooldate=sf.format(date2);
			String ids = mappingtoolService.getSerialnumber(tooldate, "AB");
			String opname = (String)request.getSession().getAttribute("opname");
			//主键  也是下面的 外键		parid
			fixedasset.setRptid(ids);
			fixedasset.setCreateby(opname);
			fixedasset.setCreatedate(tooldate);
			fixedasset.setUpdatedate(tooldate);
			fixedasset.setAuditstatus(0);
				financeSupple.setRpttype("F");
				financeSupple.setDeleteflag(0);
				financeSupple.setRptid(ids);
				financeSupple.setOrgcode(orgcode);
			for(int i=0;i<itemvalues.length;i++){
				//id = mappingtoolService.getSerialnumber(tooldate, key_name);
				id=UUID.randomUUID().toString(); 
				financeSupple.setFinreportaddid(id);
				financeSupple.setRpttype("F");
				//itemvalue nullable
				financeSupple.setItemvalue(itemvalues[i]);
				financeSupple.setItemcode(itemcodes[i]);
				financeSuppleService.add(financeSupple);
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
		FinanceSupple f=new FinanceSupple();
		f.setRptid(id);
		f.setDeleteflag(0);
		List list = financeSuppleService.queryAll(f);
		for(int i=0;i<list.size();i++){
			model.addAttribute("financeSupple"+i,list.get(i));
		}
		return "/mf/financemng/cwbc/edit";
	}
	@RequestMapping(value="edit")
	@ResponseBody
	public String edit(FinanceSupple financeSupple, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			//financeSupple.setUpdatedate(Common.fromDateY());
			Date date = new Date();
			Finreport finreport=new Finreport();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			finreport.setUpdatedate(sf.format(date));
			String opname = (String)request.getSession().getAttribute("opname");
			finreport.setUpdateby(opname);
			finreport.setRptid(financeSupple.getRptid());
			finreportService.modify(finreport);
			
			String []itemvalues=request.getParameterValues("itemvalues");
			String []ids=request.getParameterValues("ids");
			for(int i=0;i<itemvalues.length;i++){
				financeSupple.setItemvalue(itemvalues[i]);
				financeSupple.setFinreportaddid(ids[i]);
				financeSuppleService.modify(financeSupple);
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
			//ID = rptid
				finreportService.deleteByRptid(id);
				financeSuppleService.deleteByFlag(id);
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
			FinanceSupple financeSupple = financeSuppleService.getByReport(reportMonth);
			if (financeSupple==null) {
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

