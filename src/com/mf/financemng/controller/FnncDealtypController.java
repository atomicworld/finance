/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

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

import com.mf.financemng.entity.FnncDealitem;
import com.mf.financemng.entity.FnncDealtyp;
import com.mf.financemng.service.FnncDealitemService;
import com.mf.financemng.service.FnncDealtypService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;

/**
 * @author wangyw
 * @2015-04-15
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/fnncdealtyp/")
public class FnncDealtypController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private FnncDealtypService fnncDealtypService;
	@Autowired
	private FnncDealitemService fnncDealitemService;
	   
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/financemng/fnncdealtyp/add";
	}
	@RequestMapping(value="list")
	public String list(Model model){
		return "/mf/financemng/fnncdealtyp/list";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnncdealtyp
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncDealtyp fnncdealtyp,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			fnncDealtypService.add(fnncdealtyp);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncdealtyp
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncDealtyp fnncdealtyp,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncDealtypService.query(pageView, fnncdealtyp);
		List<FnncDealtyp> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnncdealtypId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fnncDealtypService.delete(ids);
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
	 * @param fnncdealtypId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="editUI")
	public String editUI(Model model,String rcrdid){
		System.out.println("====rcrdid======="+rcrdid);
		FnncDealtyp fnncdealtyp = fnncDealtypService.getById(rcrdid);
		model.addAttribute("fnncdealtyp", fnncdealtyp);
		FnncDealitem fnncdealitem=new FnncDealitem();
		fnncdealitem.setDealtype(fnncdealtyp.getDealtype());
		List<FnncDealitem> fnncdealitemList=fnncDealitemService.queryAll(fnncdealitem);
		System.out.println("====fnncdealitemList======="+fnncdealitemList.size());
		for(int i=0;i<fnncdealitemList.size();i++){
			System.out.println("=========="+fnncdealitemList.get(i).getRcrdid());
		}
		if(fnncdealitemList.size()>0&&"2".equals(rcrdid)){//2还款 1放款
			model.addAttribute("fnncdealitem1", fnncdealitemList.get(0));
			model.addAttribute("fnncdealitem2", fnncdealitemList.get(1));
			model.addAttribute("fnncdealitem3", fnncdealitemList.get(2));
			model.addAttribute("fnncdealitem4", fnncdealitemList.get(3));
		}else if(fnncdealitemList.size()>0){
			model.addAttribute("fnncdealitem1", fnncdealitemList.get(0));
			model.addAttribute("fnncdealitem2", fnncdealitemList.get(1));
			model.addAttribute("fnncdealitem3", fnncdealitemList.get(2));
		}
		return "/mf/financemng/fnncdealtyp/edit";
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param fnncdealtyp
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateFnncDealtyp(Model model,FnncDealtyp fnncdealtyp,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			fnncDealtypService.modify(fnncdealtyp);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
}

