/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FinanceSupple;

/**
 * @author wangzhi
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */
public interface FinanceSuppleDao extends BaseDao<FinanceSupple>{
	public List<FinanceSupple> findAll() throws DataAccessException;
	
	public FinanceSupple getBysuppleId(int id) throws DataAccessException;
	
	public void deleteById(int id)throws DataAccessException;
	
	public FinanceSupple getByReport(String reportMonth)throws DataAccessException;

	public void deleteByFlag(String id);


}
