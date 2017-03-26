package com.mf.org.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.org.entity.Dept;


public interface DeptDao extends BaseDao<Dept> {
	
	public void setDeptLeader(Dept dept) throws DataAccessException;
	
	public List<Dept> queryAll() throws DataAccessException;
	
	public void setNonFinance() throws DataAccessException;
	public void setFinance(Dept dept) throws DataAccessException;
	//查询下属部门数目
	public int countSubDpt(String dptNo) throws DataAccessException;
	//查询员工数目
	public int countEmp(String dptNo) throws DataAccessException;

	//查询部门下员工数目
	public int countDptEmp(String dptNo) throws DataAccessException;

}
