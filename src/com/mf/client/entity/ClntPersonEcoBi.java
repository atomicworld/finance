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

public class ClntPersonEcoBi implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "商业保险";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_BINO = "保险单号";
	public static final String ALIAS_BITYPE = "保险类型";
	public static final String ALIAS_BINAME = "保险名称";
	public static final String ALIAS_BIAMT = "保障金额";
	public static final String ALIAS_CASHVALUE = "现金价值";
	public static final String ALIAS_BICOM = "承保公司";
	public static final String ALIAS_BEGINDATE = "投保日期";
	public static final String ALIAS_CANCELDATE = "退保日期";
	public static final String ALIAS_ENDDATE = "到期日期";
	public static final String ALIAS_STATENDDATE = "统计截止日期";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonEcoBi(){
	}

	public ClntPersonEcoBi(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**保险单号==>db_column: BINO*/
	private java.lang.String bino;
	/**保险类型==>db_column: BITYPE*/
	private java.lang.String bitype;
	/**保险名称==>db_column: BINAME*/
	private java.lang.String biname;
	/**保障金额==>db_column: BIAMT*/
	private BigDecimal biamt;
	/**现金价值==>db_column: CASHVALUE*/
	private BigDecimal cashvalue;
	/**承保公司==>db_column: BICOM*/
	private java.lang.String bicom;
	/**投保日期==>db_column: BEGINDATE*/
	private java.lang.String begindate;
	/**退保日期==>db_column: CANCELDATE*/
	private java.lang.String canceldate;
	/**到期日期==>db_column: ENDDATE*/
	private java.lang.String enddate;
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
	public void setBino(java.lang.String value) {
		this.bino = value;
	}
	
	public java.lang.String getBino() {
		return this.bino;
	}
	public void setBitype(java.lang.String value) {
		this.bitype = value;
	}
	
	public java.lang.String getBitype() {
		return this.bitype;
	}
	public void setBiname(java.lang.String value) {
		this.biname = value;
	}
	
	public java.lang.String getBiname() {
		return this.biname;
	}
	
	public BigDecimal getBiamt() {
		return biamt;
	}

	public void setBiamt(BigDecimal biamt) {
		this.biamt = biamt;
	}

	public BigDecimal getCashvalue() {
		return cashvalue;
	}

	public void setCashvalue(BigDecimal cashvalue) {
		this.cashvalue = cashvalue;
	}

	public void setBicom(java.lang.String value) {
		this.bicom = value;
	}
	
	public java.lang.String getBicom() {
		return this.bicom;
	}
	public void setBegindate(java.lang.String value) {
		this.begindate = value;
	}
	
	public java.lang.String getBegindate() {
		return this.begindate;
	}
	public void setCanceldate(java.lang.String value) {
		this.canceldate = value;
	}
	
	public java.lang.String getCanceldate() {
		return this.canceldate;
	}
	public void setEnddate(java.lang.String value) {
		this.enddate = value;
	}
	
	public java.lang.String getEnddate() {
		return this.enddate;
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
			.append("Bino",getBino())
			.append("Bitype",getBitype())
			.append("Biname",getBiname())
			.append("Biamt",getBiamt())
			.append("Cashvalue",getCashvalue())
			.append("Bicom",getBicom())
			.append("Begindate",getBegindate())
			.append("Canceldate",getCanceldate())
			.append("Enddate",getEnddate())
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
		if(obj instanceof ClntPersonEcoBi == false) return false;
		if(this == obj) return true;
		ClntPersonEcoBi other = (ClntPersonEcoBi)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

