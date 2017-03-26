package com.mf.comStructure.dao;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.comStructure.entity.ComStructure;

/**
 * @author zhangcong
 * @2015-04-14
 * @version 1.0
 * @param <T>
 */
public interface ComStructureDao extends BaseDao<ComStructure>{

	public void submit(String id) throws DataAccessException;
}
