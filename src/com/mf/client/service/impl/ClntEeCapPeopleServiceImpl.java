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

import com.mf.client.dao.ClntEeCapPeopleDao;
import com.mf.client.entity.ClntEeCapPeople;
import com.mf.client.service.ClntEeCapPeopleService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeCapPeopleService")
public class ClntEeCapPeopleServiceImpl implements ClntEeCapPeopleService {
	@Autowired
	private ClntEeCapPeopleDao clntEeCapPeopleDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeCapPeople
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeCapPeople clntEeCapPeople) {
		List<ClntEeCapPeople> list = clntEeCapPeopleDao.query(pageView, clntEeCapPeople);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeCapPeople clntEeCapPeople
	 * @return List<ClntEeCapPeople>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapPeople> queryAll(ClntEeCapPeople clntEeCapPeople) {
		List<ClntEeCapPeople> list = clntEeCapPeopleDao.queryAll(clntEeCapPeople);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapPeople
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeCapPeople clntEeCapPeople) {
		clntEeCapPeopleDao.add(clntEeCapPeople);
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapPeople
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeCapPeople clntEeCapPeople) {
		clntEeCapPeopleDao.addAll(clntEeCapPeople);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeCapPeopleDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeCapPeople getById(String id) {
		return clntEeCapPeopleDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeCapPeople
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeCapPeople clntEeCapPeople) {
		clntEeCapPeopleDao.modify(clntEeCapPeople);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapPeople> findAll() {
		return clntEeCapPeopleDao.findAll();
	}
	
}
