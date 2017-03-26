package com.mf.comStructure.service;

import java.util.List;

import com.mf.comStructure.entity.*;
import com.mf.util.*;


public interface FundtableService{

	public PageView query(PageView pageView,Fundtable fundtable);
	
	public List<Fundtable> queryAll(Fundtable fundtable);
	
	public void add(Fundtable fundtable);
	
	public void addAll(Fundtable fundtable);
	
	public void delete(String id);
	
	public void modify(Fundtable fundtable);
	
	public Fundtable getById(String id);
	
	public List<Fundtable> findAll();
	
	public void submit(String id);
	
	
}
