package com.mf.businessParam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mf.businessParam.dao.BusinessKindDao;
import com.mf.businessParam.entity.BusinessKind;
import com.mf.util.PageView;

@Service("businessKindService")
public class BusinessKindServiceImpl {

	@Autowired
	BusinessKindDao businessKindDao;
	
	public void add(BusinessKind t) throws DataAccessException {
		
		businessKindDao.add(t);
	}


	public void delete(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		businessKindDao.delete(id);
	}

	public void modify(BusinessKind t) throws DataAccessException {
		// TODO Auto-generated method stub
		businessKindDao.modify(t);
	}

	public BusinessKind getById(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return businessKindDao.getById(id);
	}

	public PageView query(PageView pageView, BusinessKind t)
			throws DataAccessException {
		pageView.setRecords(businessKindDao.query(pageView,t));
		return pageView;
	}

	public List<BusinessKind> queryAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return businessKindDao.queryAll();
	}
	
	public void changeStatus(String id,String status){
		BusinessKind kind=new BusinessKind();
		kind.setKndno(id);
		kind.setIsused(status);
		businessKindDao.changeStatus(kind);
		
	}
	
	public List<BusinessKind> getType(String cstmrtyp) throws DataAccessException {
		// TODO Auto-generated method stub
		return businessKindDao.getType(cstmrtyp);
	}
	public List<BusinessKind> getTypeAll(String cstmrtyp) throws DataAccessException {
		// TODO Auto-generated method stub
		return businessKindDao.getTypeAll(cstmrtyp);
	}
	
	//add by hw
	public List<BusinessKind> getAbleType(String cstmrtyp) throws DataAccessException {
		// TODO Auto-generated method stub
		return businessKindDao.getAbleType(cstmrtyp);
	}
	
}
