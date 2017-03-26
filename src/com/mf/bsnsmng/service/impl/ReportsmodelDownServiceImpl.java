package com.mf.bsnsmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.bsnsmng.entity.*;
import com.mf.bsnsmng.dao.*;
import com.mf.bsnsmng.service.*;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-06-24
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("reportsmodelDownService")
public class ReportsmodelDownServiceImpl implements ReportsmodelDownService {
	@Autowired
	private ReportsmodelDownDao reportsmodelDownDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param reportsmodelDown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ReportsmodelDown reportsmodelDown) {
		List<ReportsmodelDown> list = reportsmodelDownDao.query(pageView, reportsmodelDown);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ReportsmodelDown reportsmodelDown
	 * @return List<ReportsmodelDown>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ReportsmodelDown> queryAll(ReportsmodelDown reportsmodelDown) {
		List<ReportsmodelDown> list = reportsmodelDownDao.queryAll(reportsmodelDown);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param reportsmodelDown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ReportsmodelDown reportsmodelDown) {
		reportsmodelDownDao.add(reportsmodelDown);
	}
	
	/**
	 * 新增操作
	 * @param reportsmodelDown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ReportsmodelDown reportsmodelDown) {
		reportsmodelDownDao.addAll(reportsmodelDown);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		reportsmodelDownDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ReportsmodelDown getById(String id) {
		return reportsmodelDownDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param reportsmodelDown
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ReportsmodelDown reportsmodelDown) {
		reportsmodelDownDao.modify(reportsmodelDown);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ReportsmodelDown> findAll() {
		return reportsmodelDownDao.findAll();
	}
	
}
