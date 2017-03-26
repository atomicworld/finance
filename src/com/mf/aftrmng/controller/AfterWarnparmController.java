/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.aftrmng.controller;

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

import com.mf.aftrmng.entity.AfterWarnparm;
import com.mf.aftrmng.service.AfterWarnparmService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author yangchao
 * @2015-01-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/background/afterwarnparm/")
public class AfterWarnparmController {
	@Autowired
	private AfterWarnparmService afterWarnparmService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/background/afterwarnparm/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param afterwarnparm
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,AfterWarnparm afterwarnparm,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			afterWarnparmService.add(afterwarnparm);
		} catch (Exception e) {
			result="{\"msg\":\"fail\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param afterwarnparm
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			AfterWarnparm afterwarnparm = new AfterWarnparm();
			afterWarnparmService.addAll(afterwarnparm);
			result="{\"id\":" + afterwarnparm.getRcrdid() + ",\"message\":\"新增成功！\"}";
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
	 * @param afterwarnparm
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,AfterWarnparm afterwarnparm,String pageNow, String pageSize){
		return "/background/afterwarnparm/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param afterwarnparm
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,AfterWarnparm afterwarnparm,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		
		pageView = afterWarnparmService.query(pageView, afterwarnparm);
		List<AfterWarnparm> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param afterwarnparmId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			afterWarnparmService.delete(ids);
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
	 * @param afterwarnparmId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String afterwarnparmId,int typeKey){
		AfterWarnparm afterwarnparm = afterWarnparmService.getById(afterwarnparmId);
		model.addAttribute("afterwarnparm", afterwarnparm);
		if(typeKey == 1){
			return "/background/afterwarnparm/edit";
		}else if(typeKey == 2){
			return "/background/afterwarnparm/view";
		}else{
			return "/background/afterwarnparm/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param afterwarnparm
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateAfterWarnparm(Model model,AfterWarnparm afterwarnparm,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			afterWarnparmService.modify(afterwarnparm);
		} catch (Exception e) {
			result="{\"msg\":\"fail\"}";
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
				afterWarnparmService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
}

