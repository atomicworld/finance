package com.mf.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mf.org.dao.DeptDao;
import com.mf.org.entity.Dept;
import com.mf.org.service.DeptService;
import com.mf.util.PageView;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptDao deptDao;

	@Override
	public PageView query(PageView pageView, Dept dept) {
		pageView.setRecords(deptDao.query(pageView,dept));
		return pageView;
	}
	
	public List<Dept> queryAll() {
		return deptDao.queryAll();
	};
	
	//新增部门
	public void add(Dept dept){
		deptDao.add(dept);
	}
	
	
	public void delete(String deptNo){
		deptDao.delete(deptNo);
	}
	
	
	public Dept getDeptById(String id){
		Dept dept=deptDao.getById(id);
		return  dept;
	}
	
	public void modify(Dept dept){
		deptDao.modify(dept);
	}
	
	
	public void setDeptLeader(Dept dept) throws DataAccessException{
		deptDao.setDeptLeader(dept);
	}
	
	
	//财务设置
	public void setNonFinance() throws DataAccessException{
		deptDao.setNonFinance();
	}
	
	public void setFinance(Dept dept) throws DataAccessException{
		deptDao.setFinance(dept); 
	}
	
	public int countSubDpt(String dptNo) throws DataAccessException{
		return deptDao.countSubDpt(dptNo);
	}
	
	public int countEmp(String dptNo) throws DataAccessException{
		return deptDao.countEmp(dptNo);
	}
	
	
	
}
