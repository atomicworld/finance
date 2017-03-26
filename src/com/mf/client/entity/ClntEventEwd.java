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

public class ClntEventEwd implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "重大事件-逃废债情况";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_EWDTP = "逃废债方式";
	public static final String ALIAS_EWDAMNT = "逃废本金";
	public static final String ALIAS_EWDINST = "逃废利息";
	public static final String ALIAS_UPDTAMNT = "更正本金";
	public static final String ALIAS_UPDTINST = "更正利息";
	public static final String ALIAS_DEALFLAG = "处理状态";
	public static final String ALIAS_CURTP = "币种";
	public static final String ALIAS_SCDATE = "登记日期";
	public static final String ALIAS_LASTMODDATE = "更新日期";
	public static final String ALIAS_USERID = "登记人ID";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntEventEwd(){
	}

	public ClntEventEwd(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**逃废债方式==>db_column: EWDTP*/
	private java.lang.String ewdtp;
	/**逃废本金==>db_column: EWDAMNT*/
	private BigDecimal ewdamnt;
	/**逃废利息==>db_column: EWDINST*/
	private BigDecimal ewdinst;
	/**更正本金==>db_column: UPDTAMNT*/
	private BigDecimal updtamnt;
	/**更正利息==>db_column: UPDTINST*/
	private BigDecimal updtinst;
	/**处理状态==>db_column: DEALFLAG*/
	private java.lang.String dealflag;
	/**币种==>db_column: CURTP*/
	private java.lang.String curtp;
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
	public void setEwdtp(java.lang.String value) {
		this.ewdtp = value;
	}
	
	public java.lang.String getEwdtp() {
		return this.ewdtp;
	}

	public BigDecimal getEwdamnt() {
		return ewdamnt;
	}

	public void setEwdamnt(BigDecimal ewdamnt) {
		this.ewdamnt = ewdamnt;
	}

	public BigDecimal getEwdinst() {
		return ewdinst;
	}

	public void setEwdinst(BigDecimal ewdinst) {
		this.ewdinst = ewdinst;
	}

	public BigDecimal getUpdtamnt() {
		return updtamnt;
	}

	public void setUpdtamnt(BigDecimal updtamnt) {
		this.updtamnt = updtamnt;
	}

	public BigDecimal getUpdtinst() {
		return updtinst;
	}

	public void setUpdtinst(BigDecimal updtinst) {
		this.updtinst = updtinst;
	}

	public void setDealflag(java.lang.String value) {
		this.dealflag = value;
	}
	
	public java.lang.String getDealflag() {
		return this.dealflag;
	}
	public void setCurtp(java.lang.String value) {
		this.curtp = value;
	}
	
	public java.lang.String getCurtp() {
		return this.curtp;
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
			.append("Ewdtp",getEwdtp())
			.append("Ewdamnt",getEwdamnt())
			.append("Ewdinst",getEwdinst())
			.append("Updtamnt",getUpdtamnt())
			.append("Updtinst",getUpdtinst())
			.append("Dealflag",getDealflag())
			.append("Curtp",getCurtp())
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
		if(obj instanceof ClntEventEwd == false) return false;
		if(this == obj) return true;
		ClntEventEwd other = (ClntEventEwd)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

