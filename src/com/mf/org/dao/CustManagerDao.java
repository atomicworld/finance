package com.mf.org.dao;

import java.util.Map;

import com.mf.base.BaseDao;
import com.mf.org.entity.CustManager;


public interface CustManagerDao extends BaseDao<CustManager> {
	
	public void changeStatus(CustManager custManager);
	

}
