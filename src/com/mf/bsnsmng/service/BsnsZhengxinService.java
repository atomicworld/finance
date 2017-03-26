/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.service;

import java.util.List;

import com.mf.bsnsmng.entity.BsnsZhengxin;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-07-13
 * @version 1.0
 * @param <T>
 */

public interface BsnsZhengxinService{

	public void add(BsnsZhengxin bsnsZhengxin);
	
	public void delete(String id);
	
	public void modify(BsnsZhengxin bsnsZhengxin);
	
	public BsnsZhengxin getById(String id);
	
}
