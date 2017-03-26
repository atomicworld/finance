/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.businessInfo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.mf.businessInfo.entity.Fileupdown;
import com.mf.businessInfo.service.FileupdownService;
import com.mf.util.Common;
import com.mf.util.PageView;
import com.mf.util.WebTool;
/**
 * @author wangyw
 * @2015-08-26
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/fileupdown/")
public class FileupdownController {
	//默认多列排序,example: username desc,createTime asc
	protected static final String DEFAULT_SORT_COLUMNS = null; 
	
	@Autowired
	private FileupdownService fileupdownService;
	
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
		return "/mf/fileupdown/add";
	}
	
	/**
	 * 保存新增
	 * @param model
	 * @param fileupdown
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,Fileupdown fileupdown,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		try {
			fileupdownService.add(fileupdown);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		 WebTool.writeJson(result, response);
		 return null;
	}
	
	/**
	 * 保存新增--for 即时编辑
	 * @param model
	 * @param fileupdown
	 * @return
	 */
	@RequestMapping(value="addnull")
	public String addnull(Model model,HttpServletResponse response,HttpServletRequest request){
		String result="";
		try {
			Fileupdown fileupdown = new Fileupdown();
			fileupdownService.addAll(fileupdown);
			result="{\"id\":" + fileupdown.getId() + ",\"message\":\"新增成功！\"}";
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
	 * @param fileupdown
	 * @param pageNow
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="query")
	public String query(Model model,Fileupdown fileupdown,String pageNow, String pageSize){
		return "/mf/fileupdown/list_list";
	}
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param fileupdown
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,Fileupdown fileupdown,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = fileupdownService.query(pageView, fileupdown);
		List<Fileupdown> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param fileupdownId
	 * @return
	 */
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String id,String filename,HttpServletResponse response,HttpServletRequest request){
		String result=null;
		String filePath = request.getRealPath("/")+"upload\\"+filename;
		File file = new File(filePath);
		if(file!= null && file.exists()){
			file.delete();
		}
		try{
			fileupdownService.delete(id);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	//  down fiel
	@RequestMapping(value="downfile")
	public void upload(String filename, HttpServletRequest request, HttpServletResponse response){
		try {
			 String path = request.getSession().getServletContext().getRealPath("/")+"upload"+File.separator;
			 System.out.println(path);
		        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型  
		        response.setContentType("multipart/form-data");  
		        //2.设置文件头：最后一个参数是设置下载文件名(假如我们叫a.pdf)  
		        response.setHeader( "Content-Disposition", "attachment;filename=" + new String( filename.getBytes("gb2312"), "ISO8859-1" )+ "" );  
		        ServletOutputStream out;  
		        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)  
		        File file = new File(path +filename );  
		        try {  
		            FileInputStream inputStream = new FileInputStream(file);  
		            //3.通过response获取ServletOutputStream对象(out)  
		            out = response.getOutputStream();  
		            int b = 0;  
		            byte[] buffer = new byte[1024];  
		            while (b != -1){  
		                b = inputStream.read(buffer);  
		                //4.写到输出流(out)中  
		                out.write(buffer,0,b);  
		            }  
		            inputStream.close();  
		            out.close();  
		            out.flush();  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	
	
	
	
	
	
}

