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

import com.mf.client.dao.ClntPersonEcoHouseDao;
import com.mf.client.entity.ClntPersonEcoHouse;
import com.mf.client.service.ClntPersonEcoHouseService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonEcoHouseService")
public class ClntPersonEcoHouseServiceImpl implements ClntPersonEcoHouseService {
	@Autowired
	private ClntPersonEcoHouseDao clntPersonEcoHouseDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonEcoHouse
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonEcoHouse clntPersonEcoHouse) {
		List<ClntPersonEcoHouse> list = clntPersonEcoHouseDao.query(pageView, clntPersonEcoHouse);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonEcoHouse clntPersonEcoHouse
	 * @return List<ClntPersonEcoHouse>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoHouse> queryAll(ClntPersonEcoHouse clntPersonEcoHouse) {
		List<ClntPersonEcoHouse> list = clntPersonEcoHouseDao.queryAll(clntPersonEcoHouse);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoHouse
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntPersonEcoHouse clntPersonEcoHouse) {
		clntPersonEcoHouseDao.add(clntPersonEcoHouse);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoHouse
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntPersonEcoHouse clntPersonEcoHouse) {
		clntPersonEcoHouseDao.addAll(clntPersonEcoHouse);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntPersonEcoHouseDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntPersonEcoHouse getById(String id) {
		return clntPersonEcoHouseDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonEcoHouse
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntPersonEcoHouse clntPersonEcoHouse) {
		clntPersonEcoHouseDao.modify(clntPersonEcoHouse);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoHouse> findAll() {
		return clntPersonEcoHouseDao.findAll();
	}
	
}
