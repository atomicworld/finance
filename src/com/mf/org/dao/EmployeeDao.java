package com.mf.org.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.org.entity.Employee;
import com.mf.util.PageView;

public interface EmployeeDao extends BaseDao<Employee> {
	
	public List<Employee> getEmployeesByDeptId(String deptId);
	
	public List<Employee> getEmployees();
	
	public void chgEmployeeStatus(Employee employee);
	
	public List<Employee> getOpEmployeesByDeptId(String deptId);
	
	public List<Employee> getCstmgrEmpByDeptId(String deptId);
	
	public int countOp(String emplyno);
	
	public int countEmployee(String idnum);
	
	public List<Employee> findAll(@Param("pageView")PageView pageView, @Param("t")Employee employee) throws DataAccessException;
	
	public List<Employee> showsubposistlist(@Param("pageView")PageView pageView, @Param("t")Employee employee) throws DataAccessException;

}
