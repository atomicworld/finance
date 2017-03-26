/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
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
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonEcoIaService")
public class ClntPersonEcoIaServiceImpl implements ClntPersonEcoIaService {
	@Autowired
	private ClntPersonEcoIaDao clntPersonEcoIaDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonEcoIa
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonEcoIa clntPersonEcoIa) {
		List<ClntPersonEcoIa> list = clntPersonEcoIaDao.query(pageView, clntPersonEcoIa);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonEcoIa clntPersonEcoIa
	 * @return List<ClntPersonEcoIa>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoIa> queryAll(ClntPersonEcoIa clntPersonEcoIa) {
		List<ClntPersonEcoIa> list = clntPersonEcoIaDao.queryAll(clntPersonEcoIa);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoIa
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntPersonEcoIa clntPersonEcoIa) {
		clntPersonEcoIaDao.add(clntPersonEcoIa);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoIa
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntPersonEcoIa clntPersonEcoIa) {
		clntPersonEcoIaDao.addAll(clntPersonEcoIa);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntPersonEcoIaDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntPersonEcoIa getById(String id) {
		return clntPersonEcoIaDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonEcoIa
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntPersonEcoIa clntPersonEcoIa) {
		clntPersonEcoIaDao.modify(clntPersonEcoIa);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoIa> findAll() {
		return clntPersonEcoIaDao.findAll();
	}
	
}
