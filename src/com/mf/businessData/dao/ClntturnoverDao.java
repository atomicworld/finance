/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessData.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.businessData.entity.Clntturnover;

/**
 * @author yangchao
 * @2015-04-02
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface ClntturnoverDao extends BaseDao<Clntturnover>{
	public List<Clntturnover> findAll() throws DataAccessException;


}
