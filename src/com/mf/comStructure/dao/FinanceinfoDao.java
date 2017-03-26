package com.mf.comStructure.dao;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.comStructure.entity.Financeinfo;

/**
 * @author wangyw
 * @2015-04-16
 * @version 1.0
 * @param <T>
 */
public interface FinanceinfoDao extends BaseDao<Financeinfo>{
	
	public void submit(String id) throws DataAccessException;

}
