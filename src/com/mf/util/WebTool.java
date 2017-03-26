package com.mf.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.mf.financemng.entity.FnncAccntitem;

import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 这是一个分页工具
 * 主要用于显示页码
 *　pagecode　要获得记录的开始索引　即　开始页码
 *  pageNow 　当前页
 *　pageCount 总页数
 *
 *  这个工具类　返回的是页索引　PageIndex
 * @version 1.0v
 */
public class WebTool {
	
  public static PageIndex getPageIndex(long pagecode, int pageNow, long pageCount){
		long startpage = pageNow-(pagecode%2==0? pagecode/2-1 : pagecode/2);
		long endpage = pageNow+pagecode/2;
		if(startpage<1){
			startpage = 1;
			if(pageCount>=pagecode) endpage = pagecode;
			else endpage = pageCount;
		}
		if(endpage>pageCount){
			endpage = pageCount;
			if((endpage-pagecode)>0) startpage = endpage-pagecode+1;
			else startpage = 1;
		}
		return new PageIndex(startpage, endpage);		
  }
  
	public static void writeJson(String result, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			response.setContentType("application/json;charset=UTF-8");
			writer = response.getWriter();
			writer.write(result);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeHtml(String result, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			writer = response.getWriter();
			writer.write(result);
			writer.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getErrorMsg(String message) {
		String msg = "";
		if(message!= null){
			String[] msgs = message.split(":");
			msg = msgs[msgs.length - 1];
		}
		return msg;
	}
	/**
	 * 下载
	 */
	  public static void exportExcel1(HttpServletResponse response,List<FnncAccntitem> list) {   
		 SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
		  WritableWorkbook wbook=null;
		  OutputStream os =null;
		  String name ="总账模板_"+ sf.format(new Date());
		  try { 
			 
		    os= response.getOutputStream();// 取得输出流   
		     // response.reset();
		      response.reset(); // 清空输出流   
		      response.setHeader("Content-disposition", "attachment; filename="+new String(name.getBytes("gbk"),"iso8859-1")+".xls");// 设定输出文件头   
		      response.setContentType("application/msexcel");// 定义输出类型 
		       wbook = Workbook.createWorkbook(os); // 建立excel文件   
		      String tmptitle = name; // 标题   
		      WritableSheet wsheet = wbook.createSheet(tmptitle, 0); // sheet名称  
		      wsheet.getSettings().setDefaultColumnWidth(15); // 设置列宽
		      
		       //设置excel标题   
		       WritableFont wfont = new WritableFont(WritableFont.ARIAL, 16,WritableFont.BOLD, 
		                     false,UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
		        WritableCellFormat wcfFC = new WritableCellFormat(wfont); 
		        wcfFC.setBackground(Colour.AQUA); 
		        //wsheet.addCell(new Label(1, 0, tmptitle, wcfFC));   
		        wfont = new jxl.write.WritableFont(WritableFont.ARIAL, 14,WritableFont.BOLD, 
		                 false, UnderlineStyle.NO_UNDERLINE,Colour.BLACK);   
		         wcfFC = new WritableCellFormat(wfont);  

		          //开始生成主体内容           
		          wsheet.addCell(new Label(0, 0, "科目号")); 
		          wsheet.addCell(new Label(1, 0, "科目名称")); 
		          wsheet.addCell(new Label(2, 0, "科目余额方向")); 
		          wsheet.addCell(new Label(3, 0, "当前借方余额"));
		          wsheet.addCell(new Label(4, 0, "当前贷方余额"));
		         String accntdrct = "";
		        
		          for(int j=0;j<list.size();j++){
		        	  if("1".equals(list.get(j).getAccntdrct())){
		        		  accntdrct="借";
				         }
		        	  if("2".equals(list.get(j).getAccntdrct())){
		        		  accntdrct="贷";
				         }
		  			   wsheet.addCell(new Label(0, j+1,list.get(j).getAccntno()));  
		               wsheet.addCell(new Label(1, j+1,list.get(j).getAccntnm()));  
		               wsheet.addCell(new Label(2, j+1,accntdrct)); 
		               wsheet.addCell(new Label(3, j+1,"0.00"));
		               wsheet.addCell(new Label(4, j+1,"0.00")); 
		          }
		       
		              //主体内容生成结束           
		               wbook.write(); // 写入文件   
		              
		             
		             } 
		       catch(Exception ex) { 
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
  
	  	/**
		 * 下载文件
		 */
		  public static void downloadFile(HttpServletResponse response,String filePath,String fileName) {  
				File file = new File(filePath);
			  
				OutputStream out = null;
				BufferedInputStream bin = null;
				FileInputStream fis = null;
				try {
					response.setCharacterEncoding("utf-8");
					response.addHeader("Content-Disposition", "attachment; filename="+new String(fileName.getBytes("gbk"),"iso8859-1"));
					response.setContentType("application/octet-stream");
					out = response.getOutputStream();
					fis = new FileInputStream(file.getPath());
					bin = new BufferedInputStream(fis);
					byte[] buf = new byte[1024];
					int len = 0;
					while ((len = bin.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					IOUtils.closeQuietly(bin);
					IOUtils.closeQuietly(out);
					IOUtils.closeQuietly(fis);
					if(file!= null && file.exists()){
						file.delete();
					}
				}
		  }
}
