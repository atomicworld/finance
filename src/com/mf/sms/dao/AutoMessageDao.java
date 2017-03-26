package com.mf.sms.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.aftrmng.entity.BsnsRepayplanAll;
import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsBill;

public interface AutoMessageDao extends BaseDao {
	
	public List<BsnsBill> queryLoanTime(String flag) throws DataAccessException;
	
	public List<BsnsRepayplanAll> queryRtrnTime(String flag) throws DataAccessException;
	
}
