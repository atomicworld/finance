package com.mf.businessData.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.businessData.dao.RateHistoryDao;
import com.mf.businessData.entity.RateHistory;
import com.mf.util.PageView;

@Service("rateHistoryService")
public class RateHistoryServiceImpl {
	
	@Autowired
	RateHistoryDao rateHistoryDao;
	
	
	public PageView query(PageView pageView,RateHistory rateHistory){
		
		List list=rateHistoryDao.queryAll(rateHistory);
		pageView.setRecords(list);
		return pageView;
		
	}
	
	
	/**
	 * 新增修改历史
	 * @param rateHistory
	 */
	public void add(RateHistory rateHistory){
		
		rateHistoryDao.add(rateHistory);
	}
	
	
	
	
	
	
	
	
}
