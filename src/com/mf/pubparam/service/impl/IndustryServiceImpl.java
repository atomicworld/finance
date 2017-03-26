/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.pubparam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.pubparam.dao.IndustryDao;
import com.mf.pubparam.entity.Industry;
import com.mf.pubparam.service.IndustryService;
/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("industryService")
public class IndustryServiceImpl implements IndustryService {
	@Autowired
	private IndustryDao industryDao;
	

	@Override
	public List<Industry> getByTCode(String tcode) {
		return industryDao.getByTCode(tcode);
	}


	@Override
	public List<Industry> queryIndustry(Industry industry) {
		return industryDao.queryIndusty(industry);
	}
	
	public Industry findByCode(String industryCode){
		return industryDao.findByCode(industryCode);
	}
}
