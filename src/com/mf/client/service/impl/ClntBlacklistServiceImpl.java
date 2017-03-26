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
@Service("clntBlacklistService")
public class ClntBlacklistServiceImpl implements ClntBlacklistService {
	@Autowired
	private ClntBlacklistDao clntBlacklistDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntBlacklist
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntBlacklist clntBlacklist) {
		List<ClntBlacklist> list = clntBlacklistDao.query(pageView, clntBlacklist);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntBlacklist clntBlacklist
	 * @return List<ClntBlacklist>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntBlacklist> queryAll(ClntBlacklist clntBlacklist) {
		List<ClntBlacklist> list = clntBlacklistDao.queryAll(clntBlacklist);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntBlacklist
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntBlacklist clntBlacklist) {
		clntBlacklistDao.add(clntBlacklist);
	}
	
	/**
	 * 新增操作
	 * @param clntBlacklist
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntBlacklist clntBlacklist) {
		clntBlacklistDao.addAll(clntBlacklist);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntBlacklistDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntBlacklist getById(String id) {
		return clntBlacklistDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntBlacklist
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntBlacklist clntBlacklist) {
		clntBlacklistDao.modify(clntBlacklist);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntBlacklist> findAll() {
		return clntBlacklistDao.findAll();
	}
	
	public List<ClntBlacklist> queryUnSubmit(ClntBlacklist clntBlacklist){
		return clntBlacklistDao.queryUnSubmit(clntBlacklist);
	}
	
}
