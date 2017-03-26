package com.mf.cntrtmng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mf.cntrtmng.entity.*;
import com.mf.cntrtmng.service.*;

import java.util.*;

@Controller
@RequestMapping(value="/mf/history/")
public class HistoryController {
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	
	//@Autowired
	//private BsnsCntrctService bsnsCntrctService;
	
	@RequestMapping(value="/list.html")
	public String showBillListForPlan(){
		return "/mf/cntrtmng/history/billlistforplan";
	}
	
	@RequestMapping(value="/showplan.html")
	public String showPlan(Model model,String dueno, HttpServletRequest request){
		//由dueno查询借据信息,借据信息通过对象传递到前台 - TBD
		
		String hkr = request.getParameter("hkr");
		
		//同时计算默认的还款计划
		List<BsnsRepayplan> planlist = bsnsRepayplanService.createDefaultPlan(dueno, hkr);
		model.addAttribute("planlist", planlist);
		
		return "/mf/cntrtmng/history/showplan";
	}
}
