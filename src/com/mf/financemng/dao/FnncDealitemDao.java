/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncDealitem;

/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */
public interface FnncDealitemDao extends BaseDao<FnncDealitem>{
	public List<FnncDealitem> findAll() throws DataAccessException;

	public FnncDealitem queryItem(FnncDealitem item)throws DataAccessException;
}
