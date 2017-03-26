/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */


package com.mf.bsnsmng.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

import com.mf.bsnsmng.entity.BsnsReport;
import com.mf.bsnsmng.service.BsnsReportService;
import com.mf.sys.entity.CompanyInfo;
import com.mf.sys.service.impl.CompanyInfoServiceImpl;
import com.mf.util.Common;
import com.mf.util.FormatDateUtil;
import com.mf.util.PageView;
import com.mf.util.SftpUtil;
import com.mf.util.WebTool;

/**      
* 类名称：BsnsReportController   
* 类描述：   
* 创建人：wangyaowei  
* 创建时间：2015-3-27 下午7:29:00   
* 修改人：wangyaowei  
* 修改时间：2015-3-27 下午7:29:00   
* 修改备注：   
* @version    
*    
*/
@Controller
@RequestMapping(value="/mf/report")
public class BsnsReportController {
	private int P_UPLOAD_FILE_SIZE=10;
	@Autowired
	private BsnsReportService bsnsReportService;
	@Autowired
	private CompanyInfoServiceImpl CompanyInfoService;
	
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
	public String addUI(Model model,HttpServletResponse response,HttpServletRequest request){
		String applyNo=request.getParameter("applyNo");
		System.out.println(applyNo);
		model.addAttribute("applyNo", applyNo);
		return "/mf/bsnsmng/report/add";
	}
	
