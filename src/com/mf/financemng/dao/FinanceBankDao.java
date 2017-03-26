/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FinanceBank;

/**
 * @author wangzhi
 * @2015-08-13
 * @version 1.0
 * @param <T>
 */
public interface FinanceBankDao extends BaseDao<FinanceBank>{
	public List<FinanceBank> findAll() throws DataAccessException;


}
