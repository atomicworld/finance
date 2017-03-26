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

import com.mf.shareholder.dao.CorpShareassetsDao;
import com.mf.shareholder.entity.CorpShareassets;
import com.mf.shareholder.service.CorpShareassetsService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("corpShareassetsService")
public class CorpShareassetsServiceImpl implements CorpShareassetsService {
	@Autowired
	private CorpShareassetsDao corpShareassetsDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param corpShareassets
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, CorpShareassets corpShareassets) {
		List<CorpShareassets> list = corpShareassetsDao.query(pageView, corpShareassets);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param CorpShareassets corpShareassets
	 * @return List<CorpShareassets>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpShareassets> queryAll(CorpShareassets corpShareassets) {
		List<CorpShareassets> list = corpShareassetsDao.queryAll(corpShareassets);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param corpShareassets
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(CorpShareassets corpShareassets) {
		corpShareassetsDao.add(corpShareassets);
	}
	
	/**
	 * 新增操作
	 * @param corpShareassets
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(CorpShareassets corpShareassets) {
		corpShareassetsDao.addAll(corpShareassets);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		corpShareassetsDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public CorpShareassets getById(String id) {
		return corpShareassetsDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param corpShareassets
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(CorpShareassets corpShareassets) {
		corpShareassetsDao.modify(corpShareassets);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<CorpShareassets> findAll() {
		return corpShareassetsDao.findAll();
	}
	
}
