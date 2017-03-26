/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncAccntctlcd;


/**
 * @author shenguangdong
 * @2015-02-10
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncAccntctlcdDao extends BaseDao<FnncAccntctlcd>{
	public List<FnncAccntctlcd> findAll() throws DataAccessException;


}
