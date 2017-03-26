/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author xujiuhua
 * @2015-01-05
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntEventMv implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "转移贷款情况";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_HPPNDATE = "发生日期";
	public static final String ALIAS_MVAMNT = "转移金额";
	public static final String ALIAS_EVENTDESC = "事件描述及发生原因";
	public static final String ALIAS_SCDATE = "登记日期";
	public static final String ALIAS_LASTMODDATE = "更新日期";
	public static final String ALIAS_USERID = "登记人ID";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntEventMv(){
	}

	public ClntEventMv(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**发生日期==>db_column: HPPNDATE*/
	private java.lang.String hppndate;
	/**转移金额==>db_column: MVAMNT*/
	private BigDecimal mvamnt;
	/**事件描述及发生原因==>db_column: EVENTDESC*/
	private java.lang.String eventdesc;
	/**登记日期==>db_column: SCDATE*/
	private java.lang.String scdate;
	/**更新日期==>db_column: LASTMODDATE*/
	private java.lang.String lastmoddate;
	/**登记人ID==>db_column: USERID*/
	private java.lang.String userid;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
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

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setHppndate(java.lang.String value) {
		this.hppndate = value;
	}
	
	public java.lang.String getHppndate() {
		return this.hppndate;
	}

	public BigDecimal getMvamnt() {
		return mvamnt;
	}

	public void setMvamnt(BigDecimal mvamnt) {
		this.mvamnt = mvamnt;
	}

	public void setEventdesc(java.lang.String value) {
		this.eventdesc = value;
	}
	
	public java.lang.String getEventdesc() {
		return this.eventdesc;
	}
	public void setScdate(java.lang.String value) {
		this.scdate = value;
	}
	
	public java.lang.String getScdate() {
		return this.scdate;
	}
	public void setLastmoddate(java.lang.String value) {
		this.lastmoddate = value;
	}
	
	public java.lang.String getLastmoddate() {
		return this.lastmoddate;
	}
	public void setUserid(java.lang.String value) {
		this.userid = value;
	}
	
	public java.lang.String getUserid() {
		return this.userid;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Hppndate",getHppndate())
			.append("Mvamnt",getMvamnt())
			.append("Eventdesc",getEventdesc())
			.append("Scdate",getScdate())
			.append("Lastmoddate",getLastmoddate())
			.append("Userid",getUserid())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEventMv == false) return false;
		if(this == obj) return true;
		ClntEventMv other = (ClntEventMv)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

