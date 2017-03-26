package com.mf.flowmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.mf.comStructure.entity.Fundtable;
import com.mf.flowmng.dao.FlowApplystepDao;
import com.mf.flowmng.entity.FlowApplystep;
import com.mf.flowmng.service.FlowApplystepService;
import com.mf.util.PageView;

@Service("flowApplystepService")
public class FlowApplystepServiceImpl implements FlowApplystepService{
      @Autowired
      private FlowApplystepDao flowApplystepDao; 
	 
	  public PageView query(PageView pageView, FlowApplystep flowApplystep){
		     List<FlowApplystep> list = flowApplystepDao.query(pageView, flowApplystep);
	   		 pageView.setRecords(list);
	   		 return pageView;
		
	  }

	@Override
	public List<FlowApplystep> findAll() {
		// TODO Auto-generated method stub
		return flowApplystepDao.findAll();
	}
	
	public List<FlowApplystep> findByapprlno(String apprlno){
		return flowApplystepDao.findByapprlno(apprlno);
	}
	
	public void add(FlowApplystep flowApplystep){
		flowApplystepDao.add(flowApplystep);
	}
	
	public FlowApplystep getMax(){
		return flowApplystepDao.getMax();
	}
	
	public FlowApplystep getByapprlno(String apprlno){
		return flowApplystepDao.getByapprlno(apprlno);
	}
	
	public void modify(FlowApplystep flowApplystep){
		  flowApplystepDao.modify(flowApplystep);
	}
	  
	public void delete(String id) {
		flowApplystepDao.delete(id);
	}
	
	public FlowApplystep getById(String id) {
		return flowApplystepDao.getById(id);
	}
}
