package com.mf.comStructure.entity;

import com.mf.base.BaseEntity;

/**
 * @author zhangcong
 * @2015-04-16
 * @version 1.0
 * @param <T>
 */

public class Financeinfo extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	public Financeinfo(){
	}
	
	//columns START
	/**finanno==>db_column: ID*/
	private java.lang.Integer id;
	/**wealthamt==>db_column: WEALTHAMT*/
	private java.lang.String wealthamt;
	/**loanreamt==>db_column: LOANREAMT*/
	private java.lang.String loanreamt;
	/**debtamt==>db_column: DEBTAMT*/
	private java.lang.String debtamt;
	/**bankfinamt==>db_column: BANKFINAMT*/
	private java.lang.String bankfinamt;
	/**owneramt==>db_column: OWNERAMT*/
	private java.lang.String owneramt;
	/**ownerincome==>db_column: OWNERINCOME*/
	private java.lang.String ownerincome;
	/**allincome==>db_column: ALLINCOME*/
	private java.lang.String allincome;
	/**profitincome==>db_column: PROFITINCOME*/
	private java.lang.String profitincome;
	/**taxamt==>db_column: TAXAMT*/
	private java.lang.String taxamt;
	/**incometax==>db_column: INCOMETAX*/
	private java.lang.String incometax;
	/**busitax==>db_column: BUSITAX*/
	private java.lang.String busitax;
	/**状态（0：未提交1：已提交）==>db_column: STATUS*/
	private java.lang.String status;
	/**profitamt==>db_column: PROFITAMT*/
	private java.lang.String profitamt;
	private String submitDate;  //提交时间
	private String createDate;  //保存时间
	//columns END
	
	public java.lang.Integer getId() {
		return id;
	}
	public void setId(java.lang.Integer id) {
		this.id = id;
	}
	public java.lang.String getWealthamt() {
		return wealthamt;
	}
	public void setWealthamt(java.lang.String wealthamt) {
		this.wealthamt = wealthamt;
	}
	public java.lang.String getLoanreamt() {
		return loanreamt;
	}
	public void setLoanreamt(java.lang.String loanreamt) {
		this.loanreamt = loanreamt;
	}
	public java.lang.String getDebtamt() {
		return debtamt;
	}
	public void setDebtamt(java.lang.String debtamt) {
		this.debtamt = debtamt;
	}
	public java.lang.String getBankfinamt() {
		return bankfinamt;
	}
	public void setBankfinamt(java.lang.String bankfinamt) {
		this.bankfinamt = bankfinamt;
	}
	public java.lang.String getOwneramt() {
		return owneramt;
	}
	public void setOwneramt(java.lang.String owneramt) {
		this.owneramt = owneramt;
	}
	public java.lang.String getOwnerincome() {
		return ownerincome;
	}
	public void setOwnerincome(java.lang.String ownerincome) {
		this.ownerincome = ownerincome;
	}
	public java.lang.String getAllincome() {
		return allincome;
	}
	public void setAllincome(java.lang.String allincome) {
		this.allincome = allincome;
	}
	public java.lang.String getProfitincome() {
		return profitincome;
	}
	public void setProfitincome(java.lang.String profitincome) {
		this.profitincome = profitincome;
	}
	public java.lang.String getTaxamt() {
		return taxamt;
	}
	public void setTaxamt(java.lang.String taxamt) {
		this.taxamt = taxamt;
	}
	public java.lang.String getIncometax() {
		return incometax;
	}
	public void setIncometax(java.lang.String incometax) {
		this.incometax = incometax;
	}
	public java.lang.String getBusitax() {
		return busitax;
	}
	public void setBusitax(java.lang.String busitax) {
		this.busitax = busitax;
	}
	public java.lang.String getStatus() {
		return status;
	}
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	public java.lang.String getProfitamt() {
		return profitamt;
	}
	public void setProfitamt(java.lang.String profitamt) {
		this.profitamt = profitamt;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}

