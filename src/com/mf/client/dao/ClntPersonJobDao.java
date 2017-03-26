/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.client.entity.ClntPersonJob;
public interface ClntPersonJobDao extends BaseDao<ClntPersonJob>{
	public List<ClntPersonJob> findAll() throws DataAccessException;
}
