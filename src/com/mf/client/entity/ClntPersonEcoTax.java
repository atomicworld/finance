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

public class ClntPersonEcoTax implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "个人纳税";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_TAXTYPE = "税种";
	public static final String ALIAS_TAXCURTYPE = "纳税币种";
	public static final String ALIAS_TAXAMT = "纳税金额";
	public static final String ALIAS_TAXDATE = "纳税日期";
	public static final String ALIAS_BEGINDATE = "区间开始日期";
	public static final String ALIAS_ENDDTATE = "区间结束日期";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonEcoTax(){
	}

	public ClntPersonEcoTax(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**税种==>db_column: TAXTYPE*/
	private java.lang.String taxtype;
	/**纳税币种==>db_column: TAXCURTYPE*/
	private java.lang.String taxcurtype;
	/**纳税金额==>db_column: TAXAMT*/
	private BigDecimal taxamt;
	/**纳税日期==>db_column: TAXDATE*/
	private java.lang.String taxdate;
	/**区间开始日期==>db_column: BEGINDATE*/
	private java.lang.String begindate;
	/**区间结束日期==>db_column: ENDDTATE*/
	private java.lang.String enddtate;
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
	public void setTaxtype(java.lang.String value) {
		this.taxtype = value;
	}
	
	public java.lang.String getTaxtype() {
		return this.taxtype;
	}
	public void setTaxcurtype(java.lang.String value) {
		this.taxcurtype = value;
	}
	
	public java.lang.String getTaxcurtype() {
		return this.taxcurtype;
	}
	
	public BigDecimal getTaxamt() {
		return taxamt;
	}

	public void setTaxamt(BigDecimal taxamt) {
		this.taxamt = taxamt;
	}

	public void setTaxdate(java.lang.String value) {
		this.taxdate = value;
	}
	
	public java.lang.String getTaxdate() {
		return this.taxdate;
	}
	public void setBegindate(java.lang.String value) {
		this.begindate = value;
	}
	
	public java.lang.String getBegindate() {
		return this.begindate;
	}
	public void setEnddtate(java.lang.String value) {
		this.enddtate = value;
	}
	
	public java.lang.String getEnddtate() {
		return this.enddtate;
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
			.append("Taxtype",getTaxtype())
			.append("Taxcurtype",getTaxcurtype())
			.append("Taxamt",getTaxamt())
			.append("Taxdate",getTaxdate())
			.append("Begindate",getBegindate())
			.append("Enddtate",getEnddtate())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntPersonEcoTax == false) return false;
		if(this == obj) return true;
		ClntPersonEcoTax other = (ClntPersonEcoTax)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

