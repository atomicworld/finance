/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import com.mf.cntrtmng.entity.BsnsOverdueUrge;
import com.mf.cntrtmng.dao.BsnsOverdueUrgeDao;
import com.mf.cntrtmng.service.*;
import com.mf.util.*;

/**
 * @author huangwen
 * @2015-05-29
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsOverdueUrgeService")
public class BsnsOverdueUrgeServiceImpl implements BsnsOverdueUrgeService {
	@Autowired
	private BsnsOverdueUrgeDao bsnsOverdueUrgeDao;
	

	/**
	 * 新增操作
	 * @param bsnsOverdueUrge
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsOverdueUrge bsnsOverdueUrge) {
		bsnsOverdueUrgeDao.add(bsnsOverdueUrge);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsOverdueUrge getById(String id) {
		return bsnsOverdueUrgeDao.getById(id);
	}
	

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsOverdueUrge> findAll() {
		return bsnsOverdueUrgeDao.findAll();
	}
	
	/**
	 * 根据日期和计划还款单号寻找唯一的
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public boolean exist(String srlno,String date) {
		BsnsOverdueUrge bsnsOverdueUrge=new BsnsOverdueUrge();
		bsnsOverdueUrge.setSrlno(srlno);
		bsnsOverdueUrge.setUrgedate(date);
		List<BsnsOverdueUrge> list = bsnsOverdueUrgeDao.queryAll(bsnsOverdueUrge);
		if(list.isEmpty()) 
			return true;
		else
			return false;
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsOverdueUrge> findBy(String srlno,String date) {
		BsnsOverdueUrge bsnsOverdueUrge=new BsnsOverdueUrge();
		bsnsOverdueUrge.setSrlno(srlno);
		bsnsOverdueUrge.setUrgedate(date);
		return bsnsOverdueUrgeDao.queryAll(bsnsOverdueUrge);
	}
	
}
