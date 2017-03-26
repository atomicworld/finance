/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.businessData.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author yangchao
 * @2015-04-02
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class Clntturnover extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Clntturnover";
	public static final String ALIAS_RECORDID = "recordid";
	public static final String ALIAS_OUTOPNO = "outopno";
	public static final String ALIAS_RCVOPNO = "rcvopno";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_TURNOVRDATE = "turnovrdate";
	public static final String ALIAS_OUTNAME = "移交人姓名";
	public static final String ALIAS_RCVNAME = "接受人姓名";
	
	//date formats
	
	public Clntturnover(){
	}

	public Clntturnover(
		java.lang.String recordid
	){
		this.recordid = recordid;
	}

	
	//columns START
	/**recordid==>db_column: RECORDID*/
	private java.lang.String recordid;
	/**outopno==>db_column: OUTOPNO*/
	private java.lang.String outopno;
	/**rcvopno==>db_column: RCVOPNO*/
	private java.lang.String rcvopno;
	/**remark==>db_column: remark*/
	private java.lang.String remark;
	/**turnovrdate==>db_column: TURNOVRDATE*/
	private java.lang.String turnovrdate;
	/**移交人姓名==>db_column: OUTNAME*/
	private java.lang.String outname;
	/**接受人姓名==>db_column: RCVNAME*/
	private java.lang.String rcvname;
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

	public void setRecordid(java.lang.String value) {
		this.recordid = value;
	}
	
	public java.lang.String getRecordid() {
		return this.recordid;
	}
	public void setOutopno(java.lang.String value) {
		this.outopno = value;
	}
	
	public java.lang.String getOutopno() {
		return this.outopno;
	}
	public void setRcvopno(java.lang.String value) {
		this.rcvopno = value;
	}
	
	public java.lang.String getRcvopno() {
		return this.rcvopno;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setTurnovrdate(java.lang.String value) {
		this.turnovrdate = value;
	}
	
	public java.lang.String getTurnovrdate() {
		return this.turnovrdate;
	}
	public void setOutname(java.lang.String value) {
		this.outname = value;
	}
	
	public java.lang.String getOutname() {
		return this.outname;
	}
	public void setRcvname(java.lang.String value) {
		this.rcvname = value;
	}
	
	public java.lang.String getRcvname() {
		return this.rcvname;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Recordid",getRecordid())
			.append("Outopno",getOutopno())
			.append("Rcvopno",getRcvopno())
			.append("Remark",getRemark())
			.append("Turnovrdate",getTurnovrdate())
			.append("Outname",getOutname())
			.append("Rcvname",getRcvname())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRecordid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Clntturnover == false) return false;
		if(this == obj) return true;
		Clntturnover other = (Clntturnover)obj;
		return new EqualsBuilder()
			.append(getRecordid(),other.getRecordid())
			.isEquals();
	}
}

