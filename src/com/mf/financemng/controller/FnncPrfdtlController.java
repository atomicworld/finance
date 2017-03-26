/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

import com.mf.financemng.entity.FnncPrfdtl;
import com.mf.financemng.service.FnncPrfdtlService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author yangchao
 * @2015-02-11
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/background/fnncprfdtl/")
public class FnncPrfdtlController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private FnncPrfdtlService fnncPrfdtlService;
	
	
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
		return "/background/fnncprfdtl/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnncprfdtl
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncPrfdtl fnncprfdtl,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			fnncPrfdtlService.add(fnncprfdtl);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncprfdtl
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncPrfdtl fnncprfdtl,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncPrfdtlService.query(pageView, fnncprfdtl);
		List<FnncPrfdtl> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnncprfdtlId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fnncPrfdtlService.delete(ids);
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
	 * @param fnncprfdtlId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String fnncprfdtlId,int typeKey){
		FnncPrfdtl fnncprfdtl = fnncPrfdtlService.getById(fnncprfdtlId);
		model.addAttribute("fnncprfdtl", fnncprfdtl);
		if(typeKey == 1){
			return "/background/fnncprfdtl/edit";
		}else if(typeKey == 2){
			return "/background/fnncprfdtl/view";
		}else{
			return "/background/fnncprfdtl/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnncprfdtl
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncPrfdtl(Model model,FnncPrfdtl fnncprfdtl,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			fnncPrfdtlService.modify(fnncprfdtl);
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
				fnncPrfdtlService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 跳到上传页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "upLoadUI")
	public String uploadUI(Model model) {
		return "/background/fnncprfdtl/upload";
	}
	
	
	
}

