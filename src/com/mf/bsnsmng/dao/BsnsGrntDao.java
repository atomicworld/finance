/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.BsnsGrnt;


/**
 * @author yangchao
 * @2015-01-07
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface BsnsGrntDao extends BaseDao<BsnsGrnt>{
	public List<BsnsGrnt> findAll() throws DataAccessException;
	public List<BsnsGrnt> getByApplyno(String applyno) throws DataAccessException;
}
