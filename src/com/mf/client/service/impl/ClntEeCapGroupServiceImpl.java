/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.client.dao.ClntEeCapGroupDao;
import com.mf.client.entity.ClntEeCapGroup;
import com.mf.client.service.ClntEeCapGroupService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeCapGroupService")
public class ClntEeCapGroupServiceImpl implements ClntEeCapGroupService {
	@Autowired
	private ClntEeCapGroupDao clntEeCapGroupDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeCapGroup
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeCapGroup clntEeCapGroup) {
		List<ClntEeCapGroup> list = clntEeCapGroupDao.query(pageView, clntEeCapGroup);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeCapGroup clntEeCapGroup
	 * @return List<ClntEeCapGroup>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapGroup> queryAll(ClntEeCapGroup clntEeCapGroup) {
		List<ClntEeCapGroup> list = clntEeCapGroupDao.queryAll(clntEeCapGroup);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapGroup
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeCapGroup clntEeCapGroup) {
		clntEeCapGroupDao.add(clntEeCapGroup);
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapGroup
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeCapGroup clntEeCapGroup) {
		clntEeCapGroupDao.addAll(clntEeCapGroup);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeCapGroupDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeCapGroup getById(String id) {
		return clntEeCapGroupDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeCapGroup
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeCapGroup clntEeCapGroup) {
		clntEeCapGroupDao.modify(clntEeCapGroup);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapGroup> findAll() {
		return clntEeCapGroupDao.findAll();
	}
	
}
