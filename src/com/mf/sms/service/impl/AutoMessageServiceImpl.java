package com.mf.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.aftrmng.entity.BsnsRepayplanAll;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.sms.dao.AutoMessageDao;
import com.mf.sms.service.AutoMessageService;


@Transactional
@Service("autoMessageService")
public class AutoMessageServiceImpl implements AutoMessageService {
	
	@Autowired
	private AutoMessageDao autoMessageDao;
	
	public List<BsnsBill> queryLoanTime(String flag) {
		return autoMessageDao.queryLoanTime(flag);
	}
	
	public List<BsnsRepayplanAll> queryRtrnTime(String flag) {
		return autoMessageDao.queryRtrnTime(flag);
	}
	
}
