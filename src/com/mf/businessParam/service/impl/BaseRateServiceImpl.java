package com.mf.businessParam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mf.businessParam.dao.BaseRateDao;
import com.mf.businessParam.entity.BaseRate;
import com.mf.util.PageView;

@Service("baseRateService")
public class BaseRateServiceImpl {

	@Autowired
	BaseRateDao baseRateDao;
	
	public void add(BaseRate t) throws DataAccessException {
		baseRateDao.add(t);

	}


	public void delete(String id) throws DataAccessException {
		// TODO Auto-generated method stub

	}
	
	public List<BaseRate>  getType(String month) throws DataAccessException {
		// TODO Auto-generated method stub
		return baseRateDao.getType(month);
	}
	public void modify(BaseRate t) throws DataAccessException {
		// TODO Auto-generated method stub
		baseRateDao.modify(t);
	}

	public BaseRate getById(String id) throws DataAccessException {
		return baseRateDao.getById(id);
	}

	public PageView query(PageView pageView, BaseRate t)throws DataAccessException {
		pageView.setRecords(baseRateDao.query(pageView,t));
		return pageView;
	}

	public List<BaseRate> queryAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
     /**
    * 根据rtno查询基准利率
    */
	public BaseRate getRateByRtno(String rtno){
		return baseRateDao.getRateByRtno(rtno);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
