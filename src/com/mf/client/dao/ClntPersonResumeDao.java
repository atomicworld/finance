/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.client.entity.ClntPersonResume;

/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface ClntPersonResumeDao extends BaseDao<ClntPersonResume>{
	public List<ClntPersonResume> findAll() throws DataAccessException;


}
