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
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */

public interface ProfitService{

	public PageView query(PageView pageView,Profit profit);
	
	public List<Profit> queryAll(Profit profit);
	
	public void add(Profit profit);
	
	public void addAll(Profit profit);
	
	public void modify(Profit profit);
	
	public Profit getById(int id);
	
	public List<Profit> findAll();
	
	public void deleteById(String rptid);
	
	public List<Profit> getByRptmonth(String rptmonth);
	
	public Profit getProfit(Profit p);
	
	public void updateProfit(Profit profit);
	
	public void deleteProfit(String rptmonth);
	
	public List<Profit> query1(Profit profit);
	
	public List<Profit> query2(Profit profit);
	
	public List<Profit> getByRptid(String rptid);
	
	
}
