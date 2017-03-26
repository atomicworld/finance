package com.mf.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.sys.dao.SysDicTypeDao;
import com.mf.sys.entity.SysDicType;
import com.mf.sys.service.SysDicTypeService;
import com.mf.util.PageView;

@Service("sysDicTypeService")
public class SysDicTypeServiceImpl implements SysDicTypeService{
	
	@Autowired
	private SysDicTypeDao sysDicTypeDao;

	@Override
	public PageView query(PageView pageView, SysDicType sysDicType) {
		List list = sysDicTypeDao.query(pageView, sysDicType);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public void add(SysDicType sysDicType) {
		sysDicTypeDao.add(sysDicType);
	}

	@Override
	public SysDicType findByCode(String code) {
		SysDicType sysDicType = sysDicTypeDao.findByCode(code);
		return sysDicType;
	}

	@Override
	public void modify(SysDicType sysDicType) {
		sysDicTypeDao.modify(sysDicType);
	}
	//chenze--start
	@Override
	public List<SysDicType> findAll(){
		List list=sysDicTypeDao.findAll();
		return list;
	}
	//chenze--end
}
