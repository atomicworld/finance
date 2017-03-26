/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.aop.dao.AopModuleDao;
import com.mf.aop.entity.AopModule;
import com.mf.aop.service.AopModuleService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-09-21
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("aopModuleService")
public class AopModuleServiceImpl implements AopModuleService {
	@Autowired
	private AopModuleDao aopModuleDao;

	@Override
	public PageView query(PageView pageView, AopModule aopModule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AopModule> queryAll(AopModule aopModule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(AopModule aopModule) {
		aopModuleDao.add(aopModule);
		
	}

	@Override
	public void addAll(AopModule aopModule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(AopModule aopModule) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AopModule getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AopModule> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
