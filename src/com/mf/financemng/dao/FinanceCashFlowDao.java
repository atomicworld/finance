/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FinanceCashFlow;

/**
 * @author wangzhi
 * @2015-08-21
 * @version 1.0
 * @param <T>
 */
public interface FinanceCashFlowDao extends BaseDao<FinanceCashFlow>{
	public List<FinanceCashFlow> findAll() throws DataAccessException;
	public FinanceCashFlow getByCashflowId(int id) throws DataAccessException;
	
	public void deleteById(int id)throws DataAccessException;
	
	public FinanceCashFlow getByReport(String reportMonth)throws DataAccessException;
	public void updateCashflow(FinanceCashFlow financeCashFlow) throws DataAccessException;
	public void deleteCashflow(String reportMonth) throws DataAccessException;
	public FinanceCashFlow getSum(String reportMonth) throws DataAccessException;
	public FinanceCashFlow getAuditSum(String reportMonth) throws DataAccessException;
	public void deleteByFlag(String id) throws DataAccessException;
	public List getByReportview(String reportMonth) throws DataAccessException;
	public List getCashflow(FinanceCashFlow financeCashFlow) throws DataAccessException;
}
