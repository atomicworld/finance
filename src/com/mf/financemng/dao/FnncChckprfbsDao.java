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
import com.mf.financemng.entity.FnncChckprfbs;
import com.mf.financemng.entity.FnncPrfbs;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.util.PageView;

/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncChckprfbsDao extends BaseDao<FnncChckprfbs>{
	public List<FnncChckprfbs> findAll() throws DataAccessException;
	public List<FnncPrfbsList> queryList(@Param("pageView")PageView pageView, @Param("t")FnncPrfbsList fnncprfbslist) throws DataAccessException;


}
