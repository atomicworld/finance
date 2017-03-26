package com.mf.org.service;

import java.util.List;
import com.mf.org.entity.*;
import com.mf.util.*;
/**
 * @author hw
 * @2015-08-21
 */

public interface EmployeetrainService{

	public PageView query(PageView pageView,Employeetrain employeetrain);
	
	public List<Employeetrain> queryAll(Employeetrain employeetrain);
	
	public void add(Employeetrain employeetrain);
	
	public void addAll(Employeetrain employeetrain);
	
	public void delete(String id);
	
	public void modify(Employeetrain employeetrain);
	
	public Employeetrain getById(String id);
	
	public List<Employeetrain> findAll();
	
	public void deleteByTrainno(String id);
	
}
