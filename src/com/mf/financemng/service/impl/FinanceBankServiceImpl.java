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

import com.mf.financemng.dao.FinanceBankDao;
import com.mf.financemng.entity.FinanceBank;
import com.mf.financemng.service.FinanceBankService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-13
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("financeBankService")
public class FinanceBankServiceImpl implements FinanceBankService {
	@Autowired
	private FinanceBankDao financeBankDao;

	@Override
	public PageView query(PageView pageView, FinanceBank financeBank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinanceBank> queryAll(FinanceBank financeBank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(FinanceBank financeBank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(FinanceBank financeBank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(FinanceBank financeBank) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FinanceBank getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FinanceBank> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
