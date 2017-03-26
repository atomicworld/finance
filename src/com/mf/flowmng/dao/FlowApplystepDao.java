package com.mf.flowmng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.flowmng.entity.FlowApplystep;

public interface FlowApplystepDao  extends BaseDao<FlowApplystep>{
	public List<FlowApplystep> findAll() throws DataAccessException;
	public List<FlowApplystep> findByapprlno(String apprlno) throws DataAccessException;
	public FlowApplystep getMax() throws DataAccessException;
	public FlowApplystep getByapprlno(String apprlno) throws DataAccessException;
	
}
