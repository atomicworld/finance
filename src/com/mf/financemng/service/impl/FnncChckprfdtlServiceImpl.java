/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.dao.FnncChckprfdtlDao;
import com.mf.financemng.entity.FnncChckprfdtl;
import com.mf.financemng.service.FnncChckprfdtlService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncChckprfdtlService")
public class FnncChckprfdtlServiceImpl implements FnncChckprfdtlService {
	@Autowired
	private FnncChckprfdtlDao fnncChckprfdtlDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncChckprfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncChckprfdtl fnncChckprfdtl) {
		List<FnncChckprfdtl> list = fnncChckprfdtlDao.query(pageView, fnncChckprfdtl);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param FnncChckprfdtl fnncChckprfdtl
	 * @return List<FnncChckprfdtl>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncChckprfdtl> queryAll(FnncChckprfdtl fnncChckprfdtl) {
		List<FnncChckprfdtl> list = fnncChckprfdtlDao.queryAll(fnncChckprfdtl);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncChckprfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncChckprfdtl fnncChckprfdtl) {
		fnncChckprfdtlDao.add(fnncChckprfdtl);
	}
	
	/**
	 * 新增操作
	 * @param fnncChckprfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncChckprfdtl fnncChckprfdtl) {
		fnncChckprfdtlDao.addAll(fnncChckprfdtl);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncChckprfdtlDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncChckprfdtl getById(String id) {
		return fnncChckprfdtlDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncChckprfdtl
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncChckprfdtl fnncChckprfdtl) {
		fnncChckprfdtlDao.modify(fnncChckprfdtl);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncChckprfdtl> findAll() {
		return fnncChckprfdtlDao.findAll();
	}
	
}
