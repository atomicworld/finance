/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.bsnsmng.dao.BsnsReportDao;
import com.mf.bsnsmng.entity.BsnsReport;
import com.mf.bsnsmng.service.BsnsReportService;
import com.mf.util.PageView;

import java.util.List;

/**
 * @author yangchao
 * @2015-03-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsReportService")
public class BsnsReportServiceImpl implements BsnsReportService {
	@Autowired
	private BsnsReportDao bsnsReportDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsReport bsnsReport) {
		List<BsnsReport> list = bsnsReportDao.query(pageView, bsnsReport);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param BsnsReport bsnsReport
	 * @return List<BsnsReport>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsReport> queryAll(BsnsReport bsnsReport) {
		List<BsnsReport> list = bsnsReportDao.queryAll(bsnsReport);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsReport bsnsReport) {
		bsnsReportDao.add(bsnsReport);
	}
	
	/**
	 * 新增操作
	 * @param bsnsReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsReport bsnsReport) {
		bsnsReportDao.addAll(bsnsReport);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		bsnsReportDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsReport getById(String id) {
		return bsnsReportDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsReport bsnsReport) {
		bsnsReportDao.modify(bsnsReport);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsReport> findAll() {
		return bsnsReportDao.findAll();
	}
	
}
