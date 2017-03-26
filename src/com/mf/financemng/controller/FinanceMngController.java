package com.mf.financemng.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.common.pub.PubConstants;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.entity.FnncLedger;
import com.mf.financemng.service.FnncAccntctlcdService;
import com.mf.financemng.service.FnncAccntitemService;
import com.mf.financemng.service.FnncLedgerService;
import com.mf.util.WebTool;

@Controller
@RequestMapping(value = "/mf/financeMng/")
public class FinanceMngController {
	@Autowired
	private FnncAccntitemService fnncAccntitemService;
	@Autowired
	private FnncAccntctlcdService fnncAccntctlcdService;
	@Autowired
	private FnncLedgerService fnncLedgerService;

	/**
	 * 跳转到余额初始化页面
	 */

	@RequestMapping(value = "balance")
	public String balance(Model model, HttpServletRequest request) {

		return "/mf/financemng/balance";
	}

	/**
	 * 下载功能
	 */
	@RequestMapping(value = "downFile")
	public String downFile(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		List<FnncAccntitem> list = fnncAccntitemService.findAll();
		WebTool.exportExcel1(response, list);
		return null;
	}

	/**
	 * 跳转到上传页面
	 */
	@RequestMapping(value = "upFile")
	public String upFile(Model model) {
		return "/mf/financemng/upFile";
	}

	/**
	 * 实现上传功能
	 */
	@RequestMapping(value = "upFileUI")
	public String upFileUI(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddhhmmss");
		String result = "{\"msg\":false,\"message\":\"上传成功!\"}";
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 当上传文件太大时，因为虚拟机能使用的内存是有限的，所以此时要通过临时文件来实现上传文件的保存
		// 此方法是设置是否使用临时文件的临界值（单位：字节）
		factory.setSizeThreshold(10000);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");

		List<File> items;

		try {
			items = upload.parseRequest(request);
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (item.isFormField()) {
					// 如果是普通表单字段
					String name = item.getFieldName();
					String value = item.getString("utf-8");

				} else {
					// 如果是文件字段
					String fileName = item.getName();
					System.out.println("foleName=="+fileName);
					fileName = fileName.substring(fileName.indexOf(".") + 1,
							fileName.length());
					String fileName1 = sf.format(new Date()) + ".xls";
					
					if (!"xls".equals(fileName)) {
						result = "{\"msg\":false,\"message\":\"请选择execl文件!\"}";
					} else {
						result = "{\"msg\":true,\"message\":\"" + fileName1
								+ "\"}";
					}
					String path = request.getRealPath("/") + "upload";
					File f = new File(path);
					if (!f.exists()) {
						f.mkdirs();
					}
					FileOutputStream fos = new FileOutputStream(path
							+ File.separator + fileName1);
					if (item.isInMemory()) {
						fos.write(item.get());
						fos.close();
					} else {
						InputStream is = item.getInputStream();
						byte[] buffer = new byte[1024];
						int len;
						while ((len = is.read(buffer)) > 0) {
							fos.write(buffer, 0, len);
						}
						is.close();
						fos.close();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		WebTool.writeHtml(result, response);
		return null;
	}

	/**
	 * excel里的数据修改
	 */
	@RequestMapping(value = "saveExl")
	public String saveExl(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String result = "{\"status\":true,\"message\":\"初始化成功\"}";
		String path = request.getRealPath("/") + "upload" + File.separator
				+ File.separator;
		String filename = request.getParameter("fileName");
		path = path + filename;
		try {
			String[][] a = getDataByJxl(path);// 获取到excel的二维数组
//			int rows = a.length;// excel的行
			// int cows = a[0].length;//excel的列
			String ledgerdate = request.getParameter("ledgerdate");// 总账日期
			ledgerdate = ledgerdate.replaceAll("-", "");
			FnncLedger fnncLedger = new FnncLedger();
			fnncLedger.setLedgerdate(ledgerdate);
			fnncLedgerService.initFromExcel(fnncLedger, a);
		} catch (Exception e) {
			result = "{\"status\":false,\"message\":\"初始化失败\"}";
			e.printStackTrace();

		}
		WebTool.writeJson(result, response);
		return null;
	}

	

	public static String[][] getDataByJxl(String filepath) {
		String str[][] = null;
		try {
			Workbook book = Workbook.getWorkbook(new File(filepath));
			// 获得第一个工作表对象
			Sheet sheet = book.getSheet(0);
			int rows = getRightRows(sheet);
			if (rows == 0) {
				return null;
			}
			int cols = sheet.getColumns();
			str = new String[rows][cols];
			for (int i = 0; i < rows; i++) {
				if (sheet.getRow(i) == null) {
					continue;
				}
				for (int j = 0; j < cols; j++) {
					if (sheet.getColumn(j) != null) {
						Cell cell = sheet.getCell(j, i);
						str[i][j] = cell.getContents();
					}
				}
			}
			book.close();

		} catch (Exception e) {
			str = new String[1][1];
			str[0][0] = "E:模板文件错误，请检查模板对应是否正确";
		}
		return str;
	}

	private static int getRightRows(Sheet sheet) {
		// System.out.println("11111111");
		int rsCols = sheet.getColumns(); // 列数
		int rsRows = sheet.getRows(); // 行数
		int nullCellNum;
		int afterRows = rsRows;
		for (int i = 1; i < rsRows; i++) { // 统计行中为空的单元格数
			nullCellNum = 0;
			for (int j = 0; j < rsCols; j++) {
				String val = sheet.getCell(j, i).getContents();

				if (val.equals(""))
					nullCellNum++;
			}
			if (nullCellNum >= rsCols) { // 如果nullCellNum大于或等于总的列数
				afterRows--; // 行数减一
			}
		}
		return afterRows;
	}

}
