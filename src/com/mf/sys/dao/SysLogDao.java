package com.mf.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.sys.entity.SysLog;
import com.mf.util.PageView;

public interface SysLogDao extends BaseDao<SysLog>{
	public List<SysLog> querySdate(@Param("pageView")PageView pageView, @Param("t")SysLog syslog, @Param("sdate")String sdate) throws DataAccessException;
	public List<SysLog> queryEdate(@Param("pageView")PageView pageView, @Param("t")SysLog syslog, @Param("edate")String edate) throws DataAccessException;
	public List<SysLog> queryDate(@Param("pageView")PageView pageView, @Param("t")SysLog syslog, @Param("sdate")String sdate, @Param("edate")String edate) throws DataAccessException;

}
