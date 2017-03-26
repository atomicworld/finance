/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessInfo.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.businessInfo.entity.*;
import com.mf.util.*;

/**
 * @author wangyw
 * @2015-08-26
 * @version 1.0
 * @param <T>
 */

public class Fileupdown extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Fileupdown";
	public static final String ALIAS_FILENAME = "文件名字";
	public static final String ALIAS_FILESIZE = "文件大小";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_UPDAY = "上传日期";
	public static final String ALIAS_FILEPATH = "文件路径";
	public static final String ALIAS_FILETYPE = "文件类型";
	public static final String ALIAS_month = "月份";
	public static final String ALIAS_REPORTID = "审计表关联id";
	
	//date formats
	
	public Fileupdown(){
	}

	public Fileupdown(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**文件名字==>db_column: filename*/
	private java.lang.String filename;
	/**文件大小==>db_column: filesize*/
	private java.lang.Long filesize;
	/**id==>db_column: id*/
	private java.lang.Integer id;
	/**上传日期==>db_column: upday*/
	private java.lang.String upday;
	/**文件路径==>db_column: filepath*/
	private java.lang.String filepath;
	/**文件类型==>db_column: filetype*/
	private java.lang.String filetype;
	private java.lang.String month;
	
	private java.lang.String reportid;
	
	//系统框架字段 start
	
	public java.lang.String getMonth() {
		return month;
	}

	public void setMonth(java.lang.String month) {
		this.month = month;
	}


	private java.lang.String sort;
	private java.lang.String direction;
	public java.lang.String getSort() {
		return sort;
	}
	
	public void setSort(java.lang.String sort) {
		this.sort = sort;
	}
	
	public java.lang.String getDirection() {
		return direction;
	}
	
	public void setDirection(java.lang.String direction) {
		this.direction = direction;
	}
	//系统框架字段 end

	public void setFilename(java.lang.String value) {
		this.filename = value;
	}
	
	public java.lang.String getFilename() {
		return this.filename;
	}
	
	public java.lang.Long getFilesize() {
		return filesize;
	}

	public void setFilesize(java.lang.Long filesize) {
		this.filesize = filesize;
	}

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setUpday(java.lang.String value) {
		this.upday = value;
	}
	
	public java.lang.String getUpday() {
		return this.upday;
	}
	public void setFilepath(java.lang.String value) {
		this.filepath = value;
	}
	
	public java.lang.String getFilepath() {
		return this.filepath;
	}
	public void setFiletype(java.lang.String value) {
		this.filetype = value;
	}
	
	public java.lang.String getFiletype() {
		return this.filetype;
	}

	public java.lang.String getReportid() {
		return reportid;
	}

	public void setReportid(java.lang.String reportid) {
		this.reportid = reportid;
	}

	

	

	

	
}

