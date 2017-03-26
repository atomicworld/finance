package com.mf.bsnsmng.dao;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.BsnsZhiya;

public interface BsnsZyDao  extends BaseDao<BsnsZhiya>{
	
	public BsnsZhiya  getByCntrctno(String cntrctno) throws DataAccessException;
	public void modifyCntrct(BsnsZhiya bsnszhiya) throws DataAccessException;
	public void deleteCntrctno(String cntrctno) throws DataAccessException;
}
