package com.mf.org.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.org.entity.EmplyTrain;

/**
 * @author 	hw
 * @2015-08-24
 */
public interface EmplyTrainDao extends BaseDao<EmplyTrain>{
	public List<EmplyTrain> findAll() throws DataAccessException;
	
	public List<EmplyTrain> getByTraino(String trainno) throws DataAccessException;
	
	public void deleteEmplyTrain(String trainno) throws DataAccessException;
}
