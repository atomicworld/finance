package com.mf.comStructure.service;

import com.mf.comStructure.entity.*;
import com.mf.util.*;
/**
 * @author zhangcong
 * @2015-04-14
 * @version 1.0
 * @param <T>
 */

public interface ComStructureService{

	public PageView query(PageView pageView,ComStructure comStructure);
	public void add(ComStructure comStructure);
	public void delete(String id);
	public void modify(ComStructure comStructure);
	public ComStructure getById(String id);
	public void submit(String id);
	
}
