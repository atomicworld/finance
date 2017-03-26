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
@Service("clntEventInstService")
public class ClntEventInstServiceImpl implements ClntEventInstService {
	@Autowired
	private ClntEventInstDao clntEventInstDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEventInst
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEventInst clntEventInst) {
		List<ClntEventInst> list = clntEventInstDao.query(pageView, clntEventInst);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEventInst clntEventInst
	 * @return List<ClntEventInst>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventInst> queryAll(ClntEventInst clntEventInst) {
		List<ClntEventInst> list = clntEventInstDao.queryAll(clntEventInst);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEventInst
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEventInst clntEventInst) {
		clntEventInstDao.add(clntEventInst);
	}
	
	/**
	 * 新增操作
	 * @param clntEventInst
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEventInst clntEventInst) {
		clntEventInstDao.addAll(clntEventInst);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEventInstDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEventInst getById(String id) {
		return clntEventInstDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEventInst
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEventInst clntEventInst) {
		clntEventInstDao.modify(clntEventInst);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventInst> findAll() {
		return clntEventInstDao.findAll();
	}
	
}
