/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.service;

import java.util.List;

import com.mf.flowmng.entity.FlowIncreaseCapital;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */

public interface FlowIncreaseCapitalService{

	public PageView query(PageView pageView,FlowIncreaseCapital flowIncreaseCapital);
	
	public List<FlowIncreaseCapital> queryAll(FlowIncreaseCapital flowIncreaseCapital);
	
	public void add(FlowIncreaseCapital flowIncreaseCapital);
	
	public void addAll(FlowIncreaseCapital flowIncreaseCapital);
	
	public void delete(int id);
	
	public void modify(FlowIncreaseCapital flowIncreaseCapital);
	
	public FlowIncreaseCapital getById(String id);
	public FlowIncreaseCapital getById(int id);
	
	public List<FlowIncreaseCapital> findAll();
	
	
}
