package com.mf.financemng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncShareholder;
import com.mf.util.PageView;

/**
 * @author chenenze
 * @2015-02-10
 * @version 1.0
 * @param <T>
 */
public interface FnncShareholderDao extends BaseDao<FnncShareholder>{
	public List<FnncShareholder> findAll() throws DataAccessException;
	public FnncShareholder findbynm(String sharholdnm)  throws DataAccessException;	
	public List<FnncShareholder> queryhistory(@Param("pageView")PageView pageView, @Param("t")FnncShareholder t) throws DataAccessException;
}
