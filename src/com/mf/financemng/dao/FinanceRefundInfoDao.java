/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FinanceRefundInfo;

/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */
public interface FinanceRefundInfoDao extends BaseDao<FinanceRefundInfo>{
	public List<FinanceRefundInfo> findAll() throws DataAccessException;
	
	public FinanceRefundInfo getFiInfoById(String id)throws DataAccessException;
	
	public void deleteById(String id) throws DataAccessException;

	public void deleteParentId(String loanno);
}
