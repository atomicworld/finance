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

import com.mf.comStructure.entity.ComStructure;
import com.mf.comStructure.service.ComStructureService;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author zhangcong
 * @2015-04-14
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/comStructure/comStructure")
public class ComStructureController {
	@Autowired
	private ComStructureService comStructureService;
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/comStructure/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ComStructure comstructure,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		String createDate = FormatDateUtil.getFormatDate("yyyy-MM-dd");
		comstructure.setCreateDate(createDate);
		comstructure.setStatus("0"); //默认未提交
		
		comStructureService.add(comstructure);
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(){
		return "/mf/comStructure/list";
	}
	
	@RequestMapping(value = "showlist")
	@ResponseBody
	public Map<String, Object> showlist(Model model, ComStructure comstructure, HttpServletRequest request) {
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
		pageView =comStructureService.query(pageView, comstructure);
		List<ComStructure> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param comstructureId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			comStructureService.delete(ids);
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
	 * @param comstructureId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,int typeKey){
		ComStructure comstructure = comStructureService.getById(id);
		model.addAttribute("comstructure", comstructure);
		if(typeKey == 1){
			return "/mf/comStructure/edit";
		}else{
			return "/mf/comStructure/view";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Model model,ComStructure comstructure,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			comStructureService.modify(comstructure);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;		
		
	}
	
	/**
	 * 根据id提交
	 * @param model
	 * @param comstructureId
	 * @return
	 */
	@RequestMapping(value="submitById",method=RequestMethod.POST)
	public String submitById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			comStructureService.submit(ids);
		    result="{\"status\":1,\"message\":\"操作成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
}

