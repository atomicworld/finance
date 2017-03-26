package com.mf.bsnsmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.ReportsmodelDown;

/**
 * @author wangyw
 * @2015-06-24
 * @version 1.0
 * @param <T>
 */
public interface ReportsmodelDownDao extends BaseDao<ReportsmodelDown>{
	public List<ReportsmodelDown> findAll() throws DataAccessException;


}
