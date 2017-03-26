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

import com.mf.client.dao.ClntPersonFamilyDao;
import com.mf.client.entity.ClntPersonFamily;
import com.mf.client.service.ClntPersonFamilyService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonFamilyService")
public class ClntPersonFamilyServiceImpl implements ClntPersonFamilyService {
	@Autowired
	private ClntPersonFamilyDao clntPersonFamilyDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonFamily
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonFamily clntPersonFamily) {
		List<ClntPersonFamily> list = clntPersonFamilyDao.query(pageView, clntPersonFamily);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonFamily clntPersonFamily
	 * @return List<ClntPersonFamily>
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonFamily> queryAll(ClntPersonFamily clntPersonFamily) {
		List<ClntPersonFamily> list = clntPersonFamilyDao.queryAll(clntPersonFamily);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonFamily
	 * @return
	 */
	public void add(ClntPersonFamily clntPersonFamily) {
		clntPersonFamilyDao.add(clntPersonFamily);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonFamily
	 * @return
	 */
	public void addAll(ClntPersonFamily clntPersonFamily) {
		clntPersonFamilyDao.addAll(clntPersonFamily);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		clntPersonFamilyDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public ClntPersonFamily getById(String id) {
		return clntPersonFamilyDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonFamily
	 * @return
	 */
	public void modify(ClntPersonFamily clntPersonFamily) {
		clntPersonFamilyDao.modify(clntPersonFamily);
	}

	/**
	 * 查找所有
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonFamily> findAll() {
		return clntPersonFamilyDao.findAll();
	}
}
