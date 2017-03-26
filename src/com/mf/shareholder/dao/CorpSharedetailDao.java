/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.shareholder.entity.CorpSharedetail;

/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */
public interface CorpSharedetailDao extends BaseDao<CorpSharedetail>{
	public List<CorpSharedetail> findAll() throws DataAccessException;


}
