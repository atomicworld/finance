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

import com.mf.financemng.dao.FnncDealtypDao;
import com.mf.financemng.entity.FnncDealtyp;
import com.mf.financemng.service.FnncDealtypService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncDealtypService")
public class FnncDealtypServiceImpl implements FnncDealtypService {
	@Autowired
	private FnncDealtypDao fnncDealtypDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncDealtyp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncDealtyp fnncDealtyp) {
		List<FnncDealtyp> list = fnncDealtypDao.query(pageView, fnncDealtyp);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncDealtyp fnncDealtyp
	 * @return List<FnncDealtyp>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncDealtyp> queryAll(FnncDealtyp fnncDealtyp) {
		List<FnncDealtyp> list = fnncDealtypDao.queryAll(fnncDealtyp);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncDealtyp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncDealtyp fnncDealtyp) {
		fnncDealtypDao.add(fnncDealtyp);
	}
	
	/**
	 * 新增操作
	 * @param fnncDealtyp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncDealtyp fnncDealtyp) {
		fnncDealtypDao.addAll(fnncDealtyp);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncDealtypDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncDealtyp getById(String id) {
		return fnncDealtypDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncDealtyp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncDealtyp fnncDealtyp) {
		fnncDealtypDao.modify(fnncDealtyp);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncDealtyp> findAll() {
		return fnncDealtypDao.findAll();
	}
	
}
