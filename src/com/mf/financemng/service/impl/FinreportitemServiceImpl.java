/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.financemng.dao.FinreportitemDao;
import com.mf.financemng.entity.Finreportitem;
import com.mf.financemng.service.FinreportitemService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2016-01-05
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("finreportitemService")
public class FinreportitemServiceImpl implements FinreportitemService {
	@Autowired
	private FinreportitemDao finreportitemDao;

	@Override
	public PageView query(PageView pageView, Finreportitem finreportitem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Finreportitem> queryAll(Finreportitem finreportitem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Finreportitem finreportitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(Finreportitem finreportitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(Finreportitem finreportitem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Finreportitem getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Finreportitem> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Finreportitem> getByPitemcode(String pitemcode) {
		List<Finreportitem> list = finreportitemDao.getByPitemcode(pitemcode);
		return list;
	}
	
	
	
	
	
}
