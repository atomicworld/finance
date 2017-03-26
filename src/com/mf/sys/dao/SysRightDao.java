/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.sys.entity.SysRight;

/**
 * @author yangchao
 * @2014-12-24
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface SysRightDao extends BaseDao<SysRight>{
	public List<SysRight> findAll() throws DataAccessException;
	public List<SysRight> getMnnoByRght(String ids) throws DataAccessException;
	public List<SysRight> getRghtByFirstMn(String mnno) throws DataAccessException;
	public String getMaxRghtNo() throws DataAccessException;
}
