/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.aftrmng.entity.AfterBadloan;
import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.base.BaseDao;
import com.mf.util.PageView;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */
public interface AfterBadloanDao extends BaseDao<AfterBadloan>{
	public List<AfterBadloan> findAll() throws DataAccessException;
	public List<AfterFvclass> query(@Param("pageView")PageView pageView, @Param("t")AfterFvclass afterfvclass) throws DataAccessException;
	public List<AfterBadloan> queryBadloan(@Param("pageView")PageView pageView, @Param("t")AfterBadloan afterbadloan) throws DataAccessException;
}
