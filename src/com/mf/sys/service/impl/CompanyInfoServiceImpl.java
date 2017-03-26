package com.mf.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.sys.dao.CompanyInfoDao;
import com.mf.sys.entity.CompanyInfo;
import com.mf.util.PageView;

@Service("companyInfoService")
public class CompanyInfoServiceImpl {

	@Autowired
	CompanyInfoDao  companyInfoDao;
	
	

	public PageView query(PageView pageView, CompanyInfo companyInfo) {
		 pageView.setRecords(companyInfoDao.query(pageView, companyInfo));
		 return pageView;
	}
	
	/**
	 * 获取公司信息
	 * @param companyInfo
	 * @return
	 */
	public CompanyInfo getCompanyInfo(CompanyInfo companyInfo){
		List list=companyInfoDao.queryAll(companyInfo);
		
		if(list!=null&&list.size()>0){
			companyInfo=(CompanyInfo)list.get(0);
			return companyInfo;
		}
		
		return null;
	}

	public void add(CompanyInfo companyInfo) {
		companyInfoDao.add(companyInfo);
	}
	
	public void update(CompanyInfo companyInfo) {
		companyInfoDao.modify(companyInfo);
	}


}
