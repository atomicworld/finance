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
import com.mf.client.entity.ClntPersonInout;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntPersonInoutService;
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
@RequestMapping(value="/mf/client/clntpersoninout/")
public class ClntPersonInoutController {
	
	@Autowired
	private ClntPersonInoutService clntPersonInoutService;
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
		return "/mf/clientmng/clntinfo/clntperson/clntpersoninout/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntpersoninout
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntPersonInout clntpersoninout,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			clntPersonInoutService.add(clntpersoninout);
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
	 * @param clntpersoninout
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			ClntPersonInout clntpersoninout = new ClntPersonInout();
			clntPersonInoutService.addAll(clntpersoninout);
			result="{\"id\":" + clntpersoninout.getId() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}
	
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clntpersoninout
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntPersonInout clntpersoninout,HttpServletRequest request){
		System.out.println();
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntPersonInoutService.query(pageView, clntpersoninout);
		List<ClntPersonInout> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clntpersoninoutId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntPersonInoutService.delete(ids);
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
	 * @param clntpersoninoutId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,String pageType){
		System.out.println("into inout getById:"+id);
		System.out.println("pageType="+pageType);
		ClntPersonInout clntpersoninout = clntPersonInoutService.getById(id);
		model.addAttribute("clntpersoninout", clntpersoninout);
		ClntClient clntClient = clntClientService.getById(clntpersoninout.getClntno());
		model.addAttribute("clntClient", clntClient);
		if(PubConstants.PAGE_TYPE_EDIT.equals(pageType)){
			System.out.println("pageType edit==>>"+pageType);
			return "/mf/clientmng/clntinfo/clntperson/clntpersoninout/edit";
		}else if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
			System.out.println("pageType view==>>"+pageType);
			return "/mf/clientmng/clntinfo/clntperson/clntpersoninout/view";
		}else{
			System.out.println("pageType null==>>"+pageType);
			return null;
		}
		
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clntpersoninout
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntPersonInout(Model model,ClntPersonInout clntpersoninout,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {		
			clntPersonInoutService.modify(clntpersoninout);
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
		model.addAttribute("view", request.getParameter("view"));
		return "/mf/clientmng/clntinfo/clntperson/clntpersoninout/list";
	}
	
	
}

