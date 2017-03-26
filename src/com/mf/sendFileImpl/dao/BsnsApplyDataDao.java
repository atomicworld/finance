/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sendFileImpl.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.sendFileImpl.entity.BsnsApplyData;

/**
 * @author wangzhi
 * @2015-09-08
 * @version 1.0
 * @param <T>
 */
public interface BsnsApplyDataDao extends BaseDao<BsnsApplyData>{
	public List<BsnsApplyData> findAll() throws DataAccessException;
	
	public List<BsnsApplyData> query1() throws DataAccessException;


}
