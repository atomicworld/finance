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
 * @2014-12-26
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntEeAttention implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "关注信息";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_BUSSDT = "业务发生日期";
	public static final String ALIAS_IDTRECFNO = "被起诉记录流水号";
	public static final String ALIAS_PLAINNM = "起诉人名称";
	public static final String ALIAS_CURTP = "币种";
	public static final String ALIAS_JDEXAMT = "判决执行金额";
	public static final String ALIAS_JDEXECDT = "判决执行日期";
	public static final String ALIAS_EXECRLT = "执行结果";
	public static final String ALIAS_IDCTCAU = "被起诉原因";
	public static final String ALIAS_MEMRECFNO = "大事信息记录流水号";
	public static final String ALIAS_MEMORDES = "大事描述";
	
	//date formats
	
	public ClntEeAttention(){
	}

	public ClntEeAttention(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**业务发生日期==>db_column: BUSSDT*/
	private java.lang.String bussdt;
	/**被起诉记录流水号==>db_column: IDTRECFNO*/
	private java.lang.String idtrecfno;
	/**起诉人名称==>db_column: PLAINNM*/
	private java.lang.String plainnm;
	/**币种==>db_column: CURTP*/
	private java.lang.String curtp;
	/**判决执行金额==>db_column: JDEXAMT*/
	private BigDecimal jdexamt;
	/**判决执行日期==>db_column: JDEXECDT*/
	private java.lang.String jdexecdt;
	/**执行结果==>db_column: EXECRLT*/
	private java.lang.String execrlt;
	/**被起诉原因==>db_column: IDCTCAU*/
	private java.lang.String idctcau;
	/**大事信息记录流水号==>db_column: MEMRECFNO*/
	private java.lang.String memrecfno;
	/**大事描述==>db_column: MEMORDES*/
	private java.lang.String memordes;
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
	public void setBussdt(java.lang.String value) {
		this.bussdt = value;
	}
	
	public java.lang.String getBussdt() {
		return this.bussdt;
	}
	public void setIdtrecfno(java.lang.String value) {
		this.idtrecfno = value;
	}
	
	public java.lang.String getIdtrecfno() {
		return this.idtrecfno;
	}
	public void setPlainnm(java.lang.String value) {
		this.plainnm = value;
	}
	
	public java.lang.String getPlainnm() {
		return this.plainnm;
	}
	public void setCurtp(java.lang.String value) {
		this.curtp = value;
	}
	
	public java.lang.String getCurtp() {
		return this.curtp;
	}
	
	public BigDecimal getJdexamt() {
		return jdexamt;
	}

	public void setJdexamt(BigDecimal jdexamt) {
		this.jdexamt = jdexamt;
	}

	public void setJdexecdt(java.lang.String value) {
		this.jdexecdt = value;
	}
	
	public java.lang.String getJdexecdt() {
		return this.jdexecdt;
	}
	public void setExecrlt(java.lang.String value) {
		this.execrlt = value;
	}
	
	public java.lang.String getExecrlt() {
		return this.execrlt;
	}
	public void setIdctcau(java.lang.String value) {
		this.idctcau = value;
	}
	
	public java.lang.String getIdctcau() {
		return this.idctcau;
	}
	public void setMemrecfno(java.lang.String value) {
		this.memrecfno = value;
	}
	
	public java.lang.String getMemrecfno() {
		return this.memrecfno;
	}
	public void setMemordes(java.lang.String value) {
		this.memordes = value;
	}
	
	public java.lang.String getMemordes() {
		return this.memordes;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Bussdt",getBussdt())
			.append("Idtrecfno",getIdtrecfno())
			.append("Plainnm",getPlainnm())
			.append("Curtp",getCurtp())
			.append("Jdexamt",getJdexamt())
			.append("Jdexecdt",getJdexecdt())
			.append("Execrlt",getExecrlt())
			.append("Idctcau",getIdctcau())
			.append("Memrecfno",getMemrecfno())
			.append("Memordes",getMemordes())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEeAttention == false) return false;
		if(this == obj) return true;
		ClntEeAttention other = (ClntEeAttention)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

