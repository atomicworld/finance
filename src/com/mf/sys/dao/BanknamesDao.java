/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sys.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.sys.entity.Banknames;

/**
 * @author wangzhi
 * @2015-08-17
 * @version 1.0
 * @param <T>
 */
public interface BanknamesDao extends BaseDao<Banknames>{
	public List<Banknames> queryByParentId(int parentId) throws DataAccessException;
	public Banknames getById1(int id)throws DataAccessException;

}
