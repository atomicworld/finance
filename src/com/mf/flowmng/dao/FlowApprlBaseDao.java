/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.flowmng.entity.FlowApprlBase;


/**
 * @author yangchao
 * @2015-01-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FlowApprlBaseDao extends BaseDao<FlowApprlBase>{
	public List<FlowApprlBase> findAll() throws DataAccessException;


}
