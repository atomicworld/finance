package com.mf.bsnsmng.controller;
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

import com.mf.bsnsmng.entity.Client;
import com.mf.bsnsmng.service.BsnsApplyService;
import com.mf.bsnsmng.service.ClientService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.org.entity.Operator;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;


/**
 * 客户列表
 * @author shengd
 * at 2014-12-16   
 */
@Controller
@RequestMapping(value = "/mf/client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	@Autowired
	private BsnsApplyService bsnsApplyService; 
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
    @RequestMapping(value="/list")
    public String getList(Model model,HttpServletRequest request){
    	return "/mf/bsnsmng/list";
    }
    
    @RequestMapping(value="/infoList")
    public String getInfoList(Model model,HttpServletRequest request){
    	String clntType = request.getParameter("clntType");
    	model.addAttribute("clntType", clntType);
     
    	return "/mf/bsnsmng/infoList";  
    }
        
    /**
	 * post方式分页查询 
	 * @param model
	 * @param combo
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,Client client,HttpServletRequest request){
//		//User u = (User)request.getSession().getAttribute("userSession");
		Operator user = (Operator)request.getSession().getAttribute("operator");
		
	    PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		/**
		 * cifType==1为个人客户cifType==2为企业客户
		 * tel==111000为test6用户
		 * 注：等到做登录之后，这些数据都是放在session里
		 */
		String clntName = request.getParameter("clntName");
    	String clntType = request.getParameter("clntType");
    	
		if(Common.isEmpty(clntType)){
			clntType="2";
		}
		if(Common.isEmpty(clntName)){
			  clntName="";
		}
		
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		//显示属于该登陆员工的客户信息列表
		client.setUserIdNum(user.getEmplyno());
		client.setClntType(clntType);
		client.setClntName(clntName);
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = clientService.query(pageView, client);
		List<Client> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	@RequestMapping(value="del")
	   public String del(Model model,HttpServletRequest request,HttpServletResponse response){
		   String result ="{\"status\":true,\"message\":\"删除成功！\"}";
		   try{
			   String clntid = request.getParameter("clntid");
			   int ishave1=bsnsApplyService.isHave(clntid);
			   int ishave2=bsnsCntrctService.isHave(clntid);
			   if(ishave1==0&&ishave2==0){
				   clientService.delete(clntid);
			   }else{
				   result ="{\"status\":true,\"message\":\"删除失败，系统中存在该客户相关信息！\"}";
			   }		
		   }catch(Exception e){
			   e.printStackTrace();
			   result ="{\"status\":false,\"message\":\"删除失败！\"}";
		   }
		  
		   WebTool.writeJson(result, response);
		   return null;
	   }
}
