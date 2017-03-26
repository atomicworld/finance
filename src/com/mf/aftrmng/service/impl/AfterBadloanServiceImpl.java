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

import com.mf.aftrmng.dao.AfterBadloanDao;
import com.mf.aftrmng.entity.AfterBadloan;
import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.aftrmng.service.AfterBadloanService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("afterBadloanService")
public class AfterBadloanServiceImpl implements AfterBadloanService {
	@Autowired
	private AfterBadloanDao afterBadloanDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param afterBadloan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, AfterBadloan afterBadloan) {
		List<AfterBadloan> list = afterBadloanDao.query(pageView, afterBadloan);
		pageView.setRecords(list);
		return pageView;
	}
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, AfterFvclass afterfvclass) {
		List<AfterFvclass> list = afterBadloanDao.query(pageView, afterfvclass);
		pageView.setRecords(list);
		return pageView;
	}
	@Transactional(readOnly=true)
	public PageView queryBadloan(PageView pageView,AfterBadloan afterBadloan){
		List<AfterBadloan> list = afterBadloanDao.queryBadloan(pageView, afterBadloan);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param AfterBadloan afterBadloan
	 * @return List<AfterBadloan>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterBadloan> queryAll(AfterBadloan afterBadloan) {
		List<AfterBadloan> list = afterBadloanDao.queryAll(afterBadloan);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param afterBadloan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(AfterBadloan afterBadloan) {
		afterBadloanDao.add(afterBadloan);
	}
	
	/**
	 * 新增操作
	 * @param afterBadloan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(AfterBadloan afterBadloan) {
		afterBadloanDao.addAll(afterBadloan);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		afterBadloanDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public AfterBadloan getById(String id) {
		return afterBadloanDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param afterBadloan
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(AfterBadloan afterBadloan) {
		afterBadloanDao.modify(afterBadloan);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterBadloan> findAll() {
		return afterBadloanDao.findAll();
	}
	
}
