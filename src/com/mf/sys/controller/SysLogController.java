package com.mf.sys.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.sys.entity.SysLog;
import com.mf.sys.service.SysLogService;
import com.mf.util.Common;
import com.mf.util.PageView;

@Controller
@RequestMapping(value = "/mf/sys/sysLog")
public class SysLogController {
	
	@Autowired
	SysLogService sysLogService;
	
	
	@RequestMapping(value = "/toList.html")
	public String list() {
		return "/mf/sys/log/log_list";
	}
	
	@RequestMapping(value = "/getLogPagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getLogPagerList(Model model,HttpServletRequest request,SysLog sysLog) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		String sdate = request.getParameter("sdate");
		String edate = request.getParameter("edate");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		
		Map map = new HashMap();
		if(Common.isEmpty(sdate) && Common.isEmpty(edate)){
			//开始和结束时间都为空,直接查询
			pageView =sysLogService.query(pageView, sysLog);
	    }else{
	    	pageView =sysLogService.queryDate(pageView, sysLog, sdate, edate);
	    }
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
		
}
