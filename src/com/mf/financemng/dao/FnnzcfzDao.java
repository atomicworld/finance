/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.Fnnzcfz;

/**
 * @author wangzhi
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
public interface FnnzcfzDao extends BaseDao<Fnnzcfz>{
	public List<Fnnzcfz> findAll() throws DataAccessException;
	
	public void deleteById(int id) throws DataAccessException;
	public Fnnzcfz getByZcfzId(int id) throws DataAccessException;
	public Fnnzcfz getFnnzcfz(Fnnzcfz f) throws DataAccessException;
	public void updateFnnzcfz(Fnnzcfz fnnzcfz) throws DataAccessException;
	public void deleteFnnzcfz(String reportMonth) throws DataAccessException;
	
	public Fnnzcfz getByReport(String reportMonth)throws DataAccessException;

	public void deleteByFlag(String id);


}
