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

import com.mf.client.dao.ClntPersonEcoBiDao;
import com.mf.client.entity.ClntPersonEcoBi;
import com.mf.client.service.ClntPersonEcoBiService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonEcoBiService")
public class ClntPersonEcoBiServiceImpl implements ClntPersonEcoBiService {
	@Autowired
	private ClntPersonEcoBiDao clntPersonEcoBiDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonEcoBi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonEcoBi clntPersonEcoBi) {
		List<ClntPersonEcoBi> list = clntPersonEcoBiDao.query(pageView, clntPersonEcoBi);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonEcoBi clntPersonEcoBi
	 * @return List<ClntPersonEcoBi>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoBi> queryAll(ClntPersonEcoBi clntPersonEcoBi) {
		List<ClntPersonEcoBi> list = clntPersonEcoBiDao.queryAll(clntPersonEcoBi);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoBi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntPersonEcoBi clntPersonEcoBi) {
		clntPersonEcoBiDao.add(clntPersonEcoBi);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoBi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntPersonEcoBi clntPersonEcoBi) {
		clntPersonEcoBiDao.addAll(clntPersonEcoBi);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntPersonEcoBiDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntPersonEcoBi getById(String id) {
		return clntPersonEcoBiDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonEcoBi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntPersonEcoBi clntPersonEcoBi) {
		clntPersonEcoBiDao.modify(clntPersonEcoBi);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoBi> findAll() {
		return clntPersonEcoBiDao.findAll();
	}
	
}
