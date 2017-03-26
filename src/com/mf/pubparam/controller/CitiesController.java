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
import com.mf.pubparam.entity.Cities;
import com.mf.pubparam.service.CitiesService;
/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/sys/cities/")
public class CitiesController {
	
	@Autowired
	private CitiesService citiesService;
	
	/**
	 * 获取城市信息
	 * @param parentId
	 * @param List<Entity>
	 * @return
	 */
	@RequestMapping(value="getCity")
	@ResponseBody
	public Map<String, List> getCitybyParentId(String parentId) {
		Entity entity;
		List<Cities> citys = citiesService.getCitybyParentId(parentId);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(Cities c:citys){
			entity = new Entity();
			entity.setKey(c.getName());
			entity.setValue(String.valueOf(c.getId()));
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
	
}

