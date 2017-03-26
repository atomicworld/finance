/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.client.dao.FnncProDao;
import com.mf.client.entity.Fixedassets;
import com.mf.client.service.FnncProService;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncProService")
public class FnncProServiceImpl implements FnncProService {
	@Autowired
	private FnncProDao fnncProDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncPro
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Fixedassets fnncPro) {
		List<Fixedassets> list = fnncProDao.query(pageView, fnncPro);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncPro fnncPro
	 * @return List<FnncPro>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fixedassets> queryAll(Fixedassets fnncPro) {
		List<Fixedassets> list = fnncProDao.queryAll(fnncPro);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncPro
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Fixedassets fnncPro) {
		fnncProDao.add(fnncPro);
	}
	
	/**
	 * 新增操作
	 * @param fnncPro
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Fixedassets fnncPro) {
		fnncProDao.addAll(fnncPro);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String proid) {
		fnncProDao.delete(proid);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteint(int proid) {
		fnncProDao.deleteint(proid);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Fixedassets getById(String id) {
		return fnncProDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncPro
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Fixedassets fnncPro) {
		fnncProDao.modify(fnncPro);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Fixedassets> findAll() {
		return fnncProDao.findAll();
	}
	
}
