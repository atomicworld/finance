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

import com.mf.shareholder.dao.CorpSharedetailDao;
import com.mf.shareholder.entity.CorpSharedetail;
import com.mf.shareholder.service.CorpSharedetailService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("corpSharedetailService")
public class CorpSharedetailServiceImpl implements CorpSharedetailService {
	@Autowired
	private CorpSharedetailDao corpSharedetailDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param corpSharedetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, CorpSharedetail corpSharedetail) {
		List<CorpSharedetail> list = corpSharedetailDao.query(pageView, corpSharedetail);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param CorpSharedetail corpSharedetail
	 * @return List<CorpSharedetail>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpSharedetail> queryAll(CorpSharedetail corpSharedetail) {
		List<CorpSharedetail> list = corpSharedetailDao.queryAll(corpSharedetail);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param corpSharedetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(CorpSharedetail corpSharedetail) {
		corpSharedetailDao.add(corpSharedetail);
	}
	
	/**
	 * 新增操作
	 * @param corpSharedetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(CorpSharedetail corpSharedetail) {
		corpSharedetailDao.addAll(corpSharedetail);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		corpSharedetailDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public CorpSharedetail getById(String id) {
		return corpSharedetailDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param corpSharedetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(CorpSharedetail corpSharedetail) {
		corpSharedetailDao.modify(corpSharedetail);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpSharedetail> findAll() {
		return corpSharedetailDao.findAll();
	}
	
}
