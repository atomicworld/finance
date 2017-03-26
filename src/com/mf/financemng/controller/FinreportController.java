/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */


package com.mf.financemng.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mf.financemng.entity.*;
import com.mf.financemng.dao.*;
import com.mf.financemng.service.*;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/financemng/finreport/")
public class FinreportController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	@Autowired
	private FinanceShareholderService financeShareholderService;
	@Autowired
	private FinreportService finreportService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/finreport/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param finreport
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Finreport finreport,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			finreportService.add(finreport);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model, Finreport finreport, 
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
		Map map = new HashMap();
		pageView =finreportService.query(pageView, finreport);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param finreport
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFinreport(Model model,Finreport finreport,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			finreportService.modify(finreport);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
}


