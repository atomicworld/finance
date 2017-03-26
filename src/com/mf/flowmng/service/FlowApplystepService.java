package com.mf.flowmng.service;

import java.util.List;




import com.mf.comStructure.entity.Fundtable;
import com.mf.flowmng.entity.FlowApplystep;
import com.mf.util.PageView;

   public interface FlowApplystepService {

	   public PageView query(PageView pageView, FlowApplystep flowApplystep);
	   public List<FlowApplystep> findAll();
	   
	   public List<FlowApplystep> findByapprlno(String apprlno);
	   
	   public FlowApplystep getByapprlno(String apprlno);
	   
	   public void add(FlowApplystep flowApplystep);
	   
	   public FlowApplystep getMax();
	   
	   public void modify(FlowApplystep flowApplystep);
	   
	   public FlowApplystep getById(String id);
	   
	   public void delete(String id);
	   
   }
