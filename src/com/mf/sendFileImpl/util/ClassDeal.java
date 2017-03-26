package com.mf.sendFileImpl.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.mf.sendFileImpl.entity.BlackList;
import com.mf.sendFileImpl.entity.BsnsApplyData;

public class ClassDeal {
	//拼成需要的字符串
	public static String getString(Object object) throws Exception {
		// 获得对象类型
		Class classType = object.getClass();
		Field fields[] = classType.getDeclaredFields();
		StringBuffer strvalu=new StringBuffer();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase(); // 获得和属性对应的getXXX()方法的名字
			String getMethodName = "get" + firstLetter + fieldName.substring(1); // 获得和属性对应的setXXX()方法的名字
			Method getMethod = classType.getMethod(getMethodName, new Class[] {}); // 获得和属性对应的setXXX()方法
			Object value = getMethod.invoke(object, new Object[] {});
//			System.out.println(fieldName + ":" + value); // 调用拷贝对象的setXXX()方法
			if(value==null){
				strvalu.append( fieldName+ "=\"\" ");
			}else{
				strvalu.append( fieldName+ "=\"" +value+ "\" ");
			}
		}
	 	return strvalu.toString();
	}
	
	//获取非正常客户的xml
	public static String getBustString(List<BlackList> list){
		StringBuffer strvalu = new StringBuffer();
		strvalu.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<Root>\n<dict/>\n<tb_RB_ReportDetail ");
		//head
		strvalu.append("Batch=\"20101011\" ");
		strvalu.append("OrgCode=\"A001\" ");
		strvalu.append("RptType=\"BCUST\" />\n");
		//body
		for(int i=0;i<list.size();i++){	//取到一个list，bkList的集合
			strvalu.append("<tb_FB_BadCust RowGuid=\"" +GUIDGener.getUUID() + "\" ");
			try{
				strvalu.append(getString(list.get(i)));
			}catch (Exception e) {
				e.printStackTrace();
			}
			strvalu.append("/>\n");
		}
		strvalu.append("</Root>");
		return strvalu.toString();
	} 
	
	public static String getBsnsApplyData(List<BsnsApplyData> list){
		StringBuffer strvalu = new StringBuffer();
		strvalu.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<Root>\n<dict/>\n<tb_RB_ReportDetail ");
		//head
		strvalu.append("Batch=\"20101011\" ");
		strvalu.append("OrgCode=\"A001\" ");
		strvalu.append("RptType=\"BCUST\" />\n");
		//body
		for(int i=0;i<list.size();i++){	//取到一个list的集合
			strvalu.append("<tb_FB_BadCust RowGuid=\"" +GUIDGener.getUUID() + "\" ");
			try{
				strvalu.append(getString(list.get(i)));
			}catch (Exception e) {
				e.printStackTrace();
			}
			strvalu.append("/>\n");
		}
		strvalu.append("</Root>");
		return strvalu.toString();
	} 
	
	public static String getCLDRString(List<Object> list){
		StringBuffer strvalu = new StringBuffer();
		strvalu.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<Root>\n<dict/>\n<tb_RB_ReportDetail ");
		//head
		strvalu.append("Batch=\"20101011\" ");
		strvalu.append("OrgCode=\"A001\" ");
		strvalu.append("RptType=\"CLDR\" />\n");
		//body
		for(int i=0;i<list.size();i++){
			strvalu.append("<tb_RF_Loan ");
			try{
				strvalu.append(getString(list.get(i)));
			}catch (Exception e) {
				e.printStackTrace();
			}
			strvalu.append(">\n");
			strvalu.append("</tb_RF_Loan >\n");
		}
		strvalu.append("</Root>");
		return strvalu.toString();
	} 
	
}
