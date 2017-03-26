package com.mf.businessParam.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.businessParam.entity.LoanUse;
import com.mf.businessParam.service.impl.LoanUseServiceImpl;
import com.mf.sys.service.SysLogService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value = "/mf/businessParam/loanUse")
public class LoanUseController {

	private static final Logger logger = Logger.getLogger(LoanUseController.class);

	@Autowired
	LoanUseServiceImpl loanUseService;
	@Autowired
	SysLogService syslogservice;

	@RequestMapping(value = "/toLoanUseList.html")
	public String list() {
		return "/mf/businessParam/loanUse/loanUse_list";
	}

	@RequestMapping(value = "/getLoanUsePagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getLoanUsePagerList(Model model, LoanUse LoanUse,
			HttpServletRequest request) {

		PageView pageView = null;
		String pageNow = "1";
		String pageSize ="10000";//设置为大数
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}

		pageView = loanUseService.query(pageView, LoanUse);
		List<LoanUse> list = pageView.getRecords();
		
		
		List resultLoanUse=new ArrayList();
		//对查询的列表进行数据处理
		for(LoanUse loanUse:list){
			if("0".equals(loanUse.getFrstfthr())){
				dealWithSonLoanUseList(loanUse,list);
				resultLoanUse.add(loanUse);
			}
		}
		
		Map resultMap = new HashMap();
 		resultMap.put("rows", resultLoanUse);
 		resultMap.put("resCode", "1");
 		
