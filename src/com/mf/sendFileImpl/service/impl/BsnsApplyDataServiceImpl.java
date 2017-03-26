/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sendFileImpl.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.financemng.entity.Fnnzcfz;
import com.mf.sendFileImpl.dao.BsnsApplyDataDao;
import com.mf.sendFileImpl.entity.BsnsApplyData;
import com.mf.sendFileImpl.service.BsnsApplyDataService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-09-08
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsApplyDataService")
public class BsnsApplyDataServiceImpl implements BsnsApplyDataService {
	@Autowired
	private BsnsApplyDataDao bsnsApplyDataDao;

	@Override
	public PageView query(PageView pageView, BsnsApplyData bsnsApplyData) {
		List<BsnsApplyData> list = bsnsApplyDataDao.query(pageView, bsnsApplyData);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<BsnsApplyData> queryAll(BsnsApplyData bsnsApplyData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(BsnsApplyData bsnsApplyData) {
		bsnsApplyDataDao.add(bsnsApplyData);
		
	}

	@Override
	public void addAll(BsnsApplyData bsnsApplyData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(BsnsApplyData bsnsApplyData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BsnsApplyData getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BsnsApplyData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BsnsApplyData> query1() {
		List<BsnsApplyData> list = bsnsApplyDataDao.query1();
		return list;
	}
	
	
}
