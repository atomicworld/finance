/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FinanceCondition;

/**
 * @author wangzhi
 * @2015-08-14
 * @version 1.0
 * @param <T>
 */
public interface FinanceConditionDao extends BaseDao<FinanceCondition>{
	public List<FinanceCondition> findAll() throws DataAccessException;

	public void deleteById(String id) throws DataAccessException;

	public FinanceCondition checkbankno(String bankno);
}
