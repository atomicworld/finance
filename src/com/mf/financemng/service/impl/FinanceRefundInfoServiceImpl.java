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

import com.mf.financemng.dao.FinanceRefundInfoDao;
import com.mf.financemng.entity.FinanceCondition;
import com.mf.financemng.entity.FinanceRefundInfo;
import com.mf.financemng.service.FinanceRefundInfoService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("financeRefundInfoService")
public class FinanceRefundInfoServiceImpl implements FinanceRefundInfoService {
	@Autowired
	private FinanceRefundInfoDao financeRefundInfoDao;

	@Override
	public PageView query(PageView pageView, FinanceRefundInfo financeRefundInfo) {
		List<FinanceRefundInfo> list = financeRefundInfoDao.query(pageView, financeRefundInfo);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<FinanceRefundInfo> queryAll(FinanceRefundInfo financeRefundInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(FinanceRefundInfo financeRefundInfo) {
		financeRefundInfoDao.add(financeRefundInfo);
	}

	@Override
	public void addAll(FinanceRefundInfo financeRefundInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		financeRefundInfoDao.deleteById(id);
		
	}

	@Override
	public void modify(FinanceRefundInfo financeRefundInfo) {
		financeRefundInfoDao.modify(financeRefundInfo);
	}

	@Override
	public FinanceRefundInfo getById(String id) {
		return financeRefundInfoDao.getFiInfoById(id);
	}

	@Override
	public List<FinanceRefundInfo> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteParentId(String loanno) {
		// TODO Auto-generated method stub
		financeRefundInfoDao.deleteParentId(loanno);
	}
	

}
