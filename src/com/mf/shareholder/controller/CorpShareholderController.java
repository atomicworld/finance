package com.mf.shareholder.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.common.pub.PubConstants;
import com.mf.common.util.StringUtil;
import com.mf.shareholder.entity.CorpPersondetail;
import com.mf.shareholder.entity.CorpShareassets;
import com.mf.shareholder.entity.CorpSharedetail;
import com.mf.shareholder.entity.CorpShareholder;
import com.mf.shareholder.service.CorpPersondetailService;
import com.mf.shareholder.service.CorpShareassetsService;
import com.mf.shareholder.service.CorpSharedetailService;
import com.mf.shareholder.service.CorpShareholderService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.*;
/**
 * @author zhangcong
 * @2015-04-14
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/shareholder/corpShareholder")
public class CorpShareholderController {
	@Autowired
	private CorpShareholderService corpShareholderService;
	@Autowired
	private CorpSharedetailService corpSharedetailService;
	@Autowired
	private CorpPersondetailService corpPersondetailService;
	@Autowired
	private CorpShareassetsService corpShareassetsService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;
	
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model,HttpServletRequest request){
		CompanyInfo companyInfo=new CompanyInfo();
		companyInfo=companyInfoService.getCompanyInfo(companyInfo);
		model.addAttribute("cmpno", companyInfo.getCmpno());
		return "/mf/sys/shareholder/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,CorpShareholder corpShareholder,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		String shareno = "SH" + StringUtil.getFormatDate(new Date(), "yyyyMMddHHmmss");
		corpShareholder.setShareno(shareno);
		corpShareholder.setDelFlg(1);
		corpShareholderService.add(corpShareholder);
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="list")
	public String sharemain(){
		return "/mf/sys/shareholder/sharemain";
	}
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="sharelist")
	public String sharelist(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/sys/shareholder/list1";
		return "/mf/sys/shareholder/list";
	}
	
	@RequestMapping(value = "showlist")
	@ResponseBody
	public Map<String, Object> showlist(Model model, CorpShareholder corpShareholder, HttpServletRequest request) {
		PageView pageView = null;
		String pageNow = request.getParameter("pager.pageNo");
		String pageSize = request.getParameter("pager.pageSize");
		if (Common.isEmpty(pageNow))
			pageView = new PageView(1);
		else {
			pageView = new PageView(Integer.parseInt(pageSize),
					Integer.parseInt(pageNow));
		}
		Map<String, Object> map = new HashMap<String, Object>();
		pageView = corpShareholderService.query(pageView, corpShareholder);
		List<CorpShareholder> list = pageView.getRecords();
		map.put("rows", list);
		map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
		map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
		return map;
	}
	
	@RequestMapping(value="historylist")
	public String historylist(HttpServletRequest request){
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals("FromMonitorUser"))
			return "/mf/sys/shareholder/historylist1";
		return "/mf/sys/shareholder/historylist";
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param comstructureId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			CorpShareholder corpShareholder = new CorpShareholder();
			corpShareholder.setShareno(ids);
			corpShareholder.setDelFlg(0);
			corpShareholderService.modify(corpShareholder);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param comstructureId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String id,String type){
		CorpShareholder corpshareholder = corpShareholderService.getById(id);
		model.addAttribute("corpshareholder", corpshareholder);
		model.addAttribute("type", type);
		return "/mf/sys/shareholder/edit";
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param comstructureId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getDetail")
	public String getDetail(Model model,String id,String type){
		model.addAttribute("type", type);
		CorpShareholder corpshareholder = corpShareholderService.getById(id);
		model.addAttribute("corpshareholder", corpshareholder);
		String shareType = corpshareholder.getShareType();
		if(PubConstants.shareType.equals(shareType)){
			model.addAttribute("shareno", corpshareholder.getShareno());
			return "/mf/sys/shareholder/main";
		}else{
			CorpSharedetail corpsharedetail = corpSharedetailService.getById(corpshareholder.getShareno());
			CorpShareassets corpshareassets = corpShareassetsService.getById(corpshareholder.getShareno());
			model.addAttribute("corpsharedetail", corpsharedetail);
			model.addAttribute("corpshareassets", corpshareassets);
			return "/mf/sys/shareholder/sharedetail";
		}
	}
	
	@RequestMapping(value="getPersonDetail")
	public String getPersonDetail(Model model, HttpServletRequest request,String type){
		model.addAttribute("type", type);
		String shareno = request.getParameter("shareno");
		CorpShareholder corpshareholder = corpShareholderService.getById(shareno);
		model.addAttribute("corpshareholder", corpshareholder);
		CorpPersondetail corppersondetail = corpPersondetailService.getById(corpshareholder.getShareno());
		model.addAttribute("corppersondetail", corppersondetail);
		return "/mf/sys/shareholder/persondetail";
		
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String update(Model model,CorpShareholder corpshareholder,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			corpShareholderService.modify(corpshareholder);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;		
		
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="updateDetail",method=RequestMethod.POST)
	public String updateDetail(Model model,CorpSharedetail corpSharedetail,CorpShareassets corpShareassets,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			CorpSharedetail detail = corpSharedetailService.getById(corpSharedetail.getShareno());
			if(detail == null){
				corpSharedetailService.add(corpSharedetail);
				corpShareassets.setShareno(corpSharedetail.getShareno());
				corpShareassetsService.add(corpShareassets);
			}else{
				corpSharedetailService.modify(corpSharedetail);
				corpShareassets.setShareno(corpSharedetail.getShareno());
				corpShareassetsService.modify(corpShareassets);
			}
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;		
		
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param comstructure
	 * @return
	 */
	@RequestMapping(value="updatePerson",method=RequestMethod.POST)
	public String updatePerson(Model model,CorpPersondetail corpPersondetail,CorpShareassets corpShareassets,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			CorpPersondetail detail = corpPersondetailService.getById(corpPersondetail.getShareno());
			if(detail == null){
				corpPersondetailService.add(corpPersondetail);
			}else{
				corpPersondetailService.modify(corpPersondetail);
			}
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;		
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param comstructureId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getRelatives")
	public String getRelatives(Model model,String id){
		CorpShareholder corpshareholder = corpShareholderService.getById(id);
		model.addAttribute("corpshareholder", corpshareholder);
		String shareType = corpshareholder.getShareType();
		if(PubConstants.shareType.equals(shareType)){
			model.addAttribute("shareno", corpshareholder.getShareno());
			return "/mf/sys/shareholder/main";
		}else{
			CorpSharedetail corpsharedetail = corpSharedetailService.getById(corpshareholder.getShareno());
			CorpShareassets corpshareassets = corpShareassetsService.getById(corpshareholder.getShareno());
			model.addAttribute("corpsharedetail", corpsharedetail);
			model.addAttribute("corpshareassets", corpshareassets);
			return "/mf/sys/shareholder/sharedetail";
		}
	}
}

