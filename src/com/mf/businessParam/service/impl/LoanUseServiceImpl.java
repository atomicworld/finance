package com.mf.businessParam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mf.businessParam.dao.LoanUseDao;
import com.mf.businessParam.entity.LoanUse;
import com.mf.util.PageView;

@Service("loanUseService")
public class LoanUseServiceImpl {

	@Autowired
	LoanUseDao loanUseDao;
	
	public void add(LoanUse t) throws DataAccessException {
		loanUseDao.add(t);
		LoanUse uploan=new LoanUse();
		uploan.setUseno(t.getFrstfthr());
		uploan.setIsbttm("0");//更新节点状态
		loanUseDao.modify(uploan);
	}
	
	public void delete(String id) throws DataAccessException {
		LoanUse loanuse=loanUseDao.getById(id);
		LoanUse up=loanUseDao.getById(loanuse.getFrstfthr());
		int ishave=loanUseDao.queryMaxLen(up);
		if(ishave==2){
			up.setIsbttm("1");//设置为底层节点
			loanUseDao.modify(up);//更新父节点
		}
		loanUseDao.delete(id);
		
	}

	public void modify(LoanUse t) throws DataAccessException {
		loanUseDao.modify(t);
	}

	//changeStatus
	public void changeStatus(LoanUse t) throws DataAccessException {
		loanUseDao.changeStatus(t);
	}
	
	
	public LoanUse getById(String id) throws DataAccessException {
		return loanUseDao.getById(id);
	}

	public PageView query(PageView pageView, LoanUse t)
			throws DataAccessException {
		pageView.setRecords(loanUseDao.query(pageView,t));
		return pageView;
	}
	
	public List<LoanUse> queryLvl(LoanUse loanuse){
		return loanUseDao.queryLvl(loanuse);
	}
	public int queryMaxLen(LoanUse loanuse){
		return loanUseDao.queryMaxLen(loanuse);
	}

	

}
