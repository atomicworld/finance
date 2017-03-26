package com.mf.aftrmng.entity;

import java.math.BigDecimal;

import com.mf.base.BaseEntity;

public class BsnsRepayplanAll extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	public BsnsRepayplanAll(){
	}
	
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**借据编号==>db_column: DUENO*/
	private java.lang.String dueno;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**需归还本金金额==>db_column: CURREPAYAMNT*/
	private BigDecimal currepayamnt;
	/**需归还利息金额==>db_column: REPAYINSTAMNT*/
	private BigDecimal repayinstamnt;
	/**还款期数==>db_column: REPAYTERMNO*/
	private java.lang.String repaytermno;
	/**还款计划编号==>db_column: srlno*/
	private java.lang.String srlno;
	/**最近催收日期==>db_column: sdate*/
	private java.lang.String sdate;
	/**最近催收日期==>db_column: cycleedt*/
	private java.lang.String cycleedt;
	
	public java.lang.String getSdate() {
		return sdate;
	}
	public void setSdate(java.lang.String sdate) {
		this.sdate = sdate;
	}
	public java.lang.String getSrlno() {
		return srlno;
	}
	public void setSrlno(java.lang.String srlno) {
		this.srlno = srlno;
	}
	public java.lang.String getCntrctno() {
		return cntrctno;
	}
	public void setCntrctno(java.lang.String cntrctno) {
		this.cntrctno = cntrctno;
	}
	public java.lang.String getDueno() {
		return dueno;
	}
	public void setDueno(java.lang.String dueno) {
		this.dueno = dueno;
	}
	
	public java.lang.String getClntno() {
		return clntno;
	}
	public void setClntno(java.lang.String clntno) {
		this.clntno = clntno;
	}
	public java.lang.String getClntnm() {
		return clntnm;
	}
	public void setClntnm(java.lang.String clntnm) {
		this.clntnm = clntnm;
	}
	public BigDecimal getCurrepayamnt() {
		return currepayamnt;
	}
	public void setCurrepayamnt(BigDecimal currepayamnt) {
		this.currepayamnt = currepayamnt;
	}
	public BigDecimal getRepayinstamnt() {
		return repayinstamnt;
	}
	public void setRepayinstamnt(BigDecimal repayinstamnt) {
		this.repayinstamnt = repayinstamnt;
	}
	public java.lang.String getCycleedt() {
		return cycleedt;
	}
	public void setCycleedt(java.lang.String cycleedt) {
		this.cycleedt = cycleedt;
	}
	public java.lang.String getRepaytermno() {
		return repaytermno;
	}
	public void setRepaytermno(java.lang.String repaytermno) {
		this.repaytermno = repaytermno;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
