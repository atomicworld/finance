/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.sys.dao.BanknamesDao;
import com.mf.sys.entity.Banknames;
import com.mf.sys.service.BanknamesService;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-17
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("banknamesService")
public class BanknamesServiceImpl implements BanknamesService {
	@Autowired
	private BanknamesDao banknamesDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param banknames
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Banknames banknames) {
		List<Banknames> list = banknamesDao.query(pageView, banknames);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Banknames banknames
	 * @return List<Banknames>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Banknames> queryAll(Banknames banknames) {
		List<Banknames> list = banknamesDao.queryAll(banknames);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param banknames
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Banknames banknames) {
		banknamesDao.add(banknames);
	}
	
	/**
	 * 新增操作
	 * @param banknames
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Banknames banknames) {
		banknamesDao.addAll(banknames);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		banknamesDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Banknames getById1(int id) {
		return banknamesDao.getById1(id);
	}
	
	/**
	 * 修改实体类
	 * @param banknames
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Banknames banknames) {
		banknamesDao.modify(banknames);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Banknames> queryByParentId(int parentId) {
		return banknamesDao.queryByParentId(parentId);
	}

	@Override
	public List<Banknames> findAll() {
		return null;
	}
	
}
