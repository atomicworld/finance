/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.financemng.entity.Finreportitem;

/**
 * @author wangyw
 * @2016-01-05
 * @version 1.0
 * @param <T>
 */
public interface FinreportitemDao extends BaseDao<Finreportitem>{
	public List<Finreportitem> findAll() throws DataAccessException;
	
	public List<Finreportitem> getByPitemcode(String pitemcode) throws DataAccessException;


}
