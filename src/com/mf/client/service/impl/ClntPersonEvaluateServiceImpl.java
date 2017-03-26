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

import com.mf.client.dao.ClntPersonEvaluateDao;
import com.mf.client.entity.ClntPersonEvaluate;
import com.mf.client.service.ClntPersonEvaluateService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-18
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonEvaluateService")
public class ClntPersonEvaluateServiceImpl implements ClntPersonEvaluateService {
	@Autowired
	private ClntPersonEvaluateDao clntPersonEvaluateDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonEvaluate
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonEvaluate clntPersonEvaluate) {
		List<ClntPersonEvaluate> list = clntPersonEvaluateDao.query(pageView, clntPersonEvaluate);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonEvaluate clntPersonEvaluate
	 * @return List<ClntPersonEvaluate>
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonEvaluate> queryAll(ClntPersonEvaluate clntPersonEvaluate) {
		List<ClntPersonEvaluate> list = clntPersonEvaluateDao.queryAll(clntPersonEvaluate);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEvaluate
	 * @return
	 */
	public void add(ClntPersonEvaluate clntPersonEvaluate) {
		clntPersonEvaluateDao.add(clntPersonEvaluate);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEvaluate
	 * @return
	 */
	public void addAll(ClntPersonEvaluate clntPersonEvaluate) {
		clntPersonEvaluateDao.addAll(clntPersonEvaluate);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		clntPersonEvaluateDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public ClntPersonEvaluate getById(String id) {
		return clntPersonEvaluateDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonEvaluate
	 * @return
	 */
	public void modify(ClntPersonEvaluate clntPersonEvaluate) {
		clntPersonEvaluateDao.modify(clntPersonEvaluate);
	}

	/**
	 * 查找所有
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonEvaluate> findAll() {
		return clntPersonEvaluateDao.findAll();
	}
	
}
