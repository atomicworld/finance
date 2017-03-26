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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.financemng.entity.FinanceCondition;
import com.mf.financemng.service.FinanceConditionService;
import com.mf.financemng.service.FinanceRefundInfoService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.BanknamesService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financecondition/")
public class FinanceConditionController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	FinanceRefundInfoService financeRefundInfoService;
	@Autowired
	private FinanceConditionService financeConditionService;
	@Autowired
	private BanknamesService banknamesService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	
	@RequestMapping(value = "list")
	public String capitalPage(HttpServletRequest request) {
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/financemng/fnncondition/list1";
		return "/mf/financemng/fnncondition/list";
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
	public Map<String, Object> showList(Model model,FinanceCondition financeCondition, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		financeCondition.setDeleteflag(0);
		pageView = financeConditionService.query(pageView,financeCondition);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	@RequestMapping(value = "addUI")
	public String addUI() {
		return "/mf/financemng/fnncondition/add";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(FinanceCondition financeCondition,String loandepart1,  HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		//bankno   is  only  check it 
		String bankno=financeCondition.getBankno();
		FinanceCondition financeCondition2=financeConditionService.checkbankno(bankno);
		if(financeCondition2==null){
		if ("2".equals(financeCondition.getChanneltype()) || "4".equals(financeCondition.getChanneltype())|| "5".equals(financeCondition.getChanneltype())) {
			financeCondition.setBankname(loandepart1);
		}
		CompanyInfo companyInfo=new CompanyInfo();
		companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			Date date = new Date();
			java.sql.Date upd_date = new java.sql.Date(date.getTime());
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			 String s= sf.format(new java.sql.Date(date.getTime()));
			String id = mappingtoolService.getSerialnumber(s, "AR");
			String opname = (String)request.getSession().getAttribute("opname");
			financeCondition.setOrgcode(companyInfo.getOrgcode());
			financeCondition.setDeleteflag(0);
			financeCondition.setLoanmoneyid(id);
			financeCondition.setCreateby(opname);
			financeCondition.setCreatedate(sf.format(date));
			financeCondition.setUpdatedate(sf.format(date));
			financeCondition.setLoanbalance(financeCondition.getSumamount());//借款余额
		
		try {
				financeConditionService.add(financeCondition);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		}
		else{
			result = "{\"msg\":\"error\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value = "editUI")
	public String editUI(String loanno,Model model) {
		FinanceCondition financeCondition = financeConditionService.getById(loanno);
		model.addAttribute("financeCondition",financeCondition);
		return "/mf/financemng/fnncondition/edit";
	}
	@RequestMapping(value = "view")
	public String view(String loanno, HttpServletRequest request, Model model) {
		FinanceCondition financeCondition = financeConditionService.getById(loanno);
		model.addAttribute("financeCondition", financeCondition);
		return "/mf/financemng/fnncondition/view";
	}
	
	@RequestMapping(value="edit")
	@ResponseBody
	public String edit(FinanceCondition financeCondition,String sumamount2,String loandepart1, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		//更新借款平衡
		String sumamountnow=financeCondition.getSumamount();
		Float sumamt=Float.parseFloat(sumamountnow)-Float.parseFloat(sumamount2);	//sumamount now  >= sumamountreturn	
		if(sumamt>=0){
			financeCondition.setLoanbalance(sumamt+"");
		if ("2".equals(financeCondition.getChanneltype()) ||"5".equals(financeCondition.getChanneltype())|| "4".equals(financeCondition.getChanneltype())) {
			financeCondition.setBankname(loandepart1);
		}
		try {
			Date date = new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			financeCondition.setUpdatedate(sf.format(date));
			String opname = (String)request.getSession().getAttribute("opname");
			financeCondition.setUpdateby(opname);
			financeCondition.setUpdatedate(sf.format(date));
				financeConditionService.modify(financeCondition);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		}
		else{
			result = "{\"msg\":\"error\"}";
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public String delete(String loanmoneyid , HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			financeConditionService.delete(loanmoneyid);
			//DELETE CHILD TABLE
			financeRefundInfoService.deleteParentId(loanmoneyid);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="checkLoanno")
	@ResponseBody
	public String checkLoanno(String loanno, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
			FinanceCondition financeCondition = financeConditionService.getById(loanno);//LOANNO==LOANMONEYID
			if (financeCondition==null) {
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

