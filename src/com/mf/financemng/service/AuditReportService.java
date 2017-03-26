/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.AuditReport;
import com.mf.financemng.entity.Profit;
import com.mf.util.*;



/**
 * @author wangyw
 * @2015-08-18
 * @version 1.0
 * @param <T>
 */

public interface AuditReportService{

	public PageView query(PageView pageView,String search,AuditReport auditReport);
	
	public List<AuditReport> queryAll(AuditReport auditReport);
	
	public void add(AuditReport auditReport);
	
	public void addAll(AuditReport auditReport);
	
	public void modify(AuditReport auditReport);
	
	public AuditReport getById(String reportid);
	
	public List<AuditReport> findAll();
	
	public void deleteById(String reportid);
	
	public AuditReport getByYear(String reportyear);
	
	
	
}
