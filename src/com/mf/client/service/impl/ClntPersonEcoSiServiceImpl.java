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

import com.mf.client.dao.ClntPersonEcoSiDao;
import com.mf.client.entity.ClntPersonEcoSi;
import com.mf.client.service.ClntPersonEcoSiService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonEcoSiService")
public class ClntPersonEcoSiServiceImpl implements ClntPersonEcoSiService {
	@Autowired
	private ClntPersonEcoSiDao clntPersonEcoSiDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonEcoSi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonEcoSi clntPersonEcoSi) {
		List<ClntPersonEcoSi> list = clntPersonEcoSiDao.query(pageView, clntPersonEcoSi);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonEcoSi clntPersonEcoSi
	 * @return List<ClntPersonEcoSi>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoSi> queryAll(ClntPersonEcoSi clntPersonEcoSi) {
		List<ClntPersonEcoSi> list = clntPersonEcoSiDao.queryAll(clntPersonEcoSi);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoSi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntPersonEcoSi clntPersonEcoSi) {
		clntPersonEcoSiDao.add(clntPersonEcoSi);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoSi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntPersonEcoSi clntPersonEcoSi) {
		clntPersonEcoSiDao.addAll(clntPersonEcoSi);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntPersonEcoSiDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntPersonEcoSi getById(String id) {
		return clntPersonEcoSiDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonEcoSi
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntPersonEcoSi clntPersonEcoSi) {
		clntPersonEcoSiDao.modify(clntPersonEcoSi);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoSi> findAll() {
		return clntPersonEcoSiDao.findAll();
	}
	
}
