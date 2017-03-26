package com.mf.base.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 管理sys模块左侧页面加载
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/mf/base")
public class BaseLeftController {

	@RequestMapping(value="/left.html")
	public String left(HttpServletRequest request){
		String mid = request.getParameter("mid");
		return "/mf/" + mid + "/left";
	}
}
