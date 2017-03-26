package com.mf.org.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.base.AutoCompleteEntity;
import com.mf.common.util.StringUtil;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.org.dao.EmployeeDao;
import com.mf.org.entity.Employee;
import com.mf.org.entity.Employeetrain;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.PageView;
@Service("employeeService")
public class EmployeeServiceImpl{

	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	private SysDictionaryService sysDictionaryService;

	public void add(Employee employee) throws DataAccessException {
		
		employeeDao.add(employee);
	}

	public void delete(String id) throws DataAccessException {
		employeeDao.delete(id);
		
	}

	public void modify(Employee employee) throws DataAccessException {
		employeeDao.modify(employee);
	}

	public Employee getById(String id) throws DataAccessException {
		return employeeDao.getById(id);
	}

	public PageView query(PageView pageView, Employee employee) throws DataAccessException {
		pageView.setRecords(employeeDao.query(pageView,employee));
		return pageView;
	}

	public List<Employee> queryAll() throws DataAccessException {
		return null;
	}
	
	//getEmployeesByDeptId
	public List<Employee> getEmployeesByDeptId(String deptId){
		return employeeDao.getEmployeesByDeptId(deptId);
	}
	
	//查询所在部门编号为deptId的且没有在操作员列表中出现的员工列表
	public List<Employee> getOpEmployeesByDeptId(String deptId){
		return employeeDao.getOpEmployeesByDeptId(deptId);
	}
	
	//查询所在部门编号为deptId的且没有在客户经理列表中出现的员工列表
	public List<Employee> getCstmgrEmpByDeptId(String deptId){
		return employeeDao.getCstmgrEmpByDeptId(deptId);
	}
	
	public List<Employee> getEmployees(){
		return employeeDao.getEmployees();
	}
	
	/**
	 * 修改员工状态
	 * 0 试用期
	 * 1 转正
	 * 2 离职
	 * @param employee
	 */
	public void chgEmployeeStatus(Employee employee){
		employeeDao.chgEmployeeStatus(employee);
	}
	
	public boolean isOp(String emplyno){
		if(employeeDao.countOp(emplyno) == 0){
			return false;
		}else{
			return true;
		}
	}

	//根据身份证返回员工信息
	public int countEmployee(String idnum) throws DataAccessException{
		return employeeDao.countEmployee(idnum);
	}

	public PageView findAll(PageView pageView, Employee employee) throws DataAccessException {
		pageView.setRecords(employeeDao.findAll(pageView,employee));
		return pageView;
	}
	
	public Map<String,List<AutoCompleteEntity>> getAllItemForAutoCmp(){
		Map<String,List<AutoCompleteEntity>> map = new HashMap<String, List<AutoCompleteEntity>>();
		List<SysDictionary> list = sysDictionaryService.findByCodeAndRemark("8012");
		List<AutoCompleteEntity> autoCmpList = new ArrayList<AutoCompleteEntity>();
		
		for(int i=0; i<list.size(); i++){
			AutoCompleteEntity autoCmpEntity = new AutoCompleteEntity();
			SysDictionary sysDictionary = list.get(i);
			String value = sysDictionary.getSdvalue();
			String key = sysDictionary.getSdkey();
			String pinyinHead = StringUtil.getFirstPinYin(key);
			autoCmpEntity.setValue(value);
			autoCmpEntity.setKey(value + " - " + key);
			autoCmpEntity.setSuggest(value + "|" + key + "|" + pinyinHead);
			autoCmpList.add(autoCmpEntity);
		}
		map.put("list", autoCmpList);
		return map;
	}
	
	public PageView showsubposistlist(PageView pageView, Employee employee) throws DataAccessException {
		pageView.setRecords(employeeDao.showsubposistlist(pageView,employee));
		return pageView;
	}
}
