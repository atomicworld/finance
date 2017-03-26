/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.aop.controller;

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

import com.mf.aop.entity.AopSysLog;
import com.mf.aop.service.AopSysLogService;
import com.mf.financemng.entity.FinanceCashFlow;
import com.mf.org.entity.Operator;
import com.mf.org.service.impl.OperatorServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author wangzhi
 * @2015-09-22
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/aopsyslog/")
public class AopSysLogController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private AopSysLogService aopSysLogService;
	@Autowired 
	private OperatorServiceImpl operatorServiceImpl;
	
	/**
	 * 跳到list页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(Model model){
		return "/mf/sys/logmanage/list";
	}
	/**
	 * 提供list展示界面的数据
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "showlist")
	@ResponseBody
	public Map<String, Object> showList(Model model,AopSysLog aopSysLog, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		String opno = request.getParameter("opnm");
		String status = request.getParameter("status");
		if (opno!=null && !"".equals(opno)) {
			Operator operator = operatorServiceImpl.getById(opno);
			aopSysLog.setOpnm(operator.getOpnm());
		}
		if (status!=null && !"".equals(status)) {
			aopSysLog.setStatus(Integer.parseInt(status));
		}
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		if(Common.isEmpty(sdate) && Common.isEmpty(edate)){
			//开始和结束时间都为空,直接查询
			pageView =aopSysLogService.query(pageView, aopSysLog);
	    }else{
	    	pageView =aopSysLogService.queryDate(pageView, aopSysLog, sdate, edate);
	    }
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}

	@RequestMapping(value = "view")
	public String view(String code,String reportMonth, HttpServletRequest request, Model model) {
		System.out.println("code===="+code);
		AopSysLog aopSysLog = aopSysLogService.getById(code);
		model.addAttribute("aopSysLog", aopSysLog);
		return "/mf/sys/logmanage/view";
	}
}

