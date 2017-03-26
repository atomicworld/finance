/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.mf.financemng.entity.FinanceShareholder;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.service.FinanceShareholderService;
import com.mf.financemng.service.FinreportService;
import com.mf.shareholder.entity.ShareholderList;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author wangzhi
 * @2015-08-23
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financeshareholder/")
public class FinanceShareholderController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	@Autowired
	private FinanceShareholderService financeShareholderService;
	@Autowired
	private FinreportService finreportService;
	/**
	 * 提供list展示界面的数据
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	/**
	 * 跳到list页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/gdqy/list1";
		return "/mf/financemng/gdqy/list";
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model,FinanceShareholder financeShareholder, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = financeShareholderService.query(pageView, financeShareholder);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	@RequestMapping(value="delete")
	@ResponseBody
	public String delete(String id, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"status\":\"1\"}";
		try {
			//delete  finreport   and financecashflow  two table  //id==rptid
			finreportService.deleteByRptid(id);
			financeShareholderService.deleteByIdRptid(id);
			} catch (Exception e) {
				result = "{\"status\":\"0\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value = "view")
	public String view(String code, HttpServletRequest request, Model model) {
		FinanceShareholder financeShareholder = new FinanceShareholder();
		financeShareholder.setParedId(code);
		List<FinanceShareholder> shareholderlist = financeShareholderService.queryAll(financeShareholder);
		for (int i = 0; i < shareholderlist.size(); i++) {
			model.addAttribute("item"+(i+1), shareholderlist.get(i));
		}
		return "/mf/financemng/gdqy/view";
	}

	@RequestMapping(value = "addUI")
	public String addUI() {
		return "/mf/financemng/gdqy/add";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(ShareholderList shareholdlist,String reportMonth, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		String id;
		String[] itemcodes={"50001","50002","50003","50004","50005","50006",
							"50007","50008","50009","50010","50011","50012",
							"50013","50014","50015","50016","50017","50018",
							"50019","50020","50021","50022","50023","50024","50025","50026"};
		// get orgcode
		CompanyInfo companyInfo=new CompanyInfo();
		companyInfo=companyInfoService.getCompanyInfo(companyInfo);
		String orgcode=companyInfo.getOrgcode();
		Finreport fixedasset=new Finreport();
		fixedasset.setOrgcode(orgcode);
		fixedasset.setCurrency("人民币");//币种
		fixedasset.setDeleteflag(0);
		fixedasset.setRptnote("股东权益变动表");//报表信息描述
		fixedasset.setRpttype("E");//报表类型
		fixedasset.setRptmonth(Integer.parseInt(reportMonth));//报表年月
		SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
		Date date2 = new Date();
		String key_name = "AG";//股东权益变动表
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
		try {
				List<FinanceShareholder> listsh=new ArrayList();
			for (int i = 0; i < shareholdlist.getShareholdlist().size(); i++) {
				//生成主键
				//date2 = new Date();
				// upd_date = new java.sql.Date(date2.getTime());
				//id = mappingtoolService.getSerialnumber(tooldate, key_name);
				id=UUID.randomUUID().toString(); 
				FinanceShareholder financeShareholder = shareholdlist.getShareholdlist().get(i);
				financeShareholder.setId(id);//主键
				financeShareholder.setRptbatch(reportMonth);//年月
				financeShareholder.setParedId(ids);//外键
				financeShareholder.setOrgcode(orgcode);
				financeShareholder.setValidate("E");//报表类型
				financeShareholder.setDeleteflag("0");
				financeShareholder.setItemcode(itemcodes[i]);
				listsh.add(financeShareholder);
				financeShareholderService.add(financeShareholder);
			}
			// 先   add 财务报表信息   
			finreportService.add(fixedasset);
			//financeShareholderService.addlistbean(listsh);
			} catch (Exception e) {
				e.printStackTrace();
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value = "editUI")
	public String editUI(String code,Model model) {
		FinanceShareholder financeShareholder = new FinanceShareholder();
		financeShareholder.setParedId(code);
		List<FinanceShareholder> shareholderlist = financeShareholderService.queryAll(financeShareholder);
		for (int i = 0; i < shareholderlist.size(); i++) {
			model.addAttribute("item"+(i+1), shareholderlist.get(i));
		}
		//model.addAttribute("shareholderlist",shareholderlist);
		return "/mf/financemng/gdqy/edit";
	}
	@RequestMapping(value="edit")
	@ResponseBody
	public String edit(ShareholderList shareholdlist, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
	//UPDATEDATE FOR OTHER TABLE FINREPORT
			Date date=new Date();
			Finreport finreport=new Finreport();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			finreport.setUpdatedate(sf.format(date));
			String opname = (String)request.getSession().getAttribute("opname");
			finreport.setUpdateby(opname);
			finreport.setRptid(request.getParameter("finreportid"));
			for (int i = 0; i < shareholdlist.getShareholdlist().size(); i++) {
				FinanceShareholder financeShareholder = shareholdlist.getShareholdlist().get(i);
				financeShareholderService.modify(financeShareholder);
			}
			//子表先更新
			finreportService.modify(finreport);
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
			//sure month is only  
			FinanceShareholder fReportCode = financeShareholderService.getById(reportMonth);
			if (fReportCode==null) {
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

