/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.aftrmng.entity.AfterWarnparm;
import com.mf.base.BaseDao;

/**
 * @author yangchao
 * @2015-01-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface AfterWarnparmDao extends BaseDao<AfterWarnparm>{
	public List<AfterWarnparm> findAll() throws DataAccessException;

	public AfterWarnparm findByWarnnm(AfterWarnparm afterWarnparm);
}
