/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.service;

import java.util.List;

import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.flowmng.entity.FlowApprlcmmnts;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-01-18
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FlowApprlcmmntsService{

	public PageView query(PageView pageView,FlowApprlcmmnts flowApprlcmmnts);
	
	public List<FlowApprlcmmnts> queryAll(FlowApprlcmmnts flowApprlcmmnts);
	
	public void add(FlowApprlcmmnts flowApprlcmmnts);
	
	
	
	public void delete(String id);
	
	public void modify(FlowApprlcmmnts flowApprlcmmnts);
	
	public FlowApprlcmmnts getById(String id);
	public PageView query1(PageView pageView,String apprvstt);

	
	
}
