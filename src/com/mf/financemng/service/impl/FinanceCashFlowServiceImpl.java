/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.financemng.dao.FinanceCashFlowDao;
import com.mf.financemng.entity.FinanceCashFlow;
import com.mf.financemng.entity.Fnnzcfz;
import com.mf.financemng.service.FinanceCashFlowService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-21
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("financeCashFlowService")
public class FinanceCashFlowServiceImpl implements FinanceCashFlowService {
	@Autowired
	private FinanceCashFlowDao financeCashFlowDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param financeCashFlow
	 * @return
	 */
	@Override
	public PageView query(PageView pageView, FinanceCashFlow financeCashFlow) {
		List<FinanceCashFlow> list = financeCashFlowDao.query(pageView, financeCashFlow);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public void add(FinanceCashFlow financeCashFlow) {
		financeCashFlowDao.add(financeCashFlow);
	}

	@Override
	public void deleteById(int id) {
		financeCashFlowDao.deleteById(id);
		
	}

	@Override
	public void modify(FinanceCashFlow financeCashFlow) {
		financeCashFlowDao.modify(financeCashFlow);
		
	}

	@Override
	public FinanceCashFlow getByCashflowId(int id) {
		return financeCashFlowDao.getByCashflowId(id);
	}

	@Override
	public FinanceCashFlow getByReport(String reportMonth) {
		// TODO Auto-generated method stub
		return financeCashFlowDao.getByReport(reportMonth);
	}
	
	/**
	 * 删除现金流量表记录
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteCashflow(String reportMonth) {
		financeCashFlowDao.deleteCashflow(reportMonth);
	}
	

	/**
	 * 修改现金流量表实体类
	 * @param profit
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void updateCashflow(FinanceCashFlow financeCashFlow) {
		financeCashFlowDao.updateCashflow(financeCashFlow);
	}
	

	/**
	 * 查询期数
	 * @param reportMonth
	 * @return
	 */
	public FinanceCashFlow getSum(String reportMonth) {
		return financeCashFlowDao.getSum(reportMonth);
	}
	
	/**
	 * 查询审计期数
	 * @param reportMonth
	 * @return
	 */
	public FinanceCashFlow getAuditSum(String reportMonth) {
		return financeCashFlowDao.getAuditSum(reportMonth);
	}

	@Override
	public List queryAll(FinanceCashFlow f) {
		// TODO Auto-generated method stub
		return financeCashFlowDao.queryAll(f);
	}

	@Override
	public void deleteByFlag(String id) {
		// TODO Auto-generated method stub
		financeCashFlowDao.deleteByFlag(id);
	}


	@Override
	public List getByReportview(String reportMonth) {
		// TODO Auto-generated method stub
		return financeCashFlowDao.getByReportview(reportMonth);
	}

	@Override
	public List getCashflow(FinanceCashFlow financeCashFlow) {
		
		return financeCashFlowDao.getCashflow(financeCashFlow);
	}
	
	
}
