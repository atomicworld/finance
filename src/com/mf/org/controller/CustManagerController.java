package com.mf.org.controller;

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

import com.mf.org.entity.CustManager;
import com.mf.org.service.impl.CustManagerServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;

@Controller
@RequestMapping(value = "/mf/org/custManager")
public class CustManagerController {

	private static final Logger logger = Logger
			.getLogger(CustManagerController.class);

	@Autowired
	CustManagerServiceImpl custManagerService;

	/**
	 * 部门查询列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCustManagerList.html")
	public String list() {		
		return "/mf/org/custManager/custManager_list";		
	}

	@RequestMapping(value = "/getCustManagerPagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getPagerList(Model model, CustManager custManager,
			HttpServletRequest request) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),	Integer.parseInt(pageNow));
		}

		pageView = custManagerService.query(pageView, custManager);
		List list = pageView.getRecords();

		Map resultMap = new HashMap();
		resultMap.put("rows", list);
		resultMap.put("pager.pageNo", pageView.getPageNow());
		resultMap.put("pager.totalRows", pageView.getRowCount());
		return resultMap;
	}
	

	@RequestMapping(value = "/toAddCustManager.html")
	public String toAddCustManager() {
		return "/mf/org/custManager/custManager_add";
	}
		
	@RequestMapping(value = "/toEdit.html")
	public String toEditCustManager(HttpServletRequest request,Model model) {
		String id=request.getParameter("id");
		CustManager custManager=custManagerService.getById(id);
		model.addAttribute("custManager", custManager);
		model.addAttribute("editFlag", true);
		return "/mf/org/custManager/custManager_add";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/custManagerAdd.html")
	@ResponseBody
	public Map<String, Object> addCustManager(CustManager custManager) {		
		custManagerService.add(custManager);
		Map resltMap = new HashMap();
		resltMap.put("resCode", 1);
		resltMap.put("resDesc", "保存成功！");
		return resltMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delCustManager.html")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request) {
		String rcrdid = request.getParameter("rcrdid");
		Map resultMap = new HashMap();
		try {
			custManagerService.delete(rcrdid);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/changeStatus.html")
	@ResponseBody
	public Map<String, Object> changeStatus(HttpServletRequest request) {
		String id = request.getParameter("id");
		String status=request.getParameter("status");
		Map resultMap = new HashMap();
		try {
			custManagerService.changeStatus(id,status);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}

	@RequestMapping(value = "/toEditCustManager.html")
	public String toEdit(HttpServletRequest request, Model model) {

		String deptId = request.getParameter("deptId");
		CustManager custManager = custManagerService.getById(deptId);
		model.addAttribute("custManager", custManager);

		return "/mf/org/custManager/custManager_edit";
	}

	@RequestMapping(value = "/editCustManager.html")
	@ResponseBody
	public Map<String, Object> editCustManager(CustManager custManager) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			custManagerService.modify(custManager);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}
		return resultMap;
	}


}