		return resultMap;
	}
	
	private void dealWithSonLoanUseList(LoanUse loanUse,List<LoanUse> list){
		//第一次为第一层进入
		String loanUseNo=loanUse.getUseno();
		List<LoanUse> sonLoanUseList=new ArrayList<LoanUse>();
		for(int i=0;i<list.size();i++){
			LoanUse loanUseL1=list.get(i);
			if(loanUseNo.equals(loanUseL1.getFrstfthr())){
				dealWithSonLoanUseList(loanUseL1, list);
				sonLoanUseList.add(loanUseL1);
			}
		}
		
		loanUse.setSonLoanUseList(sonLoanUseList);
	}
	
	

	@RequestMapping(value = "/toLoanUseAdd.html")
	public String toAddLoanUse(HttpServletRequest request) {
		String upUseNo=request.getParameter("upUseNo");
		LoanUse upLoanUse=loanUseService.getById(upUseNo);
		request.setAttribute("upLoanUse", upLoanUse);
		LoanUse loanuse= new LoanUse();
		loanuse.setLvl((Integer.parseInt(upLoanUse.getLvl())+1)+"");
		loanuse.setUseno(upUseNo);
		int Maxuseno=loanUseService.queryMaxLen(loanuse);
		loanuse.setLvl(loanuse.getLvl());//设置等级
		if(Maxuseno<10){
			upUseNo=upUseNo+"0"+Maxuseno;
		}else{
			upUseNo=upUseNo+Maxuseno;
		}
		loanuse.setUseno(upUseNo);
		request.setAttribute("newLoanUse", loanuse);
		logger.info("toAddLoanUse upUseNo:"+upUseNo);
		syslogservice.logger("add", "LoanUseController", "LoanUse", "添加用途节点", request);
		return "/mf/businessParam/loanUse/loanUse_add";
	}

	// 绑定参数
	@InitBinder("LoanUse")
	public void initBinderLoanUse(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("LoanUse.");
	}
	
	/**
	* @author wangyaowei
	* @date 2015-4-8上午1:15:17
	* @Title: addLoanUse
	* @Description: TODO(保存节点)
	* @param model
	* @param loanUse
	* @param response
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="addLoanUse")
	public String addLoanUse(Model model,LoanUse loanUse,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			loanUse.setIsbttm("1");
			loanUseService.add(loanUse);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	* @author wangyaowei
	* @date 2015-4-8上午2:03:14
	* @Title: delLoanUse
	* @Description: TODO(删除节点)
	* @param model
	* @param loanUse
	* @param response
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="delLoanUse")
	public String delLoanUse(Model model,LoanUse loanUse,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\",\"info\":\"删除成功！\"}";
		try {
			LoanUse up=loanUseService.getById(loanUse.getFrstfthr());
			int ishave=loanUseService.queryMaxLen(up);
			if(ishave>2){
				result="{\"msg\":\"suc\",\"info\":\"存在子节点无法删除！\"}";
			}else{
				loanUseService.delete(loanUse.getUseno());
			}
			
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	/**
	* @author wangyaowei
	* @date 2015-4-8上午1:43:00
	* @Title: toEditLoanUse
	* @Description: TODO(跳转到修改页面)
	* @param request
	* @param model
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value = "/toEditLoanUse.html")
	public String toEditLoanUse(HttpServletRequest request, Model model) {
		String useno=request.getParameter("useno");
		//查询当前用途信息
		LoanUse loanUse=loanUseService.getById(useno);
		request.setAttribute("loanUse", loanUse);
		//查询他上级用途
		LoanUse upLoanUse=loanUseService.getById(loanUse.getFrstfthr());
		request.setAttribute("upLoanUse", upLoanUse);
		return "/mf/businessParam/loanUse/loanUse_edit";
		
	}

	
	/**
	* @author wangyaowei
	* @date 2015-4-8上午1:59:59
	* @Title: editLoanUse
	* @Description: TODO(保存修改)
	* @param model
	* @param loanUse
	* @param response
	* @param request
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="editLoanUse")
	public String editLoanUse(Model model,LoanUse loanUse,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			loanUseService.modify(loanUse);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	
	
	/**
	* @author wangyaowei
	* @date 2015-4-8上午2:01:13
	* @Title: root
	* @Description: TODO(根目录)
	* @param model
	* @param loanuse
	* @param request
	* @return
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value = "/root.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> root(Model model, LoanUse loanuse,HttpServletRequest request) {
		loanuse.setLvl("1");
		List<LoanUse> list=loanUseService.queryLvl(loanuse);
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<list.size();i++){
			sb.append("<tr id=\"ajaxnode-"+list.get(i).getUseno()+"\" url=\""+request.getSession().getServletContext().getContextPath()+"/mf/businessParam/loanUse/rootStream.html?childNode="+list.get(i).getUseno()+"&lvl="+list.get(i).getLvl()+"\">");
			sb.append("<td><span class=\"folder\">"+list.get(i).getUseno()+"</span></td>");
			sb.append("<td>"+list.get(i).getUsenm()+"</td>");
			sb.append("<td><a href=\"javaScript:add('"+list.get(i).getUseno()+"');\">新增</a>&nbsp;&nbsp;<a href=\"javaScript:edit('"+list.get(i).getUseno()+"');\">编辑</a>&nbsp;&nbsp;<a href=\"javaScript:del('"+list.get(i).getUseno()+"');\">删除</a></td> ");
			sb.append("</tr>");
		}
		Map resultMap = new HashMap();
 		resultMap.put("rows", sb);
 		resultMap.put("resCode", "1");
		return resultMap;
	}

	
	/**
	* @author wangyaowei
	* @date 2015-4-3下午4:35:03
	* @Title: rootStream
	* @Description: TODO(tabeltree返回字符串)
	* @param model
	* @param LoanUse
	* @param response
	* @param request
	* @return void    返回类型
	* @throws
	*/
	@RequestMapping(value = "/rootStream.html")
	public void rootStream(Model model, LoanUse loanuse,HttpServletResponse response,HttpServletRequest request) {
		String node=request.getParameter("childNode");
		String lvl=request.getParameter("lvl");
		int zoom=Integer.parseInt(lvl)+1;
		loanuse.setLvl((Integer.parseInt(lvl)+1)+"");
		loanuse.setUseno(node);
		List<LoanUse> list=loanUseService.queryLvl(loanuse);
		String ico="class=\"folder\"";
		
		StringBuffer sb=new StringBuffer();
		if(zoom==4){
			ico="class=\"file\"";
			for(int i=0;i<list.size();i++){
				sb.append("<tr id=\"ajaxnode-"+list.get(i).getUseno()+"\" class=\"child-of-ajaxnode-"+node+"\" >");
				sb.append("<td><span "+ico+">"+list.get(i).getUseno()+"</span></td>");
				sb.append("<td>"+list.get(i).getUsenm()+"</td>");
				sb.append("<td><a href=\"javaScript:edit('"+list.get(i).getUseno()+"');\">编辑</a>&nbsp;&nbsp;<a href=\"javaScript:del('"+list.get(i).getUseno()+"');\">删除</a></td> ");
				sb.append(" </tr>");
			}
		}else{
			for(int i=0;i<list.size();i++){
				if("1".equals(list.get(i).getIsbttm().toString())){
					ico="class=\"file\"";
				}
				sb.append("<tr id=\"ajaxnode-"+list.get(i).getUseno()+"\" class=\"child-of-ajaxnode-"+node+"\" url=\""+request.getSession().getServletContext().getContextPath()+"/mf/businessParam/loanUse/rootStream.html?childNode="+list.get(i).getUseno()+"&lvl="+list.get(i).getLvl()+"\">");
				sb.append("<td><span "+ico+">"+list.get(i).getUseno()+"</span></td>");
				sb.append("<td>"+list.get(i).getUsenm()+"</td>");
				sb.append("<td><a href=\"javaScript:add('"+list.get(i).getUseno()+"');\">新增</a>&nbsp;&nbsp;<a href=\"javaScript:edit('"+list.get(i).getUseno()+"');\">编辑</a>&nbsp;&nbsp;<a href=\"javaScript:del('"+list.get(i).getUseno()+"');\">删除</a></td> ");
				sb.append("</tr>");
			}
		}
		
		String content=sb.toString();
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("type=text/html;charset=UTF-8");
			response.getWriter().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}

}
