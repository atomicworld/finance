/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author yangchao
 * @2015-01-27
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class AfterWarnparm extends com.mf.base.BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "AfterWarnparm";
	public static final String ALIAS_RCRDID = "记录号";
	public static final String ALIAS_WARNDAY = "告警提前天数";
	public static final String ALIAS_WARNNM = "预警类型名称";
	public static final String ALIAS_CNTRCTNO = "预警类型描述";
	public static final String ALIAS_DUENO = "是否生效";
	
	//date formats
	
	public AfterWarnparm(){
	}

	public AfterWarnparm(
		java.lang.Integer rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**记录号==>db_column: RCRDID*/
	private java.lang.Integer rcrdid;
	/**告警提前天数==>db_column: WARNDAY*/
	private java.lang.String warnday;
	/**预警类型名称==>db_column: WARNNM*/
	private java.lang.String warnnm;
	/**预警类型描述==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**是否生效==>db_column: DUENO*/
	private java.lang.String dueno;
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

	public void setRcrdid(java.lang.Integer value) {
		this.rcrdid = value;
	}
	
	public java.lang.Integer getRcrdid() {
		return this.rcrdid;
	}
	public void setWarnday(java.lang.String value) {
		this.warnday = value;
	}
	
	public java.lang.String getWarnday() {
		return this.warnday;
	}
	public void setWarnnm(java.lang.String value) {
		this.warnnm = value;
	}
	
	public java.lang.String getWarnnm() {
		return this.warnnm;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	public void setDueno(java.lang.String value) {
		this.dueno = value;
	}
	
	public java.lang.String getDueno() {
		return this.dueno;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Rcrdid",getRcrdid())
			.append("Warnday",getWarnday())
			.append("Warnnm",getWarnnm())
			.append("Cntrctno",getCntrctno())
			.append("Dueno",getDueno())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getRcrdid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof AfterWarnparm == false) return false;
		if(this == obj) return true;
		AfterWarnparm other = (AfterWarnparm)obj;
		return new EqualsBuilder()
			.append(getRcrdid(),other.getRcrdid())
			.isEquals();
	}
}

