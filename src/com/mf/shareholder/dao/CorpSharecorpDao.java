/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.shareholder.entity.CorpSharecorp;

/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */
public interface CorpSharecorpDao extends BaseDao<CorpSharecorp>{
	public List<CorpSharecorp> findAll() throws DataAccessException;


}
