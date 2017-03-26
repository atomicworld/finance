/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao; 
import com.mf.sys.entity.SysMenu;

/**
 * @author yangchao
 * @2014-12-24
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface SysMenuDao extends BaseDao<SysMenu>{
	public List<SysMenu> findAll() throws DataAccessException;
	public List<SysMenu> findByMnLen(int len) throws DataAccessException;
	public List<SysMenu> findSuperByMnLen(int len) throws DataAccessException;
	public List<SysMenu> findDevByMnLen(int len) throws DataAccessException;

}
