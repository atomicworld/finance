/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.aop.entity.AopSysLog;
import com.mf.base.BaseDao;
import com.mf.sys.entity.SysLog;
import com.mf.util.PageView;

/**
 * @author wangzhi
 * @2015-09-21
 * @version 1.0
 * @param <T>
 */
public interface AopSysLogDao extends BaseDao<AopSysLog>{
	public List<AopSysLog> findAll() throws DataAccessException;
	public int findMaxId() throws DataAccessException;
	public List<AopSysLog> querySdate(@Param("pageView")PageView pageView, @Param("t")AopSysLog aopSysLog, @Param("sdate")String sdate) throws DataAccessException;
	public List<AopSysLog> queryEdate(@Param("pageView")PageView pageView, @Param("t")AopSysLog aopSysLog, @Param("edate")String edate) throws DataAccessException;
	public List<AopSysLog> queryDate(@Param("pageView")PageView pageView, @Param("t")AopSysLog aopSysLog, @Param("sdate")String sdate, @Param("edate")String edate) throws DataAccessException;

}
