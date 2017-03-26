/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangzhi
 * @2015-08-13
 * @version 1.0
 * @param <T>
 */

public class FinanceBank extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FinanceBank";
	public static final String ALIAS_ID = "唯一标识符";
	public static final String ALIAS_LOANNO = "借款编号";
	public static final String ALIAS_LOANBANK = "借款银行";
	public static final String ALIAS_COST = "综合融资成本";
	public static final String ALIAS_CREDITAMOUNT = "授信金额";
	public static final String ALIAS_DEADLINE = "授信期限";
	public static final String ALIAS_AMOUNT = "借款金额";
	public static final String ALIAS_RATE = "借款年利率";
	public static final String ALIAS_LOANDATE = "借款日期";
	public static final String ALIAS_ENDDATE = "到期日期";
	public static final String ALIAS_GUARANTEE = "担保方式";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public FinanceBank(){
	}

	public FinanceBank(
		java.lang.String id
	){
		this.id = id;
	}

	
	//columns START
	/**唯一标识符==>db_column: ID*/
	private java.lang.String id;
	/**借款编号==>db_column: LOANNO*/
	private java.lang.String loanno;
	/**借款银行==>db_column: LOANBANK*/
	private java.lang.String loanbank;
	/**综合融资成本==>db_column: COST*/
	private java.lang.Long cost;
	/**授信金额==>db_column: CREDITAMOUNT*/
	private java.lang.Long creditamount;
	/**授信期限==>db_column: DEADLINE*/
	private java.lang.String deadline;
	/**借款金额==>db_column: AMOUNT*/
	private java.lang.Long amount;
	/**借款年利率==>db_column: RATE*/
	private java.lang.Long rate;
	/**借款日期==>db_column: LOANDATE*/
	private java.lang.String loandate;
	/**到期日期==>db_column: ENDDATE*/
	private java.lang.String enddate;
	/**担保方式==>db_column: GUARANTEE*/
	private java.lang.String guarantee;
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

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	public void setLoanno(java.lang.String value) {
		this.loanno = value;
	}
	
	public java.lang.String getLoanno() {
		return this.loanno;
	}
	public void setLoanbank(java.lang.String value) {
		this.loanbank = value;
	}
	
	public java.lang.String getLoanbank() {
		return this.loanbank;
	}
	public void setCost(java.lang.Long value) {
		this.cost = value;
	}
	
	public java.lang.Long getCost() {
		return this.cost;
	}
	public void setCreditamount(java.lang.Long value) {
		this.creditamount = value;
	}
	
	public java.lang.Long getCreditamount() {
		return this.creditamount;
	}
	public void setDeadline(java.lang.String value) {
		this.deadline = value;
	}
	
	public java.lang.String getDeadline() {
		return this.deadline;
	}
	public void setAmount(java.lang.Long value) {
		this.amount = value;
	}
	
	public java.lang.Long getAmount() {
		return this.amount;
	}
	public void setRate(java.lang.Long value) {
		this.rate = value;
	}
	
	public java.lang.Long getRate() {
		return this.rate;
	}
	public void setLoandate(java.lang.String value) {
		this.loandate = value;
	}
	
	public java.lang.String getLoandate() {
		return this.loandate;
	}
	public void setEnddate(java.lang.String value) {
		this.enddate = value;
	}
	
	public java.lang.String getEnddate() {
		return this.enddate;
	}
	public void setGuarantee(java.lang.String value) {
		this.guarantee = value;
	}
	
	public java.lang.String getGuarantee() {
		return this.guarantee;
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
			.append("Loanno",getLoanno())
			.append("Loanbank",getLoanbank())
			.append("Cost",getCost())
			.append("Creditamount",getCreditamount())
			.append("Deadline",getDeadline())
			.append("Amount",getAmount())
			.append("Rate",getRate())
			.append("Loandate",getLoandate())
			.append("Enddate",getEnddate())
			.append("Guarantee",getGuarantee())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FinanceBank == false) return false;
		if(this == obj) return true;
		FinanceBank other = (FinanceBank)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

