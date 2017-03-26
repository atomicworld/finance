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
import com.mf.financemng.entity.FnncCrryovraccnt;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-03-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncCrryovraccntDao extends BaseDao<FnncCrryovraccnt>{
	public List<FnncCrryovraccnt> findAll() throws DataAccessException;
	
	public FnncCrryovraccnt crryOvr() throws DataAccessException;
	
	public List<FnncCrryovraccnt> queryJZ(@Param("pageView")PageView pageView, @Param("t")FnncCrryovraccnt fnnccrryovraccnt) throws DataAccessException;

}
