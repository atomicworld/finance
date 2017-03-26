/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.pubparam.dao;

import java.util.List;

import com.mf.base.BaseDao;
import com.mf.pubparam.entity.Cities;

/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface CitiesDao extends BaseDao<Cities>{

	public List<Cities> getByparentId(String parentId);


}
