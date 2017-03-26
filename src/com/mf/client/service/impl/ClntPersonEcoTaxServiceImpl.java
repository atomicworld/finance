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
@Service("clntPersonEcoTaxService")
public class ClntPersonEcoTaxServiceImpl implements ClntPersonEcoTaxService {
	@Autowired
	private ClntPersonEcoTaxDao clntPersonEcoTaxDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param clntPersonEcoTax
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, ClntPersonEcoTax clntPersonEcoTax) {
		List<ClntPersonEcoTax> list = clntPersonEcoTaxDao.query(pageView, clntPersonEcoTax);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param ClntPersonEcoTax clntPersonEcoTax
	 * @return List<ClntPersonEcoTax>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoTax> queryAll(ClntPersonEcoTax clntPersonEcoTax) {
		List<ClntPersonEcoTax> list = clntPersonEcoTaxDao.queryAll(clntPersonEcoTax);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoTax
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(ClntPersonEcoTax clntPersonEcoTax) {
		clntPersonEcoTaxDao.add(clntPersonEcoTax);
	}
	
	/**
	 * 新增操作
	 * @param clntPersonEcoTax
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(ClntPersonEcoTax clntPersonEcoTax) {
		clntPersonEcoTaxDao.addAll(clntPersonEcoTax);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		clntPersonEcoTaxDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public ClntPersonEcoTax getById(String id) {
		return clntPersonEcoTaxDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param clntPersonEcoTax
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(ClntPersonEcoTax clntPersonEcoTax) {
		clntPersonEcoTaxDao.modify(clntPersonEcoTax);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<ClntPersonEcoTax> findAll() {
		return clntPersonEcoTaxDao.findAll();
	}
	
}
