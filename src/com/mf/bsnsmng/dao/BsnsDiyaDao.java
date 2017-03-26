package com.mf.bsnsmng.dao;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.BsnsDiya;

public interface BsnsDiyaDao  extends BaseDao<BsnsDiya>{
	public BsnsDiya  getByCntrctno(String cntrctno) throws DataAccessException;
	public void modifyCntrct(BsnsDiya bsnsdiya) throws DataAccessException;
	public void deleteCntrctno(String cntrctno) throws DataAccessException;

}
