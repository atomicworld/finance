/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsExtend;

/**
 * @author wangyw
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */
public interface BsnsExtendDao extends BaseDao<BsnsExtend>{
	public List<BsnsExtend> findAll() throws DataAccessException;
	
	public BsnsExtend getByDueno(String dueno)throws DataAccessException;

}
