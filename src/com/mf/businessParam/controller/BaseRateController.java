package com.mf.businessParam.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ibm.icu.text.SimpleDateFormat;
import com.mf.businessData.entity.RateHistory;
import com.mf.businessData.service.impl.RateHistoryServiceImpl;
import com.mf.businessParam.entity.BaseRate;
import com.mf.businessParam.service.impl.BaseRateServiceImpl;
import com.mf.json.Entity;
import com.mf.util.Common;
import com.mf.util.PageView;

@Controller
@RequestMapping(value = "/mf/businessParam/baseRate")
public class BaseRateController {

	private static final Logger logger = Logger
			.getLogger(BaseRateController.class);

	@Autowired
	BaseRateServiceImpl baseRateService;
	
	@Autowired
    RateHistoryServiceImpl  rateHistoryService;


	@RequestMapping(value = "/toBaseRateList.html")
	public String list() {
		return "/mf/businessParam/baseRate/baseRate_list";
	}
	
	
	
	
	

	@RequestMapping(value = "/getBaseRatePagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getBaseRatePagerList(Model model, BaseRate BaseRate,
			HttpServletRequest request) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}

		pageView = baseRateService.query(pageView, BaseRate);
		List list = pageView.getRecords();

		Map resultMap = new HashMap();
 		resultMap.put("rows", list);
		resultMap.put("pager.pageNo", Integer.valueOf(1));
		resultMap.put("pager.totalRows", Long.valueOf(50));
		return resultMap;
	}
	
	
	@RequestMapping(value = "/toRateHistoryList.html")
	public String toRateHistoryList(HttpServletRequest request) {
		//rtno
		String rtno=request.getParameter("rtno");
		request.setAttribute("rtno", rtno);
		return "/mf/businessParam/baseRate/rateHistory_list";
	}
	
	
	@RequestMapping(value = "/getRateHistoryPagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getRateHistoryPagerList(Model model, 
			HttpServletRequest request) {
		String rtno=request.getParameter("rtno");
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}

	    RateHistory rateHistory=new RateHistory();
	    //rtno
	    rateHistory.setRtno(rtno);
		pageView =rateHistoryService.query(pageView, rateHistory);
		List list = pageView.getRecords();

		Map resultMap = new HashMap();
 		resultMap.put("rows", list);
		resultMap.put("pager.pageNo", Integer.valueOf(1));
		resultMap.put("pager.totalRows", Long.valueOf(50));
		return resultMap;
	}

	
//	// 绑定参数
//	@InitBinder("BaseRate")
//	public void initBinderBaseRate(WebDataBinder binder) {
//		binder.setFieldDefaultPrefix("baseRate.");
//	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delBaseRate.html")
	@ResponseBody
	public Map<String, Object> delBaseRate(HttpServletRequest request) {
		String BaseRateId = request.getParameter("BaseRateId");
		Map resultMap = new HashMap();
		try {
			baseRateService.delete(BaseRateId);
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}

		return resultMap;
	}

	@RequestMapping(value = "/toEditBaseRate.html")
	public String toEditBaseRate(HttpServletRequest request, Model model) {
		
		String objId=request.getParameter("id");
		BaseRate baseRate=baseRateService.getById(objId);
		model.addAttribute("baseRate", baseRate);

		return "/mf/businessParam/baseRate/baseRate_edit";
		
	}

	@RequestMapping(value = "/editBaseRate.html")
	@ResponseBody
	public Map<String, Object> editBaseRate(BaseRate baseRate) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
			baseRateService.modify(baseRate);
			
			RateHistory rateHistory=new RateHistory();
			rateHistory.setRtno(baseRate.getRtno());
			rateHistory.setAdjdate(sdf.format(new Date()));
			rateHistory.setRate(baseRate.getBasert());
			rateHistory.setType(baseRate.getRtyp());
			rateHistory.setUpperlmt(baseRate.getMaxexe());
			rateHistory.setLowerlmt(baseRate.getMinexe());
		
			rateHistoryService.add(rateHistory);
			
			resultMap.put("resCode", "1");
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("resCode", "-1");
			resultMap.put("resDesc", e.getMessage());
		}
		return resultMap;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getType")
	@ResponseBody
	public Map<String, List> getType(String code, HttpServletRequest request){
		//字典类型编码
		String month = request.getParameter("month");
		Entity entity;
		List<BaseRate> 	baserate= baseRateService.getType(month);
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(BaseRate sd : baserate){
			entity = new Entity();
			entity.setKey(sd.getBasert());
			entity.setValue(sd.getRtno());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}

}
