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
 * @2015-01-04
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntRelService")
public class ClntRelServiceImpl implements ClntRelService {
	@Autowired
	private ClntRelDao clntRelDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntRel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntRel clntRel) {
		List<ClntRel> list = clntRelDao.query(pageView, clntRel);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntRel clntRel
	 * @return List<ClntRel>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntRel> queryAll(ClntRel clntRel) {
		List<ClntRel> list = clntRelDao.queryAll(clntRel);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntRel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntRel clntRel) {
		clntRelDao.add(clntRel);
	}
	
	/**
	 * 新增操作
	 * @param clntRel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntRel clntRel) {
		clntRelDao.addAll(clntRel);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntRelDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntRel getById(String id) {
		return clntRelDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntRel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntRel clntRel) {
		clntRelDao.modify(clntRel);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntRel> findAll() {
		return clntRelDao.findAll();
	}
	
}
