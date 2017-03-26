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

import com.mf.aftrmng.dao.AfterWarnparmDao;
import com.mf.aftrmng.entity.AfterWarnparm;
import com.mf.aftrmng.service.AfterWarnparmService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author yangchao
 * @2015-01-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("afterWarnparmService")
public class AfterWarnparmServiceImpl implements AfterWarnparmService {
	@Autowired
	private AfterWarnparmDao afterWarnparmDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param afterWarnparm
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, AfterWarnparm afterWarnparm) {
		List<AfterWarnparm> list = afterWarnparmDao.query(pageView, afterWarnparm);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param AfterWarnparm afterWarnparm
	 * @return List<AfterWarnparm>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterWarnparm> queryAll(AfterWarnparm afterWarnparm) {
		List<AfterWarnparm> list = afterWarnparmDao.queryAll(afterWarnparm);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param afterWarnparm
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(AfterWarnparm afterWarnparm) {
		afterWarnparmDao.add(afterWarnparm);
	}
	
	/**
	 * 新增操作
	 * @param afterWarnparm
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(AfterWarnparm afterWarnparm) {
		afterWarnparmDao.addAll(afterWarnparm);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		afterWarnparmDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public AfterWarnparm getById(String id) {
		return afterWarnparmDao.getById(id);
	}
	
	/* 
	 *查询预警参数 wyy 
	 */
	public AfterWarnparm findByWarnnm(AfterWarnparm afterWarnparm){
		return afterWarnparmDao.findByWarnnm(afterWarnparm);
	}
	
	/**
	 * 修改实体类
	 * @param afterWarnparm
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(AfterWarnparm afterWarnparm) {
		afterWarnparmDao.modify(afterWarnparm);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterWarnparm> findAll() {
		return afterWarnparmDao.findAll();
	}
	
}
