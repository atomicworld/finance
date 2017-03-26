/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */


package com.mf.sys.controller;

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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.mf.util.Common;
import com.mf.util.WebTool;

import com.mf.common.util.StringUtil;
import com.mf.json.Entity;
import com.mf.sys.entity.*;
import com.mf.sys.dao.*;
import com.mf.sys.service.*;
import com.mf.util.*;

@Controller
@RequestMapping(value="/mf/org/role")
public class SysRoleController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private SysRoleService sysRoleService;
	
	
	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}
	   
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="/list.html")
	public String list(){
		return "/mf/org/role/list";
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		//这里需要将一级菜单和下属权限项目查询出来,送到前台
		Map<SysMenu, List<SysRight>> menuRightMap = sysRoleService.findMenuRightMap();
		
		model.addAttribute("mrMap", menuRightMap);
		return "/mf/org/role/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param sysrole
	 * @return
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public String add(Model model,SysRole sysrole,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			sysRoleService.addAll(sysrole);
		} catch (Exception e) {
			//result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param sysrole
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			SysRole sysrole = new SysRole();
			sysRoleService.addAll(sysrole);
			//result="{\"id\":" + sysrole.getId() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			//result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param sysrole
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,SysRole sysrole,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = sysRoleService.query(pageView, sysrole);
		List<SysRole> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param sysroleId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			//TBD 这里应该先判断是否有相应角色类型的操作员存在,若存在则无法删除
			if(sysRoleService.countOp(ids) == 0){
				sysRoleService.delete(ids);
			    result="{\"status\":1,\"message\":\"删除成功！\"}";
			}else{
				result="{\"status\":2,\"message\":\"存在该角色类型的操作员.\"}";
			}
			
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +"删除失败!"+"\"}"; //WebTool.getErrorMsg(e.getMessage())
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param sysroleId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String sysroleId,int typeKey){
		SysRole sysrole = sysRoleService.getById(sysroleId);
		model.addAttribute("sysrole", sysrole);
		//这里需要将一级菜单和下属权限项目查询出来,送到前台
		Map<SysMenu, List<SysRight>> menuRightMap = sysRoleService.findMenuRightMap();
		model.addAttribute("mrMap", menuRightMap);
		
		if(typeKey == 1){
			return "/mf/org/role/edit";
		}else if(typeKey == 2){
			return "/mf/org/role/view";
		}else{
			return "/mf/org/role/view_1";
		}
	}
	
	/**
	 * 根据角色级别查询角色名称,用在下拉框数据填充
	 **/

	@SuppressWarnings("rawtypes")
	@RequestMapping(value="getRolesByLvl")
	@ResponseBody
	public Map<String, List> getRolesByLvl(HttpServletRequest request){
		String lvl = request.getParameter("lvl");
		Map<String,List> resMap = new HashMap<String,List>();
		if(StringUtil.isEmpty(lvl)){
		}else{
			List<SysRole> roles = sysRoleService.getByLvl(lvl);
			List<Entity> list = new ArrayList<Entity>();
			for(SysRole role : roles){
				Entity entity = new Entity();
				entity.setKey(role.getRlnm());
				entity.setValue(role.getRlid());
				list.add(entity);
			}
			resMap.put("list", list);
		}		
		return resMap;
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param sysrole
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateSysRole(Model model,SysRole sysrole,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			sysRoleService.modify(sysrole);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}"; //WebTool.getErrorMsg(e.getMessage())
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
	@ResponseBody
	public String deleteAll(String[] ids, Model model, HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				sysRoleService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			//result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	

	
}

