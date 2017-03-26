/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.text.DecimalFormat;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.client.entity.ClntGradeCommerce;
import com.mf.client.service.ClntGradeCommerceService;
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
@RequestMapping(value="/mf/clntgradecommerce/")
public class ClntGradeCommerceController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private ClntGradeCommerceService clntGradeCommerceService;
	
	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}
	   
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/clntgradecommerce/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param clntgradecommerce
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,ClntGradeCommerce clntgradecommerce,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			DecimalFormat df=new DecimalFormat("0.##");
			double base=Double.parseDouble(clntgradecommerce.getBase())*0.2*20;
			double register =Double.parseDouble(clntgradecommerce.getRegister())*0.05*20;
			double bankinfo=Double.parseDouble(clntgradecommerce.getBankinfo())*0.1*20;
			double capital=Double.parseDouble(clntgradecommerce.getCapital())*0.15*20;
			double invest=Double.parseDouble(clntgradecommerce.getInvest())*0.05*20;
			double clique=Double.parseDouble(clntgradecommerce.getClique())*0.05*20;
			double manager=Double.parseDouble(clntgradecommerce.getManager())*0.1*20;
			double payinfo=Double.parseDouble(clntgradecommerce.getPayinfo())*0.3*20;
			double score=base+register+bankinfo+capital+invest+clique+manager+payinfo;
			clntgradecommerce.setBase(df.format(base));
			clntgradecommerce.setRegister(df.format(register));
			clntgradecommerce.setBankinfo(df.format(bankinfo));
			clntgradecommerce.setCapital(df.format(capital));
			clntgradecommerce.setInvest(df.format(invest));
			clntgradecommerce.setClique(df.format(clique));
			clntgradecommerce.setManager(df.format(manager));
			clntgradecommerce.setPayinfo(df.format(payinfo));
			clntgradecommerce.setScore(df.format(score));
			ClntGradeCommerce grade=clntGradeCommerceService.getById(clntgradecommerce.getClntno());
			if(grade!=null){
				clntGradeCommerceService.modify(clntgradecommerce);
			}else{
				clntGradeCommerceService.add(clntgradecommerce);
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
	 * @param clntgradecommerce
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,ClntGradeCommerce clntgradecommerce,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clntGradeCommerceService.query(pageView, clntgradecommerce);
		List<ClntGradeCommerce> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param clntgradecommerceId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			clntGradeCommerceService.delete(ids);
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
	 * @param clntgradecommerceId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String clntgradecommerceId,int typeKey){
		ClntGradeCommerce clntgradecommerce = clntGradeCommerceService.getById(clntgradecommerceId);
		model.addAttribute("clntgradecommerce", clntgradecommerce);
		if(typeKey == 1){
			return "/mf/clntgradecommerce/edit";
		}else if(typeKey == 2){
			return "/mf/clntgradecommerce/view";
		}else{
			return "/mf/clntgradecommerce/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param clntgradecommerce
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateClntGradeCommerce(Model model,ClntGradeCommerce clntgradecommerce,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			clntGradeCommerceService.modify(clntgradecommerce);
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
				clntGradeCommerceService.delete(id);
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
		return "/mf/clntgradecommerce/upload";
	}
	
	
}

