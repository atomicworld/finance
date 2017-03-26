package com.mf.comStructure.controller;

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

import com.mf.comStructure.entity.Fundtable;
import com.mf.comStructure.service.FundtableService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/comStructure/fundtable")
public class FundtableController {
	
	@Autowired
	private FundtableService fundtableService;
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(){
		return "/mf/comStructure/fundtbl/list";
	}
	
	@RequestMapping(value = "showlist")
	@ResponseBody
	public Map<String, Object> showlist(Model model, Fundtable fundtable, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		pageView =fundtableService.query(pageView, fundtable);
		List<Fundtable> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/comStructure/fundtbl/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fundtable
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Fundtable fundtable,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			fundtable.setState("0");//新增的时候为0
			fundtableService.add(fundtable);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;
	}
	
//	/**
//	 * 保存新增--for 即时编辑
//	 * @param model
//	 * @param fundtable
//	 * @return
//	 */
//	@RequestMapping(value="addnull")
//	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
//		String result="";
//		try {
//			Fundtable fundtable = new Fundtable();
//			fundtableService.addAll(fundtable);
//			result="{\"id\":" + fundtable.getId() + ",\"message\":\"新增成功！\"}";
//		} catch (Exception e) {
//			result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
//			e.printStackTrace();
//		}
//		WebTool.writeJson(result, response);
//		 return null;
//	}

	/**
	 * 分页查询跳转
	 * @param model
	 * @param fundtable
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,Fundtable fundtable,String pageNow, String pageSize){
		return "/mf/comStructure/fundtbl/list";
	}
//	
//	/**
//	 * post方式分页查询
//	 * @param model
//	 * @param fundtable
//	 * @return map
//	 */
//	@RequestMapping(value="showlist",method=RequestMethod.POST)
//    @ResponseBody
//	public Map<String, Object> showlist(Model model,Fundtable fundtable,HttpServletRequest request){
//		User u = (User)request.getSession().getAttribute("userSession");
//		if(null ==u){
//			request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
//			return null;
//		}
//		PageView pageView = null;
//		String pageNow=request.getParameter("pager.pageNo");
//		String pageSize=request.getParameter("pager.pageSize");
//		if(Common.isEmpty(pageNow)){
//			pageView = new PageView(1);
//		}else{
//			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
//		}
//		Map<String, Object> map=new HashMap<String, Object>();
//		Organization org=(Organization)request.getSession().getAttribute("organizationSession");
//		if(u.getLevel()==1){//管理员
//			
//		}else if(org!=null){//部门负责人
//		}else{//只能看得到自己添加的
//		}
//		pageView = fundtableService.query(pageView, fundtable);
//		List<Fundtable> list=pageView.getRecords();
//		map.put("rows", list); 
//		map.put("pager.pageNo", pageView.getPageNow());
//		map.put("pager.totalRows", pageView.getRowCount());
//		return map;
//	}
//	
	/**
	 * 根据id删除
	 * @param model
	 * @param fundtableId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fundtableService.delete(ids);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
//	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param fundtableId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String fundtableId,int typeKey){
		Fundtable fundtable = fundtableService.getById(fundtableId);
		model.addAttribute("fundtable", fundtable);
		if(typeKey == 1){
			return "/mf/comStructure/fundtbl/edit";
		}else if(typeKey == 2){
			return "/mf/comStructure/fundtbl/view";
		}else{
			return "/mf/comStructure/fundtbl/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fundtable
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFundtable(Model model,Fundtable fundtable,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			fundtableService.modify(fundtable);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		 return null;		
		
	}

	/**
	 * 批量删除数据
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
				System.out.println(id);
				if(fundtableService.getById(id).getState().equals("0"))//已经提交的不能删除
					fundtableService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功，已提交无法删除！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 *	提交
	 */
	@RequestMapping(value="submitById",method=RequestMethod.POST)
	public String submitById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fundtableService.submit(ids);
		    result="{\"status\":1,\"message\":\"操作成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	
}

