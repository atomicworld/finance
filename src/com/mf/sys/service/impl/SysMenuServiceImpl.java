/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.sys.entity.*;
import com.mf.sys.dao.*;
import com.mf.sys.service.*;
import com.mf.util.*;
/**
 * @author yangchao
 * @2014-12-24
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("sysMenuService")
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param sysMenu
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, SysMenu sysMenu) {
		List<SysMenu> list = sysMenuDao.query(pageView, sysMenu);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param SysMenu sysMenu
	 * @return List<SysMenu>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<SysMenu> queryAll(SysMenu sysMenu) {
		List<SysMenu> list = null;
		//list = sysMenuDao.queryAll(sysMenu);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param sysMenu
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(SysMenu sysMenu) {
		sysMenuDao.add(sysMenu);
	}
	
	/**
	 * 新增操作
	 * @param sysMenu
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(SysMenu sysMenu) {
		//sysMenuDao.addAll(sysMenu);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		sysMenuDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public SysMenu findById(String id) {
		return sysMenuDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param sysMenu
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(SysMenu sysMenu) {
		sysMenuDao.modify(sysMenu);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<SysMenu> findAll() {
		return sysMenuDao.findAll();
	}
	
}
