/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.pubparam.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.json.Entity;
import com.mf.pubparam.entity.Industry;
import com.mf.pubparam.service.IndustryService;
/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/pubparam/industry/")
public class IndustryController {
	
	@Autowired
	private IndustryService industryService;
	
	
	/**
	 * 获取行业信息
	 * @param parentId
	 * @param List<Entity>
	 * @return
	 */
	@RequestMapping(value="getIndustryByCode")
	@ResponseBody
	public Map<String, List> getIndustry(String code, String tcode, Industry industry) {
		System.out.println("---------------code---------------"+code);
		System.out.println("---------------tcode---------------"+tcode);
		industry.setIndustryCode(code);
		industry.setTiercode(tcode);
		Entity entity;
		List<Industry> industries = industryService.queryIndustry(industry);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(Industry idst:industries){
			entity = new Entity();
			entity.setKey(idst.getIndustryName());
			entity.setValue(String.valueOf(idst.getIndustryCode()));
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
	/**
	 * 获取行业信息
	 * @param parentId
	 * @param List<Entity>
	 * @return
	 */
	@RequestMapping(value="getIndustryByTCode")
	@ResponseBody
	public Map<String, List> getIndustryByTCode(String tcode) {
		System.out.println("---------------tcode---------------"+tcode);
		Entity entity;
		List<Industry> industries = industryService.getByTCode(tcode);
		System.out.println("industries:"+industries);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(Industry idst:industries){
			System.out.println("key:"+idst.getIndustryName());
			System.out.println("value:"+idst.getIndustryCode());
			entity = new Entity();
			entity.setKey(idst.getIndustryName());
			entity.setValue(String.valueOf(idst.getIndustryCode()));
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
	
}

