/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.bsnsmng.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.entity.BsnsGrnt;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.BsnsGrntService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author shengd
 * @2015-01-07
 * @Email: 1017768302@qq.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/bsnsgrnt/")
public class BsnsGrntController {
	
	@Autowired
	private BsnsGrntService bsnsGrntService;
	@Autowired
	private BsnsApplyService bsnsApplyService;
	/**
	 * 跳转到保证人信息list页面
	 */
	@RequestMapping(value="list")
	public String getList(Model model,HttpServletRequest request){
		String applyNo = request.getParameter("applyNo");
		model.addAttribute("applyNo",applyNo);
		return "/mf/bsnsmng/bsnsgrnt/list";
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model,HttpServletRequest request){
		String applyNo = request.getParameter("applyNo");
		BsnsApply bsnsApply = bsnsApplyService.getById(applyNo);
		model.addAttribute("bsnsApply", bsnsApply);
		return "/mf/bsnsmng/bsnsgrnt/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param bsnsgrnt
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,BsnsGrnt bsnsgrnt,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			bsnsGrntService.add(bsnsgrnt);
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
	 * @param bsnsgrnt
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsGrnt bsnsgrnt,HttpServletRequest request){
		
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsGrntService.query(pageView, bsnsgrnt);
		List<BsnsGrnt> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param bsnsgrntId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			bsnsGrntService.delete(ids);
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
	 * @param bsnsgrntId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String bsnsgrntId,int typeKey){
		BsnsGrnt bsnsgrnt = bsnsGrntService.getById(bsnsgrntId);
		model.addAttribute("bsnsgrnt", bsnsgrnt);
		if(typeKey == 1){
			return "/mf/bsnsmng/bsnsgrnt/edit";
		}else if(typeKey == 2){
			return "/mf/bsnsmng/bsnsgrnt/view";
		}else{
			return "/mf/bsnsmng/bsnsgrnt/view_1";
		}
	}
	

	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param bsnsgrntId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getByCntrctno")
	public String getByCntrctno(Model model,String bsnsgrntId,int typeKey){
		BsnsGrnt bsnsgrnt = bsnsGrntService.getById(bsnsgrntId);
		model.addAttribute("bsnsgrnt", bsnsgrnt);
		if(typeKey == 1){
			return "/mf/cntrtmng/bsnscntrct/agreement/edit/bsnsgrnt/edit";
		}else if(typeKey == 2){
			return "/mf/cntrtmng/bsnscntrct/agreement/edit/bsnsgrnt/view";
		}else{
			return "/mf/cntrtmng/bsnscntrct/agreement/edit/bsnsgrnt/view_1";
		}
	}
	/**
	 * 更新修改的信息
	 * @param model
	 * @param bsnsgrnt
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateBsnsGrnt(Model model,BsnsGrnt bsnsgrnt,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			bsnsGrntService.modify(bsnsgrnt);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
	    	WebTool.writeJson(result, response);
		 return null;		
		
	}
	
}

