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

import com.mf.client.dao.ClntPersonJobDao;
import com.mf.client.entity.ClntPersonJob;
import com.mf.client.service.ClntPersonJobService;
import com.mf.util.PageView;
@Transactional
@Service("clntPersonJobService")
public class ClntPersonJobServiceImpl implements ClntPersonJobService {
	@Autowired
	private ClntPersonJobDao clntPersonJobDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonJob
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonJob clntPersonJob) {
		List<ClntPersonJob> list = clntPersonJobDao.query(pageView, clntPersonJob);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonJob clntPersonJob
	 * @return List<ClntPersonJob>
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonJob> queryAll(ClntPersonJob clntPersonJob) {
		List<ClntPersonJob> list = clntPersonJobDao.queryAll(clntPersonJob);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonJob
	 * @return
	 */
	public void add(ClntPersonJob clntPersonJob) {
		clntPersonJobDao.add(clntPersonJob);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		clntPersonJobDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public ClntPersonJob getById(String id) {
		return clntPersonJobDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonJob
	 * @return
	 */
	public void modify(ClntPersonJob clntPersonJob) {
		clntPersonJobDao.modify(clntPersonJob);
	}

	/**
	 * 查找所有
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonJob> findAll() {
		return clntPersonJobDao.findAll();
	}
	
}
