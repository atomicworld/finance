/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncTaxsub;
import com.mf.util.PageView;

/**
 * @author wangyw
 * @2015-08-19
 * @version 1.0
 * @param <T>
 */
public interface FnncTaxsubDao extends BaseDao<FnncTaxsub>{
	public List<FnncTaxsub> findAll() throws DataAccessException;

	public void deleteById(String id) throws DataAccessException;
	
	public List<FnncTaxsub> query1(@Param("pageView")PageView pageView, @Param("t")FnncTaxsub t) throws DataAccessException;
	
	public List<FnncTaxsub> query2(@Param("pageView")PageView pageView, @Param("t")FnncTaxsub t) throws DataAccessException;

	public List<FnncTaxsub> query3(@Param("pageView")PageView pageView, @Param("t")FnncTaxsub t) throws DataAccessException;


}
