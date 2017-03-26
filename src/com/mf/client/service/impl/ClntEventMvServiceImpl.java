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
@Service("clntEventMvService")
public class ClntEventMvServiceImpl implements ClntEventMvService {
	@Autowired
	private ClntEventMvDao clntEventMvDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEventMv
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEventMv clntEventMv) {
		List<ClntEventMv> list = clntEventMvDao.query(pageView, clntEventMv);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEventMv clntEventMv
	 * @return List<ClntEventMv>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventMv> queryAll(ClntEventMv clntEventMv) {
		List<ClntEventMv> list = clntEventMvDao.queryAll(clntEventMv);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEventMv
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEventMv clntEventMv) {
		clntEventMvDao.add(clntEventMv);
	}
	
	/**
	 * 新增操作
	 * @param clntEventMv
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEventMv clntEventMv) {
		clntEventMvDao.addAll(clntEventMv);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEventMvDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEventMv getById(String id) {
		return clntEventMvDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEventMv
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEventMv clntEventMv) {
		clntEventMvDao.modify(clntEventMv);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEventMv> findAll() {
		return clntEventMvDao.findAll();
	}
	
}
