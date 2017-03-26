package com.mf.cntrtmng.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnout;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnoutService;
import com.mf.cntrtmng.service.BsnsRepaylogService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/cntrtmng/bsnsrepayplan/")
public class BsnsRepayplanController {
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	
	@Autowired
	private BsnsBillService bsnsBillService;
	
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	
	@Autowired
	private BsnsRepaylogService bsnsRepaylogService;
	
	private static final String JSP_PATH = "/mf/cntrtmng/bsnsrepayplan/"; 
	@Autowired
	private BsnsLnoutService bsnsLnoutService;
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/cntrtmng/bsnsrepayplan/add";
	}
	
	/**
	* @author wangyaowei
	* @date 2015-2-6下午7:26:20
	* @Title: add
	* @Description: TODO(保存还款计划)
	* @param bsnsrepayplan
	* @param response
	* @param request
	*/
	@RequestMapping(value="add")
	public String add(Model model,BsnsRepayplan bsnsrepayplan,HttpServletResponse response,HttpServletRequest request){
		String result = "{\"msg\":\"suc\",\"message\":\" suc\"}";
		String dueno = bsnsrepayplan.getDueno();
		// 还款期数
		String[] repaytermnoArray = request.getParameterValues("repaytermno"); 
		// 还款周期开始日期
		String[] cyclesdtArray =request.getParameterValues("cyclesdt"); 
		// 还款周期结束日期
		String[] cycleedtArray =request.getParameterValues("cycleedt"); 
		// 需归还利息金额
		BigDecimal[] repayinstamntArray =castArrayStrToBd(request.getParameterValues("repayinstamnt")); 
		// 需归还本金金额
		BigDecimal[] currepayamntArray = castArrayStrToBd(request.getParameterValues("currepayamnt")); 
		// 待还款本金余额
		BigDecimal[] tbrepaybalArray = castArrayStrToBd(request.getParameterValues("tbrepaybal")); 
		// 待还款本金金额
		BigDecimal[] tbrepaypttlArray = castArrayStrToBd(request.getParameterValues("tbrepaypttl")); 
		// 累计归还本金金额
		BigDecimal[] repayedprinsumArray = castArrayStrToBd(request.getParameterValues("repayedprinsum"));
		// 实际还款日期
		String[] actualrepaydtArray =request.getParameterValues("actualrepaydt"); 
		// 还款状态
		String[] repaysttArray = request.getParameterValues("repaystt"); 
		
		String payday=request.getParameter("payday");
		String specailDay=request.getParameter("specailDay");

		try {	
				
			if (repaytermnoArray != null && repayinstamntArray != null 
						&& currepayamntArray != null ) {
				List<BsnsRepayplan> list = new ArrayList<BsnsRepayplan>();
				//缓存上一个bean对象
				BsnsRepayplan preBsnsrepayplan = new BsnsRepayplan();
				for (int j = 0; j < repaytermnoArray.length; j++) {
					
					bsnsrepayplan = new BsnsRepayplan();
					bsnsrepayplan.setRepaytermno(repaytermnoArray[j]);
					bsnsrepayplan.setCyclesdt(cyclesdtArray[j]);
					bsnsrepayplan.setCycleedt(cycleedtArray[j]);
					//需归还利息金额
					bsnsrepayplan.setRepayinstamnt(repayinstamntArray[j]);
					
					//待还款本金金额=需归还本金金额
					bsnsrepayplan.setTbrepaypttl(currepayamntArray[j]);
					// 待还款本金余额 ， 累计归还本金金额
					if(j==0) {
						//第一期的待还本金余额就是借据总额
						bsnsrepayplan.setTbrepaybal(tbrepaybalArray[j]);						
					} else {
						//其余的待还本金余额=上期的余额- 上期归还本金金额
						bsnsrepayplan.setTbrepaybal(preBsnsrepayplan.getTbrepaybal().subtract(preBsnsrepayplan.getCurrepayamnt()));
//						//其余的累计归还本金金额=上期的[累计归还本金金额] + [上期归还本金金额]
//						bsnsrepayplan.setRepayedprinsum(preBsnsrepayplan.getRepayedprinsum().add(preBsnsrepayplan.getCurrepayamnt()));
					}		
					//累计归还本金金额=0(制定还款计划是，还没开始还款，所以累计还款本金为0)
					//制定计划是【累计归还本金金额】为0，执行还款时更新
					bsnsrepayplan.setRepayedprinsum(new  BigDecimal(0));
					//实际归还本金金额【还款时更新】
					bsnsrepayplan.setCurrepayamnt(new BigDecimal(0));
					bsnsrepayplan.setRepaystt(repaysttArray[j]); 
					
					list.add(bsnsrepayplan);
					//缓存当前bean的累计值
					preBsnsrepayplan.setTbrepaybal(bsnsrepayplan.getTbrepaybal());
					preBsnsrepayplan.setCurrepayamnt(bsnsrepayplan.getCurrepayamnt());
				
				}
				bsnsRepayplanService.addList(list, dueno, payday,specailDay);
				
				//判断是否 拥有借据信息
				BsnsLnout bsnsLnout=new BsnsLnout();
				bsnsLnout.setCntrctno(bsnsrepayplan.getCntrctno());
				List<BsnsLnout> listsize= bsnsLnoutService.queryList(bsnsLnout);
				if(listsize.size()<1){
					result = "{\"msg\":\"suc\",\"message\":\"zero\"}";
				}
			}
		} catch (Exception e) {
			result = "{\"msg\":\"fail\",\"message\":\""
					+ WebTool.getErrorMsg(e.getMessage()) + "\"}";
			e.printStackTrace();
		}
		
		WebTool.writeJson(result, response);
		return null;
	}
	
	// String[] 数组转换为 BigDecimal[]数组
	private BigDecimal[] castArrayStrToBd(Object[] oArr){
		BigDecimal bd = null;
		BigDecimal[] bdArr = new BigDecimal[oArr.length];
		for(int k = 0; k < oArr.length; k++){
			bd = new BigDecimal((String)oArr[k]); 
			bdArr[k] = bd;
		}
		return bdArr;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param bsnsrepayplan
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			BsnsRepayplan bsnsrepayplan = new BsnsRepayplan();
			bsnsRepayplanService.addAll(bsnsrepayplan);
			result="{\"id\":" + bsnsrepayplan.getSrlno() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result="{\"id\":\"0\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 分页查询跳转
	 * @param model
	 * @param bsnsrepayplan
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,BsnsRepayplan bsnsrepayplan,String pageNow, String pageSize){
		return "/mf/cntrtmng/bsnsrepayplan/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnsrepayplan
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsRepayplan bsnsrepayplan,HttpServletRequest request){
		System.out.println("========showlist=========="+bsnsrepayplan.getDueno());
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsRepayplanService.query(pageView, bsnsrepayplan);
		List<BsnsRepayplan> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param bsnsrepayplanId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			bsnsRepayplanService.delete(ids);
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
	 * @param bsnsrepayplanId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String bsnsrepayplanId,int typeKey){
		BsnsRepayplan bsnsrepayplan = bsnsRepayplanService.getById(bsnsrepayplanId);
		model.addAttribute("bsnsrepayplan", bsnsrepayplan);
		if(typeKey == 1){
			return "/mf/cntrtmng/bsnsrepayplan/edit";
		}else if(typeKey == 2){
			return "/mf/cntrtmng/bsnsrepayplan/view";
		}else{
			return "/mf/cntrtmng/bsnsrepayplan/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param bsnsrepayplan
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateBsnsRepayplan(Model model,BsnsRepayplan bsnsrepayplan,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";;
		try {			
			bsnsRepayplanService.modify(bsnsrepayplan);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	
	/**
	 * 批量删除数据
	 * 
	 * @param model
	 * @param String
	 *            [] ids
	 * @return
	 */
	@RequestMapping(value = "deleteAll")
	public String deleteAll(String[] ids, Model model, HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				bsnsRepayplanService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	

	@RequestMapping(value="list")
	public String list(String dueno, HttpServletRequest request, Model model){
		BsnsBill bsnsbill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsbill", bsnsbill);
		request.setAttribute("dueno", dueno);
		return JSP_PATH + "list";
	}
	
	@RequestMapping(value="queryDueno",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> queryDueno(Model model,BsnsRepayplan bsnsrepayplan,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsRepayplanService.queryDueno(pageView, bsnsrepayplan);
		List<BsnsRepayplan> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}

	/**
	 * @author xujiuhua
	 * @date 2015年3月29日21:42:49
	 * @Description: 获取还款计划json数据
	 * @param dueno
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="getPlans")
	@ResponseBody
	public Map<String, List> getPlans(Model model,String dueno,HttpServletRequest request, HttpServletResponse response){
		String hkr = request.getParameter("specailDay"); // 固定还款日
		List<BsnsRepayplan> planlist = bsnsRepayplanService.createDefaultPlan(dueno, hkr);
		Map<String, List> resMap = new HashMap<String, List>();
		resMap.put("planlist", planlist);
		return resMap;
	}
	
	
	/**
	* @author wangyaowei
	* @date 2015-2-3下午4:58:24
	* @Title: showPlan
	* @Description: 查询已存在还款计划
	* @param dueno
	* @return String    返回类型
	*/
	@RequestMapping(value="showplan")
	public String showPlan(Model model,String dueno,HttpServletRequest request){
		//由dueno查询借据信息,借据信息通过对象传递到前台 - TBD
		BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsBill", bsnsBill);
		// 合同信息
		BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(bsnsBill.getCntrctno());
		model.addAttribute("bsnsCntrct", bsnsCntrct);
		
		String hkr = request.getParameter("specailDay"); // 固定还款日
		System.out.println("-----------hkr-----------"+hkr);
		//同时计算默认的还款计划
		List<BsnsRepayplan> planlist = bsnsRepayplanService.createDefaultPlan(dueno, hkr);
		model.addAttribute("planlist", planlist);
		return JSP_PATH + "showplan";
	}	
	/**
	 * @param model
	 * @param dueno
	 * @param request
	 * @return
	 * wyw
	 * 补录借据生产还款计划表
	 */
	@RequestMapping(value="showplanAfter")
	public String showplanAfter(Model model,String dueno,HttpServletRequest request){
		//由dueno查询借据信息,借据信息通过对象传递到前台 - TBD
		BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsBill", bsnsBill);
		// 合同信息
		BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(bsnsBill.getCntrctno());
		model.addAttribute("bsnsCntrct", bsnsCntrct);
		
		String hkr = request.getParameter("gdhkr"); // 固定还款日
		
		//同时计算默认的还款计划
		List<BsnsRepayplan> planlist = bsnsRepayplanService.createDefaultPlan(dueno, hkr);
		model.addAttribute("planlist", planlist);
		return "/mf/cntrtmng/bsnsrepayplan/billList/showplan";
	}
	/**
	 * @param model
	 * @param dueno
	 * @param request
	 * @return
	 * wyw
	 * 补录借据生产还款计划表
	 */
	@RequestMapping(value="showplanAfterEdit")
	public String showplanAfterEdit(Model model,String dueno,HttpServletRequest request){
		 BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
		 model.addAttribute("bsnsBill", bsnsBill);
		 BsnsCntrct bsnscntrct= bsnsCntrctService.getById(bsnsBill.getCntrctno());
		 model.addAttribute("bsnsCntrct", bsnscntrct);
		 List<BsnsRepayplan> planlist = bsnsRepayplanService.getByDueno(dueno);
		 model.addAttribute("planlist", planlist);
		return "/mf/cntrtmng/bsnsrepayplan/afterplanadd/showplan";
	}
	/**
	 * @param model
	 * @param dueno
	 * @param request
	 * @return 判断还款计划是否已存在
	 * wyw 方法未使用20150130
	 */
	@RequestMapping(value="isHavePlan")
	public String isHavePlan(Model model,String dueno,HttpServletRequest request){
		 int ish=bsnsRepayplanService.getCountPlan(dueno);
		 if(ish>0){
			 BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
			 model.addAttribute("bsnsBill", bsnsBill);
			 List<BsnsRepayplan> planlist = bsnsRepayplanService.getByDueno(dueno);
			 model.addAttribute("planlist", planlist);
			 return "/mf/cntrtmng/bsnsrepayplan/billList/showplan";
		 }else{
			 return "redirect:/mf/cntrtmng/bsnsrepayplan/showplanAfter.html?dueno="+dueno;
		 }
	}
	/**
	 * 判断当前要还款的日期在这之前是否还有未还款的
	 * @param model
	 * @param dueno
	 * @param request
	 * @return
	 */
	@RequestMapping(value="plandate")
	public String plandate(Model model,String dueno,String cyclesdt,HttpServletResponse response,HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		System.out.println("dueno====>"+dueno+"<==cyclesdt====="+cyclesdt);
		BsnsRepayplan bsnsRepayplan = new BsnsRepayplan();
		bsnsRepayplan.setDueno(dueno);
		bsnsRepayplan.setCyclesdt(cyclesdt);
		try {
		      List<BsnsRepayplan> list = bsnsRepayplanService.queryBycyclesdt(bsnsRepayplan);
		      System.out.println("list size="+list.size());
		       if (list.size()>0) {
		    	   result = "{\"msg\":\"fail\"}";
		       }else {
		    	   result = "{\"msg\":\"suc\"}";
			}
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 已放款合同-还款计划详情
	 * @author xujiuhua
	 * @date 2015年3月31日17:12:38
	 * @param model
	 * @param dueno
	 * @param request
	 * @return
	 */
	@RequestMapping(value="repyplaninfo")
	public String repyplaninfo(Model model,String dueno, HttpServletRequest request){
		BsnsBill bsnsBill = bsnsBillService.findByDueno(dueno);
		model.addAttribute("bsnsBill", bsnsBill);
		BsnsCntrct bsnsCntrct = bsnsCntrctService.findByCntrctno(bsnsBill.getCntrctno());
		model.addAttribute("bsnsCntrct", bsnsCntrct);
		request.setAttribute("dueno", dueno);
		// 已还款信息
		BsnsRepaylog bsnsrepaylog=new BsnsRepaylog();
		bsnsrepaylog.setBsnsno(dueno);
		BigDecimal a=new BigDecimal(0.0);
		BigDecimal b=new BigDecimal(0.0);
		BigDecimal c=new BigDecimal(0.0);
		List<BsnsRepaylog> bsnsrepaylogList=bsnsRepaylogService.queryAll(bsnsrepaylog);
		for(int i=0;i<bsnsrepaylogList.size();i++){
			a=a.add(bsnsrepaylogList.get(i).getRcvprinamnt());//实收金额
			b=b.add(bsnsrepaylogList.get(i).getRcvinstamnt());//实收利息
			c=c.add(bsnsrepaylogList.get(i).getDiscountamnt());//优惠金额
		}
		bsnsrepaylog.setRcvprinamnt(a);
		bsnsrepaylog.setRcvinstamnt(b);
		bsnsrepaylog.setDiscountamnt(c);
		model.addAttribute("bsnsrepaylog",bsnsrepaylog);
		return JSP_PATH + "repyplaninfo";
	}
	
	/**
	* @author wangyaowei
	* @date 2015-1-30下午6:46:52
	* @Title: billList
	* @Description: TODO(生成还款计划菜单地址指向页面)
	* @param model
	* @param request
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="billList")
	 public String billList(Model model,HttpServletRequest request){
    	return JSP_PATH + "billList/list";  
    }
	
}

