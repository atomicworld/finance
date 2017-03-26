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

import com.mf.client.dao.ClntEeCapInvestDao;
import com.mf.client.entity.ClntEeCapInvest;
import com.mf.client.service.ClntEeCapInvestService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("clntEeCapInvestService")
public class ClntEeCapInvestServiceImpl implements ClntEeCapInvestService {
	@Autowired
	private ClntEeCapInvestDao clntEeCapInvestDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntEeCapInvest
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntEeCapInvest clntEeCapInvest) {
		List<ClntEeCapInvest> list = clntEeCapInvestDao.query(pageView, clntEeCapInvest);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntEeCapInvest clntEeCapInvest
	 * @return List<ClntEeCapInvest>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapInvest> queryAll(ClntEeCapInvest clntEeCapInvest) {
		List<ClntEeCapInvest> list = clntEeCapInvestDao.queryAll(clntEeCapInvest);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapInvest
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntEeCapInvest clntEeCapInvest) {
		clntEeCapInvestDao.add(clntEeCapInvest);
	}
	
	/**
	 * 新增操作
	 * @param clntEeCapInvest
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntEeCapInvest clntEeCapInvest) {
		clntEeCapInvestDao.addAll(clntEeCapInvest);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntEeCapInvestDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntEeCapInvest getById(String id) {
		return clntEeCapInvestDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntEeCapInvest
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntEeCapInvest clntEeCapInvest) {
		clntEeCapInvestDao.modify(clntEeCapInvest);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntEeCapInvest> findAll() {
		return clntEeCapInvestDao.findAll();
	}
	
}
