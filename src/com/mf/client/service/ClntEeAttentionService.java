/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.service;

import java.util.List;

import com.mf.client.entity.ClntEeAttention;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface ClntEeAttentionService{

	public PageView query(PageView pageView,ClntEeAttention clntEeAttention);
	
	public List<ClntEeAttention> queryAll(ClntEeAttention clntEeAttention);
	
	public void add(ClntEeAttention clntEeAttention);
	
	public void addAll(ClntEeAttention clntEeAttention);
	
	public void delete(String id);
	
	public void modify(ClntEeAttention clntEeAttention);
	
	public ClntEeAttention getById(String id);
	
	public List<ClntEeAttention> findAll();
	
	
}
