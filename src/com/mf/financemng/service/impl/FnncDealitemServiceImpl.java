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

import com.mf.financemng.dao.FnncDealitemDao;
import com.mf.financemng.entity.FnncDealitem;
import com.mf.financemng.service.FnncDealitemService;
import com.mf.util.PageView;


import java.util.List;

/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncDealitemService")
public class FnncDealitemServiceImpl implements FnncDealitemService {
	@Autowired
	private FnncDealitemDao fnncDealitemDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncDealitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncDealitem fnncDealitem) {
		List<FnncDealitem> list = fnncDealitemDao.query(pageView, fnncDealitem);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncDealitem fnncDealitem
	 * @return List<FnncDealitem>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncDealitem> queryAll(FnncDealitem fnncDealitem) {
		List<FnncDealitem> list = fnncDealitemDao.queryAll(fnncDealitem);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncDealitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncDealitem fnncDealitem) {
		fnncDealitemDao.add(fnncDealitem);
	}
	
	/**
	 * 新增操作
	 * @param fnncDealitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncDealitem fnncDealitem) {
		fnncDealitemDao.addAll(fnncDealitem);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncDealitemDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncDealitem getById(String id) {
		return fnncDealitemDao.getById(id);
	}
	//wyy
	public FnncDealitem queryItem(FnncDealitem item){
		return fnncDealitemDao.queryItem(item);
	}
	/**
	 * 修改实体类
	 * @param fnncDealitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncDealitem fnncDealitem) {
		fnncDealitemDao.modify(fnncDealitem);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncDealitem> findAll() {
		return fnncDealitemDao.findAll();
	}
	
}
