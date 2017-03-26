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

import com.mf.client.dao.ClntEeCapFampartDao;
import com.mf.client.entity.ClntEeCapFampart;
import com.mf.client.service.ClntEeCapFampartService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeCapFampartService")
public class ClntEeCapFampartServiceImpl implements ClntEeCapFampartService {
	@Autowired
	private ClntEeCapFampartDao clntEeCapFampartDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeCapFampart
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeCapFampart clntEeCapFampart) {
		List<ClntEeCapFampart> list = clntEeCapFampartDao.query(pageView, clntEeCapFampart);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeCapFampart clntEeCapFampart
	 * @return List<ClntEeCapFampart>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapFampart> queryAll(ClntEeCapFampart clntEeCapFampart) {
		List<ClntEeCapFampart> list = clntEeCapFampartDao.queryAll(clntEeCapFampart);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapFampart
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeCapFampart clntEeCapFampart) {
		clntEeCapFampartDao.add(clntEeCapFampart);
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapFampart
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeCapFampart clntEeCapFampart) {
		clntEeCapFampartDao.addAll(clntEeCapFampart);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeCapFampartDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeCapFampart getById(String id) {
		return clntEeCapFampartDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeCapFampart
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeCapFampart clntEeCapFampart) {
		clntEeCapFampartDao.modify(clntEeCapFampart);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapFampart> findAll() {
		return clntEeCapFampartDao.findAll();
	}
	
}
