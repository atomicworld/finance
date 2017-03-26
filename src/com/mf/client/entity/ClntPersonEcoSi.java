/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonEcoSi implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "社会保险";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_SITYPE = "社会保险种类";
	public static final String ALIAS_AMTPERMON = "每月投保金";
	public static final String ALIAS_BALANCEAMT = "余额";
	public static final String ALIAS_BEGINDATE = "投保开始日期";
	public static final String ALIAS_STATENDDATE = "统计截止日期";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonEcoSi(){
	}

	public ClntPersonEcoSi(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**社会保险种类==>db_column: SITYPE*/
	private java.lang.String sitype;
	/**每月投保金==>db_column: AMTPERMON*/
	private BigDecimal amtpermon;
	/**余额==>db_column: BALANCEAMT*/
	private BigDecimal balanceamt;
	/**投保开始日期==>db_column: BEGINDATE*/
	private java.lang.String begindate;
	/**统计截止日期==>db_column: STATENDDATE*/
	private java.lang.String statenddate;
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
	public void setSitype(java.lang.String value) {
		this.sitype = value;
	}
	
	public java.lang.String getSitype() {
		return this.sitype;
	}
	
	public BigDecimal getAmtpermon() {
		return amtpermon;
	}

	public void setAmtpermon(BigDecimal amtpermon) {
		this.amtpermon = amtpermon;
	}

	public BigDecimal getBalanceamt() {
		return balanceamt;
	}

	public void setBalanceamt(BigDecimal balanceamt) {
		this.balanceamt = balanceamt;
	}

	public void setBegindate(java.lang.String value) {
		this.begindate = value;
	}
	
	public java.lang.String getBegindate() {
		return this.begindate;
	}
	public void setStatenddate(java.lang.String value) {
		this.statenddate = value;
	}
	
	public java.lang.String getStatenddate() {
		return this.statenddate;
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
			.append("Sitype",getSitype())
			.append("Amtpermon",getAmtpermon())
			.append("Balanceamt",getBalanceamt())
			.append("Begindate",getBegindate())
			.append("Statenddate",getStatenddate())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntPersonEcoSi == false) return false;
		if(this == obj) return true;
		ClntPersonEcoSi other = (ClntPersonEcoSi)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

