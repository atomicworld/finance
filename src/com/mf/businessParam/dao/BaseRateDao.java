package com.mf.businessParam.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.businessParam.entity.BaseRate;

public interface BaseRateDao extends BaseDao<BaseRate> {
	public List<BaseRate>  getType(String month) throws DataAccessException;
    public BaseRate getRateByRtno(String rtno)   throws DataAccessException;
}
