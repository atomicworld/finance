/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.client.entity.ClntBlacklist;

/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface ClntBlacklistDao extends BaseDao<ClntBlacklist>{
	public List<ClntBlacklist> findAll() throws DataAccessException;
	
	//add by hw
	public List<ClntBlacklist> queryUnSubmit(ClntBlacklist clntBlacklist) throws DataAccessException;

}
