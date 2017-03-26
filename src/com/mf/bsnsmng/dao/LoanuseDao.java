package com.mf.bsnsmng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.Loanuse;

public interface LoanuseDao extends BaseDao<Loanuse> {
	public List<Loanuse> findAll() throws DataAccessException;
	
	public Loanuse getByUsenm(String usenm) throws DataAccessException;
}
