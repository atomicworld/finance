/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author yangchao
 * @2015-03-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class BsnsReport extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BsnsReport";
	public static final String ALIAS_REPORTNO = "编号";
	public static final String ALIAS_INTRO = "描述";
	public static final String ALIAS_URL = "地址";
	public static final String ALIAS_APPLYNO = "申请报告";
	
	//date formats
	
	public BsnsReport(){
	}

	public BsnsReport(
		java.lang.Integer reportno
	){
		this.reportno = reportno;
	}

	
	//columns START
	/**编号==>db_column: reportno*/
	private java.lang.Integer reportno;
	/**描述==>db_column: desc*/
	private java.lang.String intro;
	/**地址==>db_column: url*/
	private java.lang.String url;
	/**申请报告==>db_column: applyno*/
	private java.lang.String applyno;
	private java.lang.String fileName;
	//columns END
	
	//系统框架字段 start
	
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

	public void setReportno(java.lang.Integer value) {
		this.reportno = value;
	}
	
	public java.lang.Integer getReportno() {
		return this.reportno;
	}
	public java.lang.String getIntro() {
		return intro;
	}

	public void setIntro(java.lang.String intro) {
		this.intro = intro;
	}

	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	public void setApplyno(java.lang.String value) {
		this.applyno = value;
	}
	
	public java.lang.String getApplyno() {
		return this.applyno;
	}

	public java.lang.String getFileName() {
		return fileName;
	}

	public void setFileName(java.lang.String fileName) {
		this.fileName = fileName;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Reportno",getReportno())
			.append("Intro",getIntro())
			.append("Url",getUrl())
			.append("Applyno",getApplyno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getReportno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsReport == false) return false;
		if(this == obj) return true;
		BsnsReport other = (BsnsReport)obj;
		return new EqualsBuilder()
			.append(getReportno(),other.getReportno())
			.isEquals();
	}
}

