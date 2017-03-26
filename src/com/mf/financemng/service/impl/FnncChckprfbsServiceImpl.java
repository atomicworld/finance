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

import com.mf.financemng.dao.FnncChckprfbsDao;
import com.mf.financemng.entity.FnncChckprfbs;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.financemng.service.FnncChckprfbsService;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncChckprfbsService")
public class FnncChckprfbsServiceImpl implements FnncChckprfbsService {
	@Autowired
	private FnncChckprfbsDao fnncChckprfbsDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncChckprfbs
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncChckprfbs fnncChckprfbs) {
		List<FnncChckprfbs> list = fnncChckprfbsDao.query(pageView, fnncChckprfbs);
		pageView.setRecords(list);
		return pageView;
	}

	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncChckprfbs getById(String id) {
		return fnncChckprfbsDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncChckprfbs
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncChckprfbs fnncChckprfbs) {
		fnncChckprfbsDao.modify(fnncChckprfbs);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncChckprfbs> findAll() {
		return fnncChckprfbsDao.findAll();
	}
	
	@Override
	public PageView queryList(PageView pageView, FnncPrfbsList fnncprfbslist) {
		List<FnncPrfbsList> list = fnncChckprfbsDao.queryList(pageView, fnncprfbslist);
		pageView.setRecords(list);
		return pageView;
	}


	@Override
	public void add(FnncChckprfbs fnncchckprfbs) {
		fnncChckprfbsDao.add(fnncchckprfbs);
	}
}
