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

import com.mf.shareholder.dao.CorpSharecorpDao;
import com.mf.shareholder.entity.CorpSharecorp;
import com.mf.shareholder.service.CorpSharecorpService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("corpSharecorpService")
public class CorpSharecorpServiceImpl implements CorpSharecorpService {
	@Autowired
	private CorpSharecorpDao corpSharecorpDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param corpSharecorp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, CorpSharecorp corpSharecorp) {
		List<CorpSharecorp> list = corpSharecorpDao.query(pageView, corpSharecorp);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param CorpSharecorp corpSharecorp
	 * @return List<CorpSharecorp>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpSharecorp> queryAll(CorpSharecorp corpSharecorp) {
		List<CorpSharecorp> list = corpSharecorpDao.queryAll(corpSharecorp);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param corpSharecorp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(CorpSharecorp corpSharecorp) {
		corpSharecorpDao.add(corpSharecorp);
	}
	
	/**
	 * 新增操作
	 * @param corpSharecorp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(CorpSharecorp corpSharecorp) {
		corpSharecorpDao.addAll(corpSharecorp);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		corpSharecorpDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public CorpSharecorp getById(String id) {
		return corpSharecorpDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param corpSharecorp
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(CorpSharecorp corpSharecorp) {
		corpSharecorpDao.modify(corpSharecorp);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpSharecorp> findAll() {
		return corpSharecorpDao.findAll();
	}
	
}
