/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */

public class ClntGradeCommerce extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "ClntGradeCommerce";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_REGISTER = "注册评估分数";
	public static final String ALIAS_BANKINFO = "金融业务";
	public static final String ALIAS_CAPITAL = "资本评估";
	public static final String ALIAS_MANAGER = "高管评估";
	public static final String ALIAS_PAYINFO = "偿还意愿";
	public static final String ALIAS_BASE = "基础信息";
	public static final String ALIAS_CLIQUE = "集团评估";
	public static final String ALIAS_INVEST="对外投资";
	public static final String ALIAS_SCORE = "score";
	
	//date formats
	
	public ClntGradeCommerce(){
	}

	public ClntGradeCommerce(
		java.lang.String clntno
	){
		this.clntno = clntno;
	}

	
	//columns START
	/**客户编号==>db_column: clntno*/
	private java.lang.String clntno;
	/**注册评估分数==>db_column: register*/
	private java.lang.String register;
	/**金融业务==>db_column: bankinfo*/
	private java.lang.String bankinfo;
	/**资本评估==>db_column: capital*/
	private java.lang.String capital;
	/**高管评估==>db_column: manager*/
	private java.lang.String manager;
	/**偿还意愿==>db_column: payinfo*/
	private java.lang.String payinfo;
	/**基础信息==>db_column: base*/
	private java.lang.String base;
	/**集团评估==>db_column: clique*/
	private java.lang.String clique;
	/**score==>db_column: score*/
	private java.lang.String score="0";
	/**invest==>db_column: invest*/
	private java.lang.String invest;
	
	/**评分情况说明==>db_column: memo*/
	private java.lang.String memo;
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

	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setRegister(java.lang.String value) {
		this.register = value;
	}
	
	public java.lang.String getRegister() {
		return this.register;
	}
	public void setBankinfo(java.lang.String value) {
		this.bankinfo = value;
	}
	
	public java.lang.String getBankinfo() {
		return this.bankinfo;
	}
	public void setCapital(java.lang.String value) {
		this.capital = value;
	}
	
	public java.lang.String getCapital() {
		return this.capital;
	}
	public void setManager(java.lang.String value) {
		this.manager = value;
	}
	
	public java.lang.String getManager() {
		return this.manager;
	}
	public void setPayinfo(java.lang.String value) {
		this.payinfo = value;
	}
	
	public java.lang.String getPayinfo() {
		return this.payinfo;
	}
	public void setBase(java.lang.String value) {
		this.base = value;
	}
	
	public java.lang.String getBase() {
		return this.base;
	}
	public void setClique(java.lang.String value) {
		this.clique = value;
	}
	
	public java.lang.String getClique() {
		return this.clique;
	}
	public void setScore(java.lang.String value) {
		this.score = value;
	}
	
	public java.lang.String getScore() {
		return this.score;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Clntno",getClntno())
			.append("Register",getRegister())
			.append("Bankinfo",getBankinfo())
			.append("Capital",getCapital())
			.append("Manager",getManager())
			.append("Payinfo",getPayinfo())
			.append("Base",getBase())
			.append("Clique",getClique())
			.append("Score",getScore())
			.append("Invest",getInvest())
			.append("Memo",getInvest())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getClntno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntGradeCommerce == false) return false;
		if(this == obj) return true;
		ClntGradeCommerce other = (ClntGradeCommerce)obj;
		return new EqualsBuilder()
			.append(getClntno(),other.getClntno())
			.isEquals();
	}

	public void setInvest(java.lang.String invest) {
		this.invest = invest;
	}

	public java.lang.String getInvest() {
		return invest;
	}

	public java.lang.String getMemo() {
		return memo;
	}

	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	
	
}

