/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.financemng.entity.AuditReport;
import com.mf.util.PageView;

/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
public interface AuditReportDao extends BaseDao<AuditReport>{
	public List<AuditReport> findAll() throws DataAccessException;
	public void deleteById(String reportid) throws DataAccessException;
	public AuditReport getById(String reportid) throws DataAccessException;
	public List<AuditReport> query1(@Param("pageView")PageView pageView, @Param("t")AuditReport t) throws DataAccessException;
	public List<AuditReport> query2(@Param("pageView")PageView pageView, @Param("t")AuditReport t) throws DataAccessException;
	public List<AuditReport> query3(@Param("pageView")PageView pageView, @Param("t")AuditReport t) throws DataAccessException;
	public AuditReport getByYear(String reportyear) throws DataAccessException;

}
