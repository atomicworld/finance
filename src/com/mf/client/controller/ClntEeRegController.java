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
import com.mf.client.entity.ClntEeReg;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntEeRegService;
import com.mf.common.pub.PubConstants;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2014-12-25
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/client/clnteereg/")
public class ClntEeRegController {
	
	@Autowired
	private ClntEeRegService clntEeRegService;
	@Autowired
	private ClntClientService clntClientService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/clientmng/clnteereg/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clnteereg
	 * @return
	 */
	@RequestMapping(value="save")
	public String add(Model model,ClntEeReg clnteereg,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			ClntEeReg cer = clntEeRegService.getById(clnteereg.getClntno());
			if(null == cer){
				clntEeRegService.add(clnteereg);
			}else{
				clntEeRegService.modify(clnteereg);
			}
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
	 * @param clnteereg
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			ClntEeReg clnteereg = new ClntEeReg();
			clntEeRegService.addAll(clnteereg);
			result="{\"id\":" + clnteereg.getClntno() + ",\"message\":\"新增成功！\"}";
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
	 * @param clnteereg
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,ClntEeReg clnteereg,String pageNow, String pageSize){
		return "/mf/clientmng/clnteereg/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param clnteereg
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntEeReg clnteereg,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntEeRegService.query(pageView, clnteereg);
		List<ClntEeReg> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clnteeregId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntEeRegService.delete(ids);
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
	 * @param clnteeregId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String clnteeregId,int typeKey){
		ClntEeReg clnteereg = clntEeRegService.getById(clnteeregId);
		model.addAttribute("clnteereg", clnteereg);
		if(typeKey == 1){
			return "/mf/clientmng/clnteereg/edit";
		}else if(typeKey == 2){
			return "/mf/clientmng/clnteereg/view";
		}else{
			return "/mf/clientmng/clnteereg/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clnteereg
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntEeReg(Model model,ClntEeReg clnteereg,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntEeRegService.modify(clnteereg);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
	}
	
	@RequestMapping(value = "getByClntno")
	public String getByClntno(Model model, String clntno, String pageType, HttpServletRequest request){
		ClntEeReg clntEeReg = clntEeRegService.getById(clntno);
		model.addAttribute("clnteereg", clntEeReg);
		ClntClient clntClient = clntClientService.getById(clntno);
		model.addAttribute("clntClient", clntClient);
		
		if(PubConstants.PAGE_TYPE_EDIT.equals(pageType)){
			return "/mf/clientmng/clntinfo/clntee/clnteereg/edit";
		}else if(PubConstants.PAGE_TYPE_VIEW.equals(pageType)){
			model.addAttribute("view", request.getParameter("view"));
			
			return "/mf/clientmng/clntinfo/clntee/clnteereg/view";
		}else{
			if(null == clntEeReg){
				// 不存在，显示新增编辑界面
//				pageType = ConstantValue.PAGE_TYPE_EDIT;
//				request.setAttribute("pageType", pageType);
				return "/mf/clientmng/clntinfo/clntee/clnteereg/edit";
			}else{
				// 存在，显示查看界面
//				pageType = ConstantValue.PAGE_TYPE_VIEW;
//				request.setAttribute("pageType", pageType);
				return "/mf/clientmng/clntinfo/clntee/clnteereg/view";
			}
			
		}
	}
}
