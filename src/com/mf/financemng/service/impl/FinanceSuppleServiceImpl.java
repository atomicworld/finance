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

import com.mf.financemng.dao.FinanceSuppleDao;
import com.mf.financemng.entity.FinanceSupple;
import com.mf.financemng.service.FinanceSuppleService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("financeSuppleService")
public class FinanceSuppleServiceImpl implements FinanceSuppleService {
	@Autowired
	private FinanceSuppleDao financeSuppleDao;

	@Override
	public PageView query(PageView pageView, FinanceSupple financeSupple) {
		List<FinanceSupple> list = financeSuppleDao.query(pageView, financeSupple);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public void add(FinanceSupple financeSupple) {
		financeSuppleDao.add(financeSupple);
		
	}

	@Override
	public void addAll(FinanceSupple financeSupple) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(FinanceSupple financeSupple) {
		financeSuppleDao.modify(financeSupple);
		
	}

	@Override
	public FinanceSupple getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FinanceSupple getBysuppleId(int id) {
		return financeSuppleDao.getBysuppleId(id);
		
	}

	@Override
	public void deleteById(int id) {
		financeSuppleDao.deleteById(id);
		
	}

	@Override
	public List<FinanceSupple> queryAll(FinanceSupple financeSupple) {
		// TODO Auto-generated method stub
		return financeSuppleDao.queryAll(financeSupple);
	}

	@Override
	public FinanceSupple getByReport(String reportMonth) {
		// TODO Auto-generated method stub
		return financeSuppleDao.getByReport(reportMonth);
	}

	@Override
	public void deleteByFlag(String id) {
		// TODO Auto-generated method stub
		financeSuppleDao.deleteByFlag(id);
	}
	
}
