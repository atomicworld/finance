package com.mf.cntrtmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author huangw
 * @2015-06-03
 * @version 1.0
 * @param <T>
 */

public class BsnsOverdueUrge extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "BsnsOverdueUrge";
	public static final String ALIAS_NO = "主键";
	public static final String ALIAS_SRLNO = "计划编号";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_URGEID = "催收人编号";
	public static final String ALIAS_URGENAME = "催收人姓名";
	public static final String ALIAS_URGEDATE = "下达催收通知的日期";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	
	//date formats
	
	public BsnsOverdueUrge(){
	}

	public BsnsOverdueUrge(
		java.lang.Integer no
	){
		this.no = no;
	}

	
	//columns START
	/**主键==>db_column: NO*/
	private java.lang.Integer no;
	/**计划编号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**催收人编号==>db_column: URGEID*/
	private java.lang.String urgeid;
	/**催收人姓名==>db_column: URGENAME*/
	private java.lang.String urgename;
	/**下达催收通知的日期==>db_column: URGEDATE*/
	private java.lang.String urgedate;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
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

	public void setNo(java.lang.Integer value) {
		this.no = value;
	}
	
	public java.lang.Integer getNo() {
		return this.no;
	}
	public void setSrlno(java.lang.String value) {
		this.srlno = value;
	}
	
	public java.lang.String getSrlno() {
		return this.srlno;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setUrgeid(java.lang.String value) {
		this.urgeid = value;
	}
	
	public java.lang.String getUrgeid() {
		return this.urgeid;
	}
	public void setUrgename(java.lang.String value) {
		this.urgename = value;
	}
	
	public java.lang.String getUrgename() {
		return this.urgename;
	}
	public void setUrgedate(java.lang.String value) {
		this.urgedate = value;
	}
	
	public java.lang.String getUrgedate() {
		return this.urgedate;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("No",getNo())
			.append("Srlno",getSrlno())
			.append("Clntno",getClntno())
			.append("Urgeid",getUrgeid())
			.append("Urgename",getUrgename())
			.append("Urgedate",getUrgedate())
			.append("Cntrctno",getCntrctno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNo())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsOverdueUrge == false) return false;
		if(this == obj) return true;
		BsnsOverdueUrge other = (BsnsOverdueUrge)obj;
		return new EqualsBuilder()
			.append(getNo(),other.getNo())
			.isEquals();
	}
}



