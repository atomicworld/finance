/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.pubparam.service;

import java.util.List;

import com.mf.pubparam.entity.Industry;
/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface IndustryService{

	public List<Industry> getByTCode(String tcode);

	public List<Industry> queryIndustry(Industry industry);
	
	public Industry findByCode(String industryCode);
	
}
