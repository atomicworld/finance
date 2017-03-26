/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.aop.entity.AopModule;
import com.mf.base.BaseDao;

/**
 * @author wangzhi
 * @2015-09-21
 * @version 1.0
 * @param <T>
 */
public interface AopModuleDao extends BaseDao<AopModule>{
	public List<AopModule> findAll() throws DataAccessException;


}
