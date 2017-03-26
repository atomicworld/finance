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

import com.mf.client.dao.ClntEeCapOutDao;
import com.mf.client.entity.ClntEeCapOut;
import com.mf.client.service.ClntEeCapOutService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeCapOutService")
public class ClntEeCapOutServiceImpl implements ClntEeCapOutService {
	@Autowired
	private ClntEeCapOutDao clntEeCapOutDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeCapOut
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeCapOut clntEeCapOut) {
		List<ClntEeCapOut> list = clntEeCapOutDao.query(pageView, clntEeCapOut);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeCapOut clntEeCapOut
	 * @return List<ClntEeCapOut>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapOut> queryAll(ClntEeCapOut clntEeCapOut) {
		List<ClntEeCapOut> list = clntEeCapOutDao.queryAll(clntEeCapOut);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapOut
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeCapOut clntEeCapOut) {
		clntEeCapOutDao.add(clntEeCapOut);
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapOut
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeCapOut clntEeCapOut) {
		clntEeCapOutDao.addAll(clntEeCapOut);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeCapOutDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeCapOut getById(String id) {
		return clntEeCapOutDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeCapOut
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeCapOut clntEeCapOut) {
		clntEeCapOutDao.modify(clntEeCapOut);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapOut> findAll() {
		return clntEeCapOutDao.findAll();
	}
	
}
