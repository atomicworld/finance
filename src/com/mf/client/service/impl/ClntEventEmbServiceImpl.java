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
@Service("clntEventEmbService")
public class ClntEventEmbServiceImpl implements ClntEventEmbService {
	@Autowired
	private ClntEventEmbDao clntEventEmbDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEventEmb
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEventEmb clntEventEmb) {
		List<ClntEventEmb> list = clntEventEmbDao.query(pageView, clntEventEmb);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEventEmb clntEventEmb
	 * @return List<ClntEventEmb>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventEmb> queryAll(ClntEventEmb clntEventEmb) {
		List<ClntEventEmb> list = clntEventEmbDao.queryAll(clntEventEmb);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEventEmb
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEventEmb clntEventEmb) {
		clntEventEmbDao.add(clntEventEmb);
	}
	
	/**
	 * 新增操作
	 * @param clntEventEmb
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEventEmb clntEventEmb) {
		clntEventEmbDao.addAll(clntEventEmb);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEventEmbDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEventEmb getById(String id) {
		return clntEventEmbDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEventEmb
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEventEmb clntEventEmb) {
		clntEventEmbDao.modify(clntEventEmb);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventEmb> findAll() {
		return clntEventEmbDao.findAll();
	}
	
}
