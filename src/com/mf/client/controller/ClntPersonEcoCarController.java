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
import com.mf.client.entity.ClntPersonEcoCar;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonEcoCarService;
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
@RequestMapping(value="/mf/client/clntpersonecocar/")
public class ClntPersonEcoCarController {
	
	@Autowired
	private ClntPersonEcoCarService clntPersonEcoCarService;
	@Autowired
	private ClntClientService clntClientService;
	
	private final static String JSP_PATH = "/mf/clientmng/clnteco/clntperson/clntpersonecocar/";
	
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
	 * @param clntpersonecocar
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntPersonEcoCar clntpersonecocar,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			clntPersonEcoCarService.add(clntpersonecocar);
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
	 * @param clntpersonecocar
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			ClntPersonEcoCar clntpersonecocar = new ClntPersonEcoCar();
			clntPersonEcoCarService.addAll(clntpersonecocar);
			result="{\"id\":" + clntpersonecocar.getId() + ",\"message\":\"新增成功！\"}";
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
	 * @param clntpersonecocar
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,ClntPersonEcoCar clntpersonecocar,String pageNow, String pageSize){
		return "/mf/clientmng/clntpersonecocar/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clntpersonecocar
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntPersonEcoCar clntpersonecocar,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntPersonEcoCarService.query(pageView, clntpersonecocar);
		List<ClntPersonEcoCar> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clntpersonecocarId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntPersonEcoCarService.delete(ids);
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
	 * @param clntpersonecocarId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,String pageType){
		ClntPersonEcoCar clntpersonecocar = clntPersonEcoCarService.getById(id);
		model.addAttribute("clntpersonecocar", clntpersonecocar);
		ClntClient clntClient = clntClientService.getById(clntpersonecocar.getClntno());
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
	 * @param clntpersonecocar
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntPersonEcoCar(Model model,ClntPersonEcoCar clntpersonecocar,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntPersonEcoCarService.modify(clntpersonecocar);
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
				clntPersonEcoCarService.delete(id);
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

