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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.entity.Fnnzcfz;
import com.mf.financemng.service.FinreportService;
import com.mf.financemng.service.FnnzcfzService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/fnnzcfz/")
public class FnnzcfzController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private FnnzcfzService fnnzcfzService;
	@Autowired
	private FinreportService finreportService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	/**
	 * 跳到list页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/zcfz/list1";
		return "/mf/financemng/zcfz/list";
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
	public Map<String, Object> showList(Model model,Fnnzcfz fnnzcfz, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = fnnzcfzService.query(pageView, fnnzcfz);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}

	@RequestMapping(value = "view")
	public String view(String id, HttpServletRequest request, Model model) {
		Fnnzcfz	fnnzcfz =new Fnnzcfz(); 
		fnnzcfz.setRptid(id);
			List list=fnnzcfzService.queryAll(fnnzcfz);
			for(int i=1;i<list.size()+1;i++)
			model.addAttribute("fnnzcfz"+i,list.get(i-1));
		return "/mf/financemng/zcfz/view";
	}

	@RequestMapping(value = "addUI")
	public String addUI() {
		return "/mf/financemng/zcfz/add";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(Fnnzcfz fnnzcfz, HttpServletResponse response, HttpServletRequest request){
		int[] itemcode1={20001,20002,20003,20004,20005,20006,20007,20008,20009,20010,
							20011,20012,20013,20014,20015,20016,20017,20042,20018};
		int[] itemcode11={20019,20020,20021,20022,20023,20024,20025,20026,20027,20028,
				20029,20030,20031,20032,20033,20035,20036,20037,20038,20039,20040,20041};
		String result = "{\"msg\":\"suc\"}";
		try {
			//get orgcode
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
				Date date = new Date();
				//java.sql.Date upd_date = new java.sql.Date(date.getTime());
				String id;
				// add first// 先   add 财务报表信息  
				SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
				//主键 的时间 
				String tooldate=sf.format(date);
				// String s= sf.format(new java.sql.Date(date.getTime()));
				String ids = mappingtoolService.getSerialnumber(tooldate, "AB");
				String opname = (String)request.getSession().getAttribute("opname");
				String[] name1=request.getParameterValues("name1");
				String[] name11=request.getParameterValues("name11");
				Finreport fixedasset=new Finreport();
		//UPDATEDATE FOR OTHER TABLE FINREPORT
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
				fixedasset.setRptmonth(fnnzcfz.getRptmonth());//报表年月
				//主键  也是下面的 外键		parid
				fixedasset.setRptid(ids);
				fixedasset.setCreateby(opname);
				fixedasset.setCreatedate(tooldate);
				fixedasset.setUpdatedate(tooldate);
				fixedasset.setAuditstatus(0);
				fnnzcfz.setRpttype("A");
				fnnzcfz.setRptdate(Common.fromDateY());
				fnnzcfz.setDeleteflag(0);
				fnnzcfz.setOrgcode(companyInfo.getOrgcode());
				fnnzcfz.setRptid(ids);// 外键
				for(int i=0;i<name1.length;i++){
						fnnzcfz.setItemvalue(name1[i]);
					fnnzcfz.setItemcode(itemcode1[i]);
					//生成主键
					// id = mappingtoolService.getSerialnumber(tooldate, "AC");
					 id=UUID.randomUUID().toString();
					fnnzcfz.setAssetid(id);
					fnnzcfzService.add(fnnzcfz);
				}
				for(int i=0;i<name11.length;i++){
						fnnzcfz.setItemvalue(name11[i]);
					fnnzcfz.setItemcode(itemcode11[i]);
					//生成主键
					// id = mappingtoolService.getSerialnumber(tooldate, "AC");
					id=UUID.randomUUID().toString();
					fnnzcfz.setAssetid(id);
					fnnzcfzService.add(fnnzcfz);			
					}
				//先增加子表  后增加父表
				finreportService.add(fixedasset);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value = "editUI")
	public String editUI(String id,Model model) {
	Fnnzcfz	fnnzcfz =new Fnnzcfz(); 
	fnnzcfz.setRptid(id);
		List list=fnnzcfzService.queryAll(fnnzcfz);
		for(int i=1;i<list.size()+1;i++)
		model.addAttribute("fnnzcfz"+i,list.get(i-1));
		return "/mf/financemng/zcfz/edit";
	}
	@RequestMapping(value="edit")
	@ResponseBody
	public String edit(Fnnzcfz fnnzcfz, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
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
					fnnzcfz.setItemvalue(name1[i]);
				fnnzcfz.setAssetid(assetids[i]);
				fnnzcfzService.modify(fnnzcfz);
			}
			for(int i=19;i<name11.length+19;i++){
					fnnzcfz.setItemvalue(name11[i-19]);
				fnnzcfz.setAssetid(assetids[i]);
				fnnzcfzService.modify(fnnzcfz);
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
				//id==rptid
				finreportService.deleteByRptid(id);
				fnnzcfzService.deleteByFlag(id);
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
			Fnnzcfz fnnzcfz = fnnzcfzService.getByReport(reportMonth);
			if (fnnzcfz==null) {
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

