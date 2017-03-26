/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.shareholder.dao.CorpSharerelativesDao;
import com.mf.shareholder.entity.CorpSharerelatives;
import com.mf.shareholder.service.CorpSharerelativesService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("corpSharerelativesService")
public class CorpSharerelativesServiceImpl implements CorpSharerelativesService {
	@Autowired
	private CorpSharerelativesDao corpSharerelativesDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param corpSharerelatives
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, CorpSharerelatives corpSharerelatives) {
		List<CorpSharerelatives> list = corpSharerelativesDao.query(pageView, corpSharerelatives);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param CorpSharerelatives corpSharerelatives
	 * @return List<CorpSharerelatives>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpSharerelatives> queryAll(CorpSharerelatives corpSharerelatives) {
		List<CorpSharerelatives> list = corpSharerelativesDao.queryAll(corpSharerelatives);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param corpSharerelatives
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(CorpSharerelatives corpSharerelatives) {
		corpSharerelativesDao.add(corpSharerelatives);
	}
	
	/**
	 * 新增操作
	 * @param corpSharerelatives
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(CorpSharerelatives corpSharerelatives) {
		corpSharerelativesDao.addAll(corpSharerelatives);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		corpSharerelativesDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public CorpSharerelatives getById(String id) {
		return corpSharerelativesDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param corpSharerelatives
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(CorpSharerelatives corpSharerelatives) {
		corpSharerelativesDao.modify(corpSharerelatives);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpSharerelatives> findAll() {
		return corpSharerelativesDao.findAll();
	}
	
}
