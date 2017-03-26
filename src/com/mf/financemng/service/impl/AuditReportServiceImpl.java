/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.financemng.dao.AuditReportDao;
import com.mf.financemng.entity.AuditReport;
import com.mf.financemng.service.AuditReportService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-08-18
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("auditReportService")
public class AuditReportServiceImpl implements AuditReportService {
	@Autowired
	private AuditReportDao auditReportDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param auditReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView,String search,AuditReport auditReport) {
		List<AuditReport> list = null;
		if(auditReport.getReportyear()!=null&&!"".equals(auditReport.getReportyear().trim())){
			if("1".equals(search.trim())){
				 list = auditReportDao.query1(pageView, auditReport);
			}else if("2".equals(search.trim())){
				 list = auditReportDao.query2(pageView, auditReport);
			}else if("3".equals(search.trim())){
				 list = auditReportDao.query3(pageView, auditReport);
			}
		}else{
			list = auditReportDao.query(pageView, auditReport);
		}
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param AuditReport auditReport
	 * @return List<AuditReport>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AuditReport> queryAll(AuditReport auditReport) {
		List<AuditReport> list = auditReportDao.queryAll(auditReport);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param auditReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(AuditReport auditReport) {
		auditReportDao.add(auditReport);
	}
	
	/**
	 * 新增操作
	 * @param auditReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(AuditReport auditReport) {
		auditReportDao.addAll(auditReport);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void deleteById(String reportid) {
		auditReportDao.deleteById(reportid);
	}
	
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public AuditReport getById(String reportid) {
		return auditReportDao.getById(reportid);
	}
	
	/**
	 * 修改实体类
	 * @param auditReport
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(AuditReport auditReport) {
		auditReportDao.modify(auditReport);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AuditReport> findAll() {
		return auditReportDao.findAll();
	}

	@Override
	public AuditReport getByYear(String reportyear) {
		return auditReportDao.getByYear(reportyear);
	}

	

	
	
}
