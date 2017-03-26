package com.mf.businessData.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.businessData.dao.ClntMergeDao;
import com.mf.businessData.entity.ClntMerge;
import com.mf.util.PageView;

@Service("clntMergeService")
public class ClntMergeServiceImpl {

	@Autowired
	ClntMergeDao clntMergeDao;
	
	public PageView queryMergeList(PageView pageView,ClntMerge clntMerge){
		
		List<ClntMerge>  list=clntMergeDao.query(pageView,clntMerge);
		
		pageView.setRecords(list);
		
		return pageView;
		
	}
	
	
	
	public void mergeCust(ClntMerge clntMerge){
		clntMergeDao.add(clntMerge);
	}
	

}
