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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntEeCapInvest;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntEeCapInvestService;
import com.mf.common.pub.PubConstants;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/client/clnteecapinvest/")
public class ClntEeCapInvestController {
	
	@Autowired
	private ClntEeCapInvestService clntEeCapInvestService;
	@Autowired
	private ClntClientService clntClientService;
	
	private final static String JSP_PATH = "/mf/clientmng/clntinfo/clntee/clnteecapinvest/";
	
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model, String clntid){
		ClntClient clntClient = clntClientService.getById(clntid);
		model.addAttribute("clntClient", clntClient);
		return JSP_PATH + "add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clnteecapinvest
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntEeCapInvest clnteecapinvest,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			clntEeCapInvestService.add(clnteecapinvest);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param clnteecapinvest
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			ClntEeCapInvest clnteecapinvest = new ClntEeCapInvest();
			clntEeCapInvestService.addAll(clnteecapinvest);
			result="{\"id\":" + clnteecapinvest.getId() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 分页查询跳转
	 * @param model
	 * @param clnteecapinvest
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,ClntEeCapInvest clnteecapinvest,String pageNow, String pageSize){
		return "/mf/clientmng/clnteecapinvest/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clnteecapinvest
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntEeCapInvest clnteecapinvest,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntEeCapInvestService.query(pageView, clnteecapinvest);
		List<ClntEeCapInvest> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clnteecapinvestId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntEeCapInvestService.delete(ids);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param clnteecapinvestId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,String pageType){
		ClntEeCapInvest clnteecapinvest = clntEeCapInvestService.getById(id);
		model.addAttribute("clnteecapinvest", clnteecapinvest);
		ClntClient clntClient = clntClientService.getById(clnteecapinvest.getClntno());
		model.addAttribute("clntClient", clntClient);
		if(PubConstants.PAGE_TYPE_EDIT.equals(pageType)){
			return JSP_PATH + "edit";
		}else if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
			return JSP_PATH + "view";
		}else{
			return null;
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clnteecapinvest
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntEeCapInvest(Model model,ClntEeCapInvest clnteecapinvest,HttpServletResponse response){
		String result="{\"msg\":\"suc\"}";
		try {			
			clntEeCapInvestService.modify(clnteecapinvest);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	
	/**
	 * 批量删除数据
	 * 
	 * @param model
	 * @param String
	 *            [] ids
	 * @return
	 */
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String[] ids, Model model, HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				clntEeCapInvestService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value = "list")
	public String list(Model model,String clntno, HttpServletRequest request){
		request.setAttribute("clntno", clntno);
		model.addAttribute("view", request.getParameter("view"));
		return JSP_PATH + "list";
	}
}

