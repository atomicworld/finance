/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.controller;

import java.math.BigDecimal;
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

import com.mf.flowmng.entity.FlowIncreaseCapital;
import com.mf.flowmng.service.FlowIncreaseCapitalService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.SysDictionaryService;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author wangzhi
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value = "/mf/increasecapital/")
public class FlowIncreaseCapitalController {
	// 默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null;

	@Autowired
	private FlowIncreaseCapitalService flowIncreaseCapitalService;
	@Autowired
	private CompanyInfoServiceImpl companyInfoServiceImpl;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	@RequestMapping(value = "capitalPage")
	public String capitalPage() {
		return "/mf/flowmng/increasecapital/capitalList";
	}

	/**
	 * 提供list展示界面的数据
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "query")
	@ResponseBody
	public Map<String, Object> showList(Model model,FlowIncreaseCapital flowIncreaseCapital, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		pageView = flowIncreaseCapitalService.query(pageView,flowIncreaseCapital);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}

	@RequestMapping(value = "view")
	public String view(int id, Model model) {
		FlowIncreaseCapital flowIncreaseCapital = flowIncreaseCapitalService.getById(id);
		CompanyInfo companyInfo = companyInfoServiceImpl.getCompanyInfo(new CompanyInfo());
		model.addAttribute("companyInfo", companyInfo);
		model.addAttribute("flowIncreaseCapital",flowIncreaseCapital);
		return "/mf/flowmng/increasecapital/capitalview";
	}

	@RequestMapping(value = "addUI")
	public String addUI(Model model) {
		CompanyInfo companyInfo = companyInfoServiceImpl.getCompanyInfo(new CompanyInfo());
		model.addAttribute("companyInfo", companyInfo);
		return "/mf/flowmng/increasecapital/capitaladd";
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public String add(FlowIncreaseCapital flowIncreaseCapital, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		//BigDecimal afterAmount = flowIncreaseCapital.getBeforeCapital().add(flowIncreaseCapital.getIncreaseAmount());
			
		CompanyInfo companyInfo = companyInfoServiceImpl.getCompanyInfo(new CompanyInfo());
		BigDecimal bigDecimal = BigDecimal.valueOf(Long.parseLong(companyInfo.getCmpcptlamnt())).add(flowIncreaseCapital.getIncreaseAmount());
		String cmpcptlamnt = bigDecimal.toString();
		companyInfo.setCmpcptlamnt(cmpcptlamnt);
		System.out.println("增资后金额:"+cmpcptlamnt);
		flowIncreaseCapital.setAfterAmount(bigDecimal);
		try {
				companyInfoServiceImpl.update(companyInfo);
				flowIncreaseCapitalService.add(flowIncreaseCapital);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	@RequestMapping(value = "editUI")
	public String editUI(int id,Model model) {
		FlowIncreaseCapital flowIncreaseCapital = flowIncreaseCapitalService.getById(id);
		CompanyInfo companyInfo = companyInfoServiceImpl.getCompanyInfo(new CompanyInfo());
		model.addAttribute("companyInfo", companyInfo);
		model.addAttribute("flowIncreaseCapital",flowIncreaseCapital);
		return "/mf/flowmng/increasecapital/capitalEdit";
	}
	@RequestMapping(value="edit")
	@ResponseBody
	public String edit(FlowIncreaseCapital flowIncreaseCapital, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		CompanyInfo companyInfo = companyInfoServiceImpl.getCompanyInfo(new CompanyInfo());
		BigDecimal bigDecimal = BigDecimal.valueOf(Long.parseLong(companyInfo.getCmpcptlamnt())).add(flowIncreaseCapital.getIncreaseAmount());
		String cmpcptlamnt = bigDecimal.toString();
		companyInfo.setCmpcptlamnt(cmpcptlamnt);
		System.out.println("增资后金额:"+cmpcptlamnt);
		flowIncreaseCapital.setAfterAmount(bigDecimal);
		try {
				companyInfoServiceImpl.update(companyInfo);
				flowIncreaseCapitalService.modify(flowIncreaseCapital);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="delete")
	@ResponseBody
	public String delete(int id, HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
				flowIncreaseCapitalService.delete(id);
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
}
