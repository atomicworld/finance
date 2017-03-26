package com.mf.org.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.org.entity.Dept;
import com.mf.util.PageView;

public interface DeptService {
	
	public PageView query(PageView pageView, Dept dept) ;
	
	public List<Dept> queryAll() ;
	
	public void add(Dept dept);

	public void delete(String deptNo);
	
	public Dept getDeptById(String id);
	
	public void modify(Dept dept);
	
	public void setDeptLeader(Dept dept) throws DataAccessException;
	
	//财务设置
	public void setNonFinance() throws DataAccessException;
	public void setFinance(Dept dept) throws DataAccessException;
	
	public int countSubDpt(String dptNo) throws DataAccessException;
	public int countEmp(String dptNo) throws DataAccessException;

	
}
