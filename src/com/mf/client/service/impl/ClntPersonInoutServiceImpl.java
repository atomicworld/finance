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

import com.mf.client.dao.ClntPersonInoutDao;
import com.mf.client.entity.ClntPersonInout;
import com.mf.client.service.ClntPersonInoutService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonInoutService")
public class ClntPersonInoutServiceImpl implements ClntPersonInoutService {
	@Autowired
	private ClntPersonInoutDao clntPersonInoutDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonInout
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonInout clntPersonInout) {
		List<ClntPersonInout> list = clntPersonInoutDao.query(pageView, clntPersonInout);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonInout clntPersonInout
	 * @return List<ClntPersonInout>
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonInout> queryAll(ClntPersonInout clntPersonInout) {
		List<ClntPersonInout> list = clntPersonInoutDao.queryAll(clntPersonInout);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonInout
	 * @return
	 */
	public void add(ClntPersonInout clntPersonInout) {
		clntPersonInoutDao.add(clntPersonInout);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonInout
	 * @return
	 */
	public void addAll(ClntPersonInout clntPersonInout) {
		clntPersonInoutDao.addAll(clntPersonInout);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		clntPersonInoutDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public ClntPersonInout getById(String id) {
		return clntPersonInoutDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonInout
	 * @return
	 */
	public void modify(ClntPersonInout clntPersonInout) {
		clntPersonInoutDao.modify(clntPersonInout);
	}

	/**
	 * 查找所有
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonInout> findAll() {
		return clntPersonInoutDao.findAll();
	}
	
}
