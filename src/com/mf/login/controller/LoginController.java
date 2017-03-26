package com.mf.login.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.org.entity.Operator;
import com.mf.login.service.LoginService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.SysLogService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.Common;
import com.mf.util.SysParamUtil;
import com.mf.util.WebTool;
import com.mf.util.ikeyTools;

@Controller
@RequestMapping(value="/syslogin")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private SysLogService syslogService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	
	@RequestMapping(value="/login.html")
	@ResponseBody
	public void login(Operator operator, HttpServletRequest request, HttpServletResponse response){
		String result = null;	
		int checkRslt = loginService.checkUser(operator);
		if(checkRslt == PubConstants.LOGIN_NOTEXIST){
			result="{\"status\":false,\"message\":\"用户名不存在!\"}";
			
			syslogService.logger("系统登录尝试", operator.getVpnacct() + "用户名不存在", "operator", "无", request);
		}else if(checkRslt == PubConstants.LOGIN_NOTINUSE){
			result="{\"status\":false,\"message\":\"操作员已被停用!\"}";
			
			syslogService.logger("系统登录尝试", operator.getVpnacct() + "操作员已被停用", "operator", "无", request);
		}else if(checkRslt == PubConstants.LOGIN_NOTINPOS){
			result="{\"status\":false,\"message\":\"操作员已离职!\"}";
			
			syslogService.logger("系统登录尝试", operator.getVpnacct() + "操作员已离职", "operator", "无", request);
		}else if(checkRslt == PubConstants.LOGIN_DYNMPWDERR){
			result="{\"status\":false,\"message\":\"动态口令错误!\"}";
			
			syslogService.logger("系统登录尝试", operator.getVpnacct() + "动态口令错误", "operator", "无", request);
		}else if(checkRslt == PubConstants.LOGIN_STTCPWDERR){
			result="{\"status\":false,\"message\":\"密码错误!\"}";
			
			syslogService.logger("系统登录尝试", operator.getVpnacct() + "密码错误", "operator", "无", request);
		}else if(checkRslt == PubConstants.LOGIN_MULTIUSER){
			result="{\"status\":false,\"message\":\"多名操作员拥有相同的登录名和密码!\"}";
			
			syslogService.logger("系统登录尝试", operator.getVpnacct() + "多名操作员拥有相同的登录名和密码", "operator", "无", request);
		}else if(checkRslt == PubConstants.LOGIN_SUCCESS){ 
			
			String keys = request.getParameter("keys");
			//判断是否需要令牌认证
			if ("1".equals(keys) && !Common.isEmpty(keys)) {
				//取出ikey
				String ikey = request.getParameter("ikey");
				//取出当前登陆账号对应的令牌串号
				String acct = SysParamUtil.getParam(operator.getVpnacct());
				//令牌验证
				ikeyTools tools = new ikeyTools();
				int res = tools.CheckIkey(acct, ikey);
				
				//如果返回结果小于0，代表失败
				if (res < 0) {
					//设置错误信息
					result="{\"status\":false,\"message\":\""+SysParamUtil.getParam(res+"")+"\"}";
				}else {
					result="{\"status\":true,\"message\":\"登陆成功\"}";
					//登陆成功后,向session中写入内容
					loginService.setSeesionCntnt(request, operator);
					
					syslogService.logger("系统登录尝试", operator.getVpnacct() + "登录成功", "operator", " ", request);				
				}
			//不需要认证直接返回结果
			}else {
				result="{\"status\":true,\"message\":\"登陆成功\"}";
				//登陆成功后,向session中写入内容
				loginService.setSeesionCntnt(request, operator);
				
				syslogService.logger("系统登录尝试", operator.getVpnacct() + "登录成功", "operator", " ", request);
			}
			
		}else { 
			result="{\"status\":false,\"message\":\"请确认登录信息是否输入正确.\"}";
			
			syslogService.logger("系统登录尝试", operator.getVpnacct() + "其他原因导致登录异常", "operator", "无", request);
		}
		
		
		
		
		WebTool.writeJson(result, response);
	}
	
	 /**
	 * @param model
	 * @param request
	 * @return
	 * 退出系统
	 */
	@RequestMapping(value="/login_classic.html")
	   public String ApplicationList(Model model,HttpServletRequest request){
				//request.getSession().removeAttribute("operator");
				if(null==request.getSession(false)){
					if(true==request.getSession(true).isNew()){
						request.getSession().removeAttribute("operator");
					}else{
						
					}
				}
		       return "redirect:/system/login/login.jsp";
	   }
	@RequestMapping(value="/getTitle.html")
	@ResponseBody
	public void getTitle(HttpServletRequest request, HttpServletResponse response){
		String result="{\"msg\":false,\"message\":\"未设置公司名称\"}";;
		 try{
			 CompanyInfo companyInfo=new CompanyInfo();
			 companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			 if(companyInfo!=null)
				 result="{\"msg\":true,\"message\":\""+companyInfo.getCmpnm()+"\"}";
			}catch(Exception e){
				result="{\"msg\":false,\"message\":\"未设置公司名称\"}";
				e.printStackTrace();
			}
			WebTool.writeJson(result, response);
		}
}
