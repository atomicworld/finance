package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncCapitalreport;

/**
 * @author chenenze
 * @2015-02-11
 * @version 1.0
 * @param <T>
 */
public interface FnncCapitalreportDao extends BaseDao<FnncCapitalreport>{
	public List<FnncCapitalreport> findAll(String id) throws DataAccessException;


}
