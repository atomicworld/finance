/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.client.entity.ClntGradeCommerce;

/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */
public interface ClntGradeCommerceDao extends BaseDao<ClntGradeCommerce>{
	public List<ClntGradeCommerce> findAll() throws DataAccessException;


}
