/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.aftrmng.controller;

import java.util.Date;
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

import com.ibm.icu.text.SimpleDateFormat;
import com.mf.aftrmng.entity.AfterReadamnt;
import com.mf.aftrmng.service.AfterReadamntService;
import com.mf.common.util.WaterIdGener;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/aftrmng/afterreadamnt/")
public class AfterReadamntController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private AfterReadamntService afterReadamntService;
	
	
	@RequestMapping(value="list")
	public String list(Model model){
		List<AfterReadamnt> ar=afterReadamntService.findAll();
		if(ar.size()>0){
			model.addAttribute("ar", ar.get(0));
			return "/mf/aftrmng/afterreadamnt/edit";
		}else{
			return "/mf/aftrmng/afterreadamnt/add";
		}
	}
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/aftrmng/afterreadamnt/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param afterreadamnt
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,AfterReadamnt afterreadamnt,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			String rcrdid=WaterIdGener.getWaterId();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			afterreadamnt.setCrtdate(sdf.format(new Date()));
			afterreadamnt.setRecdid(rcrdid);
			afterReadamntService.add(afterreadamnt);
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
	 * @param afterreadamnt
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,AfterReadamnt afterreadamnt,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = afterReadamntService.query(pageView, afterreadamnt);
		List<AfterReadamnt> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param afterreadamntId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			afterReadamntService.delete(ids);
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
	 * @param afterreadamntId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String afterreadamntId,int typeKey){
		AfterReadamnt afterreadamnt = afterReadamntService.getById(afterreadamntId);
		model.addAttribute("afterreadamnt", afterreadamnt);
		if(typeKey == 1){
			return "/mf/aftrmng/afterreadamnt/edit";
		}else if(typeKey == 2){
			return "/mf/aftrmng/afterreadamnt/view";
		}else{
			return "/mf/aftrmng/afterreadamnt/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param afterreadamnt
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateAfterReadamnt(Model model,AfterReadamnt afterreadamnt,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			afterreadamnt.setCrtdate(sdf.format(new Date()));
			afterReadamntService.modify(afterreadamnt);
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
				afterReadamntService.delete(id);
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
		return "/mf/aftrmng/afterreadamnt/upload";
	}
	
}

