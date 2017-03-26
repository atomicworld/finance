/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncChckprfdtl;

/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncChckprfdtlDao extends BaseDao<FnncChckprfdtl>{
	public List<FnncChckprfdtl> findAll() throws DataAccessException;


}
