/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.sys.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.sys.entity.SysRole;


public interface SysRoleDao extends BaseDao<SysRole>{
	public List<SysRole> findAll() throws DataAccessException;
	public String calcNewRoleId(String rllvl) throws DataAccessException;
	public void addAll(SysRole sysRole) throws DataAccessException;
	public List<SysRole> getByLvl(String lvl) throws DataAccessException;
	public int countOp(String rlid) throws DataAccessException;
}
