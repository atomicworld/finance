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
import com.mf.client.entity.ClntPersonEcoSi;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonEcoSiService;
import com.mf.common.pub.PubConstants;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/client/clntpersonecosi/")
public class ClntPersonEcoSiController {
	
	@Autowired
	private ClntPersonEcoSiService clntPersonEcoSiService;
	@Autowired
	private ClntClientService clntClientService;
	
	private final static String JSP_PATH = "/mf/clientmng/clnteco/clntperson/clntpersonecosi/";
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model, String clntid){
		model.addAttribute("clntClient", clntClientService.getById(clntid));
		return JSP_PATH + "add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntpersonecosi
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntPersonEcoSi clntpersonecosi,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			clntPersonEcoSiService.add(clntpersonecosi);
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
	 * @param clntpersonecosi
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			ClntPersonEcoSi clntpersonecosi = new ClntPersonEcoSi();
			clntPersonEcoSiService.addAll(clntpersonecosi);
			result="{\"id\":" + clntpersonecosi.getId() + ",\"message\":\"新增成功！\"}";
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
	 * @param clntpersonecosi
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,ClntPersonEcoSi clntpersonecosi,String pageNow, String pageSize){
		return "/mf/clientmng/clntpersonecosi/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clntpersonecosi
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntPersonEcoSi clntpersonecosi,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntPersonEcoSiService.query(pageView, clntpersonecosi);
		List<ClntPersonEcoSi> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clntpersonecosiId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntPersonEcoSiService.delete(ids);
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
	 * @param clntpersonecosiId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,String pageType){
		ClntPersonEcoSi clntpersonecosi = clntPersonEcoSiService.getById(id);
		model.addAttribute("clntpersonecosi", clntpersonecosi);
		ClntClient clntClient = clntClientService.getById(clntpersonecosi.getClntno());
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
	 * @param clntpersonecosi
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntPersonEcoSi(Model model,ClntPersonEcoSi clntpersonecosi,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntPersonEcoSiService.modify(clntpersonecosi);
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
				clntPersonEcoSiService.delete(id);
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
	public String list(String clntno, HttpServletRequest request){
		request.setAttribute("clntno", clntno);
		return JSP_PATH + "list";
	}
}

