/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-04-20
 * @version 1.0
 * @param <T>
 */

public class AfterBadloan extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AfterBadloan";
	public static final String ALIAS_RECDID = "recdid";
	public static final String ALIAS_DUENO = "借据号";
	public static final String ALIAS_AMNT = "金额";
	public static final String ALIAS_STATUS = "状态 0未处置 1已处置";
	public static final String ALIAS_DESCS = "描述";
	public static final String ALIAS_CRTDATE = "创建日期";
	
	//date formats
	
	public AfterBadloan(){
	}

	public AfterBadloan(
		java.lang.String recdid
	){
		this.recdid = recdid;
	}

	
	//columns START
	/**recdid==>db_column: recdid*/
	private java.lang.String recdid;
	/**借据号==>db_column: dueno*/
	private java.lang.String dueno;
	/**金额==>db_column: amnt*/
	private BigDecimal amnt;
	/**状态 0未处置 1已处置==>db_column: status*/
	private java.lang.String status;
	/**描述==>db_column: descs*/
	private java.lang.String descs;
	/**创建日期==>db_column: crtdate*/
	private java.lang.String crtdate;
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

	public void setRecdid(java.lang.String value) {
		this.recdid = value;
	}
	
	public java.lang.String getRecdid() {
		return this.recdid;
	}
	public void setDueno(java.lang.String value) {
		this.dueno = value;
	}
	
	public java.lang.String getDueno() {
		return this.dueno;
	}
	public void setStatus(java.lang.String value) {
		this.status = value;
	}
	
	public java.lang.String getStatus() {
		return this.status;
	}
	public void setDescs(java.lang.String value) {
		this.descs = value;
	}
	
	public java.lang.String getDescs() {
		return this.descs;
	}
	public void setCrtdate(java.lang.String value) {
		this.crtdate = value;
	}
	
	public java.lang.String getCrtdate() {
		return this.crtdate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Recdid",getRecdid())
			.append("Dueno",getDueno())
			.append("Amnt",getAmnt())
			.append("Status",getStatus())
			.append("Descs",getDescs())
			.append("Crtdate",getCrtdate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRecdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AfterBadloan == false) return false;
		if(this == obj) return true;
		AfterBadloan other = (AfterBadloan)obj;
		return new EqualsBuilder()
			.append(getRecdid(),other.getRecdid())
			.isEquals();
	}

	public void setAmnt(BigDecimal amnt) {
		this.amnt = amnt;
	}

	public BigDecimal getAmnt() {
		return amnt;
	}
}

