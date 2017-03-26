package com.mf.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.flowmng.dao.FlowApprlerDao;
import com.mf.login.service.EventService;

@Service("eventService")
public class EventServiceImpl implements EventService {

	@Autowired
	private FlowApprlerDao flowApprlerDao;
	
	@Override
	//查看是否 审批权限
	public int getFlowApprler(String opno){
		int tmp = flowApprlerDao.getByOpno(opno);
		return tmp;
	}
	
}
