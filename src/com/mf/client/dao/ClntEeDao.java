/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.client.entity.ClntEe;

/**
 * @author xujiuhua
 * @2014-12-24
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface ClntEeDao extends BaseDao<ClntEe>{
	public List<ClntEe> findAll() throws DataAccessException;
	
	public ClntEe FindByid(String clntno); 

}
