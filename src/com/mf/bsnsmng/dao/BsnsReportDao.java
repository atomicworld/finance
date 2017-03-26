/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.BsnsReport;

/**
 * @author yangchao
 * @2015-03-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface BsnsReportDao extends BaseDao<BsnsReport>{
	public List<BsnsReport> findAll() throws DataAccessException;


}
