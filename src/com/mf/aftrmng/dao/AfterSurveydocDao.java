/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.aftrmng.entity.AfterSurveydoc;

/**
 * @author xujiuhua
 * @2015-01-20
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface AfterSurveydocDao extends BaseDao<AfterSurveydoc>{
	public List<AfterSurveydoc> findAll() throws DataAccessException;

	public void updateAll(AfterSurveydoc afterSurveydoc) throws DataAccessException;
}
