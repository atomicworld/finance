package com.mf.comStructure.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.comStructure.dao.FinanceinfoDao;
import com.mf.comStructure.entity.Financeinfo;
import com.mf.comStructure.service.FinanceinfoService;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-04-16
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("financeinfoService")
public class FinanceinfoServiceImpl implements FinanceinfoService {
	@Autowired
	private FinanceinfoDao financeinfoDao;
	
	public PageView query(PageView pageView, Financeinfo financeinfo) {
		List<Financeinfo> list = financeinfoDao.query(pageView, financeinfo);
		pageView.setRecords(list);
		return pageView;
	}
	
	public void add(Financeinfo financeinfo) {
		financeinfoDao.add(financeinfo);
	}
	
	public void delete(String id) {
		financeinfoDao.delete(id);
	}
	
	public Financeinfo getById(String id) {
		return financeinfoDao.getById(id);
	}
	
	public void modify(Financeinfo financeinfo) {
		financeinfoDao.modify(financeinfo);
	}

	public void submit(String id) {
		financeinfoDao.submit(id);
	}
}
