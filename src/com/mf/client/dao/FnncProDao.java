/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.client.entity.Fixedassets;

/**
 * @author wangyw
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
public interface FnncProDao extends BaseDao<Fixedassets>{
	public List<Fixedassets> findAll() throws DataAccessException;
	public void deleteint(int proid);
	

}
