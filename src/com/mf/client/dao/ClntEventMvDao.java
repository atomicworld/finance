/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.client.entity.ClntEventMv;

/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface ClntEventMvDao extends BaseDao<ClntEventMv>{
	public List<ClntEventMv> findAll() throws DataAccessException;


}
