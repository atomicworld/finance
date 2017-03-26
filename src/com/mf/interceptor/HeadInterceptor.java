package com.mf.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
public class HeadInterceptor implements Filter {
	
	private String loginPage;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest=(HttpServletRequest)request;		  
		HttpSession session = httpServletRequest.getSession();
		//判断用户session是否过期或是否登录
		String url=httpServletRequest.getServletPath();	
		
		String monitorValue =httpServletRequest.getParameter("MonitorValue");		   
		if( StringUtil.isNotEmpty(monitorValue) || url.indexOf("monitorMain.jsp")>=0) {
			//来自监管系统的url，放行
			session.setAttribute("operator", PubConstants.SuperAdmin);
			chain.doFilter(request, response);
		} else {			
			if(url.indexOf("login.html")>=0 || url.indexOf("login.jsp")>=0){ 
				chain.doFilter(request, response);
			} else if(url.indexOf("getTitle.html")>=0  ){ 
				chain.doFilter(request, response);
			}else{
				if (session!= null&&session.getAttribute("operator")!=null) {
					chain.doFilter(request, response);
				} else  {
					String name=httpServletRequest.getContextPath();
					String path=httpServletRequest.getRequestURL().toString();
					String port=httpServletRequest.getLocalPort()+"";
					String paths=path.substring(0,path.lastIndexOf(":")+1);
					HttpServletResponse httpresponse=(HttpServletResponse)response;
					httpresponse.sendRedirect(paths+port+name+loginPage+"?mess=true");
				}
			}
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException  {
		this.loginPage=filterConfig.getInitParameter("loginPage");
	}

	
}
