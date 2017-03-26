/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.aftrmng.dao.AfterReadamntDao;
import com.mf.aftrmng.entity.AfterReadamnt;
import com.mf.aftrmng.service.AfterReadamntService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("afterReadamntService")
public class AfterReadamntServiceImpl implements AfterReadamntService {
	@Autowired
	private AfterReadamntDao afterReadamntDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param afterReadamnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, AfterReadamnt afterReadamnt) {
		List<AfterReadamnt> list = afterReadamntDao.query(pageView, afterReadamnt);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param AfterReadamnt afterReadamnt
	 * @return List<AfterReadamnt>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterReadamnt> queryAll(AfterReadamnt afterReadamnt) {
		List<AfterReadamnt> list = afterReadamntDao.queryAll(afterReadamnt);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param afterReadamnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(AfterReadamnt afterReadamnt) {
		afterReadamntDao.add(afterReadamnt);
	}
	
	/**
	 * 新增操作
	 * @param afterReadamnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(AfterReadamnt afterReadamnt) {
		afterReadamntDao.addAll(afterReadamnt);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		afterReadamntDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public AfterReadamnt getById(String id) {
		return afterReadamntDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param afterReadamnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(AfterReadamnt afterReadamnt) {
		afterReadamntDao.modify(afterReadamnt);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterReadamnt> findAll() {
		return afterReadamntDao.findAll();
	}
	
}
