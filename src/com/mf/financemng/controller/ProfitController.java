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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.entity.Profit;
import com.mf.financemng.service.FinreportService;
import com.mf.financemng.service.FinreportitemService;
import com.mf.financemng.service.ProfitService;
import com.mf.shareholder.entity.ShareholderList;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/profit/")
public class ProfitController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private ProfitService profitService;
	
	@Autowired
	private FinreportitemService finreportitemService; 
	
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	
	@Autowired
	private FinreportService finreportService;
	
	@Autowired
	private CompanyInfoServiceImpl  companyInfoService;
	
	
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/profit/list1";
		return "/mf/financemng/profit/list";
	}
	
	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model, Profit profit, 
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
		pageView =profitService.query(pageView, profit);
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
	public String addUI(Model model,String pitemcode){
		String year = Common.fromDateYear();
		model.addAttribute("year", year);
		return "/mf/financemng/profit/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ShareholderList profitlist,HttpServletResponse response,HttpServletRequest request){
		String result=null;
		try {	
			String opname = (String)request.getSession().getAttribute("opname");
				String isbalance = request.getParameter("isbalance");
				CompanyInfo companyInfo=new CompanyInfo();
				companyInfo=companyInfoService.getCompanyInfo(companyInfo);
				String rptmonth = request.getParameter("rptmonth");
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String time = format.format(new Date());
				Finreport finreport = new Finreport();
				String date1 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				String key_name1 = "AB";//前缀角色表的
				String rptid = mappingtoolService.getSerialnumber(date1, key_name1);
				finreport.setRptid(rptid);
				finreport.setOrgcode(companyInfo.getOrgcode());
				finreport.setRpttype("B");
				finreport.setRptmonth(Integer.parseInt(rptmonth));
				finreport.setCurrency("人民币");
				finreport.setIsbalance(Integer.parseInt(isbalance));
				finreport.setRptnote("利润表");
				finreport.setDeleteflag(0);
				finreport.setCreatedate(time);
				finreport.setCreateby(opname);
				finreport.setUpdatedate(time);
				finreport.setAuditstatus(0);
				finreportService.add(finreport);
				Profit profit = new Profit();
				String date2 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				String key_name2 = "AD";//前缀角色表的
				profit.setRptid(rptid);
				profit.setRptmonth(Integer.parseInt(rptmonth));
				profit.setOrgcode(companyInfo.getOrgcode());
				profit.setRpttype("B");
				profit.setDeleteflag(0);
			for(int i=0;i<profitlist.getProfitlist().size();i++){
				//Profit profit = new Profit();
				//String date2 = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
				//String key_name2 = "AD";//前缀角色表的
				//String profitid = mappingtoolService.getSerialnumber(date2, key_name2);
				String profitid = UUID.randomUUID().toString(); 
				profit.setProfitid(profitid);
				//profit.setRptid(rptid);
				//profit.setRptmonth(Integer.parseInt(rptmonth));
				profit.setItemcode(profitlist.getProfitlist().get(i).getItemcode());
				//profit.setOrgcode(companyInfo.getOrgcode());
				//profit.setRpttype("B");profit.setDeleteflag(0);
				//if(profitlist.getProfitlist().get(i).getItemvalue()!=null&&!"".equals(profitlist.getProfitlist().get(i).getItemvalue())){
					profit.setItemvalue(profitlist.getProfitlist().get(i).getItemvalue());
				//}
				profitService.add(profit);
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
	 * 根据id删除
	 * @param model
	 * @param profitId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteById(Model model,String rptid, HttpServletResponse response){
		String result=null;
		try{
			finreportService.deleteByRptid(rptid);
			profitService.deleteById(rptid);
			result = "{\"msg\":\"suc\"}";
		}catch(Exception e){
			result = "{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 修改单条记录
	 * @param model
	 * @param profitId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getByRptid")
	public String getByRptid(Model model,String rptid){
		String year = Common.fromDateYear();
		model.addAttribute("year", year);
		List<Profit> list = profitService.getByRptid(rptid);
		for(int i=0;i<list.size();i++){
			model.addAttribute("profit"+i, list.get(i));
		}
		Finreport finreport = finreportService.getByRptid(rptid);
		model.addAttribute("finreport", finreport);
		String s =finreport.getRptmonth()+"";
		s = s.substring(0, s.length()-2);
		String s1 = s+"01";
		Profit profit = new Profit();
		profit.setRptmonthstart(Integer.parseInt(s1));
		profit.setRptmonth(finreport.getRptmonth());
		List<Profit> list1 = profitService.query2(profit);
		for(int i=0;i<list1.size();i++){
			model.addAttribute("sumvalue"+i, list1.get(i).getItemvalue());
		}
		return "/mf/financemng/profit/edit";
		
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param profit
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Model model,ShareholderList profitlist,HttpServletResponse response,HttpServletRequest request){		
		String result=null;
		try {
			String isbalance = request.getParameter("isbalance");
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			String time = format.format(new Date());
			String rptid = request.getParameter("rptid");
			Finreport finreport = new Finreport();
			finreport.setRptid(rptid);
			finreport.setIsbalance(Integer.parseInt(isbalance));
			finreport.setUpdatedate(time);
			finreportService.modify(finreport);
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
	 * 查看单条记录
	 * @param model
	 * @param montime
	 * @return
	 */
	@RequestMapping(value="view")
	public String view(Model model,String rptid){
		List<Profit> list = profitService.getByRptid(rptid);
		for(int i=0;i<list.size();i++){
			model.addAttribute("profit"+i, list.get(i));
		}
		Finreport finreport = finreportService.getByRptid(rptid);
		model.addAttribute("finreport", finreport);
		String s =finreport.getRptmonth()+"";
		s = s.substring(0, s.length()-2);
		String s1 = s+"01";
		Profit profit = new Profit();
		profit.setRptmonthstart(Integer.parseInt(s1));
		profit.setRptmonth(finreport.getRptmonth());
		List<Profit> list1 = profitService.query2(profit);
		for(int i=0;i<list1.size();i++){
			model.addAttribute("sumvalue"+i, list1.get(i).getItemvalue());
		}
		return "/mf/financemng/profit/view";
		
	}
	
	/**
	 *根据月份查记录
	 * @param model
	 * @param rptmonth
	 * @return
	 */
	@RequestMapping(value="checkReportMonth")
	@ResponseBody
	public String checkReportMonth(Model model,String rptmonth,HttpServletResponse response){
		String result=null;
		try {
			List<Profit> list = profitService.getByRptmonth(rptmonth);
			if(list.size()>0){
				result = "{\"msg\":\"fail\"}";
			}else{
				result = "{\"msg\":\"suc\"}";
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
	 * @param montime
	 * @return
	 */
	@RequestMapping(value="checkMonth")
	@ResponseBody
	public String checkMonth(Model model,String rptmonth,HttpServletResponse response){
		String result=null;
		try {
			DateFormat format1 = new SimpleDateFormat("yyyyMM");
			String t = format1.format(new Date());
			if(Integer.parseInt(rptmonth)<=Integer.parseInt(t)){
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
	
	
	
	
	
	
}

