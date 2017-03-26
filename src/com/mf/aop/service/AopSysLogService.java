/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.service;

import java.util.List;

import com.mf.aop.entity.AopSysLog;
import com.mf.sys.entity.SysLog;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-09-21
 * @version 1.0
 * @param <T>
 */

public interface AopSysLogService{

	public PageView query(PageView pageView,AopSysLog aopSysLog);
	
	public List<AopSysLog> queryAll(AopSysLog aopSysLog);
	
	public void add(AopSysLog aopSysLog);
	
	
	public void delete(String id);
	
	public void modify(AopSysLog aopSysLog);
	
	public AopSysLog getById(String id);
	
	public List<AopSysLog> findAll();
	
	public PageView queryDate(PageView pageView, AopSysLog aopSysLog, String sdate, String edate);
	
}
