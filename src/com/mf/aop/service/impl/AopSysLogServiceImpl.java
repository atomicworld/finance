/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.aop.dao.AopSysLogDao;
import com.mf.aop.entity.AopSysLog;
import com.mf.aop.service.AopSysLogService;
import com.mf.financemng.entity.FinanceCashFlow;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-09-21
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("aopSysLogService")
public class AopSysLogServiceImpl implements AopSysLogService {
	@Autowired
	private AopSysLogDao aopSysLogDao;
	@Override
	public PageView query(PageView pageView, AopSysLog aopSysLog) {
		List<AopSysLog> list = aopSysLogDao.query(pageView, aopSysLog);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public List<AopSysLog> queryAll(AopSysLog aopSysLog) {
		return aopSysLogDao.queryAll(aopSysLog);
	}

	@Override
	public void add(AopSysLog aopSysLog) {
		aopSysLogDao.add(aopSysLog);
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(AopSysLog aopSysLog) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AopSysLog getById(String code) {
		// TODO Auto-generated method stub
		return aopSysLogDao.getById(code);
	}

	@Override
	public List<AopSysLog> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageView queryDate(PageView pageView, AopSysLog aopSysLog,
			String sdate, String edate) {
		if((!Common.isEmpty(sdate)) && (!Common.isEmpty(edate))){
			//起始和结束日期都有
			pageView.setRecords(aopSysLogDao.queryDate(pageView, aopSysLog, sdate, edate));
		}else{
			if(!(Common.isEmpty(sdate))){
				//有起始日期
				pageView.setRecords(aopSysLogDao.querySdate(pageView, aopSysLog, sdate));
			}
			if(!(Common.isEmpty(edate))){
				//有结束日期
				pageView.setRecords(aopSysLogDao.queryEdate(pageView, aopSysLog, edate));
			}
		}
		
		return pageView;
	}
	
	
}
