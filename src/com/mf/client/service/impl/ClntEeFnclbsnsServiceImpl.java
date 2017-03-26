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

import com.mf.client.dao.ClntEeFnclbsnsDao;
import com.mf.client.entity.ClntEeFnclbsns;
import com.mf.client.service.ClntEeFnclbsnsService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeFnclbsnsService")
public class ClntEeFnclbsnsServiceImpl implements ClntEeFnclbsnsService {
	@Autowired
	private ClntEeFnclbsnsDao clntEeFnclbsnsDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeFnclbsns
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeFnclbsns clntEeFnclbsns) {
		List<ClntEeFnclbsns> list = clntEeFnclbsnsDao.query(pageView, clntEeFnclbsns);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeFnclbsns clntEeFnclbsns
	 * @return List<ClntEeFnclbsns>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeFnclbsns> queryAll(ClntEeFnclbsns clntEeFnclbsns) {
		List<ClntEeFnclbsns> list = clntEeFnclbsnsDao.queryAll(clntEeFnclbsns);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeFnclbsns
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeFnclbsns clntEeFnclbsns) {
		clntEeFnclbsnsDao.add(clntEeFnclbsns);
	}
	
	/**
	 * 新增操作
	 * @param clntEeFnclbsns
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeFnclbsns clntEeFnclbsns) {
		clntEeFnclbsnsDao.addAll(clntEeFnclbsns);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeFnclbsnsDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeFnclbsns getById(String id) {
		return clntEeFnclbsnsDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeFnclbsns
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeFnclbsns clntEeFnclbsns) {
		clntEeFnclbsnsDao.modify(clntEeFnclbsns);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeFnclbsns> findAll() {
		return clntEeFnclbsnsDao.findAll();
	}
	
}
