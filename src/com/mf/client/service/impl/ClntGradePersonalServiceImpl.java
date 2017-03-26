/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.client.dao.ClntGradePersonalDao;
import com.mf.client.entity.ClntGradePersonal;
import com.mf.client.service.ClntGradePersonalService;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntGradePersonalService")
public class ClntGradePersonalServiceImpl implements ClntGradePersonalService {
	@Autowired
	private ClntGradePersonalDao clntGradePersonalDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntGradePersonal
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntGradePersonal clntGradePersonal) {
		List<ClntGradePersonal> list = clntGradePersonalDao.query(pageView, clntGradePersonal);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntGradePersonal clntGradePersonal
	 * @return List<ClntGradePersonal>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntGradePersonal> queryAll(ClntGradePersonal clntGradePersonal) {
		List<ClntGradePersonal> list = clntGradePersonalDao.queryAll(clntGradePersonal);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntGradePersonal
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntGradePersonal clntGradePersonal) {
		clntGradePersonalDao.add(clntGradePersonal);
	}
	
	/**
	 * 新增操作
	 * @param clntGradePersonal
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntGradePersonal clntGradePersonal) {
		clntGradePersonalDao.addAll(clntGradePersonal);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntGradePersonalDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntGradePersonal getById(String id) {
		return clntGradePersonalDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntGradePersonal
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntGradePersonal clntGradePersonal) {
		clntGradePersonalDao.modify(clntGradePersonal);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntGradePersonal> findAll() {
		return clntGradePersonalDao.findAll();
	}
	
}
