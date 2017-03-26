package com.mf.comStructure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.comStructure.entity.*;
import com.mf.comStructure.service.ComStructureService;
import com.mf.comStructure.dao.*;
import com.mf.util.*;
/**
 * @author zhangcong
 * @2015-04-14
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("comStructureService")
public class ComStructureServiceImpl implements ComStructureService {
	@Autowired
	private ComStructureDao comStructureDao;
	
	public PageView query(PageView pageView, ComStructure comStructure) {
		List<ComStructure> list = comStructureDao.query(pageView, comStructure);
		pageView.setRecords(list);
		return pageView;
	}
	
	public void add(ComStructure comStructure) {
		comStructureDao.add(comStructure);
	}
	
	public void delete(String id) {
		comStructureDao.delete(id);
	}
	
	public ComStructure getById(String id) {
		return comStructureDao.getById(id);
	}
	
	public void modify(ComStructure comStructure) {
		comStructureDao.modify(comStructure);
	}

	public void submit(String id) {
		comStructureDao.submit(id);
	}
}
