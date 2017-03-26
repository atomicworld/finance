/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.Finreport;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2016-01-08
 * @version 1.0
 * @param <T>
 */

public interface FinreportService{

	public PageView query(PageView pageView,Finreport finreport);
	
	public List<Finreport> queryAll(Finreport finreport);
	
	public void add(Finreport finreport);
	
	public void addAll(Finreport finreport);
	
	public void deleteByRptid(String rptid);
	
	public void modify(Finreport finreport);
	
	public Finreport getByRptid(String rptid);
	
	public List<Finreport> findAll();
	
	public Finreport getByRptmonth(Finreport finreport);
	
	public void deleteByRptmonth(Finreport finreport);
	
	
}
