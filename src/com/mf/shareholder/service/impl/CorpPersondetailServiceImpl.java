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

import com.mf.shareholder.dao.CorpPersondetailDao;
import com.mf.shareholder.entity.CorpPersondetail;
import com.mf.shareholder.service.CorpPersondetailService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("corpPersondetailService")
public class CorpPersondetailServiceImpl implements CorpPersondetailService {
	@Autowired
	private CorpPersondetailDao corpPersondetailDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param corpPersondetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, CorpPersondetail corpPersondetail) {
		List<CorpPersondetail> list = corpPersondetailDao.query(pageView, corpPersondetail);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param CorpPersondetail corpPersondetail
	 * @return List<CorpPersondetail>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpPersondetail> queryAll(CorpPersondetail corpPersondetail) {
		List<CorpPersondetail> list = corpPersondetailDao.queryAll(corpPersondetail);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param corpPersondetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(CorpPersondetail corpPersondetail) {
		corpPersondetailDao.add(corpPersondetail);
	}
	
	/**
	 * 新增操作
	 * @param corpPersondetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(CorpPersondetail corpPersondetail) {
		corpPersondetailDao.addAll(corpPersondetail);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		corpPersondetailDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public CorpPersondetail getById(String id) {
		return corpPersondetailDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param corpPersondetail
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(CorpPersondetail corpPersondetail) {
		corpPersondetailDao.modify(corpPersondetail);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpPersondetail> findAll() {
		return corpPersondetailDao.findAll();
	}
	
}
