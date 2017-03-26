package com.mf.org.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.json.Entity;
import com.mf.org.entity.Dept;
import com.mf.org.service.DeptService;
import com.mf.util.Common;
import com.mf.util.PageView;

@Controller
@RequestMapping(value = "/mf/org/deptManager")
public class DeptManagerController {

	private static final Logger logger = Logger
			.getLogger(DeptManagerController.class);

	@Autowired
	DeptService deptService;

	/**
	 * 部门查询列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toDeptList.html")
	public String list(HttpServletRequest request) {
		// 通过DAO查询部门列表信息
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/org/deptManager/dept_list1";
		return "/mf/org/deptManager/dept_list";
	}

	@RequestMapping(value = "/getDeptPagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getDeptPagerList(Model model, Dept dept,
			HttpServletRequest request) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}

		pageView = deptService.query(pageView, dept);
		List list = pageView.getRecords();

		Map resultMap = new HashMap();
		resultMap.put("rows", list);
		resultMap.put("pager.pageNo", pageView.getPageNow());
		resultMap.put("pager.totalRows", pageView.getRowCount());
		
		return resultMap;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getAllDeptList.html")
	@ResponseBody
	public List getAllDeptList() {
		List<Dept> deptList  = deptService.queryAll();
		List resultList=new ArrayList();
		if(deptList!=null&&deptList.size()>0){
			for(Dept dept:deptList){
				Map map=new HashMap();
				map.put("key", dept.getDptname());//表明为显示的key
				map.put("value", dept.getDptno());//表明实际value
				resultList.add(map);
			}
		}
		
		return resultList;
	}
	
	

	@RequestMapping(value = "/deptAdd.html")
	public String toAddDept() {
		return "/mf/org/deptManager/dept_add";
	}

	// 绑定参数
	@InitBinder("dept")
	public void initBinderDept(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("dept.");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/addDept.html")
	@ResponseBody
	public Map<String, Object> addDept(Dept dept) {
		logger.info("dept:" + dept.getDptname());
		deptService.add(dept);
		Map resltMap = new HashMap();
		resltMap.put("resCode", 1);
		resltMap.put("resDesc", "保存成功！");
		return resltMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delDept.html")
	@ResponseBody
	public Map<String, Object> delDept(HttpServletRequest request) {
		String deptId = request.getParameter("deptId");
		Map resultMap = new HashMap();
		try {
			//删除操作之前判断该部门是否有下属部门
			if(deptService.countSubDpt(deptId) > 0){
				resultMap.put("resCode", "2");
				resultMap.put("resDesc", "该部门存在下级部门,不可撤销");
			}else if(deptService.countEmp(deptId) > 0){
				resultMap.put("resCode", "3");
				resultMap.put("resDesc", "该部门存在员工,不可撤销");
			}else{
				deptService.delete(deptId);
				resultMap.put("resCode", "1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}

	@RequestMapping(value = "/toEditDept.html")
	public String toEditDept(HttpServletRequest request, Model model) {

		String deptId = request.getParameter("deptId");
		Dept dept = deptService.getDeptById(deptId);
		model.addAttribute("dept", dept);

		return "/mf/org/deptManager/dept_edit";
	}

	@RequestMapping(value = "/editDept.html")
	@ResponseBody
	public Map<String, Object> editDept(Dept dept) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			deptService.modify(dept);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}
		return resultMap;
	}
	
	
	@RequestMapping(value = "/toSetDeptLeader.html")
	public String toSetDeptLeader(HttpServletRequest request) {
		String deptNo=request.getParameter("deptNo");
		request.setAttribute("deptNo", deptNo);
		return "/mf/org/deptManager/set_dept_leader";
	}
	
	
	@RequestMapping(value = "/setDeptLeader.html")
	@ResponseBody
	public Map<String, Object> setDeptLeader(HttpServletRequest request,Dept dept) {
		//设置部门负责人
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
			deptService.setDeptLeader(dept);
			resultMap.put("resCode", "1");
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}
	
		return resultMap;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getType")
	@ResponseBody
	public Map<String, List> getType(String code, HttpServletRequest request){
		//字典类型编码
		Entity entity;
		List<Dept> dept= deptService.queryAll();
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(Dept sd : dept){
			entity = new Entity();
			entity.setKey(sd.getDptname());
			entity.setValue(sd.getDptno());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
	@RequestMapping(value = "/toOrgBaseInfoList.html")
	public String toOrgBaseInfoList() {
		
		return "/mf/org/deptManager/org_dept_list";
	}
	
	
	
	@RequestMapping(value = "/setFinance.html")
	@ResponseBody
	public Map<String, Object> setFinance(HttpServletRequest request,Dept dept) {
		//设置部门负责人
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try{
			deptService.setNonFinance();
			deptService.setFinance(dept);
			resultMap.put("resCode", "1");
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}
	
		return resultMap;
	}
	
	


}
