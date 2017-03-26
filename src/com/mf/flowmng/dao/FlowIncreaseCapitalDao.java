/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.flowmng.entity.FlowIncreaseCapital;

/**
 * @author wangzhi
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */
public interface FlowIncreaseCapitalDao extends BaseDao<FlowIncreaseCapital>{
	public List<FlowIncreaseCapital> findAll() throws DataAccessException;
	public FlowIncreaseCapital getCapitalById(int id) throws DataAccessException;
	public void deleteById(int id) throws DataAccessException;

}
