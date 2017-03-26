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

import com.mf.client.dao.ClntEeRegDao;
import com.mf.client.entity.ClntEeReg;
import com.mf.client.service.ClntEeRegService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-25
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeRegService")
public class ClntEeRegServiceImpl implements ClntEeRegService {
	@Autowired
	private ClntEeRegDao clntEeRegDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeReg
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeReg clntEeReg) {
		List<ClntEeReg> list = clntEeRegDao.query(pageView, clntEeReg);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeReg clntEeReg
	 * @return List<ClntEeReg>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeReg> queryAll(ClntEeReg clntEeReg) {
		List<ClntEeReg> list = clntEeRegDao.queryAll(clntEeReg);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeReg
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeReg clntEeReg) {
		clntEeRegDao.add(clntEeReg);
	}
	
	/**
	 * 新增操作
	 * @param clntEeReg
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeReg clntEeReg) {
		clntEeRegDao.addAll(clntEeReg);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeRegDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeReg getById(String id) {
		return clntEeRegDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeReg
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeReg clntEeReg) {
		clntEeRegDao.modify(clntEeReg);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeReg> findAll() {
		return clntEeRegDao.findAll();
	}
	
}