	/**
	* @author wangyaowei
	* @date 2015-3-27下午11:13:53
	* @Title: report
	* @Description: TODO(跳转到贷前调查报告)
	* @param model
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value="report")
	public String report(Model model,HttpServletResponse response,HttpServletRequest request){
		String applyNo=request.getParameter("applyNo");
		model.addAttribute("applyNo", applyNo);
		return "/mf/bsnsmng/report/list";
	}
	/**
	 * 保存新增
	 * @param model
	 * @param bsnsreport
	 * @return
	 */
	@RequestMapping(value="add")
	public String add(Model model,BsnsReport bsnsreport,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";;
		String fileName= new String();
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
				
		      while (iter.hasNext()) {  
		          FileItem item = (FileItem) iter.next(); 
		          if (item.isFormField()) {  
		              //如果是普通表单字段  
		              String name = item.getFieldName();
		              String value= item.getString("utf-8");
					  map.put(name, value);
		          } else {  
		        	  CompanyInfo compInfo = CompanyInfoService.getCompanyInfo(new CompanyInfo());
		        	  
		        	  //上传文件的原文件名
		        	  fileName = item.getName(); 	 
		        	  String subfix=fileName.substring(fileName.lastIndexOf("."),fileName.length());	                 
		        	  String fileName1=UUID.randomUUID()+subfix;
		     		 
	                  if(item.getSize()>1024*1024*P_UPLOAD_FILE_SIZE){
	                	  result="{\"msg\":\"fail\",\"message\":\"文件超过5MB!\"}";
	                	  WebTool.writeHtml(result, response);
	                	  return null;
	                  }
//	                 String saveDir =request.getRealPath("/");
//	                 //文件上传到web服务器下
//	                 uploadFileToWebDir( map,fileName1,saveDir, item);
	                 //文件上传到sftp文件服务器上	                  
	                  String saveDir =compInfo.getCmpno()+"/"+FormatDateUtil.getDate("yyyyMMdd")+"/" +map.get("applyno") ;
	                  map.put("url",saveDir);
	                  SftpUtil sftpUtil = new SftpUtil();
	                  sftpUtil.connect();	                  
	                  sftpUtil.upload(saveDir,(FileInputStream)item.getInputStream(),fileName1 );	 
	                  //保存文件路径到数据库中
	                  saveDir =saveDir + "/" +fileName1;
	                  map.put("url",saveDir);
		          }  
		      }  
		      
		      bsnsreport.setFileName(fileName);//文件名称
		      bsnsreport.setApplyno(map.get("applyno"));//申请编号
		      bsnsreport.setIntro(map.get("intro"));//文档描述
		      bsnsreport.setUrl(map.get("url"));
		      bsnsReportService.add(bsnsreport);
		} catch (Exception e) {
			result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeHtml(result, response);
		return null;
			
			
	}
	/**
	 * 保存上传文件到web服务器上（新版改为sftp了，配合pad端使用）
	 * @param map
	 * @param fileName1
	 * @param saveDir
	 * @param item
	 * @throws IOException
	 */
	private void uploadFileToWebDir( Map<String,String> map,String fileName1,String saveDir,FileItem item)throws IOException {
				
         FileOutputStream fos;
         String path=saveDir+"upload"+File.separator+fileName1;
         String path1="/upload/"+fileName1;
         fos = new FileOutputStream(path);
			
         map.put("url",path1);
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
	
	/**
	 * post方式分页查询
	 * @param model
	 * @param bsnsreport
	 * @return map
	 */
	@RequestMapping(value="showlist",method=RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> showlist(Model model,BsnsReport bsnsreport,HttpServletRequest request){
		PageView pageView = null;
		String pageNow=request.getParameter("pager.pageNo");
		String pageSize=request.getParameter("pager.pageSize");
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageSize),Integer.parseInt(pageNow));
		}
		Map<String, Object> map=new HashMap<String, Object>();
		pageView = bsnsReportService.query(pageView, bsnsreport);
		List<BsnsReport> list=pageView.getRecords();
		map.put("rows", list); 
		map.put("pager.pageNo", pageView.getPageNow());
		map.put("pager.totalRows", pageView.getRowCount());
		return map;
	}
	
	/**
	 * 根据id删除
	 * @param model
	 * @param bsnsreportId
	 * @return
	 *//*
	@RequestMapping(value="deleteById",method=RequestMethod.POST)
	public String deleteById(Model model,String reportno, HttpServletResponse response){
		String result=null;
		try{
			BsnsReport bsnsreport=bsnsReportService.getById(reportno);             
			//删除sftp上原文件
			SftpUtil sftpUtil = new SftpUtil();
			sftpUtil.connect();
			String delFile =bsnsreport.getUrl();		
			String fileDir = delFile.substring(0,delFile.lastIndexOf("/"));
			String filename = delFile.substring(delFile.lastIndexOf("/")+1);
			sftpUtil.deleteFile(fileDir,filename);
			//删除表记录
			bsnsReportService.delete(reportno);
		    result="{\"status\":1,\"message\":\"删除成功！\"}";
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
		WebTool.writeJson(result, response);
		return null;
	}
	
	
	*//**
	 * 更新修改的信息
	 * @param model
	 * @param bsnsreport
	 * @return
	 *//*
	@RequestMapping(value="update")
	public String updateBsnsReport(Model model,BsnsReport bsnsreport,HttpServletResponse response,HttpServletRequest request){
		String result="{\"msg\":\"suc\"}";
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
				
		      while (iter.hasNext()) {  
		    	  FileItem item = (FileItem) iter.next(); 
		    	  if (item.isFormField()) {  
		    		  //如果是普通表单字段  
		    		  String name = item.getFieldName();
		    		  String value= item.getString("utf-8");
		    		  map.put(name, value);
		    	  } else { 
		    		  
		    		  SftpUtil sftpUtil = new SftpUtil();
	                  sftpUtil.connect();	          
	                  
		    		  //删除原文件
		    		  String delFile = map.get("url");		
		    		  String fileDir = delFile.substring(0,delFile.lastIndexOf("/"));
		    		  String filename = delFile.substring(delFile.lastIndexOf("/")+1);
		    		  sftpUtil.deleteFile(fileDir,filename);		    		  
		    		  
		        	  //上传新文件到sftp服务器上
		    		  CompanyInfo compInfo = CompanyInfoService.getCompanyInfo(new CompanyInfo());
		        	  String fileName = item.getName(); 	 
		        	  String subfix=fileName.substring(fileName.lastIndexOf("."),fileName.length());	                 
		        	  String fileName1=UUID.randomUUID()+subfix;
		     		 
	                  if(item.getSize()>1024*1024*P_UPLOAD_FILE_SIZE){
	                	  result="{\"msg\":\"fail\",\"message\":\"文件超过5MB!\"}";
	                	  WebTool.writeHtml(result, response);
	                	  return null;
	                  }     
	                 //文件上传到sftp文件服务器上	的目录路径                  
	                  String saveDir =compInfo.getCmpno()+"/"+FormatDateUtil.getDate("yyyyMMdd")+"/" +map.get("applyno") ;	                         
	                  sftpUtil.upload(saveDir,(FileInputStream)item.getInputStream(),fileName1 );	    
	                  //
	                  saveDir= saveDir+ "/" +fileName1;
	                  map.put("url",saveDir);
		    		  */
