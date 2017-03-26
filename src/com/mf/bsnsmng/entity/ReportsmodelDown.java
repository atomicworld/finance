package com.mf.bsnsmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-06-24
 * @version 1.0
 * @param <T>
 */

public class ReportsmodelDown extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "ReportsmodelDown";
	public static final String ALIAS_REPORTNO = "报表主键";
	public static final String ALIAS_REPORTNAME = "报表名称";
	public static final String ALIAS_DOWNPATH = "报表下载路径";
	
	//date formats
	
	public ReportsmodelDown(){
	}

	public ReportsmodelDown(
		java.lang.String reportno
	){
		this.reportno = reportno;
	}

	
	//columns START
	/**报表主键==>db_column: REPORTNO*/
	private java.lang.String reportno;
	/**报表名称==>db_column: REPORTNAME*/
	private java.lang.String reportname;
	/**报表下载路径==>db_column: DOWNPATH*/
	private java.lang.String downpath;
	/**报表描述==>db_column: memo*/
	private java.lang.String memo;
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

	public void setReportno(java.lang.String value) {
		this.reportno = value;
	}
	
	public java.lang.String getReportno() {
		return this.reportno;
	}
	public void setReportname(java.lang.String value) {
		this.reportname = value;
	}
	
	public java.lang.String getReportname() {
		return this.reportname;
	}
	public void setDownpath(java.lang.String value) {
		this.downpath = value;
	}
	
	public java.lang.String getDownpath() {
		return this.downpath;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Reportno",getReportno())
			.append("Reportname",getReportname())
			.append("Downpath",getDownpath())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getReportno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ReportsmodelDown == false) return false;
		if(this == obj) return true;
		ReportsmodelDown other = (ReportsmodelDown)obj;
		return new EqualsBuilder()
			.append(getReportno(),other.getReportno())
			.isEquals();
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}

	public java.lang.String getMemo() {
		return memo;
	}

}

