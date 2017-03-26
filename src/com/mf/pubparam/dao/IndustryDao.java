/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.pubparam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.pubparam.entity.Industry;

/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface IndustryDao extends BaseDao<Industry>{

	public List<Industry> getByTCode(String tcode) throws DataAccessException;

	public List<Industry> queryIndusty(Industry industry) throws DataAccessException;

	public Industry findByCode(String industryCode);

}
