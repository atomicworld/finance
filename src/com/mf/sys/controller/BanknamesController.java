/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.sys.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.json.Entity;
import com.mf.pubparam.entity.Cities;
import com.mf.sys.entity.Banknames;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.BanknamesService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.*;
/**
 * @author wangzhi
 * @2015-08-17
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/banknames/")
public class BanknamesController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private BanknamesService banknamesService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	
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
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/banknames/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param banknames
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Banknames banknames,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			banknamesService.add(banknames);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 
	 * @param model
	 * @param banknames
	 * @return
	 */
	@RequestMapping(value="getBank")
	@ResponseBody
	public Map<String,List> getBank(int parentId,HttpServletResponse response,HttpServletRequest request){
		Entity entity;
			List<Banknames> banknames = banknamesService.queryByParentId(parentId);
			List<Entity> list = new ArrayList<Entity>();
			Map<String,List> resMap = new HashMap<String,List>();
			for(Banknames c:banknames){
				entity = new Entity();
				entity.setKey(c.getBankname());
				entity.setValue(String.valueOf(c.getId()));
				list.add(entity);
			}
			resMap.put("list", list);
			return resMap;
		
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param banknames
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,Banknames banknames,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = banknamesService.query(pageView, banknames);
		List<Banknames> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param banknamesId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			banknamesService.delete(ids);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param banknames
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateBanknames(Model model,Banknames banknames,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			banknamesService.modify(banknames);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
}

