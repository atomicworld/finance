package com.mf.financemng.controller;

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

import com.mf.financemng.entity.FnncShareholder;
import com.mf.financemng.service.FnncShareholderService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author chenenze
 * @2015-02-10
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/sharholder/")
public class FnncShareholderController {
	
	@Autowired
	private FnncShareholderService fnncShareholderService;
	
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String listlabel(){
		return "/mf/financemng/sharholder/listlabel";
	}
	/**
	 * 跳转到listnew展示页面
	 * @return
	 */
	@RequestMapping(value="holdnew")
	public String listnew(){
		return "/mf/financemng/sharholder/holdnew";
	}
	/**
	 * 跳转到listend展示页面
	 * @return
	 */
	@RequestMapping(value="holdend")
	public String listend(){
		return "/mf/financemng/sharholder/holdend";
	}
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/financemng/sharholder/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnncshareholder
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncShareholder fnncshareholder,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		FnncShareholder sharholdnm=fnncShareholderService.findbynm(fnncshareholder.getSharholdnm());
		try {
			if(null!=sharholdnm){
				result = "{\"msg\":\"fail\"}";
			}else{
				fnncShareholderService.add(fnncshareholder, request);
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
	 * @param fnncshareholder
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			FnncShareholder fnncshareholder = new FnncShareholder();
			fnncShareholderService.addAll(fnncshareholder);
			result="{\"id\":" + fnncshareholder.getSharholdno() + ",\"message\":\"新增成功！\"}";
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
	 * @param fnncshareholder
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,FnncShareholder fnncshareholder,String pageNow, String pageSize){
		return "/mf/financemng/fnncshareholder/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncshareholder
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncShareholder fnncshareholder,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncShareholderService.query(pageView, fnncshareholder);
		List<FnncShareholder> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncshareholder
	 * @return map
	 */
	@RequestMapping(value="showhistory",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showhistory(Model model,FnncShareholder fnncshareholder,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncShareholderService.queryhistory(pageView, fnncshareholder);
		List<FnncShareholder> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnncshareholderId
	 * @return
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fnncShareholderService.delete(ids);
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
	 * @param Id
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String Id,int typeKey){
		FnncShareholder fnncshareholder = fnncShareholderService.getById(Id);
		model.addAttribute("fnncshareholder", fnncshareholder);
		if(typeKey == 1){
			return "/mf/financemng/sharholder/edit";
		}else if(typeKey == 2){
			return "/mf/financemng/sharholder/view";
		}else{
			return "/mf/financemng/fnncshareholder/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnncshareholder
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncShareholder(Model model,FnncShareholder fnncshareholder,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			fnncShareholderService.modify(fnncshareholder);
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
				fnncShareholderService.delete(id);
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

