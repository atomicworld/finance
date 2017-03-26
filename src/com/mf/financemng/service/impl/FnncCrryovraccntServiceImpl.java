/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.dao.FnncCrryovraccntDao;
import com.mf.financemng.entity.FnncCrryovraccnt;
import com.mf.financemng.service.FnncCrryovraccntService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author yangchao
 * @2015-03-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncCrryovraccntService")
public class FnncCrryovraccntServiceImpl implements FnncCrryovraccntService {
	@Autowired
	private FnncCrryovraccntDao fnncCrryovraccntDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncCrryovraccnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncCrryovraccnt fnncCrryovraccnt) {
		List<FnncCrryovraccnt> list = fnncCrryovraccntDao.query(pageView, fnncCrryovraccnt);
		pageView.setRecords(list);
		return pageView;
	}
	@Transactional(readOnly=true)
	public PageView queryJZ(PageView pageView, FnncCrryovraccnt fnncCrryovraccnt) {
		List<FnncCrryovraccnt> list = fnncCrryovraccntDao.queryJZ(pageView, fnncCrryovraccnt);
		pageView.setRecords(list);
		return pageView;
	}
	
	public boolean queryLen(PageView pageView, FnncCrryovraccnt fnncCrryovraccnt){
		List<FnncCrryovraccnt> list = fnncCrryovraccntDao.queryJZ(pageView, fnncCrryovraccnt);
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 不分页查询
	 * @param FnncCrryovraccnt fnncCrryovraccnt
	 * @return List<FnncCrryovraccnt>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncCrryovraccnt> queryAll(FnncCrryovraccnt fnncCrryovraccnt) {
		List<FnncCrryovraccnt> list = fnncCrryovraccntDao.queryAll(fnncCrryovraccnt);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncCrryovraccnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncCrryovraccnt fnncCrryovraccnt) {
		fnncCrryovraccntDao.add(fnncCrryovraccnt);
	}
	
	/**
	 * 新增操作
	 * @param fnncCrryovraccnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncCrryovraccnt fnncCrryovraccnt) {
		fnncCrryovraccntDao.addAll(fnncCrryovraccnt);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncCrryovraccntDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncCrryovraccnt getById(String id) {
		return fnncCrryovraccntDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncCrryovraccnt
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncCrryovraccnt fnncCrryovraccnt) {
		fnncCrryovraccntDao.modify(fnncCrryovraccnt);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncCrryovraccnt> findAll() {
		return fnncCrryovraccntDao.findAll();
	}
	
}
