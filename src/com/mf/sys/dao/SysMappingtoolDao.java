package com.mf.sys.dao;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.sys.entity.SysMappingtool;

public interface SysMappingtoolDao extends BaseDao<SysMappingtool>{
	
	public String getSerialnumber(SysMappingtool sysMappingtool) throws DataAccessException;
	public void modifySerialnumber(SysMappingtool sysMappingtool) throws DataAccessException;
	public void initSerialnumber(SysMappingtool sysMappingtool) throws DataAccessException;
	
}
