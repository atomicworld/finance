/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.financemng.dao.FinreportDao;
import com.mf.financemng.entity.Finreport;
import com.mf.financemng.service.FinreportService;
import com.mf.util.PageView;
/**
 * @author wangyw
 * @2016-01-08
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("finreportService")
public class FinreportServiceImpl implements FinreportService {
	@Autowired
	private FinreportDao finreportDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param finreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Finreport finreport) {
		List<Finreport> list = finreportDao.query(pageView, finreport);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Finreport finreport
	 * @return List<Finreport>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Finreport> queryAll(Finreport finreport) {
		List<Finreport> list = finreportDao.queryAll(finreport);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param finreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Finreport finreport) {
		finreportDao.add(finreport);
	}
	
	/**
	 * 新增操作
	 * @param finreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(Finreport finreport) {
		finreportDao.addAll(finreport);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteByRptid(String rptid) {
		finreportDao.deleteByRptid(rptid);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Finreport getByRptid(String rptid) {
		return finreportDao.getByRptid(rptid);
	}
	
	/**
	 * 修改实体类
	 * @param finreport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(Finreport finreport) {
		finreportDao.modify(finreport);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Finreport> findAll() {
		return finreportDao.findAll();
	}

	@Override
	public Finreport getByRptmonth(Finreport finreport) {
		return finreportDao.getByRptmonth(finreport);
	}

	@Override
	public void deleteByRptmonth(Finreport finreport) {
		finreportDao.deleteByRptmonth(finreport);
	}
	
}
