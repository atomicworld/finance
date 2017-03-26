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

import com.mf.client.dao.ClntPersonResumeDao;
import com.mf.client.entity.ClntPersonResume;
import com.mf.client.service.ClntPersonResumeService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonResumeService")
public class ClntPersonResumeServiceImpl implements ClntPersonResumeService {
	@Autowired
	private ClntPersonResumeDao clntPersonResumeDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonResume
	 * @return
	 */
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonResume clntPersonResume) {
		List<ClntPersonResume> list = clntPersonResumeDao.query(pageView, clntPersonResume);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonResume clntPersonResume
	 * @return List<ClntPersonResume>
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonResume> queryAll(ClntPersonResume clntPersonResume) {
		List<ClntPersonResume> list = clntPersonResumeDao.queryAll(clntPersonResume);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonResume
	 * @return
	 */
	public void add(ClntPersonResume clntPersonResume) {
		clntPersonResumeDao.add(clntPersonResume);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonResume
	 * @return
	 */
	public void addAll(ClntPersonResume clntPersonResume) {
		clntPersonResumeDao.addAll(clntPersonResume);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	public void delete(String id) {
		clntPersonResumeDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	@Transactional(readOnly=true)
	public ClntPersonResume getById(String id) {
		return clntPersonResumeDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonResume
	 * @return
	 */
	public void modify(ClntPersonResume clntPersonResume) {
		clntPersonResumeDao.modify(clntPersonResume);
	}

	/**
	 * 查找所有
	 * @return
	 */
	@Transactional(readOnly=true)
	public List<ClntPersonResume> findAll() {
		return clntPersonResumeDao.findAll();
	}
	
}
