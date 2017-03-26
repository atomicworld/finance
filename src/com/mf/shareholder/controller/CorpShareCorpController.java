package com.mf.shareholder.controller;

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

import com.mf.common.util.StringUtil;
import com.mf.shareholder.entity.CorpSharecorp;
import com.mf.shareholder.service.CorpSharecorpService;
import com.mf.shareholder.service.CorpShareholderService;
import com.mf.util.*;
/**
 * @author zhangcong
 * @2015-04-14
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/shareholder/corp")
public class CorpShareCorpController {
	@Autowired
	private CorpShareholderService corpShareholderService;
	@Autowired
	private CorpSharecorpService corpSharecorpService;
	
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model,HttpServletRequest request){
		String shareno = request.getParameter("shareno");
		model.addAttribute("shareno", shareno);
		return "/mf/sys/shareholder/corp/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,CorpSharecorp corpSharecorp,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		String corpno = "CO" + StringUtil.getFormatDate(new Date(), "yyyyMMddHHmmss");
		corpSharecorp.setCorpno(corpno);
		corpSharecorpService.add(corpSharecorp);
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String list(Model model,HttpServletRequest request,String type){
		model.addAttribute("type", type);
		String shareno = request.getParameter("shareno");
		model.addAttribute("shareno", shareno);
		return "/mf/sys/shareholder/corp/list";
	}
	
	@RequestMapping(value = "showlist")
	@ResponseBody
	public Map<String, Object> showlist(Model model, CorpSharecorp corpSharecorp, HttpServletRequest request) {
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
		pageView = corpSharecorpService.query(pageView, corpSharecorp);
		List<CorpSharecorp> list = pageView.getRecords();
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
			corpSharecorpService.delete(ids);
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
	public String getById(Model model,String id,String type){
		model.addAttribute("type", type);
		CorpSharecorp corpsharecorp = corpSharecorpService.getById(id);
		model.addAttribute("corpsharecorp", corpsharecorp);
		return "/mf/sys/shareholder/corp/edit";
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Model model,CorpSharecorp corpSharecorp,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			corpSharecorpService.modify(corpSharecorp);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;		
		
	}
	
}

