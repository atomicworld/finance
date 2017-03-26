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
@Service("clntEventOtherService")
public class ClntEventOtherServiceImpl implements ClntEventOtherService {
	@Autowired
	private ClntEventOtherDao clntEventOtherDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEventOther
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEventOther clntEventOther) {
		List<ClntEventOther> list = clntEventOtherDao.query(pageView, clntEventOther);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEventOther clntEventOther
	 * @return List<ClntEventOther>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventOther> queryAll(ClntEventOther clntEventOther) {
		List<ClntEventOther> list = clntEventOtherDao.queryAll(clntEventOther);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEventOther
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEventOther clntEventOther) {
		clntEventOtherDao.add(clntEventOther);
	}
	
	/**
	 * 新增操作
	 * @param clntEventOther
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEventOther clntEventOther) {
		clntEventOtherDao.addAll(clntEventOther);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEventOtherDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEventOther getById(String id) {
		return clntEventOtherDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEventOther
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEventOther clntEventOther) {
		clntEventOtherDao.modify(clntEventOther);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventOther> findAll() {
		return clntEventOtherDao.findAll();
	}
	
}
