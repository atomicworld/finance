/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author shenguangdong
 * @2015-02-10
 * @Email: 1017768302@qq.com
 * @version 1.0
 * @param <T>
 */

public class FnncLedger {
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "总账汇总表-余额初始化保存";
	public static final String ALIAS_LEDGERNO = "ledgerno";
	public static final String ALIAS_CURTP = "币种";
	public static final String ALIAS_ACCNTNO = "科目编码";
	public static final String ALIAS_LEDGERDATE = "总账日期";
	public static final String ALIAS_ACCNTDRCT = "科目余额方向";
	public static final String ALIAS_UPACCNTNO = "所属科目编码";
	public static final String ALIAS_JQM_BAL = "期末余额借方";
	public static final String ALIAS_DQM_BAL = "期末余额贷方";
	public static final String ALIAS_JQC_BAL = "期初余额借方";
	public static final String ALIAS_DQC_BAL = "期初余额贷方";
	public static final String ALIAS_JBQ_AMT = "本期合计金额借方";
	public static final String ALIAS_DBQ_AMT = "本期合计金额贷方";
	public static final String ALIAS_JYSUM_AMT = "本年累计金额借方";
	public static final String ALIAS_DYSUM_AMT = "本年累计金额贷方";
	public static final String ALIAS_FLAG = "标志";
	
	//date formats
	
	public FnncLedger(){
	}

	public FnncLedger(
		java.lang.Integer ledgerno
	){
		this.ledgerno = ledgerno;
	}

	
	//columns START
	/**ledgerno==>db_column: LEDGERNO*/
	private java.lang.Integer ledgerno;
	/**科目编码==>db_column: ACCNTNO*/
	private java.lang.String accntno;
	/**币种==>db_column: CURTP*/
	private java.lang.String curtp;
	/**总账日期==>db_column: LEDGERDATE*/
	private java.lang.String ledgerdate;
	/**科目余额方向==>db_column: ACCNTDRCT*/
	private java.lang.String accntdrct;
	/**所属科目编码==>db_column: UPACCNTNO*/
	private java.lang.String upaccntno;
	/**期末余额借方==>db_column: JQM_BAL*/
	private BigDecimal jqmBal;
	/**期末余额贷方==>db_column: DQM_BAL*/
	private BigDecimal dqmBal;
	/**期初余额借方==>db_column: JQC_BAL*/
	private BigDecimal jqcBal;
	/**期初余额贷方==>db_column: DQC_BAL*/
	private BigDecimal dqcBal;
	/**本期合计金额借方==>db_column: JBQ_AMT*/
	private BigDecimal jbqAmt;
	/**本期合计金额贷方==>db_column: DBQ_AMT*/
	private BigDecimal dbqAmt;
	/**本年累计金额借方==>db_column: JYSUM_AMT*/
	private BigDecimal jysumAmt;
	/**本年累计金额贷方==>db_column: DYSUM_AMT*/
	private BigDecimal dysumAmt;
	/**标志==>db_column: FLAG*/
	private java.lang.String flag;
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

	public void setLedgerno(java.lang.Integer value) {
		this.ledgerno = value;
	}
	
	public java.lang.Integer getLedgerno() {
		return this.ledgerno;
	}
	public void setCurtp(java.lang.String value) {
		this.curtp = value;
	}
	
	public java.lang.String getCurtp() {
		return this.curtp;
	}
	public void setLedgerdate(java.lang.String value) {
		this.ledgerdate = value;
	}
	
	public java.lang.String getLedgerdate() {
		return this.ledgerdate;
	}
	public void setAccntdrct(java.lang.String value) {
		this.accntdrct = value;
	}
	
	public java.lang.String getAccntdrct() {
		return this.accntdrct;
	}
	public void setUpaccntno(java.lang.String value) {
		this.upaccntno = value;
	}
	
	public java.lang.String getUpaccntno() {
		return this.upaccntno;
	}
	public void setJqmBal(BigDecimal value) {
		this.jqmBal = value;
	}
	
	public BigDecimal getJqmBal() {
		return this.jqmBal;
	}
	public void setDqmBal(BigDecimal value) {
		this.dqmBal = value;
	}
	
	public BigDecimal getDqmBal() {
		return this.dqmBal;
	}
	public void setJqcBal(BigDecimal value) {
		this.jqcBal = value;
	}
	
	public BigDecimal getJqcBal() {
		return this.jqcBal;
	}
	public void setDqcBal(BigDecimal value) {
		this.dqcBal = value;
	}
	
	public BigDecimal getDqcBal() {
		return this.dqcBal;
	}
	public void setJbqAmt(BigDecimal value) {
		this.jbqAmt = value;
	}
	
	public BigDecimal getJbqAmt() {
		return this.jbqAmt;
	}
	public void setDbqAmt(BigDecimal value) {
		this.dbqAmt = value;
	}
	
	public BigDecimal getDbqAmt() {
		return this.dbqAmt;
	}
	public void setJysumAmt(BigDecimal value) {
		this.jysumAmt = value;
	}
	
	public BigDecimal getJysumAmt() {
		return this.jysumAmt;
	}
	public void setDysumAmt(BigDecimal value) {
		this.dysumAmt = value;
	}
	
	public BigDecimal getDysumAmt() {
		return this.dysumAmt;
	}
	public void setFlag(java.lang.String value) {
		this.flag = value;
	}
	
	public java.lang.String getFlag() {
		return this.flag;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Ledgerno",getLedgerno())
			.append("Curtp",getCurtp())
			.append("Accntno",getAccntno())
			.append("Ledgerdate",getLedgerdate())
			.append("Accntdrct",getAccntdrct())
			.append("Upaccntno",getUpaccntno())
			.append("JqmBal",getJqmBal())
			.append("DqmBal",getDqmBal())
			.append("JqcBal",getJqcBal())
			.append("DqcBal",getDqcBal())
			.append("JbqAmt",getJbqAmt())
			.append("DbqAmt",getDbqAmt())
			.append("JysumAmt",getJysumAmt())
			.append("DysumAmt",getDysumAmt())
			.append("Flag",getFlag())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getLedgerno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncLedger == false) return false;
		if(this == obj) return true;
		FnncLedger other = (FnncLedger)obj;
		return new EqualsBuilder()
			.append(getLedgerno(),other.getLedgerno())
			.isEquals();
	}

	public java.lang.String getAccntno() {
		return accntno;
	}

	public void setAccntno(java.lang.String accntno) {
		this.accntno = accntno;
	}
}

