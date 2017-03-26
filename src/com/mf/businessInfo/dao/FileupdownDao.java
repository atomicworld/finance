/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessInfo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.businessInfo.entity.Fileupdown;

/**
 * @author wangyw
 * @2015-08-26
 * @version 1.0
 * @param <T>
 */
public interface FileupdownDao extends BaseDao<Fileupdown>{
	public List<Fileupdown> findAll() throws DataAccessException;

	public int count(String id);
	
	public void deleteByReportid(String reportid) throws DataAccessException;
	
	public List<Fileupdown> getByReportid(String reportid) throws DataAccessException;


}
