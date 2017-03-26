package com.mf.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mf.org.dao.CustManagerDao;
import com.mf.org.entity.CustManager;
import com.mf.util.PageView;

@Service("custManagerService")
public class CustManagerServiceImpl {

	@Autowired
	CustManagerDao custManagerDao;
	
	public void add(CustManager t) throws DataAccessException {
		t.setSngltop("0.00");
		t.setTtltop("0.00");
		custManagerDao.add(t);
	}


	public void delete(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		custManagerDao.delete(id);
	}
	
	public void changeStatus(String id,String status) throws DataAccessException {
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("recordId", Integer.parseInt(id));
//		map.put("isused", status);
		CustManager custManager=new CustManager();
		custManager.setRcrdid(id);
		custManager.setIsused(status);
		custManagerDao.changeStatus(custManager);
	}
	
	

	public void modify(CustManager t) throws DataAccessException {
		// TODO Auto-generated method stub
		t.setTtltop("0.00");
		t.setSngltop("0.00");
		custManagerDao.modify(t);
	}

	public CustManager getById(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return custManagerDao.getById(id);
	}

	public PageView query(PageView pageView, CustManager t)
			throws DataAccessException {
		pageView.setRecords(custManagerDao.query(pageView,t));
		return pageView;
	}

	public List<CustManager> queryAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
