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

import com.mf.financemng.dao.FinanceConditionDao;
import com.mf.financemng.entity.FinanceCondition;
import com.mf.financemng.service.FinanceConditionService;
import com.mf.flowmng.entity.FlowIncreaseCapital;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("financeConditionService")
public class FinanceConditionServiceImpl implements FinanceConditionService {
	@Autowired
	private FinanceConditionDao financeConditionDao;

	@Override
	public PageView query(PageView pageView, FinanceCondition financeCondition) {
		List<FinanceCondition> list = financeConditionDao.query(pageView, financeCondition);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<FinanceCondition> queryAll(FinanceCondition financeCondition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(FinanceCondition financeCondition) {
		financeConditionDao.add(financeCondition);
		
	}

	@Override
	public void addAll(FinanceCondition financeCondition) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		financeConditionDao.deleteById(id);
		
	}

	@Override
	public void modify(FinanceCondition financeCondition) {
		financeConditionDao.modify(financeCondition);
		
	}

	@Override
	public FinanceCondition getById(String id) {
		// TODO Auto-generated method stub
		return financeConditionDao.getById(id);
	}

	@Override
	public List<FinanceCondition> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinanceCondition checkbankno(String bankno) {
		// TODO Auto-generated method stub
		return financeConditionDao.checkbankno(bankno);
	}
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param financeCondition
	 * @return
	 */
	
}
