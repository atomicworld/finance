/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


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

import com.mf.financemng.entity.FnncDealitem;
import com.mf.financemng.service.FnncDealitemService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/fnncdealitem/")
public class FnncDealitemController {
	@Autowired
	private FnncDealitemService fnncDealitemService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/fnncdealitem/add";
	}
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(Model model){
		return "/mf/financemng/fnncdealitem/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnncdealitem
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncDealitem fnncdealitem,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			fnncDealitemService.add(fnncdealitem);
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
	 * @param fnncdealitem
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncDealitem fnncdealitem,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncDealitemService.query(pageView, fnncdealitem);
		List<FnncDealitem> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnncdealitemId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fnncDealitemService.delete(ids);
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
	 * @param fnncdealitemId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String fnncdealitemId,int typeKey){
		FnncDealitem fnncdealitem = fnncDealitemService.getById(fnncdealitemId);
		model.addAttribute("fnncdealitem", fnncdealitem);
		if(typeKey == 1){
			return "/mf/fnncdealitem/edit";
		}else if(typeKey == 2){
			return "/mf/fnncdealitem/view";
		}else{
			return "/mf/fnncdealitem/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnncdealitem
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncDealitem(Model model,HttpServletRequest request,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			String[] rcrdid=request.getParameterValues("rcrdid");
			String[] accntno=request.getParameterValues("accntno");
			String[] accntnm=request.getParameterValues("accntname");
			
			for(int i=0;i<rcrdid.length;i++){
				FnncDealitem fnncdealitem =new FnncDealitem();
				fnncdealitem.setRcrdid(rcrdid[i]);
				fnncdealitem.setAccntno(accntno[i]);
				fnncdealitem.setAccntname(accntnm[i]);
			    fnncDealitemService.modify(fnncdealitem);
			}
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
				fnncDealitemService.delete(id);
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

