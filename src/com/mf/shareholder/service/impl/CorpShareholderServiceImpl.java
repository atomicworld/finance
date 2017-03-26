/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.shareholder.dao.CorpShareholderDao;
import com.mf.shareholder.entity.CorpShareholder;
import com.mf.shareholder.service.CorpShareholderService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("corpShareholderService")
public class CorpShareholderServiceImpl implements CorpShareholderService {
	@Autowired
	private CorpShareholderDao corpShareholderDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param corpShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, CorpShareholder corpShareholder) {
		List<CorpShareholder> list = corpShareholderDao.query(pageView, corpShareholder);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param CorpShareholder corpShareholder
	 * @return List<CorpShareholder>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpShareholder> queryAll(CorpShareholder corpShareholder) {
		List<CorpShareholder> list = corpShareholderDao.queryAll(corpShareholder);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param corpShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(CorpShareholder corpShareholder) {
		corpShareholderDao.add(corpShareholder);
	}
	
	/**
	 * 新增操作
	 * @param corpShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(CorpShareholder corpShareholder) {
		corpShareholderDao.addAll(corpShareholder);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		corpShareholderDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public CorpShareholder getById(String id) {
		return corpShareholderDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param corpShareholder
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(CorpShareholder corpShareholder) {
		corpShareholderDao.modify(corpShareholder);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpShareholder> findAll() {
		return corpShareholderDao.findAll();
	}
	
}
