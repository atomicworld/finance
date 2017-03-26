/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessData.service;

import java.util.List;

import com.mf.businessData.entity.Clntturnover;
import com.mf.util.PageView;
/**
 * @author yangchao
 * @2015-04-02
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntturnoverService{

	public PageView query(PageView pageView,Clntturnover clntturnover);
	
	public List<Clntturnover> queryAll(Clntturnover clntturnover);
	
	public void add(Clntturnover clntturnover);
	
	public void addAll(Clntturnover clntturnover);
	
	public void delete(String id);
	
	public void modify(Clntturnover clntturnover);
	
	public Clntturnover getById(String id);
	
	public List<Clntturnover> findAll();
	
	
}
