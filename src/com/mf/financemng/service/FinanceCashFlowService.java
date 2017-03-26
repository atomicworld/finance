/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;

import com.mf.financemng.entity.FinanceCashFlow;
import com.mf.financemng.entity.Fnnzcfz;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-21
 * @version 1.0
 * @param <T>
 */

public interface FinanceCashFlowService{

	public PageView query(PageView pageView,FinanceCashFlow financeCashFlow);
	
	
	public void add(FinanceCashFlow financeCashFlow);
	
	
	public void deleteById(int id);
	
	public void modify(FinanceCashFlow financeCashFlow);
	
	public FinanceCashFlow getByCashflowId(int id);
	
	public FinanceCashFlow getByReport(String reportMonth);
	
	public void updateCashflow(FinanceCashFlow financeCashFlow);
	
	public void deleteCashflow(String reportMonth);
	
	public FinanceCashFlow getSum(String reportMonth);
	
	public FinanceCashFlow getAuditSum(String reportMonth);


	public List queryAll(FinanceCashFlow f);


	public void deleteByFlag(String id);


	public List getByReportview(String reportMonth);
	
	public List getCashflow(FinanceCashFlow financeCashFlow);
}
