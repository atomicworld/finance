/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.mf.util.*;
import com.mf.client.entity.*;
import com.mf.client.dao.*;
import com.mf.client.service.*;/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEventEwdService")
public class ClntEventEwdServiceImpl implements ClntEventEwdService {
	@Autowired
	private ClntEventEwdDao clntEventEwdDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEventEwd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEventEwd clntEventEwd) {
		List<ClntEventEwd> list = clntEventEwdDao.query(pageView, clntEventEwd);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEventEwd clntEventEwd
	 * @return List<ClntEventEwd>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventEwd> queryAll(ClntEventEwd clntEventEwd) {
		List<ClntEventEwd> list = clntEventEwdDao.queryAll(clntEventEwd);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEventEwd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEventEwd clntEventEwd) {
		clntEventEwdDao.add(clntEventEwd);
	}
	
	/**
	 * 新增操作
	 * @param clntEventEwd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEventEwd clntEventEwd) {
		clntEventEwdDao.addAll(clntEventEwd);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEventEwdDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEventEwd getById(String id) {
		return clntEventEwdDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEventEwd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEventEwd clntEventEwd) {
		clntEventEwdDao.modify(clntEventEwd);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventEwd> findAll() {
		return clntEventEwdDao.findAll();
	}
	
}
