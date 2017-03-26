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

public class ClntEeCapOut implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "对外投资";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_INVESTNM = "被投资单位名称";
	public static final String ALIAS_BYLNCARDNO = "被投资方贷款卡编码";
	public static final String ALIAS_ORGNO = "组织机构代码";
	public static final String ALIAS_CURTP1 = "币种1";
	public static final String ALIAS_INVAMT1 = "投资金额1";
	public static final String ALIAS_CURTP2 = "币种2";
	public static final String ALIAS_INVAMT2 = "投资金额2";
	public static final String ALIAS_CURTP3 = "币种3";
	public static final String ALIAS_INVAMT3 = "投资金额3";
	
	//date formats
	
	public ClntEeCapOut(){
	}

	public ClntEeCapOut(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**被投资单位名称==>db_column: INVESTNM*/
	private java.lang.String investnm;
	/**被投资方贷款卡编码==>db_column: BYLNCARDNO*/
	private java.lang.String bylncardno;
	/**组织机构代码==>db_column: ORGNO*/
	private java.lang.String orgno;
	/**币种1==>db_column: CURTP1*/
	private java.lang.String curtp1;
	/**投资金额1==>db_column: INVAMT1*/
	private BigDecimal invamt1;
	/**币种2==>db_column: CURTP2*/
	private java.lang.String curtp2;
	/**投资金额2==>db_column: INVAMT2*/
	private BigDecimal invamt2;
	/**币种3==>db_column: CURTP3*/
	private java.lang.String curtp3;
	/**投资金额3==>db_column: INVAMT3*/
	private BigDecimal invamt3;
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
	public void setInvestnm(java.lang.String value) {
		this.investnm = value;
	}
	
	public java.lang.String getInvestnm() {
		return this.investnm;
	}
	public void setBylncardno(java.lang.String value) {
		this.bylncardno = value;
	}
	
	public java.lang.String getBylncardno() {
		return this.bylncardno;
	}
	public void setOrgno(java.lang.String value) {
		this.orgno = value;
	}
	
	public java.lang.String getOrgno() {
		return this.orgno;
	}
	public void setCurtp1(java.lang.String value) {
		this.curtp1 = value;
	}
	
	public java.lang.String getCurtp1() {
		return this.curtp1;
	}
	
	public BigDecimal getInvamt1() {
		return invamt1;
	}

	public void setInvamt1(BigDecimal invamt1) {
		this.invamt1 = invamt1;
	}

	public BigDecimal getInvamt2() {
		return invamt2;
	}

	public void setInvamt2(BigDecimal invamt2) {
		this.invamt2 = invamt2;
	}

	public BigDecimal getInvamt3() {
		return invamt3;
	}

	public void setInvamt3(BigDecimal invamt3) {
		this.invamt3 = invamt3;
	}

	public void setCurtp2(java.lang.String value) {
		this.curtp2 = value;
	}
	
	public java.lang.String getCurtp2() {
		return this.curtp2;
	}
	
	public void setCurtp3(java.lang.String value) {
		this.curtp3 = value;
	}
	
	public java.lang.String getCurtp3() {
		return this.curtp3;
	}
	

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Investnm",getInvestnm())
			.append("Bylncardno",getBylncardno())
			.append("Orgno",getOrgno())
			.append("Curtp1",getCurtp1())
			.append("Invamt1",getInvamt1())
			.append("Curtp2",getCurtp2())
			.append("Invamt2",getInvamt2())
			.append("Curtp3",getCurtp3())
			.append("Invamt3",getInvamt3())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntEeCapOut == false) return false;
		if(this == obj) return true;
		ClntEeCapOut other = (ClntEeCapOut)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

