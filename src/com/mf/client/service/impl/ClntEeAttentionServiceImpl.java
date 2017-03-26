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

import com.mf.client.dao.ClntEeAttentionDao;
import com.mf.client.entity.ClntEeAttention;
import com.mf.client.service.ClntEeAttentionService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeAttentionService")
public class ClntEeAttentionServiceImpl implements ClntEeAttentionService {
	@Autowired
	private ClntEeAttentionDao clntEeAttentionDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeAttention
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeAttention clntEeAttention) {
		List<ClntEeAttention> list = clntEeAttentionDao.query(pageView, clntEeAttention);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeAttention clntEeAttention
	 * @return List<ClntEeAttention>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeAttention> queryAll(ClntEeAttention clntEeAttention) {
		List<ClntEeAttention> list = clntEeAttentionDao.queryAll(clntEeAttention);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeAttention
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeAttention clntEeAttention) {
		clntEeAttentionDao.add(clntEeAttention);
	}
	
	/**
	 * 新增操作
	 * @param clntEeAttention
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeAttention clntEeAttention) {
		clntEeAttentionDao.addAll(clntEeAttention);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeAttentionDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeAttention getById(String id) {
		return clntEeAttentionDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeAttention
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeAttention clntEeAttention) {
		clntEeAttentionDao.modify(clntEeAttention);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeAttention> findAll() {
		return clntEeAttentionDao.findAll();
	}
	
}
