package com.mf.businessData.controller;

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

import com.mf.businessData.entity.ClntMerge;
import com.mf.businessData.service.impl.ClntMergeServiceImpl;
import com.mf.client.entity.ClntClient;
import com.mf.client.service.ClntClientService;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.Common;
import com.mf.util.PageView;

@Controller
@RequestMapping(value = "/mf/billmanger/")
public class BillManagerController {

	private static final Logger logger = Logger.getLogger(CustController.class);

	@RequestMapping(value = "/index.html")
	public String list() {
		return "/mf/businessData/billmanager/index";
	}
	
	@Autowired
	ClntClientService clntClientService;
	
	@Autowired
	ClntMergeServiceImpl  clntMergeService;
	
	@Autowired
	private SysDictionaryService sysDictionaryService;
	

	
	/**
	 * 查询客户信息列表
	 * @param model
	 * @param request
	 * @param clntClient
	 * @return
	 */
	@RequestMapping(value = "/getCustPagerList.html")
	@ResponseBody
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, Object> getCustPagerList(Model model,
			HttpServletRequest request,ClntClient clntClient) {

		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map map = new HashMap();
		//供业务参数查询客户信息列表
		pageView =clntClientService.queryCust(pageView, clntClient);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	/**
	 * 获取合并客户信息
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getMergePageList.html")
	@ResponseBody
	public Map<String, Object> getMergePageList(Model model,
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
		Map map = new HashMap();
		//供业务参数查询客户信息列表
		ClntMerge clntMerge=new ClntMerge();
		pageView =clntMergeService.queryMergeList(pageView, clntMerge);
		List list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
		
	}
	
	/**
	 * 更新客户名称
	 * @return
	 */
	@RequestMapping(value = "/toUpdateCustName.html")
	public String toUpdateCustName(HttpServletRequest request){
		String clientId=request.getParameter("id");
		ClntClient c=new ClntClient();
		c.setClntid(Integer.parseInt(clientId));
		List<ClntClient> client=clntClientService.queryType(c);
		request.setAttribute("client", client.get(0));
		return "/mf/businessData/cust/update_name";
	}
	
	
	/**
	 * 更新客户名称
	 * @return
	 */
	@RequestMapping(value = "/updateCustName.html")
	@ResponseBody
	public  Map<String, Object> updateCustName(HttpServletRequest request,ClntClient clntClient){
		clntClientService.update(clntClient);
		
		Map resltMap = new HashMap();
		resltMap.put("resCode", 1);
		resltMap.put("resDesc", "更新成功！");
		return resltMap;
		
	}
	
	
	@RequestMapping(value = "/toUpdateCertNo.html")
	public  String toUpdateCertNo(HttpServletRequest request){
		String clientId=request.getParameter("id");
		ClntClient c=new ClntClient();
		c.setClntid(Integer.parseInt(clientId));
		List<ClntClient> client=clntClientService.queryType(c);
		request.setAttribute("client", client.get(0));
		return "/mf/businessData/cust/update_certno";
	}
	
	
	/**
	 * 更新客户证件号
	 * @return
	 */
	@RequestMapping(value = "/updateCertNo.html")
	@ResponseBody
	public  Map<String, Object> updateCertNo(HttpServletRequest request,ClntClient clntClient){
		clntClientService.update(clntClient);
		
		Map resltMap = new HashMap();
		resltMap.put("resCode", 1);
		resltMap.put("resDesc", "更新成功！");
		return resltMap;
	}
	
	
	@RequestMapping(value = "/toUpdateOperator.html")
	public String toUpdateOperator(HttpServletRequest request){
		String clientId=request.getParameter("id");
		ClntClient client=clntClientService.getCustById(clientId);
		request.setAttribute("client", client);
		
		return "/mf/businessData/cust/update_operator";
		
	}
	
	/**
	 * 更新管户人
	 * @return
	 */
	@RequestMapping(value = "/updateOperator.html")
	@ResponseBody
	public Map<String, Object> updateOperator(HttpServletRequest request,ClntClient clntClient){
		
		clntClientService.update(clntClient);
		
		Map resltMap = new HashMap();
		resltMap.put("resCode", 1);
		resltMap.put("resDesc", "更新成功！");
		return resltMap;
		
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/delete.html")
	@ResponseBody
	public Map<String, Object> delete(HttpServletRequest request
			) {
		String clientId=request.getParameter("id");
		Map resltMap = new HashMap();
		try {
			clntClientService.delete(clientId);
			resltMap.put("resCode", 1);
			resltMap.put("resDesc", "更新成功！");
		} catch (Exception e) {
			resltMap.put("resCode", 0);
			resltMap.put("resDesc", "异常:" + e.getMessage());
		}

		return resltMap;
	}
	
	
	
	@RequestMapping(value = "/mergeCust.html")
	@ResponseBody
	public Map<String,Object> mergeCust(HttpServletRequest request,ClntMerge clntMerge){
		
		Map<String,Object> resltMap = new HashMap<String,Object>();
		
		try {
			//TODO  进行客户合并操作
			
			clntMergeService.mergeCust(clntMerge);
			resltMap.put("resCode", 1);
			resltMap.put("resDesc", "合并成功！");
		} catch (Exception e) {
			resltMap.put("resCode", 0);
			resltMap.put("resDesc", "异常:" + e.getMessage());
		}

		return resltMap;
	}
	


	
}