//		    		  String filePath = request.getRealPath("/")+url;
//		    		  File file = new File(filePath);
//		    		  if(file!= null && file.exists()){
//		    			  file.delete();
//		    		  }
							
		    		  //添加新文件
//		    		  String fileName = item.getName();  
//		    		  bsnsreport.setFileName(fileName);//文件名称
//					  String filedName1=UUID.randomUUID()+fileName.substring(fileName.lastIndexOf("."),fileName.length());
//	                  FileOutputStream fos;
//	                  String path=request.getRealPath("/")+"upload"+File.separator+filedName1;
//	                  String path1="/upload/"+filedName1;
//	                  fos = new FileOutputStream(path);
//	                  map.put("url",path1);
//	                  if(item.isInMemory()){
//	                	  fos.write(item.get());
//	                	  fos.close();
//	                  }else{
//	                	  InputStream is=item.getInputStream();
//	                	  byte[] buffer=new byte[1024];
//	                	  int len;
//	                	  while((len=is.read(buffer))>0){
//	                		  fos.write(buffer,0,len);
//	                	  }	
//	                	  is.close();
//	                	  fos.close();
//	                  }
		    	/*  }  */
		    /*  }
		      bsnsreport.setReportno(Integer.parseInt(map.get("reportno")));
		      bsnsreport.setApplyno(map.get("applyno"));//申请编号
		      bsnsreport.setIntro(map.get("intro"));//文档描述
		      bsnsreport.setUrl(map.get("url"));
		      bsnsReportService.modify(bsnsreport);
			} catch (Exception e) {
				result="{\"msg\":\"fail\",\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
				e.printStackTrace();
			}
			 WebTool.writeHtml(result, response);
			 return null;
	}
	*/
	
	/**
	 * 下载sftp服务器上文件
	 * @param model
	 * @param bsnsreport
	 * @return
	 */	
	@RequestMapping(value="download")
	public String downloadFile(Model model,String reportno, HttpServletResponse response){
		String result=null;
		try{
			BsnsReport bsnsreport=bsnsReportService.getById(reportno);       
			
			//设置文件MIME类型  
			response.setContentType("text/html;charset=UTF-8");			
	        //设置Content-Disposition  
	        response.setHeader("Content-Disposition", "attachment;filename="+bsnsreport.getFileName());  
	        //读取目标文件，通过response将目标文件写到客户端  
	        OutputStream out = response.getOutputStream();  
	                
			//下载sftp上原文件
			SftpUtil sftpUtil = new SftpUtil();
			sftpUtil.connect();
			String downloadFile =bsnsreport.getUrl();		
			String fileDir = downloadFile.substring(0,downloadFile.lastIndexOf("/"));
			String filename = downloadFile.substring(downloadFile.lastIndexOf("/")+1);
			sftpUtil.download(fileDir, filename,out);
			//
			out.close();
		}catch(Exception e){
			result="{\"status\":0,\"message\":\"" +WebTool.getErrorMsg(e.getMessage())+"\"}";
			e.printStackTrace();
		}
//		WebTool.writeJson(result, response);
		return null;
	}

	/**
	* @author wangyaowei
	* @date 2015-3-28上午1:32:42
	* @Title: uploadUI
	* @Description: TODO(修改页面)
	* @param model
	* @param reportno
	* @return
	* @return String    返回类型
	* @throws
	*/
	@RequestMapping(value = "updateUI")
	public String updateUI(Model model,String reportno) {
		BsnsReport bsnsreport=bsnsReportService.getById(reportno);
		model.addAttribute("bsnsreport", bsnsreport);
		model.addAttribute("applyNo", bsnsreport.getApplyno());
		return "/mf/bsnsmng/report/edit";
	}
	
	@RequestMapping(value="upload")
	   public String upload(Model model,HttpServletRequest request){
		   String applyNo = request.getParameter("applyNo");
		   model.addAttribute("applyNo", applyNo);
		   return "/mf/cntrtmng/cntrctextend/report/list";
	   }
	
	/**
	 * 跳到新增页面
	 * @return
	 */
	@RequestMapping(value="addExtendUI")
	public String addExtendUI(Model model,HttpServletResponse response,HttpServletRequest request){
		String applyNo=request.getParameter("applyNo");
		System.out.println(applyNo);
		model.addAttribute("applyNo", applyNo);
		return "/mf/cntrtmng/cntrctextend/report/add";
	}
}

