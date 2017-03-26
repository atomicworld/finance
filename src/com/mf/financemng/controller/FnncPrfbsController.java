/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.financemng.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.financemng.entity.*;
import com.mf.financemng.service.*;
import com.mf.org.entity.Operator;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.*;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/financemng/jzpz/")
public class FnncPrfbsController {
	
	@Autowired
	private FnncPrfbsService fnncPrfbsService;
	@Autowired
	private SysDictionaryService sysDictionaryService;
	@Autowired
	private FnncPrfbsService fnncprfbsservice;
	@Autowired
	private FnncPrfdtlService fnncprfdtlservice;
	
	//凭证复核页面
	@RequestMapping(value="queryPzfh")
	public String queryPzfh(Model model,FnncPrfbs fnncprfbs,String pageNow, String pageSize){
		return "/mf/financemng/pzfh/pzlrUI";
	}
	//历史凭证
	@RequestMapping(value="queryHistory")
	public String queryHistory(Model model,FnncPrfbs fnncprfbs,String pageNow, String pageSize){
		return "/mf/financemng/jzpz/history";
	}
	//财务结账
	@RequestMapping(value="queryCwjz")
	public String queryCwjz(Model model,FnncPrfbs fnncprfbs,String pageNow, String pageSize){
		return "/mf/financemng/cwjz/index";
	}
	//凭证汇总
		@RequestMapping(value="pzhz")
		public String pzhz(Model model,FnncPrfbs fnncprfbs,String pageNow, String pageSize){
			return "/mf/financemng/cwjz/pzhz";
		}
	//凭证冲销
		@RequestMapping(value="pzcx")
		public String pzcx(Model model,FnncPrfbs fnncprfbs,String pageNow, String pageSize){
			return "/mf/financemng/pzcx/yfhpzUI";
		}
	//凭证冲销
		@RequestMapping(value="pzcxUI")
		public String pzcxUI(Model model,HttpServletRequest request){
			String accntflg=request.getParameter("accntflg");
			request.setAttribute("accntflg", accntflg);
			return "/mf/financemng/pzcx/pzcxUI";
		}
	//凭证冲销
		@RequestMapping(value="pzcxInfo")
		public String pzcxInfo(Model model,String prfno){
			FnncPrfbs fnncprfbs = fnncPrfbsService.getByprfno(prfno);
			model.addAttribute("fnncprfbs", fnncprfbs);
			List<FnncPrfdtlList> list=fnncprfdtlservice.querylist(fnncprfbs.getPrftrcno()); 
			model.addAttribute("fnncprfdtllist", list);
			BigDecimal total=new BigDecimal(0);
			for(int i=0;i<list.size();i++){
				if("1".equals(list.get(i).getJdflg())){
					total=total.add(list.get(i).getAmnt());
				}
			}
			model.addAttribute("total", total);
			return "/mf/financemng/pzcx/info";
		}
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addPZUI")
	public String addUI(Model model){
		return "/mf/financemng/jzpz/newPZ";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fnncaccntitem
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,FnncPrfbs fnncprfbs,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			
			Operator operator = (Operator)request.getSession().getAttribute("operator");
			String opno=operator.getEmplyno();//操作员编号
			String dptno=operator.getDptno();//部门编号
			
			String txdt=request.getParameter("txdt");//凭证发生日期
			String title=request.getParameter("title");//摘要
			
			String remark[]=request.getParameterValues("remark");//详情摘要
			String accntno[]=request.getParameterValues("accntno");//科目编号
			String upaccntno[]=request.getParameterValues("upaccntno");//所属科目编号
			String amnt1[]=request.getParameterValues("amnt1");//借发金额
			String amnt2[]=request.getParameterValues("amnt2");//代发金额
			
			/*System.out.println(remark.length+"remark======"+java.util.Arrays.toString(remark));
			System.out.println(accntno.length+"accntno======"+ java.util.Arrays.toString(accntno));
			System.out.println(upaccntno.length+"upaccntno======"+java.util.Arrays.toString(upaccntno));
			System.out.println(amnt1.length+"amnt1======"+java.util.Arrays.toString(amnt1));
			System.out.println(amnt2.length+"amnt2======"+java.util.Arrays.toString(amnt2));
			*/
			String prefix="";
		
			boolean xianjin=false;
			boolean yinhang=false;
			boolean zhuanzhang=false;
			for(int i=0;i<accntno.length;i++){
				 String bh=accntno[i].substring(0,4);
				 if("1001".equals(bh)){
					 xianjin=true;
				 }else if("1002".equals(bh)){
					yinhang=true;
				 }else{
					 zhuanzhang=true;
				 }
				 
			}
			if(xianjin==false&&yinhang==false){//现金和银行都未发生 为 转账
				prefix="ZZ";
			}else if(xianjin==true&&yinhang==true){//现金和银行同时发生 已贷方金额为准
				//anmt1 借方 anmt2 贷方 
				for(int i=0;i<accntno.length;i++){
					double type=Double.parseDouble(amnt2[i]);
					String bh=accntno[i].substring(0,4);
					if(type>0.0){
						if("1001".equals(bh)){
							prefix="XF";
						}else{
							prefix="YF";
						}
						break;
					}
				}
				
			}else if(xianjin==true){//只有现金发生
				for(int i=0;i<accntno.length;i++){
					double type=Double.parseDouble(amnt1[i]);
					String bh=accntno[i].substring(0,4);
					if("1001".equals(bh)){
						if(type>0.0){
							prefix="XS";
						}else{
							prefix="XF";
						}
						break;
					}
				}
			}else if(yinhang==true){//只有银行发生
				for(int i=0;i<accntno.length;i++){
					double type=Double.parseDouble(amnt1[i]);
					String bh=accntno[i].substring(0,4);
					if("1002".equals(bh)){
						if(type>0.0){
							prefix="YS";
						}else{
							prefix="YF";
						}
						break;
					}
				}
			}
			
			
			String accntxx=WaterIdGener.getWaterId();//流水号
			fnncprfbs.setPrftrcno(accntxx+opno);//流水号
			fnncprfbs.setOpno(opno);//操作员
			fnncprfbs.setDptno(dptno);//部门编号
			fnncprfbs.setTxdt(txdt);//发生日期
			fnncprfbs.setRegdt(sdf.format(new Date()));//登记日期
			fnncprfbs.setRemark(title);//摘要
			fnncprfbs.setStt("1");//默认登记状态
			fnncprfbs.setPrftyp(prefix);//凭证状态
			fnncprfbs.setPrfno(prefix+accntxx);//凭证编号
			
			fnncprfbsservice.add(fnncprfbs);//保存
			FnncPrfdtl spl;
			for(int i=0;i<accntno.length;i++){
				 String sqnno=WaterIdGener.getWaterId();
				 spl=new FnncPrfdtl();
				 spl.setPrftrcno(accntxx+opno);//流水号
				 spl.setSqnno(sqnno+i);//顺序号
				 spl.setAccntno(accntno[i]);//科目编号
				 spl.setUpaccntno(upaccntno[i]);//所属科目编号
				 spl.setRemark(remark[i].trim());//摘要
				 spl.setSqsort((i+1)+"");//顺序号
				 if("0".equals(amnt1[i])){
					 spl.setJdflg(PubConstants.CHCKPRFBS_ACCNTFLG_D);//贷标志
				 }else if("0".equals(amnt2[i])){
					 spl.setJdflg(PubConstants.CHCKPRFBS_ACCNTFLG_J);//借标志
				 }
				 if(!"0".equals(amnt1[i])){
					 spl.setAmnt(new BigDecimal(amnt1[i]));//发生金额
				 }else if(!"0".equals(amnt2[i])){
					 spl.setAmnt(new BigDecimal(amnt2[i]));//发生金额
				 }
				 fnncprfdtlservice.add(spl);
			}
			
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	
	@RequestMapping(value="pzlrUI")
	public String pzlrUI(Model model){
		return "/mf/financemng/jzpz/pzlrUI";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fnncprfbs
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,FnncPrfbs fnncprfbs,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fnncPrfbsService.queryWFHBase(pageView, fnncprfbs);
		List<FnncPrfbs> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fnncprfbsId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			fnncPrfbsService.delete(ids);
			fnncprfdtlservice.delete(ids);
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
	 * @param fnncprfbsId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getEdit")
	public String getEdit(Model model,String prfno){
		FnncPrfbs fnncprfbs = fnncPrfbsService.getByprfno(prfno);
		model.addAttribute("fnncprfbs", fnncprfbs);
		List<FnncPrfdtlList> list=fnncprfdtlservice.querylist(fnncprfbs.getPrftrcno()); 
		model.addAttribute("fnncprfdtllist", list);
		model.addAttribute("fnncsize", list.size());
		BigDecimal total=new BigDecimal(0);
		for(int i=0;i<list.size();i++){
			if("1".equals(list.get(i).getJdflg())){
				total=total.add(list.get(i).getAmnt());
			}
		}
		model.addAttribute("total", total);
		return "/mf/financemng/jzpz/edit";
	}
	@RequestMapping(value="getInfo")
	public String getInfo(Model model,String prfno){
		FnncPrfbs fnncprfbs = fnncPrfbsService.getByprfno(prfno);
		model.addAttribute("fnncprfbs", fnncprfbs);
		List<FnncPrfdtlList> list=fnncprfdtlservice.querylist(fnncprfbs.getPrftrcno()); 
		model.addAttribute("fnncprfdtllist", list);
		BigDecimal total=new BigDecimal(0);
		for(int i=0;i<list.size();i++){
			if("1".equals(list.get(i).getJdflg())){
				total=total.add(list.get(i).getAmnt());
			}
		}
		model.addAttribute("total", total);
		return "/mf/financemng/pzfh/info";
	}
	
	
	@RequestMapping(value="onlyViewInfo")
	public String onlyViewInfo(Model model,String prfno){
		FnncPrfbs fnncprfbs = fnncPrfbsService.getByprfno(prfno);
		model.addAttribute("fnncprfbs", fnncprfbs);
		List<FnncPrfdtlList> list=fnncprfdtlservice.querylist(fnncprfbs.getPrftrcno()); 
		model.addAttribute("fnncprfdtllist", list);
		BigDecimal total=new BigDecimal(0);
		for(int i=0;i<list.size();i++){
			if("1".equals(list.get(i).getJdflg())){
				total=total.add(list.get(i).getAmnt());
			}
		}
		model.addAttribute("total", total);
		return "/mf/financemng/yfhpz/info";
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-13上午5:17:06
	* @Title: updateSubmit
	* @Description: TODO(更改提交状态)
	* @return String    返回类型
	*/
	@RequestMapping(value="updateSubmit",method=RequestMethod.POST)
	public String updateSubmit(Model model,FnncPrfbs fnncprfbs,HttpServletResponse response){		
		String result = "{\"status\":1,\"message\":\"修改成功！\"}";
		try {	
			fnncPrfbsService.modify(fnncprfbs);
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-12下午10:33:55
	* @Title: querylist
	* @Description: TODO(关联查询凭证录入信息)
	* @param model
	* @param fnncaccntitem
	* @param request
	* @return Map<String,Object>    返回类型
	*/
	@RequestMapping(value="querylist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> querylist(Model model,FnncPrfbsList fnncprfbslist,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		
		pageView = fnncPrfbsService.querylist(pageView, fnncprfbslist);
		List<FnncAccntitem> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	@RequestMapping(value="udpate")
	public String udpate(Model model,FnncPrfbs fnncprfbs,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String prfno=request.getParameter("prfno");//凭证编号
			Operator operator = (Operator)request.getSession().getAttribute("operator");
			String opno=operator.getEmplyno();//操作员编号
			String dptno=operator.getDptno();//部门编号
			
			String txdt=request.getParameter("txdt");//凭证发生日期
			String title=request.getParameter("title");//摘要
			/** 详细信息*/
			String sqnno[]=request.getParameterValues("sqnno");//主键 
			String remark[]=request.getParameterValues("remark");//详情摘要
			String accntno[]=request.getParameterValues("accntno");//科目编号
			String upaccntno[]=request.getParameterValues("upaccntno");//所属科目编号
			String amnt1[]=request.getParameterValues("amnt1");//借发金额
			String amnt2[]=request.getParameterValues("amnt2");//代发金额
			
			/*System.out.println(sqnno.length+"sqnno======"+java.util.Arrays.toString(sqnno));
			System.out.println(remark.length+"remark======"+java.util.Arrays.toString(remark));
			System.out.println(accntno.length+"accntno======"+ java.util.Arrays.toString(accntno));
			System.out.println(upaccntno.length+"upaccntno======"+java.util.Arrays.toString(upaccntno));
			System.out.println(amnt1.length+"amnt1======"+java.util.Arrays.toString(amnt1));
			System.out.println(amnt2.length+"amnt2======"+java.util.Arrays.toString(amnt2));*/
			//=========================更新基本信息==================================
			String prefix="";
			
			boolean xianjin=false;
			boolean yinhang=false;
			boolean zhuanzhang=false;
			for(int i=0;i<accntno.length;i++){
				 String bh=accntno[i].substring(0,4);
				 if("1001".equals(bh)){
					 xianjin=true;
				 }else if("1002".equals(bh)){
					yinhang=true;
				 }else{
					 zhuanzhang=true;
				 }
				 
			}
			if(xianjin==false&&yinhang==false){//现金和银行都未发生 为 转账
				prefix="ZZ";
			}else if(xianjin==true&&yinhang==true){//现金和银行同时发生 已贷方金额为准
				//anmt1 借方 anmt2 贷方 
				for(int i=0;i<accntno.length;i++){
					double type=Double.parseDouble(amnt2[i]);
					String bh=accntno[i].substring(0,4);
					if(type>0.0){
						if("1001".equals(bh)){
							prefix="XF";
						}else{
							prefix="YF";
						}
						break;
					}
				}
				
			}else if(xianjin==true){//只有现金发生
				for(int i=0;i<accntno.length;i++){
					double type=Double.parseDouble(amnt1[i]);
					String bh=accntno[i].substring(0,4);
					if("1001".equals(bh)){
						if(type>0.0){
							prefix="XS";
						}else{
							prefix="XF";
						}
						break;
					}
				}
			}else if(yinhang==true){//只有银行发生
				for(int i=0;i<accntno.length;i++){
					double type=Double.parseDouble(amnt1[i]);
					String bh=accntno[i].substring(0,4);
					if("1002".equals(bh)){
						if(type>0.0){
							prefix="YS";
						}else{
							prefix="YF";
						}
						break;
					}
				}
			}
			
			
			fnncprfbs=fnncprfbsservice.getByprfno(prfno);
			fnncprfbs.setOpno(opno);//操作员
			fnncprfbs.setDptno(dptno);//部门编号
			fnncprfbs.setTxdt(txdt);//发生日期
			fnncprfbs.setRemark(title);//摘要
			fnncprfbs.setPrftyp(prefix);//凭证状态
			fnncprfbsservice.modify(fnncprfbs);//更新修改
			//============================删除详细信息========================
			List<FnncPrfdtl> oldList=fnncprfdtlservice.getByPrfrtcno(fnncprfbs.getPrftrcno());

			for(int i=0;i<oldList.size();i++){
				boolean ishave=false;
				if(sqnno!=null)
				for(int j=0;j<sqnno.length;j++){
					if(oldList.get(i).getSqnno().equals(sqnno[j])){
						ishave=true;
						break;
					}
				}
				if(!ishave){
					fnncprfdtlservice.deleteBysqnno(oldList.get(i).getSqnno());
				}
			}
			
			//============================更新详细信息========================
			if(sqnno!=null)
			 for(int i=0;i<sqnno.length;i++){
				 FnncPrfdtl spl=new FnncPrfdtl();
				 spl.setSqnno(sqnno[i]);//顺序号
				 spl.setAccntno(accntno[i]);//科目编号
				 spl.setUpaccntno(upaccntno[i]);//所属科目编号
				 spl.setRemark(remark[i].trim());//摘要
				 if("0".equals(amnt1[i])){
					 spl.setJdflg(PubConstants.CHCKPRFBS_ACCNTFLG_D);//贷标志
				 }else if("0".equals(amnt2[i])){
					 spl.setJdflg(PubConstants.CHCKPRFBS_ACCNTFLG_J);//借标志
				 }
				 if(!"0".equals(amnt1[i])){
					 spl.setAmnt(new BigDecimal(amnt1[i]));//发生金额
				 }else if(!"0".equals(amnt2[i])){
					 spl.setAmnt(new BigDecimal(amnt2[i]));//发生金额
				 }
				 fnncprfdtlservice.modify(spl);
			 }
			//============================新增详细信息========================

			FnncPrfdtl spl;
			 int old=0;
			if(sqnno!=null)old=sqnno.length;
			for(int i=old;i<accntno.length;i++){
				 String sqnnos=WaterIdGener.getWaterId();
				 spl=new FnncPrfdtl();
				 spl.setPrftrcno(fnncprfbs.getPrftrcno());//流水号
				 spl.setSqnno(sqnnos+i);//主键id
				 spl.setAccntno(accntno[i]);//科目编号
				 spl.setUpaccntno(upaccntno[i]);//所属科目编号
				 spl.setRemark(remark[i].trim());//摘要
				 spl.setSqsort((i+1)+"");//顺序号
				 if("0".equals(amnt1[i])){
					 spl.setJdflg(PubConstants.CHCKPRFBS_ACCNTFLG_D);//贷标志
				 }else if("0".equals(amnt2[i])){
					 spl.setJdflg(PubConstants.CHCKPRFBS_ACCNTFLG_J);//借标志
				 }
				 if(!"0".equals(amnt1[i])){
					 spl.setAmnt(new BigDecimal(amnt1[i]));//发生金额
				 }else if(!"0".equals(amnt2[i])){
					 spl.setAmnt(new BigDecimal(amnt2[i]));//发生金额
				 }
				 fnncprfdtlservice.add(spl);
			}
			
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-14下午10:53:30
	* @Title: queryAccnt
	* @Description: TODO(财务结转查询)
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value="queryAccnt",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> queryAccnt(Model model,FnncPrfdtlList fnncprfdtllist,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		
		pageView = fnncprfdtlservice.queryAccnt(pageView, fnncprfdtllist);
		List<FnncPrfdtlList> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	/**
	* @author wangyaowei
	* @date 2015-2-14下午10:53:30
	* @Title: queryAccnt
	* @Description: TODO(恢复数据查询)
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value="queryAccntAll",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> queryAccntAll(Model model,FnncPrfdtlList fnncprfdtllist,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		
		pageView = fnncprfdtlservice.queryAccntAll(pageView, fnncprfdtllist);
		List<FnncPrfdtlList> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
}

