/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.RequestParam;

import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsOverdueUrge;

/**
 * @author huangwen
 * @2015-05-29
 * @version 1.0
 * @param <T>
 */
public interface BsnsOverdueUrgeDao extends BaseDao<BsnsOverdueUrge>{
	public List<BsnsOverdueUrge> findAll() throws DataAccessException;

	public void add(BsnsOverdueUrge bsnsOverdueUrge) throws DataAccessException;
	
	public BsnsOverdueUrge getById(String id) throws DataAccessException;
	
	public List<BsnsOverdueUrge> selectByMap(String srlno,String data) throws DataAccessException;
							
}
