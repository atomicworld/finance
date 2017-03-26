/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.dao.FnncAccntctlcdDao;
import com.mf.financemng.entity.FnncAccntctlcd;
import com.mf.financemng.service.FnncAccntctlcdService;
import com.mf.util.PageView;

import java.util.List;


/**
 * @author shenguangdong
 * @2015-02-10
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncAccntctlcdService")
public class FnncAccntctlcdServiceImpl implements FnncAccntctlcdService {
	@Autowired
	private FnncAccntctlcdDao fnncAccntctlcdDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncAccntctlcd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncAccntctlcd fnncAccntctlcd) {
		List<FnncAccntctlcd> list = fnncAccntctlcdDao.query(pageView, fnncAccntctlcd);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncAccntctlcd fnncAccntctlcd
	 * @return List<FnncAccntctlcd>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncAccntctlcd> queryAll(FnncAccntctlcd fnncAccntctlcd) {
		List<FnncAccntctlcd> list = fnncAccntctlcdDao.queryAll(fnncAccntctlcd);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncAccntctlcd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncAccntctlcd fnncAccntctlcd) {
		fnncAccntctlcdDao.add(fnncAccntctlcd);
	}
	
	/**
	 * 新增操作
	 * @param fnncAccntctlcd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncAccntctlcd fnncAccntctlcd) {
		fnncAccntctlcdDao.addAll(fnncAccntctlcd);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncAccntctlcdDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncAccntctlcd getById(String id) {
		return fnncAccntctlcdDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncAccntctlcd
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncAccntctlcd fnncAccntctlcd) {
		fnncAccntctlcdDao.modify(fnncAccntctlcd);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncAccntctlcd> findAll() {
		return fnncAccntctlcdDao.findAll();
	}
	
}
