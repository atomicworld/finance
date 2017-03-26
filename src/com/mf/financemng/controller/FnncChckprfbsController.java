/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.financemng.entity.FnncChckprfbs;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.financemng.service.FnncChckprfbsService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2015-02-12
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/yfhpz/")
public class FnncChckprfbsController {
	
	@Autowired
	private FnncChckprfbsService fnncChckprfbsService;
	
	
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/financemng/fnncchckprfbs/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnncchckprfbs
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncChckprfbs fnncchckprfbs,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			fnncChckprfbsService.add(fnncchckprfbs);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	/**
	 * 分页查询跳转
	 * @param model
	 * @param fnncchckprfbs
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,FnncChckprfbs fnncchckprfbs,String pageNow, String pageSize){
		return "/mf/financemng/fnncchckprfbs/list_list";
	}
	
	@RequestMapping(value="yfhpzUI")
	public String yfhpzUI(String accntflg, HttpServletRequest request){
		if(null != accntflg){
			request.setAttribute("accntflg", accntflg);
			return "/mf/financemng/yfhpz/jzpzUI";
		}else{
			return "/mf/financemng/yfhpz/yfhpzUI";
		}
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncchckprfbs
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncChckprfbs fnncchckprfbs,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncChckprfbsService.query(pageView, fnncchckprfbs);
		List<FnncChckprfbs> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	

	@RequestMapping(value="queryList",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> queryList(Model model,FnncPrfbsList fnncprfbslist,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncChckprfbsService.queryList(pageView, fnncprfbslist);
		List<FnncPrfbsList> list = pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param fnncchckprfbsId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String fnncchckprfbsId,int typeKey){
		FnncChckprfbs fnncchckprfbs = fnncChckprfbsService.getById(fnncchckprfbsId);
		model.addAttribute("fnncchckprfbs", fnncchckprfbs);
		if(typeKey == 1){
			return "/mf/financemng/fnncchckprfbs/edit";
		}else if(typeKey == 2){
			return "/mf/financemng/fnncchckprfbs/view";
		}else{
			return "/mf/financemng/fnncchckprfbs/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnncchckprfbs
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncChckprfbs(Model model,FnncChckprfbs fnncchckprfbs,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			fnncChckprfbsService.modify(fnncchckprfbs);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
}

