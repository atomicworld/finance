package com.mf.org.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.base.AutoCompleteEntity;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.org.entity.Employee;
import com.mf.org.service.impl.EmployeeServiceImpl;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value = "/mf/org/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	@Autowired
	private SysDictionaryService sysDictionaryService;


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/employeeAdd.html")
	@ResponseBody
	public Map<String, Object> addEmployee(Employee employee) {
		// 获取页面传过来的身份证是不是唯一值
		int count = employeeService.countEmployee(employee.getIdnum());
		Map resultMap = new HashMap();

		if (StringUtil.isEmpty(employee.getPolstate())) {
			// 如果为空 默认为试用状态
			employee.setPolstate("0");
		}
		if (StringUtil.isEmpty(employee.getState())) {
			// 如果为空 默认为试用状态
			employee.setState("0");
		}
		if (0 != count) {
			resultMap.put("resCode", "2");
			resultMap.put("resDesc", "证件号码已注册!");
			
			return resultMap;
		}
		employeeService.add(employee);

		resultMap.put("resCode", 1);
		resultMap.put("resDesc", "保存成功！");

		return resultMap;
	}

	@RequestMapping(value = "/toEmployeeList.html")
	public String toList(HttpServletRequest request) {
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/org/employee/employee_list1";
		return "/mf/org/employee/employee_list";
	}

	@RequestMapping(value = "/getEmployeePagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getEmployeePagerList(Model model,
			Employee employee, HttpServletRequest request) {
		// 获取员工状态
		String state = request.getParameter("state");
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		// TODO 进行员工列表的查询，分正式员工 转正员工与离职员工 进行标志位的判定。
		employee.setState(state);
		pageView = employeeService.query(pageView, employee);

		Map resultMap = new HashMap();
		resultMap.put("rows", pageView.getRecords());
		resultMap.put("pager.pageNo", pageView.getPageNow());
		resultMap.put("pager.totalRows", pageView.getRowCount());

		return resultMap;
	}

	/**
	 * 跳转到员工新增界面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toEmployeeAdd.html")
	public String toAddEmployee() {

		return "/mf/org/employee/employee_add";
	}

	@RequestMapping(value = "/toEditEmployee.html")
	public String toEditEmployee(HttpServletRequest request, Model model) {
		String empId = request.getParameter("id");
		Employee employee = employeeService.getById(empId);
		model.addAttribute("employee", employee);
		
		SysDictionary sysDictionary = new SysDictionary();
		if(StringUtil.isNotEmpty(employee.getSubposist())) {			
			sysDictionary.setCode("8012");
			sysDictionary.setSdvalue(employee.getSubposist());
			sysDictionary = sysDictionaryService.findByCodeAndValue(sysDictionary);
			sysDictionary.setSdkey(sysDictionary.getSdvalue() + " - " + sysDictionary.getSdkey());
		}
		model.addAttribute("sysDictionary", sysDictionary);
		return "/mf/org/employee/employee_edit";
	}

	@RequestMapping(value = "/editEmployee.html")
	@ResponseBody
	public Map<String, Object> editEmployee(Employee employee) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			employeeService.modify(employee);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delEmployee.html")
	@ResponseBody
	public Map<String, Object> delEmployee(HttpServletRequest request) {
		String id = request.getParameter("id");
		Map resultMap = new HashMap();
		try {
			employeeService.delete(id);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getEmployeesByDeptId.html")
	@ResponseBody
	public List getEmployeesByDeptId(HttpServletRequest request) {
		String deptId = request.getParameter("deptId");
		String opType = request.getParameter("opType");
		// 此处不为空，则是操作员新增下拉列表
		List<Employee> list = null;
		if (StringUtil.isNotEmpty(opType)) {
			if (opType.equals("operator")) {
				// 过滤已经存在于操作员表中的员工
				list = employeeService.getOpEmployeesByDeptId(deptId);
			} else if (opType.equals("cstmrmngr")) {
				list = employeeService.getCstmgrEmpByDeptId(deptId);
			}
		} else {
			list = employeeService.getEmployeesByDeptId(deptId);
		}
		// 获取部门下员工列表
		List resultList = new ArrayList();
		if (list != null && list.size() > 0) {
			for (Employee emp : list) {
				Map map = new HashMap();
				map.put("key", emp.getEmplynm());// 表明为显示的key
				map.put("value", emp.getEmplyno());// 表明实际value
				resultList.add(map);
			}
		}

		return resultList;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getEmployees.html")
	@ResponseBody
	public List getEmployees(HttpServletRequest request) {

		List<Employee> list = employeeService.getEmployees();
		// 获取部门下员工列表
		List resultList = new ArrayList();
		if (list != null && list.size() > 0) {
			for (Employee emp : list) {
				Map map = new HashMap();
				map.put("key", emp.getEmplynm());// 表明为显示的key
				map.put("value", emp.getEmplyno());// 表明实际value
				resultList.add(map);
			}
		}

		return resultList;
	}

	@RequestMapping(value = "/getEmployeeById.html")
	@ResponseBody
	public Employee getEmployeeById(HttpServletRequest request, Model model) {
		String empId = request.getParameter("id");
		Employee employee = employeeService.getById(empId);

		return employee;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/chgEmployeeStatus.html")
	@ResponseBody
	public Map<String, Object> chgEmployeeStatus(HttpServletRequest request,
			Employee employee) {
		Map resultMap = new HashMap();

		try {
			// 判断若是改变状态为离职
			if (employee.getState().equals("2")) {
				// 判断该员工是否为系统操作员
				if (employeeService.isOp(employee.getEmplyno())) {
					resultMap.put("resCode", "2");
					resultMap.put("resDesc", "该员工为系统操作员,请先将其从系统操作员中移除");
					return resultMap;
				}
			}
			employeeService.chgEmployeeStatus(employee);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}

	//add by zhangcong
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(Model model,HttpServletRequest request){
		return "/mf/org/employee/list";
	}
	
	@RequestMapping(value = "showlist")
	@ResponseBody
	public Map<String, Object> showlist(Model model, Employee employee, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		pageView = employeeService.query(pageView, employee);
		List<Employee> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	//
	
	@RequestMapping(value="getAllItem")
	@ResponseBody
	public Map<String, List<AutoCompleteEntity>> getAllItem(){
		Map<String,List<AutoCompleteEntity>> map;
		//查询所有科目信息
		map = employeeService.getAllItemForAutoCmp();
		return map;
	}
	
	@RequestMapping(value="isChild")
	public String isChild(Model model,SysDictionary sysDictionary,HttpServletResponse response){
	String result="";
	try {
			sysDictionary.setCode("8012");
			SysDictionary fa = sysDictionaryService.findByCodeAndValue(sysDictionary);
			   if("0".equals(fa.getRemark())){
				   result="{\"msg\":\"false\"}";
			   }else{
				   result="{\"msg\":\"true\"}";
			   }
		} catch (Exception e) {
			 result="{\"msg\":\"false\"}";
		}
		   
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value = "showsubposistlist")
	@ResponseBody
	public Map<String, Object> showsubposistlist(Model model, Employee employee, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		pageView = employeeService.showsubposistlist(pageView, employee);
		List<Employee> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
}
