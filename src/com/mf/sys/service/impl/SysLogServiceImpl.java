package com.mf.sys.service.impl;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.icu.text.SimpleDateFormat;
import com.mf.org.entity.Operator;
import com.mf.sys.dao.SysLogDao;
import com.mf.sys.entity.SysLog;
import com.mf.sys.service.SysLogService;
import com.mf.util.Common;
import com.mf.util.PageView;

@Service("sysLogService")
public class SysLogServiceImpl implements SysLogService {

	@Autowired
	SysLogDao sysLogDao;
	
	
	
	@Override
	public PageView query(PageView pageView, SysLog sysLog) {
		 pageView.setRecords(sysLogDao.query(pageView, sysLog));
		 return pageView;
	}
	
	@Override
	public PageView queryDate(PageView pageView, SysLog sysLog, String sdate, String edate){
		if((!Common.isEmpty(sdate)) && (!Common.isEmpty(edate))){
			//起始和结束日期都有
			pageView.setRecords(sysLogDao.queryDate(pageView, sysLog, sdate, edate));
		}else{
			if(!(Common.isEmpty(sdate))){
				//有起始日期
				pageView.setRecords(sysLogDao.querySdate(pageView, sysLog, sdate));
			}
			if(!(Common.isEmpty(edate))){
				//有结束日期
				pageView.setRecords(sysLogDao.queryEdate(pageView, sysLog, edate));
			}
		}
		
		return pageView;
	}

	@Override
	public void add(SysLog sysLog) {
		sysLogDao.add(sysLog);
	}

	@Override
	public void delete(String id) {
		
	}
	//操作类型 optype:增删改查,
	//obj操作对象：controller, 
	//optable:操作表或对象，
	//opcontent：操作内容,
	//userName：操作员 
	public void logger(String optype,String obj,String optable,String opcontent,HttpServletRequest request){
		Operator user = (Operator)request.getSession().getAttribute("operator");
		String dptnm = (String)request.getSession().getAttribute("dptname");
		
		//chenkk added for wyw - start
		//此处应该增加处理还没有登录成功,未保存session的情况处理
		String opnm = "未登录用户";
		if(user != null){
			opnm = user.getOpnm();
		}
		if(dptnm == null){
			dptnm = "无";
		}
		//chenkk added for wyw - end
		
		SysLog log=new SysLog();
		log.setOptype(optype);
		log.setOpobject(obj);
		log.setOptable(optable);		
		//chenkk modify for wyw - start
		log.setOporg(dptnm);
		log.setOpperson(opnm);
		//chenkk modify for wyw - end
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String nowTime=sdf.format(new Date());
		log.setOptime(nowTime);
		sysLogDao.add(log);
	}


}
