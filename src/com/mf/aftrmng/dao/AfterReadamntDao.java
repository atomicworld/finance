/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.aftrmng.entity.AfterReadamnt;
import com.mf.base.BaseDao;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */
public interface AfterReadamntDao extends BaseDao<AfterReadamnt>{
	public List<AfterReadamnt> findAll() throws DataAccessException;


}
