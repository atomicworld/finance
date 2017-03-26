/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */


package com.mf.client.controller;

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

import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntPersonJob;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonJobService;
import com.mf.common.pub.PubConstants;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
@Controller
@RequestMapping(value = "/mf/client/clntpersonjob/")
public class ClntPersonJobController {
	
	@Autowired
	private ClntPersonJobService clntPersonJobService;
	@Autowired
	private ClntClientService clntClientService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model, String clntid){
		ClntClient clntClient = clntClientService.getById(clntid);
		model.addAttribute("clntClient", clntClient);
		return "/mf/clientmng/clntinfo/clntperson/clntpersonjob/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntpersonjob
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntPersonJob clntPersonJob,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			clntPersonJobService.add(clntPersonJob);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" + WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(Model model,String clntno, HttpServletRequest request){
		request.setAttribute("clntno", clntno);
		model.addAttribute("view",request.getParameter("view"));
		return "/mf/clientmng/clntinfo/clntperson/clntpersonjob/list";
	}
	
	/**
	 * 提供list展示界面的数据
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "showlist")
	@ResponseBody
	public Map<String, Object> showList(Model model, ClntPersonJob clntPersonJob, 
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
		pageView =clntPersonJobService.query(pageView, clntPersonJob);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	
	@RequestMapping(value="getById")
	public String getById(Model model, String id, String pageType){
		ClntPersonJob clntPersonJob = clntPersonJobService.getById(id);
		model.addAttribute("clntPersonJob", clntPersonJob);
		ClntClient clntClient = clntClientService.getById(clntPersonJob.getClntno());
		model.addAttribute("clntClient", clntClient);
		if(PubConstants.PAGE_TYPE_EDIT.equals(pageType)){
			return "/mf/clientmng/clntinfo/clntperson/clntpersonjob/edit";
		}else if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
			return "/mf/clientmng/clntinfo/clntperson/clntpersonjob/view";
		}else{
			return null;
		}
	}
	
	@RequestMapping(value="update")
	public String update(ClntPersonJob clntpersonjob, HttpServletResponse response, HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			clntPersonJobService.modify(clntpersonjob);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" + WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
}

