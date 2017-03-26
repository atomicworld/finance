package com.mf.sys.service;

import javax.servlet.http.HttpServletRequest;

import com.mf.sys.entity.SysLog;
import com.mf.util.PageView;

public interface SysLogService{
	
	public PageView query(PageView pageView,SysLog sysLog);
	
	public PageView queryDate(PageView pageView, SysLog syslog, String sdate, String edate);
	
	public void add(SysLog sysLog);
	
	public void delete(String id);
	
	public void logger(String type,String obj,String table,String desc,HttpServletRequest request);
}
