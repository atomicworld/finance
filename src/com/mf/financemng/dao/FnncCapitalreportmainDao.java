package com.mf.financemng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncCapitalreportmain;

/**
 * @author chenenze
 * @2015-02-14
 * @version 1.0
 * @param <T>
 */
public interface FnncCapitalreportmainDao extends BaseDao<FnncCapitalreportmain>{
	public List<FnncCapitalreportmain> findAll() throws DataAccessException;


}
