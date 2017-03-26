/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import com.mf.util.*;
import com.mf.client.entity.*;
import com.mf.client.dao.*;
import com.mf.client.service.*;/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntPersonEcoCarService")
public class ClntPersonEcoCarServiceImpl implements ClntPersonEcoCarService {
	@Autowired
	private ClntPersonEcoCarDao clntPersonEcoCarDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonEcoCar
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonEcoCar clntPersonEcoCar) {
		List<ClntPersonEcoCar> list = clntPersonEcoCarDao.query(pageView, clntPersonEcoCar);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonEcoCar clntPersonEcoCar
	 * @return List<ClntPersonEcoCar>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoCar> queryAll(ClntPersonEcoCar clntPersonEcoCar) {
		List<ClntPersonEcoCar> list = clntPersonEcoCarDao.queryAll(clntPersonEcoCar);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoCar
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntPersonEcoCar clntPersonEcoCar) {
		clntPersonEcoCarDao.add(clntPersonEcoCar);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoCar
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntPersonEcoCar clntPersonEcoCar) {
		clntPersonEcoCarDao.addAll(clntPersonEcoCar);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntPersonEcoCarDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntPersonEcoCar getById(String id) {
		return clntPersonEcoCarDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonEcoCar
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntPersonEcoCar clntPersonEcoCar) {
		clntPersonEcoCarDao.modify(clntPersonEcoCar);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoCar> findAll() {
		return clntPersonEcoCarDao.findAll();
	}
	
}
