package com.mf.comStructure.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.comStructure.entity.Fundtable;


public interface FundtableDao extends BaseDao<Fundtable>{
	public List<Fundtable> findAll() throws DataAccessException;

	public void submit(String id) throws DataAccessException;
}
