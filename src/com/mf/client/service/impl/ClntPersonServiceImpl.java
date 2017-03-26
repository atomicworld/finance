package com.mf.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.client.dao.ClntPersonDao;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntPersonService;
import com.mf.util.PageView;

@Service("clntPersonService")
public class ClntPersonServiceImpl implements ClntPersonService{
	
	@Autowired
	private ClntPersonDao clntPersonDao;
	
	@Override
	public PageView query(PageView pageView, ClntPerson clntPerson) {
		List<ClntPerson> list = clntPersonDao.query(pageView, clntPerson);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public ClntPerson findByCertno(String certno) {
		return clntPersonDao.findByCertno(certno);
	}

	@Override
	public void add(ClntPerson clntPerson) {
		clntPersonDao.add(clntPerson);
	}

	@Override
	public ClntPerson findByClntno(String clntno) {
		return clntPersonDao.findByClntno(clntno);
	}
	@Override
	public ClntPerson getByClntno(String clntno) {
		return clntPersonDao.getByClntno(clntno);
	}
	
	@Override
	public void update(ClntPerson clntPerson) {
		clntPersonDao.modify(clntPerson);
	}



}
