/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */


package com.mf.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntGradeCommerce;
import com.mf.client.entity.ClntGradePersonal;
import com.mf.client.entity.ClntPersonEvaluate;
import com.mf.client.service.ClntClientService;
import com.mf.client.service.ClntGradeCommerceService;
import com.mf.client.service.ClntGradePersonalService;
import com.mf.client.service.ClntPersonEvaluateService;
/**
 * @author xujiuhua
 * @2014-12-18
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/client/clntpersonevaluate/")
public class ClntPersonEvaluateController {
	
	@Autowired
	private ClntPersonEvaluateService clntPersonEvaluateService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private ClntGradePersonalService clntGradePersonalService;
	@Autowired
	private ClntGradeCommerceService clntGradeCommerceService;
	
	
	   
	//wyy
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(个人客户评估) 
	 * @param @param model
	 * @param @param clntno
	 * @param @return 设定文件 
	 * @date 2015-5-19
	 */ 
	@RequestMapping(value="getByClntnoPerson")
	public String getByClntnoPerson(Model model,String clntno){
		ClntClient clntClient = clntClientService.getById(clntno);
		model.addAttribute("clntClient", clntClient);
		ClntGradePersonal grade=clntGradePersonalService.getById(clntno);
		if(grade!=null){
			double base=Double.parseDouble(grade.getBase())/3/2;
			double occup =Double.parseDouble(grade.getOccup())/1/2;
			double vitae=Double.parseDouble(grade.getVitae())/0.5/2;
			double exprec=Double.parseDouble(grade.getExprec())/1/2;
			double asset=Double.parseDouble(grade.getAsset())/3/2;
			double safe=Double.parseDouble(grade.getSafe())/0.5/2;
			double tax=Double.parseDouble(grade.getTax())/0.5/2;
			double immasset =Double.parseDouble(grade.getImmasset())/0.5/2;
			grade.setBase(String.valueOf(base));
			grade.setOccup(String.valueOf(occup));
			grade.setVitae(String.valueOf(vitae));
			grade.setExprec(String.valueOf(exprec));
			grade.setAsset(String.valueOf(asset));
			grade.setSafe(String.valueOf(safe));
			grade.setTax(String.valueOf(tax));
			grade.setImmasset(String.valueOf(immasset));			
		}
		model.addAttribute("grade",grade);//客户等级评估星级显示
		return "/mf/clientmng/clntinfo/clntperson/clntpersonevaluate/view";
	}
	//wyy
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(获得对公客户的分数评估) 
	 * @param @param model
	 * @param @param clntno
	 * @param @return 设定文件 
	 * @date 2015-5-19
	 */ 
	@RequestMapping(value="getByClntno")
	public String getByClntno(Model model,String clntno){
		ClntClient clntClient = clntClientService.getById(clntno);
		model.addAttribute("clntClient", clntClient);
		
		ClntGradeCommerce grade=clntGradeCommerceService.getById(clntno);
		if(grade!=null){
			double base=Double.parseDouble(grade.getBase())/2/2;
			double register   =Double.parseDouble(grade.getRegister())/0.5/2;
			double bankinfo =Double.parseDouble(grade.getBankinfo())/1/2;
			double capital =Double.parseDouble(grade.getCapital())/1.5/2;
			double invest =Double.parseDouble(grade.getInvest())/0.5/2;
			double clique =Double.parseDouble(grade.getClique())/0.5/2;
			double manager	=Double.parseDouble(grade.getManager())/1/2;
			double payinfo =Double.parseDouble(grade.getPayinfo())/3/2;
			grade.setBase(String.valueOf(base));
			grade.setRegister(String.valueOf(register));
			grade.setBankinfo(String.valueOf(bankinfo));
			grade.setCapital(String.valueOf(capital));
			grade.setInvest(String.valueOf(invest));
			grade.setClique(String.valueOf(clique));
			grade.setManager(String.valueOf(manager));
			grade.setPayinfo(String.valueOf(payinfo));
		}
		model.addAttribute("grade",grade);//客户等级评估星级显示
		return "/mf/clientmng/clntinfo/clntee/clnteerel/view";
	}
}

