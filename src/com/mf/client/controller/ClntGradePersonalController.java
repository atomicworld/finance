/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.client.controller;

import java.text.DecimalFormat;
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

import com.mf.client.entity.ClntGradePersonal;
import com.mf.client.service.ClntGradePersonalService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/clntgradepersonal/")
public class ClntGradePersonalController {
	
	@Autowired
	private ClntGradePersonalService clntGradePersonalService;
	
	   
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/clntgradepersonal/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntgradepersonal
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntGradePersonal clntgradepersonal,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			DecimalFormat df=new DecimalFormat("0.##");
			double base=Double.parseDouble(clntgradepersonal.getBase())*0.3*20;
			double occup =Double.parseDouble(clntgradepersonal.getOccup())*0.1*20;
			double vitae=Double.parseDouble(clntgradepersonal.getVitae())*0.05*20;
			double exprec=Double.parseDouble(clntgradepersonal.getExprec())*0.1*20;
			double asset=Double.parseDouble(clntgradepersonal.getAsset())*0.3*20;
			double safe=Double.parseDouble(clntgradepersonal.getSafe())*0.05*20;
			double tax=Double.parseDouble(clntgradepersonal.getTax())*0.05*20;
			double immasset =Double.parseDouble(clntgradepersonal.getImmasset())*0.05*20;
			double score=base+occup+vitae+exprec+asset+safe+tax+immasset;
			clntgradepersonal.setBase(df.format(base));
			clntgradepersonal.setOccup(df.format(occup));
			clntgradepersonal.setVitae(df.format(vitae));
			clntgradepersonal.setExprec(df.format(exprec));
			clntgradepersonal.setAsset(df.format(asset));
			clntgradepersonal.setSafe(df.format(safe));
			clntgradepersonal.setTax(df.format(tax));
			clntgradepersonal.setImmasset(df.format(immasset));
			clntgradepersonal.setScore(df.format(score));
			ClntGradePersonal grade=clntGradePersonalService.getById(clntgradepersonal.getClntno());
			if(grade!=null){
				clntGradePersonalService.modify(clntgradepersonal);
			}else{
				clntGradePersonalService.add(clntgradepersonal);
			}
			
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
	 * @param clntgradepersonal
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntGradePersonal clntgradepersonal,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntGradePersonalService.query(pageView, clntgradepersonal);
		List<ClntGradePersonal> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clntgradepersonalId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntGradePersonalService.delete(ids);
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
	 * @param clntgradepersonalId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String clntgradepersonalId,int typeKey){
		ClntGradePersonal clntgradepersonal = clntGradePersonalService.getById(clntgradepersonalId);
		model.addAttribute("clntgradepersonal", clntgradepersonal);
		if(typeKey == 1){
			return "/mf/clntgradepersonal/edit";
		}else if(typeKey == 2){
			return "/mf/clntgradepersonal/view";
		}else{
			return "/mf/clntgradepersonal/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clntgradepersonal
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntGradePersonal(Model model,ClntGradePersonal clntgradepersonal,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntGradePersonalService.modify(clntgradepersonal);
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
				clntGradePersonalService.delete(id);
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
		return "/mf/clntgradepersonal/upload";
	}
}

