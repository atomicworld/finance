package com.mf.sms.service;

import java.util.List;

import com.mf.aftrmng.entity.BsnsRepayplanAll;
import com.mf.cntrtmng.entity.BsnsBill;

public interface AutoMessageService {
	
	public List<BsnsBill> queryLoanTime(String flag);	//合同到期

	public List<BsnsRepayplanAll> queryRtrnTime(String flag);	//还款到期
	
}
