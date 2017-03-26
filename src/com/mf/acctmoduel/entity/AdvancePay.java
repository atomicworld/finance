package com.mf.acctmoduel.entity;

import java.math.BigDecimal;

import com.mf.base.BaseEntity;

public class AdvancePay extends BaseEntity implements java.io.Serializable{
		
	private static final long serialVersionUID = 1L;
	public AdvancePay(){
		
	}

	/**借据编号	==>db_column: CNTRCTNO*/
	private java.lang.String dueno;
	/**合同编号	==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**客户名称==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**还款方式==>db_column: RPMNTWAY*/
	private java.lang.String rpmntway;
	/**计息方式==>db_column: INTRSTMD*/
	private java.lang.String intrstmd;
	/**贷款总额（元）==>db_column: DUEAMNT*/
	private BigDecimal dueamnt;
	/**贷款余额（元）==>db_column: LNBLNC*/
	private BigDecimal lnblnc;
	/**放款日期==>db_column: OUTDATE*/
	private java.lang.String outdate;
	/**到期日期==>db_column: MTRTYDATE*/
	private java.lang.String mtrtydate;
	
	public java.lang.String getCntrctno() {
		return cntrctno;
	}
	public void setCntrctno(java.lang.String cntrctno) {
		this.cntrctno = cntrctno;
	}
	public java.lang.String getClntnm() {
		return clntnm;
	}
	public void setClntnm(java.lang.String clntnm) {
		this.clntnm = clntnm;
	}
	public java.lang.String getIntrstmd() {
		return intrstmd;
	}
	public void setIntrstmd(java.lang.String intrstmd) {
		this.intrstmd = intrstmd;
	}
	public BigDecimal getLnblnc() {
		return lnblnc;
	}
	public void setLnblnc(BigDecimal lnblnc) {
		this.lnblnc = lnblnc;
	}
	public java.lang.String getDueno() {
		return dueno;
	}
	public void setDueno(java.lang.String dueno) {
		this.dueno = dueno;
	}
	public java.lang.String getRpmntway() {
		return rpmntway;
	}
	public void setRpmntway(java.lang.String rpmntway) {
		this.rpmntway = rpmntway;
	}
	public java.lang.String getOutdate() {
		return outdate;
	}
	public void setOutdate(java.lang.String outdate) {
		this.outdate = outdate;
	}
	public java.lang.String getMtrtydate() {
		return mtrtydate;
	}
	public void setMtrtydate(java.lang.String mtrtydate) {
		this.mtrtydate = mtrtydate;
	}
	public BigDecimal getDueamnt() {
		return dueamnt;
	}
	public void setDueamnt(BigDecimal dueamnt) {
		this.dueamnt = dueamnt;
	}
	public java.lang.String getClntno() {
		return clntno;
	}
	public void setClntno(java.lang.String clntno) {
		this.clntno = clntno;
	}
	
}
