package com.mf.cntrtmng.entity;

import java.math.BigDecimal;

public class BsnsPrePaymentBean {
	
	String[] repaytermnoArray ; // 还款期数
	String[] srlnoArray ; //计划编号
	
	
	String[] cyclesdtArray ; // 还款周期开始日期
	String[] cycleedtArray ; // 还款周期结束日期
	BigDecimal[] repayinstamntArray ; // 需归还利息金额
	BigDecimal[] currepayamntArray ; // 需归还本金金额
	BigDecimal[] tbrepaybalArray ; // 待还款本金余额
	BigDecimal[] tbrepaypttlArray ; // 贷还款本金金额
	BigDecimal[] repayedprinsumArray ;// 累计归还本金金额
	
	//还款日志对象
	BsnsRepaylog bsnsRepaylog ;
	//票据对象
	BsnsBill bsnsBill;
	
	
	public String[] getSrlnoArray() {
		return srlnoArray;
	}

	public void setSrlnoArray(String[] srlnoArray) {
		this.srlnoArray = srlnoArray;
	}

	public BsnsBill getBsnsBill() {
		return bsnsBill;
	}

	public void setBsnsBill(BsnsBill bsnsBill) {
		this.bsnsBill = bsnsBill;
	}

	public String[] getRepaytermnoArray() {
		return repaytermnoArray;
	}

	public void setRepaytermnoArray(String[] repaytermnoArray) {
		this.repaytermnoArray = repaytermnoArray;
	}

	public String[] getCyclesdtArray() {
		return cyclesdtArray;
	}

	public void setCyclesdtArray(String[] cyclesdtArray) {
		this.cyclesdtArray = cyclesdtArray;
	}

	public String[] getCycleedtArray() {
		return cycleedtArray;
	}

	public void setCycleedtArray(String[] cycleedtArray) {
		this.cycleedtArray = cycleedtArray;
	}

	public BigDecimal[] getRepayinstamntArray() {
		return repayinstamntArray;
	}

	public void setRepayinstamntArray(BigDecimal[] repayinstamntArray) {
		this.repayinstamntArray = repayinstamntArray;
	}

	public BigDecimal[] getCurrepayamntArray() {
		return currepayamntArray;
	}

	public void setCurrepayamntArray(BigDecimal[] currepayamntArray) {
		this.currepayamntArray = currepayamntArray;
	}

	public BigDecimal[] getTbrepaybalArray() {
		return tbrepaybalArray;
	}

	public void setTbrepaybalArray(BigDecimal[] tbrepaybalArray) {
		this.tbrepaybalArray = tbrepaybalArray;
	}

	public BigDecimal[] getTbrepaypttlArray() {
		return tbrepaypttlArray;
	}

	public void setTbrepaypttlArray(BigDecimal[] tbrepaypttlArray) {
		this.tbrepaypttlArray = tbrepaypttlArray;
	}

	public BigDecimal[] getRepayedprinsumArray() {
		return repayedprinsumArray;
	}

	public void setRepayedprinsumArray(BigDecimal[] repayedprinsumArray) {
		this.repayedprinsumArray = repayedprinsumArray;
	}

	public BsnsRepaylog getBsnsRepaylog() {
		return bsnsRepaylog;
	}

	public void setBsnsRepaylog(BsnsRepaylog bsnsRepaylog) {
		this.bsnsRepaylog = bsnsRepaylog;
	}

	
	

}
