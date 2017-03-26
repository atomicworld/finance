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
import com.mf.client.entity.ClntPersonFamily;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonFamilyService;
import com.mf.common.pub.PubConstants;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/client/clntpersonfamily/")
public class ClntPersonFamilyController {
	
	@Autowired
	private ClntPersonFamilyService clntPersonFamilyService;
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
		return "/mf/clientmng/clntinfo/clntperson/clntpersonfamily/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntpersonfamily
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntPersonFamily clntpersonfamily,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			clntPersonFamilyService.add(clntpersonfamily);
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
	 * @param clntpersonfamily
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			ClntPersonFamily clntpersonfamily = new ClntPersonFamily();
			clntPersonFamilyService.addAll(clntpersonfamily);
			result="{\"id\":" + clntpersonfamily.getId() + ",\"message\":\"新增成功！\"}";
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
	 * @param clntpersonfamily
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,ClntPersonFamily clntpersonfamily,String pageNow, String pageSize){
		return "/mf/clientmng/clntpersonfamily/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clntpersonfamily
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntPersonFamily clntpersonfamily,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntPersonFamilyService.query(pageView, clntpersonfamily);
		List<ClntPersonFamily> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clntpersonfamilyId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntPersonFamilyService.delete(ids);
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
	 * @param clntpersonfamilyId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,String pageType){
		ClntPersonFamily clntPersonFamily = clntPersonFamilyService.getById(id);
		ClntClient clntClient = clntClientService.getById(clntPersonFamily.getClntno());
		model.addAttribute("clntpersonfamily", clntPersonFamily);
		model.addAttribute("clntClient", clntClient);
		if(PubConstants.PAGE_TYPE_EDIT.equals(pageType)){
			return "/mf/clientmng/clntinfo/clntperson/clntpersonfamily/edit";
		}else if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
			return "/mf/clientmng/clntinfo/clntperson/clntpersonfamily/view";
		}else{
			return null;
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clntpersonfamily
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntPersonFamily(Model model,ClntPersonFamily clntpersonfamily,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntPersonFamilyService.modify(clntpersonfamily);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
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
		model.addAttribute("view", request.getParameter("view"));//
		return "/mf/clientmng/clntinfo/clntperson/clntpersonfamily/list";
	}
	
}

