/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.businessInfo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mf.businessInfo.entity.Checkinfo;
import com.mf.businessInfo.entity.Fileupdown;
import com.mf.businessInfo.service.FileupdownService;
import com.mf.businessInfo.service.MothService;
import com.mf.common.pub.PubConstants;
import com.mf.json.Entity;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.sys.service.impl.MappingtoolServiceImpl;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/moth/")
public class MothController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private MothService mothService;
	@Autowired
	private FileupdownService fileupdown;
	@Autowired
	private MappingtoolServiceImpl mappingtoolService;
	@Autowired
	CompanyInfoServiceImpl  companyInfoService;

	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addUI")
	public String addUI(Model model){
		return "/mf/businessData/monthrep/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param moth
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Checkinfo moth,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
		try {
			String[] blanchout=request.getParameterValues("blanchout");
			String[] blanchin=request.getParameterValues("blanchin");
			String[] summery=request.getParameterValues("summery");
			String[] day=request.getParameterValues("rptday");
			//取orgcode
			CompanyInfo companyInfo=new CompanyInfo();
			companyInfo=companyInfoService.getCompanyInfo(companyInfo);
			//生成主键
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			Date date = new Date();
			//java.sql.Date upd_date = new java.sql.Date(date.getTime());
			String key_name = "AM";//前缀监管
			String id,tooldate=sf.format(date);
			String opname = (String)request.getSession().getAttribute("opname");
			moth.setCreateby(opname);
			moth.setCreatedate(tooldate);
			moth.setOrgcode(companyInfo.getOrgcode());
			String year=moth.getRptdate().toString().substring(0, 4);
			String mm=moth.getRptdate().toString().substring(4, 6);
			moth.setRptyear(Integer.parseInt(year));
			moth.setRptmonth(Integer.parseInt(mm));
			moth.setUpdatedate(tooldate);
			if(day==null){
				//如果 没有加明细则执行
				id = mappingtoolService.getSerialnumber(tooldate, key_name);
				moth.setBankbillid(id);
				mothService.add(moth);
			}else{
				// sum leaveamt
				Double in=(double) 0;
				Double out=(double) 0;
			for(int i=0;i<day.length;i++){
				in=Double.parseDouble(blanchin[i])+in;
				out=Double.parseDouble(blanchout[i])+out;
				moth.setLeftamount(String.valueOf(in-out));
				id = mappingtoolService.getSerialnumber(tooldate, key_name);
				moth.setBankbillid(id);
				moth.setRptday(Integer.parseInt(day[i]));
				moth.setBlanchin(blanchin[i]);
				moth.setBlanchout(blanchout[i]);
				moth.setSummery(summery[i]);
				mothService.add(moth);
			}
			}
			result="{\"msg\":\"suc\"}";
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	
	/**
	 * 分页查询跳转
	 * @param model
	 * @param moth
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public Map<String, Object> getSysMenuList(Model model,Checkinfo sysMenu,
			HttpServletRequest request){
			PageView pageView=null;
			String pageNow =request.getParameter("pager.pageNo");
			String pageSize=request.getParameter("pager.pageSize");
			if (Common.isEmpty(pageNow))
				pageView=new PageView(1);
			else{
				pageView=new PageView(Integer.parseInt(pageSize),
						Integer.parseInt(pageNow));
			}
			Map map = new HashMap();
			pageView = this.mothService.query(pageView, sysMenu);
			List list = pageView.getRecords();
			map.put("rows", list);
			map.put("pager.pageNo", Integer.valueOf(pageView.getPageNow()));
			map.put("pager.totalRows", Long.valueOf(pageView.getRowCount()));
			return map;
		}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param moth
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,Checkinfo moth,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = mothService.query(pageView, moth);
		List<Checkinfo> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据month删除
	 * @param model
	 * @param mothId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String month, HttpServletResponse response){
		String result=null;
		try{
			mothService.delete(month);
			fileupdown.delete(month);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	/**
	 * 根据id删除
	 * @param model
	 * @param mothId
	 * @return
	 */
	@RequestMapping(value="deleteById2",method=RequestMethod.POST)
	public String deleteById2(Model model,String month, HttpServletResponse response){
		String result="{\"msg\":\"suc\"}";
		try{
			mothService.delete2(month);
			result="{\"msg\":\"suc\"}";
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
	 * @param mothId
	 * @param type
	 * @return
	 */
	@RequestMapping(value="getById")
	public String getById(Model model,String month){
	
		List<Checkinfo> list = mothService.getById2(month);
		model.addAttribute("details", list);
		Checkinfo moth=new Checkinfo();
		moth=list.get(0);
		model.addAttribute("moth", moth);
			return "/mf/businessData/monthrep/edit";
	}
	/**
	 * 更新修改的信息
	 * @param model
	 * @param moth
	 * @return
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateMoth(Model model,Checkinfo moth,String sumin,String sumout,HttpServletResponse response,HttpServletRequest request){		
		String result="result";
		try {
			//String[] bankbillid=request.getParameterValues("bankbillid");
			String[] blanchout=request.getParameterValues("blanchout");
			String[] blanchin=request.getParameterValues("blanchin");
			String[] summery=request.getParameterValues("summery");
			String[] day=request.getParameterValues("rptday");
			Date date= new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMMdd");
			String opname = (String)request.getSession().getAttribute("opname");
			//java.sql.Date upd_date = new java.sql.Date(date.getTime());
			String key_name = "AM";//前缀监管
			String id,tooldate=sf.format(date);
			moth.setUpdateby(opname);
			moth.setUpdatedate(tooldate);
			// first delete by month
			mothService.delete(moth.getRptdate().toString());
			if(day==null){
				id = mappingtoolService.getSerialnumber(tooldate, key_name);
				moth.setBankbillid(id);
				mothService.add(moth);
			}else{
				// sum leaveamt
				Double in=(double) 0;
				Double out=(double) 0;
				for(int i=0;i<day.length;i++){
					 in=Double.parseDouble(blanchin[i])+in;
					 out=Double.parseDouble(blanchout[i])+out;
				}
				moth.setLeftamount(String.valueOf(in-out));
			for(int i=0;i<day.length;i++){
				id = mappingtoolService.getSerialnumber(tooldate, key_name);
				moth.setBankbillid(id);
				moth.setRptday(Integer.parseInt(day[i]));
				if(!blanchin[i].equals(""))
				moth.setBlanchin(blanchin[i]);
				if(!blanchout[i].equals(""))
				moth.setBlanchout(blanchout[i]);
				if(!summery[i].equals(""))
				moth.setSummery(summery[i]);
				mothService.add(moth);
			}
			}
			  result="{\"status\":1,\"message\":\"修改成功！\"}";
					}catch(Exception e){
						result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
						e.printStackTrace();
					}
		 WebTool.writeJson(result, response);
		 return null;		
	}

	/**
	 * 跳到开始
	 * 
	 * @return
	 */
	
	@RequestMapping(value = "show")
	public String show(HttpServletRequest request) {
		String tmp = request.getSession().getAttribute("operator").toString();
		if(tmp.equals(PubConstants.SuperAdmin))
			return "/mf/businessData/monthrep/list1";
		return "/mf/businessData/monthrep/list";
	}
	
	/**
	 * 跳转到上传页面
	 */
	@RequestMapping(value = "upFile")
	public String upFile(Model model,String month) {
		Fileupdown fileup=new Fileupdown();
		fileup.setMonth(month);
		List<Fileupdown> file=fileupdown.queryAll(fileup);
		model.addAttribute("file",file);
		model.addAttribute("month",month);
		return "/mf/businessData/monthrep/upFile";
	}

	/**
	 * 实现上传功能
	 */
	@RequestMapping(value = "upFileUI")
	public String FileUp(Model model,String month,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
		      DiskFileItemFactory factory = new DiskFileItemFactory();  
		      // 当上传文件太大时，因为虚拟机能使用的内存是有限的，所以此时要通过临时文件来实现上传文件的保存  
		      // 此方法是设置是否使用临时文件的临界值（单位：字节）  
		      factory.setSizeThreshold(10000);  
		      ServletFileUpload upload = new ServletFileUpload(factory); 
		      upload.setHeaderEncoding("utf-8");
		      List<File> items;
		      Map<String,String> map = new HashMap<String, String>();
				items = upload.parseRequest(request);
				Iterator iter = items.iterator();  
			          FileItem item = (FileItem) iter.next(); 
			          if (item.isFormField()) {  
			              //如果是普通表单字段  
			              String name = item.getFieldName();
			              String value= item.getString("utf-8");
						  map.put(name, value);
			          } else {  
			                  String fileName = item.getName(); 
			                  item.getSize();//获取文件大小
			                  String subfix=fileName.substring(fileName.lastIndexOf("."),fileName.length());
			                  if(item.getSize()>(1024*1024)){//1m
			                	  result="{\"msg\":\"fail\",\"message\":\"文件超过2MB!\"}";
			                	  WebTool.writeHtml(result, response);
			                	  return null;
			      				}
			                  FileOutputStream fos;
								String path=request.getRealPath("/")+"upload"+File.separator+fileName;
								String path1="/upload/"+fileName;
								fos = new FileOutputStream(path);
								    
								Date dd=new Date();
						              		String d=dd.toString();
						              		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
						              		 System.out.println(f.format(new Date()));
						  			      Fileupdown fileup=new Fileupdown();
						  			      fileup.setMonth(month);
						  		          fileup.setUpday(f.format(new Date()));
						  				  fileup.setFilename(fileName);//文件名称
						                    fileup.setFiletype(subfix);
						                    fileup.setFilesize(item.getSize());
						                    fileup.setFilepath(path1);
						                    //调用 file 添加
						                fileupdown.add(fileup);
								if(item.isInMemory()){
										fos.write(item.get());
										fos.close();
								}else{
								    InputStream is=item.getInputStream();
								   	byte[] buffer=new byte[1024];
								   	int len;
							    	while((len=is.read(buffer))>0){
								    	fos.write(buffer,0,len);
								    }	
								    is.close();
								    fos.close();
								}
			            }  
			} catch (Exception e) {
				result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
				e.printStackTrace();
			}
			 WebTool.writeHtml(result, response);
			 return null;
	}
	
// 验证  报表存在？
	@RequestMapping(value="checkReportMonth")
	@ResponseBody
	public String checkReportMonth(String reportMonth, Model moth,HttpServletResponse response, HttpServletRequest request){
		String result = "{\"msg\":\"suc\"}";
		try {
		Checkinfo financeCashFlow = mothService.getById(reportMonth);
			if (financeCashFlow==null) {
				result = "{\"msg\":\"suc\"}";
			}else {
				result = "{\"msg\":\"fail\"}";
			}
			} catch (Exception e) {
				result = "{\"msg\":\"fail\"}";
			}
		WebTool.writeJson(result, response);
		return null;
	}
	
	@RequestMapping(value="getBank")
	@ResponseBody
	public Map<String, List> getCitybyParentId() {
		Entity entity;
		List<Checkinfo> citys = mothService.getBank();
		List<Entity> list = new ArrayList<Entity>();
		Map<String,List> resMap = new HashMap<String,List>();
		for(Checkinfo c:citys){
			entity = new Entity();
		//	System.out.println(c.getBanknmno()+c.getCountno());
			entity.setValue(c.getBankacc());
			entity.setKey(c.getBankname()+"|"+c.getBankacc());
			list.add(entity);
		}
		resMap.put("list", list);
		return resMap;
	}
	
}

