package com.mf.acctmoduel.entity;

import java.math.BigDecimal;

import com.mf.base.BaseEntity;

public class AdvancePayMoney extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	public AdvancePayMoney(){
		
	}
	/**业务编号（同借据号）==>db_column: BSNSNO*/
	private java.lang.String dueno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**执行利率==>db_column: BSNSRT*/
	private BigDecimal bsnsrt;
	/**计息方式==>db_column: INTRSTMD*/
	private java.lang.String intrstmd;
	/**提前还款本金金额==>db_column: REPAYPRINAMNT*/
	private BigDecimal repayprinamnt;
	/**提前还款违约金==>db_column: FNAMNT*/
	private BigDecimal fnamnt;
	/**操作员部门编号==>db_column: BSNSDPTNO*/
	private java.lang.String bsnsdptno;
	
	
	
	
	public java.lang.String getClntnm() {
		return clntnm;
	}
	public void setClntnm(java.lang.String clntnm) {
		this.clntnm = clntnm;
	}
	public BigDecimal getBsnsrt() {
		return bsnsrt;
	}
	public void setBsnsrt(BigDecimal bsnsrt) {
		this.bsnsrt = bsnsrt;
	}
	public java.lang.String getIntrstmd() {
		return intrstmd;
	}
	public void setIntrstmd(java.lang.String intrstmd) {
		this.intrstmd = intrstmd;
	}
	public BigDecimal getRepayprinamnt() {
		return repayprinamnt;
	}
	public void setRepayprinamnt(BigDecimal repayprinamnt) {
		this.repayprinamnt = repayprinamnt;
	}
	public BigDecimal getFnamnt() {
		return fnamnt;
	}
	public void setFnamnt(BigDecimal fnamnt) {
		this.fnamnt = fnamnt;
	}
	public java.lang.String getBsnsdptno() {
		return bsnsdptno;
	}
	public void setBsnsdptno(java.lang.String bsnsdptno) {
		this.bsnsdptno = bsnsdptno;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public java.lang.String getDueno() {
		return dueno;
	}
	public void setDueno(java.lang.String dueno) {
		this.dueno = dueno;
	}
	
}
