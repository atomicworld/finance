/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.cntrtmng.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.poi.poifs.filesystem.DirectoryEntry;
import org.apache.poi.poifs.filesystem.DocumentEntry;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.higinet.es.message.Request;

import com.mf.bsnsmng.entity.Loanuse;
import com.mf.bsnsmng.service.LoanuseService;
import com.mf.client.entity.ClntClient;
import com.mf.client.service.ClntClientService;
import com.mf.cntrtmng.dao.BsnsLnoutDao;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnout;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsCntrctService;
import com.mf.cntrtmng.service.BsnsLnoutService;
import com.mf.common.pub.PubConstants;
import com.mf.common.util.NOSUtil;
import com.mf.common.util.ReplaceNumber;
import com.mf.org.entity.Operator;
import com.mf.org.service.impl.OperatorServiceImpl;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value="/mf/cntrtmng/bsnslnout/")
public class BsnsLnoutController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private BsnsLnoutService bsnsLnoutService;
	@Autowired
	private BsnsLnoutDao bsnsLnoutDao;
	@Autowired
	private BsnsCntrctService bsnsCntrctService;
	@Autowired
	OperatorServiceImpl operatorService;
	@Autowired
	private ClntClientService clntClientService;
	@Autowired
	private LoanuseService loanuseService;
	
	@Autowired
	private BsnsBillService bsnsBillService;
	
	
	/** binder用于bean属性的设置 */
	@InitBinder  
	public void initBinder(WebDataBinder binder) {  
	        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));  
	}
	   
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/cntrtmng/bsnslnout/add";
	}
	@RequestMapping(value="lnoutPage")
	public String lnoutPage(){
		return "/mf/cntrtmng/loanout/message/cntrtmngList";
	}
	/**
	 * 保存新增
	 * @param model
	 * @param bsnslnout
	 * @return
	 */	//BsnsLnout bsnslnout
	@RequestMapping(value="applyout") 
	public String applyout(Model model,BsnsLnout bsnslnout,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\",\"message\":\"" +"true"+"\"}";
		try {
			bsnsLnoutService.add(bsnslnout);
			BsnsCntrct bsnscntrct=new BsnsCntrct();
			bsnscntrct.setCntrctstt(PubConstants.CNTRCTSTT_NEW);
			Operator operator = (Operator)request.getSession().getAttribute("operator");
			bsnscntrct.setRegopno(operator.getEmplyno());
			List<BsnsCntrct> list=bsnsCntrctService.findList(bsnscntrct);
			System.out.println("============="+list.size());
			if(list.size()<1){
				result="{\"msg\":\"suc\",\"message\":\"" +"false"+"\"}";
			}
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param bsnslnout
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			BsnsLnout bsnslnout = new BsnsLnout();
			bsnsLnoutService.addAll(bsnslnout);
			result="{\"id\":" + bsnslnout.getOutno() + ",\"message\":\"新增成功！\"}";
		} catch (Exception e) {
			result="{\"id\":\"0\",\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * post方式分页查询可以放款的信息列表
	 * @param model
	 * @param bsnslnout
	 * @return map
	 */
	@RequestMapping(value="showoutable",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showoutable(Model model,BsnsLnout bsnsLnout,HttpServletRequest request){

		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();

		pageView = bsnsLnoutService.queryoutable(pageView, bsnsLnout);
		List<BsnsLnout> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnslnout
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsLnout bsnslnout,HttpServletRequest request){

		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();

		pageView = bsnsLnoutService.query(pageView, bsnslnout);
		List<BsnsLnout> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param bsnslnoutId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String ids, HttpServletResponse response){
		String result=null;
		try{
			bsnsLnoutService.delete(ids);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	/**
	 * 查询&修改单条记录
	 * @param model
	 * @param bsnslnoutId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String bsnslnoutId,int typeKey){
		BsnsLnout bsnslnout = bsnsLnoutService.getById(bsnslnoutId);
		model.addAttribute("bsnslnout", bsnslnout);
		if(typeKey == 1){
			return "/mf/cntrtmng/bsnslnout/edit";
		}else if(typeKey == 2){
			return "/mf/cntrtmng/bsnslnout/view";
		}else{
			return "/mf/cntrtmng/bsnslnout/view_1";
		}
	}
	
	/**
	 * 更新修改的信息
	 * @param model
	 * @param bsnslnout
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateBsnsLnout(Model model,BsnsLnout bsnslnout,HttpServletResponse response){		
		String result="{\"msg\":\"suc\"}";
		try {			
			bsnsLnoutService.modify(bsnslnout);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;		
		
	}
	
	/**
	 * 跳转到执行放款的显示窗口
	 * @param model
	 * @param outno
	 * @return
	 */
	@RequestMapping(value="exeoutinfo")
	public String exeoutinfo(Model model,String outno){
		//通过outno(放款编号)查询出账信息表及延伸相关信息
		BsnsLnout bsnslnout = bsnsLnoutDao.findOneByOutno(outno);
		model.addAttribute("bsnslnout", bsnslnout);
		
		return "/mf/cntrtmng/loanout/exeoutinfo";
	}
	
	/**
	 * 执行放款操作
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(value="exeout",method=RequestMethod.POST)
	public String exeout(Model model,BsnsLnout bsnslnout,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {			
			BsnsLnout old=bsnsLnoutService.getById(bsnslnout.getOutno());
			//1:已放款；2：未放款
			if("1".equals(old.getOutstt())){
				 result="{\"msg\":\"once\",\"message\":\"" +"不可重复操作！"+"\"}";
				 WebTool.writeJson(result, response);
				 return null;
			}else{
				//add by hw 增加一个手写的放款日期
				String date = request.getParameter("outdate");
				String pay = request.getParameter("pay");
				String bnkno = request.getParameter("bnkno");
				bsnsLnoutService.exeout(bsnslnout,date,pay,bnkno);
			}
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 跳转到list展示页面
	 * @return
	 */
	@RequestMapping(value="fklist")
	public String list(){
		return "/mf/cntrtmng/loanout/fk/listlabel";
	}
	
	
	/**
	 * 查询已放款合同
	 * @param model
	 * @param bsnslnout
	 * @param request
	 * @return
	 */
	@RequestMapping(value="showouted",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showouted(Model model,BsnsLnout bsnslnout, HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		bsnslnout.setOutstt(PubConstants.OUTSTT_OUTED);
		pageView = bsnsLnoutService.queryOuted(pageView, bsnslnout);
		List<BsnsLnout> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
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
	@ResponseBody
	public String deleteAll(String[] ids, Model model, HttpServletResponse response) {
		String result = null;
		try {
			for (String id : ids) {
				bsnsLnoutService.delete(id);
			}
			result = "{\"status\":1,\"message\":\"删除成功！\"}";
		} catch (Exception e) {
			result="{\"status\":0,\"message\":\"" +"fail"+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}

	
	
	
	/**
	* @author wangyaowei
	* @date 2015-3-19下午5:07:54
	* @Title: showoutInfo
	* @Description: TODO(查看放款通知单)
	* @param model
	* @param bsnsLnout
	* @param request
	* @return Map<String,Object>    返回类型
	* @throws
	*/
	@RequestMapping(value="showoutInfo",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showoutInfo(Model model,BsnsLnout bsnsLnout,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();

		pageView = bsnsLnoutService.showoutInfo(pageView, bsnsLnout);
		List<BsnsLnout> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	/**
	* @author wangyaowei
	* @date 2015-3-19下午5:34:27
	* @Title: showTabInfo
	* @Description: TODO(放款通知单查看页面)
	* @param model
	* @param outno
	* @return String    返回类型
	*/
	@RequestMapping(value="showTabInfo")
	public String showTabInfo(Model model,String outno){
		model.addAttribute("outno", outno);
		return "/mf/cntrtmng/loanout/message/tabJsp";
	}
	
	/**
	* @author wangyaowei
	* @date 2015-3-19下午5:37:23
	* @Title: otherInfo
	* @Description: TODO(放款通知单详情 查看业务)
	* @param model
	* @param outno
	*/
	@RequestMapping(value="otherInfo")
	public String otherInfo(Model model,String outno){
		//通过outno查询出账信息表及延伸相关信息
		BsnsLnout bsnslnout = bsnsLnoutDao.findOneByOutno(outno);
		model.addAttribute("bsnslnout", bsnslnout);
		BsnsCntrct bsnscntrct=bsnsCntrctService.findByCntrctno(bsnslnout.getCntrctno());
		model.addAttribute("bsnscntrct", bsnscntrct);
		return "/mf/cntrtmng/loanout/message/otherInfo";
	}
	/**
	* @author wangyaowei
	* @date 2015-3-19下午5:35:26
	* @Title: lnoutInfo
	* @Description: TODO(放款通知单 单款放款详情)
	* @param model
	* @param outno
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="lnoutInfo")
	public String lnoutInfo(Model model,String outno){
		//add by hw start
		BsnsBill bsnsBill = bsnsBillService.findByDueno(outno);
		model.addAttribute("bsnsBill",bsnsBill);
		//add by hw end
		BsnsLnout bsnslnout = bsnsLnoutDao.findOneByOutno(outno);
		model.addAttribute("bsnslnout", bsnslnout);
		BsnsCntrct bsnscntrct = bsnsCntrctService.findByCntrctno(bsnslnout.getCntrctno());
		model.addAttribute("bsnscntrct", bsnscntrct);
		Operator operator=operatorService.getById(bsnslnout.getRegopno());
		model.addAttribute("operator", operator);
		return "/mf/cntrtmng/loanout/message/lnoutInfo";
	}
	@RequestMapping(value="printInfo")
	public String printInfo(Model model,String outno){
		BsnsLnout bsnslnout = bsnsLnoutDao.findOneByOutno(outno);
		BsnsCntrct bsnscntrct = bsnsCntrctService.findByCntrctno(bsnslnout.getCntrctno());
		StringBuffer params=new StringBuffer();
		
		String money=NOSUtil.change(bsnslnout.getOutamnt().doubleValue());
		params.append("cntrctno,"+bsnscntrct.getCntrctno());
		params.append(";clntnm,"+bsnslnout.getClntnm());
		params.append(";outamnt,"+money);
		params.append(";bsnsrt,"+bsnslnout.getBsnsrt());
		params.append(";outdate,"+bsnslnout.getOutdate());
		model.addAttribute("params", params.toString());
		
		return "/mf/cntrtmng/loanout/message/word";
	}
	
	/**
	* @author wangyaowei
	* @date 2015-3-24下午11:15:58
	* @Title: exportExcel
	* @Description: TODO(还款历史合同导出)
	* @param response
	* @param request
	* @param bsnscntrct
	* @return void    返回类型
	* @throws
	*/
	@RequestMapping(value = "exportExcel")
	public void exportExcel(HttpServletResponse response,HttpServletRequest request,BsnsCntrct bsnsCntrct) {
		  //type 判断导出的数据类型是个人用户数据还是公共用户数据
		  
		  WritableWorkbook wbook=null;
		  OutputStream os =null;
		  try { 
			  
			  String username=request.getParameter("username");
			  if(username!=null){
				  String clntname=new String(username.getBytes("iso-8859-1"),"utf-8");
				  bsnsCntrct.setClntnm(clntname);
			  }
			  bsnsCntrct.setOutflg(PubConstants.OUTFLG_YES);
			  List<BsnsCntrct> list= bsnsLnoutService.queryExcel(bsnsCntrct);
			  String type="历史补录合同信息表";
			  os= response.getOutputStream();// 取得输出流   
		      response.reset(); // 清空输出流   
		      response.setHeader("Content-disposition", "attachment; filename="+new String(type.getBytes("gbk"),"iso8859-1")+".xls");// 设定输出文件头   
		      response.setContentType("application/msexcel");// 定义输出类型 
		      wbook = Workbook.createWorkbook(os); // 建立excel文件   
		      String tmptitle = "历史补录合同信息表"; // 标题   
		      WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称  
		      //设置excel标题   
		      WritableFont wfont = new WritableFont(WritableFont.ARIAL, 12,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
		      WritableCellFormat wcfFC = new WritableCellFormat(wfont); 
		      wcfFC.setAlignment(jxl.format.Alignment.CENTRE);
		      wsheet.setColumnView(0,20);//设置列宽
		      wsheet.setColumnView(1,15);
		      wsheet.setColumnView(2,15);
		      wsheet.setColumnView(3,15);
		      wsheet.setColumnView(4,15);
		      wsheet.setColumnView(5,15);
		      //开始生成主体内容    
		      wsheet.addCell(new Label(0, 0, "合同编号",wcfFC)); 
		      wsheet.addCell(new Label(1, 0, "客户名称",wcfFC)); 
		      wsheet.addCell(new Label(2, 0, "合同金额(元)",wcfFC));
		      wsheet.addCell(new Label(3, 0, "放款日期",wcfFC));
		      wsheet.addCell(new Label(4, 0, "结束日期",wcfFC));
		      wsheet.addCell(new Label(5, 0, "业务种类",wcfFC));
		      WritableCellFormat format = new WritableCellFormat(); 
		      format.setAlignment(jxl.format.Alignment.CENTRE);
		      for(int j=0;j<list.size();j++){
		    	BsnsCntrct bsnslnouttRow= list.get(j);
		  		wsheet.addCell(new Label(0, j+1,bsnslnouttRow.getCntrctno(),format));  
		        wsheet.addCell(new Label(1, j+1,bsnslnouttRow.getClntnm(),format));  
		        wsheet.addCell(new Label(2, j+1,bsnslnouttRow.getCntrctamnt().toString(),format)); 
		        wsheet.addCell(new Label(3, j+1,bsnslnouttRow.getCntrctsdate(),format)); 
		        wsheet.addCell(new Label(4, j+1,bsnslnouttRow.getCntrctedate(),format));
		        wsheet.addCell(new Label(5, j+1,bsnslnouttRow.getKndno(),format)); 
		       }
		       //主体内容生成结束           
		       wbook.write(); // 写入文件   
		       }catch(Exception ex) { 
		           ex.printStackTrace(); 
		       }finally{
		        	try {
						wbook.close();
						os.close(); // 关闭流
					} catch (WriteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
		         }
		      }    

    
	@RequestMapping(value = "printCntrctWord")
	public String printCntrctWord(HttpServletResponse response,HttpServletRequest request,BsnsCntrct bsnscntrct) {
				  String  result="{\"msg\":\"failed\"}";
		          String path = request.getRealPath("/")+"Document"+File.separator+"upload"+File.separator;  
		          String fileName="";
		          BsnsCntrct bs=bsnsCntrctService.getByPrintInfo(bsnscntrct.getCntrctno());
		          try {  
		              if (!"".equals(path)) {  
		                  // 检查目录是否存在  
		                  File fileDir = new File(path);  
		                  if (fileDir.exists()) {  
		                     // 生成临时文件名称  
		                     fileName = System.currentTimeMillis()+".doc";  
		                     String content = "" +
		                     		"<html>" +
		                     		"<div style=\"text-align: center\">" +
		                     		"<span style=\"font-family: 黑体;font-size: 28px;width: 75%\">合同信息<br /></span>" +
		                     		"<table style=\"width: 750px;\">"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;width:23%\">客户号:</td>"+
		                     		"<td  style=\"text-align: left;width:34%\" >"+bs.getClntno()+"</td>"+
		                     		"<td  style=\"text-align: right;width:23%\">客户名称：</td>"+
		                     		"<td  style=\"text-align: left;width:20%\">"+bs.getClntnm()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">合同号:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getCntrctno()+"</td>"+
		                     		"<td  style=\"text-align: right;\">业务品种：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getKndno()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">期限种类:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getTermtyp()+"</td>"+
		                     		"<td  style=\"text-align: right;\">合同金额：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getCntrctamnt()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">还款方式:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getRpmntway()+"</td>"+
		                     		"<td  style=\"text-align: right;\">计息方式：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getIntrstmd()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">放款金额:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getOutamnt()+"</td>"+
		                     		"<td  style=\"text-align: right;\">合同期限：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getTrmmnth()+"月"+bs.getTrmday()+"日</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">合同起始日期:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getCntrctsdate()+"</td>"+
		                     		"<td  style=\"text-align: right;\">合同结束日期：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getCntrctedate()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">利率类型:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getBsrtyp()+"</td>"+
		                     		"<td  style=\"text-align: right;\">申请利率：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getApplyrt()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">主担保方式:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getGrtway()+"</td>"+
		                     		"<td  style=\"text-align: right;\">担保类型：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getGrtwaydtl()+"</td>"+
		                     		"</tr>"+
		                     		"<tr>"+
		                     		"<td  style=\"text-align: right;\">申请用途:</td>"+
		                     		"<td  style=\"text-align: left;\" >"+bs.getUseno()+"</td>"+
		                     		"<td  style=\"text-align: right;\">登记日期：</td>"+
		                     		"<td  style=\"text-align: left;\">"+bs.getRegdate()+"</td>"+
		                     		"</tr>"+
		                     		"</table>"+
		                     		"</div>" +
		                     		"</html>";  
		                      byte b[] = content.getBytes();  
		                     ByteArrayInputStream bais = new ByteArrayInputStream(b);  
		                      POIFSFileSystem poifs = new POIFSFileSystem();  
		                      DirectoryEntry directory = poifs.getRoot();  
		                      DocumentEntry documentEntry = directory.createDocument("WordDocument", bais);  
		                      FileOutputStream ostream = new FileOutputStream(path+ fileName);  
		                      poifs.writeFilesystem(ostream);  
		                      bais.close();  
		                      ostream.close();
		                      result="{\"msg\":\"succ\",\"url\":\""+fileName+"\"}";
		                 }  
		             }  
		          } catch (IOException e) {  
		              e.printStackTrace();
		        } 
		         WebTool.writeJson(result, response);
		 		 return null;		          
	}
	
	
	/** 
	 * @author made_in_heaven@foxmail.com
	 * @Description: TODO(打印放款通知单) 
	 * @param @param model
	 * @param @param bsnslnout
	 * @param @param request
	 * @param @return 设定文件 
	 * @date 2015-6-2
	 */ 
	@RequestMapping(value = "printNotice")
	public String printNotice(Model model,BsnsLnout bsnslnout, HttpServletRequest request) {
		String outno=bsnslnout.getOutno();
		String filename=request.getParameter("filename");
		BsnsLnout lnout=bsnsLnoutService.getById(outno);
		ClntClient client=new ClntClient();
		client.setClntid(Integer.parseInt(lnout.getClntno()));
		List<ClntClient> clntclient=clntClientService.queryType(client);
		ClntClient clnt=clntclient.get(0);//客户信息
		BsnsCntrct bsnscntrct=bsnsCntrctService.findByCntrctno(lnout.getCntrctno());//合同信息
		Loanuse loanuse=loanuseService.getById(bsnscntrct.getUseno().toString());//用途
		StringBuffer params=new StringBuffer();
		String occrdate=FormatDateUtil.prase(lnout.getRegdate());//发生日期
		String outdate=FormatDateUtil.prase(lnout.getOutdate());//借款日期
		String mtrtydate=FormatDateUtil.prase(lnout.getCntrctedate());//到期日期
		String money=NOSUtil.change(lnout.getOutamnt().doubleValue());
		params.append(ReplaceNumber.prase(lnout.getOutamnt().doubleValue(),9));//数字金额
		params.append("dueno,"+lnout.getOutno());//借据编号
		params.append(";occrdate,"+occrdate);//发生日期
		params.append(";dueamnt,"+money);//借据金额
		params.append(";clntnm,"+lnout.getClntnm());//客户名称
		params.append(";cntrctno,"+lnout.getCntrctno());//合同编号
		params.append(";outdate,"+outdate);//借款日期
		params.append(";mtrtydate,"+mtrtydate);//到期日期
		params.append(";certtype,"+clnt.getCerttype());//证件类型
		params.append(";certno,"+clnt.getCertno());//证件号
		BigDecimal month=new BigDecimal(120);
		params.append(";applyrt,"+bsnscntrct.getApplyrt().divide(month,2,BigDecimal.ROUND_HALF_UP));//月利率
		params.append(";useno,"+loanuse.getUsenm());//贷款用途
		model.addAttribute("params", params.toString());
		model.addAttribute("filename",filename);
		return "/mf/temp/word";
	}
	
}

