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

import com.mf.client.dao.ClntEeDao;
import com.mf.client.entity.ClntEe;
import com.mf.client.service.ClntEeService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-24
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeService")
public class ClntEeServiceImpl implements ClntEeService {
	@Autowired
	private ClntEeDao clntEeDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEe
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEe clntEe) {
		List<ClntEe> list = clntEeDao.query(pageView, clntEe);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEe clntEe
	 * @return List<ClntEe>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEe> queryAll(ClntEe clntEe) {
		List<ClntEe> list = clntEeDao.queryAll(clntEe);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEe
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEe clntEe) {
		clntEeDao.add(clntEe);
	}
	
	/**
	 * 新增操作
	 * @param clntEe
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEe clntEe) {
		clntEeDao.addAll(clntEe);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEe getById(String id) {
		return clntEeDao.getById(id);
	}
	@Transactional(readOnly=true)
	public ClntEe FindByid(String id) {
		return clntEeDao.FindByid(id);
	}
	
	
	/**
	 * 修改实体类
	 * @param clntEe
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEe clntEe) {
		clntEeDao.modify(clntEe);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEe> findAll() {
		return clntEeDao.findAll();
	}

}
