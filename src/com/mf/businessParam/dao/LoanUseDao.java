package com.mf.businessParam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.businessParam.entity.LoanUse;

public interface LoanUseDao extends BaseDao<LoanUse> {
	
	public void changeStatus(LoanUse t) throws DataAccessException;
	public List<LoanUse> queryLvl(LoanUse loanuse);
	public int queryMaxLen(LoanUse loanuse);
}
