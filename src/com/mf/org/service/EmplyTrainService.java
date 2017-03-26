package com.mf.org.service;

import java.util.List;

import com.mf.org.entity.*;
import com.mf.util.*;
/**
 * @author hw
 * @2015-08-24
 */

public interface EmplyTrainService{

	public PageView query(PageView pageView,EmplyTrain emplyTrain);
	
	public List<EmplyTrain> queryAll(EmplyTrain emplyTrain);
	
	public void add(EmplyTrain emplyTrain);
	
	public void addAll(EmplyTrain emplyTrain);
	
	public void delete(String id);
	
	public void modify(EmplyTrain emplyTrain);
	
	public EmplyTrain getById(String id);
	
	public List<EmplyTrain> findAll();
	
	public List<EmplyTrain> getByTraino(String trainno);
	
	public void deleteByTrainno(String trainno);
	
}
