/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.client.dao.ClntGradeCommerceDao;
import com.mf.client.entity.ClntGradeCommerce;
import com.mf.client.service.ClntGradeCommerceService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntGradeCommerceService")
public class ClntGradeCommerceServiceImpl implements ClntGradeCommerceService {
	@Autowired
	private ClntGradeCommerceDao clntGradeCommerceDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntGradeCommerce
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntGradeCommerce clntGradeCommerce) {
		List<ClntGradeCommerce> list = clntGradeCommerceDao.query(pageView, clntGradeCommerce);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntGradeCommerce clntGradeCommerce
	 * @return List<ClntGradeCommerce>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntGradeCommerce> queryAll(ClntGradeCommerce clntGradeCommerce) {
		List<ClntGradeCommerce> list = clntGradeCommerceDao.queryAll(clntGradeCommerce);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntGradeCommerce
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntGradeCommerce clntGradeCommerce) {
		clntGradeCommerceDao.add(clntGradeCommerce);
	}
	
	/**
	 * 新增操作
	 * @param clntGradeCommerce
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntGradeCommerce clntGradeCommerce) {
		clntGradeCommerceDao.addAll(clntGradeCommerce);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntGradeCommerceDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntGradeCommerce getById(String id) {
		return clntGradeCommerceDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntGradeCommerce
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntGradeCommerce clntGradeCommerce) {
		clntGradeCommerceDao.modify(clntGradeCommerce);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntGradeCommerce> findAll() {
		return clntGradeCommerceDao.findAll();
	}
	
}
