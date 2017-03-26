package com.mf.org.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.util.StringUtil;
import com.mf.org.entity.Dept;
import com.mf.org.entity.Operator;
import com.mf.org.service.impl.OperatorServiceImpl;
import com.mf.util.Common;
import com.mf.util.ConvertUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/org/operator")
public class OperatorController {

	@Autowired
	OperatorServiceImpl operatorService;	
	
	@RequestMapping(value = "/toList.html")
	public String list() {
		return "/mf/org/operator/operator_list";
	}
	
	@RequestMapping(value = "/getOperatorPagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getOperatorPagerList(Model model,
			HttpServletRequest request,Operator operator) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		
		List list =operatorService.query(pageView, operator);
		map.put("rows", list);
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	
	@RequestMapping(value = "/toAddOperator.html")
	public String toAddOperator(HttpServletRequest request) {
		request.setAttribute("operatorEntity", new com.mf.org.entity.Operator());
		return "/mf/org/operator/operator_add";
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/addOperator.html")
	@ResponseBody
	public Map addOperator(HttpServletRequest request,Operator operator){
		HashMap resultMap=new HashMap();
		try{			
			operator.setPwd(ConvertUtil.getMd5(operator.getPwd()));
			operatorService.add(operator);
			resultMap.put("resCode", "1");
			resultMap.put("resDesc", "操作成功!");
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("resCode", "1");
			resultMap.put("resDesc", "操作失败！"+e.getMessage());
		}
		
		return resultMap;
	}
	
	
	@RequestMapping(value = "/toUpdateOperator.html")
	public String toUpdateOperator(HttpServletRequest request){
		String id=request.getParameter("id");
		Operator operator =null;
		try{
		    operator =operatorService.getById(id);
		}catch(Exception e){
			e.printStackTrace();
		}		
		request.setAttribute("operatorEntity", operator);		
		
		return "/mf/org/operator/operator_add";
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/updateOperator.html")
	@ResponseBody
	public Map updateOperator(HttpServletRequest request,Operator operator){
		HashMap resultMap=new HashMap();
		try{			
			operator.setPwd(ConvertUtil.getMd5(operator.getPwd()));
			operatorService.modify(operator);
			resultMap.put("resCode", "1");
			resultMap.put("resDesc", "操作成功!");
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("resCode", "1");
			resultMap.put("resDesc", "操作失败!"+e.getMessage());
		}		
		return resultMap;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getAllOperators.html")
	@ResponseBody
	public List getAllOperators() {
		Operator op=new Operator();
		List<Operator> list  = operatorService.queryAll(op);
		List resultList=new ArrayList();
		if(list!=null&&list.size()>0){
			for(Operator operator:list){
				Map map=new HashMap();
				map.put("key", operator.getOpnm());//表明为显示的key
				map.put("value", operator.getEmplyno());//表明实际value
				resultList.add(map);
			}
		}		
		return resultList;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getOperators.html")
	@ResponseBody
	public List getOperators() {
		//查找操作员（不包括管理员）
		Operator op=new Operator();
		List<Operator> list  = operatorService.getOperators(op);
		List resultList=new ArrayList();
		if(list!=null&&list.size()>0){
			for(Operator operator:list){
				Map map=new HashMap();
				map.put("key", operator.getOpnm());//表明为显示的key
				map.put("value", operator.getEmplyno());//表明实际value
				resultList.add(map);
			}
		}		
		return resultList;
	}
	
	/**
	 * 获取操作员姓名
	 * by shengd 2015-03-16
	 */
	
	@RequestMapping(value="getOpnm")
	public String getOpnm(Model model, HttpServletRequest request ,HttpServletResponse response ){
		
		String opno = request.getParameter("opno");//操作员编号
		Operator operator=operatorService.getOpnm(opno);    
	    String opnm = operator.getOpnm();
	    String result = "{\"status\":true,\"message\":\""+opnm+"\"}";
	    
	     WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 根据员工编号删除操作员 by chenkk
	 */
	@RequestMapping(value="del")
	@ResponseBody
	public Map delOp(HttpServletRequest request,Operator operator){
		HashMap resultMap=new HashMap();
		try{
			if(StringUtil.isEmpty(operator.getEmplyno())){
				resultMap.put("resCode", "0");
				resultMap.put("resDesc", "操作员编号为空!");
			}else{
				//判断操作员是否满足删除条件
				int canBeDel = operatorService.isCanBeDel(operator.getEmplyno());
				if(canBeDel == 1){
					operatorService.delete(operator.getEmplyno());
					resultMap.put("resCode", "1");
					resultMap.put("resDesc", "删除成功！");
				}else if(canBeDel == 2){
					resultMap.put("resCode", "2");
					resultMap.put("resDesc", "请首先将其从客户经理列表中移除.");
				}else if(canBeDel == 3){
					resultMap.put("resCode", "3");
					resultMap.put("resDesc", "请首先将其从审批人员列表中移除.");
				}else if(canBeDel == 4){
					resultMap.put("resCode", "4");
					resultMap.put("resDesc", "该操作员名下还有管理的客户.");
				}				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("resCode", "0");
			resultMap.put("resDesc", "操作失败！"+e.getMessage());
		}	
		return resultMap;
	}
	
	/**
	 * 更新操作员启用/停用状态 by chenkk
	 */
	@RequestMapping(value="changeUsed")
	@ResponseBody
	public Map changeUsed(HttpServletRequest request,Operator operator){
		HashMap resultMap=new HashMap();
		try{
			if(StringUtil.isEmpty(operator.getEmplyno())){
				resultMap.put("resCode", "0");
				resultMap.put("resDesc", "操作员编号为空!");
			}else{
				operatorService.changeUsed(operator);
				resultMap.put("resCode", "1");
				resultMap.put("resDesc", "操作成功！");				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			resultMap.put("resCode", "0");
			resultMap.put("resDesc", "操作失败！"+e.getMessage());
		}	
		return resultMap;
	}
	
	//检查登录账号是否已存在  - chenkk
	@RequestMapping(value="isacctexist")
	public String isAcctExist(Model model, HttpServletRequest request ,HttpServletResponse response){
		String result = "{\"validateResult\":{\"valid\":false}}";
		String acct = request.getParameter("validateValue");
		if(!StringUtil.isEmpty(acct)){
			int count = operatorService.countByAcct(acct);
			if(count == 0){
				//不存在
				result = "{\"validateResult\":{\"valid\":false}}";
			}else{
				result = "{\"validateResult\":{\"valid\":true}}";
			}
		}
		WebTool.writeJson(result, response);
		return null;
	}

	@RequestMapping(value = "toChgpwdUI")
	public String chgpwdUI(HttpServletRequest request) {
		Operator operator = (Operator)request.getSession().getAttribute("operator");
		
		if(operator != null){
			request.setAttribute("operator", operator);
		}
		return "/mf/org/operator/chgpwdUI";
	}
	
	@RequestMapping(value="chgpwd")
	public String changePwd(Operator operator,HttpServletResponse response){
		String result="{\"msg\":\"suc\"}";
		try {			
			operator.setPwd(ConvertUtil.getMd5(operator.getPwd()));
			operatorService.changePwd(operator);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}"; //WebTool.getErrorMsg(e.getMessage())
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	} 
	
	@RequestMapping(value="getDept")
	public String getDept(Model model, HttpServletRequest request ,HttpServletResponse response ){
		
		String opno = request.getParameter("opno");//操作员编号
		Operator operator=operatorService.getOpnm(opno);    
	    String result = "{\"status\":true,\"message\":\""+operator.getDptno()+"\"}";
	    
	     WebTool.writeJson(result, response);
		 return null;
	}
}
