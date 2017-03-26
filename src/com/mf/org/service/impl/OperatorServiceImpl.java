package com.mf.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mf.org.dao.OperatorDao;
import com.mf.org.entity.Operator;
import com.mf.util.PageView;

@Service("operatorService")
public class OperatorServiceImpl {

	public void add(Operator t) throws DataAccessException {
		operatorDao.add(t);
	}

	@Autowired
	OperatorDao operatorDao;

	public void delete(String id) throws DataAccessException {
		operatorDao.delete(id);
	}

	public void modify(Operator t) throws DataAccessException {
		operatorDao.modify(t);
	}

	public Operator getById(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return operatorDao.getById(id);
	}
	
	public Operator getOpnm(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return operatorDao.getOpnm(id);
	}

	public List<Operator> query(PageView pageView, Operator t)
			throws DataAccessException {
		return operatorDao.query(pageView, t);
	}

	public List<Operator> queryAll(Operator t) throws DataAccessException {
		return operatorDao.queryAll(t);
	}
	
	public List<Operator> getByCzy(String id) throws DataAccessException {
		// TODO Auto-generated method stub
		return operatorDao.getByCzy(id);
	}
	
	//判断是否满足删除条件
	public int isCanBeDel(String id){
		//判断该操作员是否在客户经理列表中存在
		if(operatorDao.countMngr(id) > 0){
			return 2;
		}
		//判断该操作员是否配置有审批岗位
		if(operatorDao.countAppr(id) > 0){
			return 3;
		}
		//判断该操作员名下是否有管理的客户
		if(operatorDao.countClnt(id) > 0){
			return 4;
		}
		return 1;
	}
	
	public void changeUsed(Operator t) throws DataAccessException {
		operatorDao.changeUsed(t);
	}
	
	//查询vpnacct是否已存在
	public int countByAcct(String vpnacct) throws DataAccessException {
		return operatorDao.countByAcct(vpnacct);
	}
	
	public void changePwd(Operator t) throws DataAccessException {
		operatorDao.changePwd(t);
	}

	public List<Operator> getOperators(Operator t) throws DataAccessException {
		return operatorDao.getOperators(t);
	}
}
