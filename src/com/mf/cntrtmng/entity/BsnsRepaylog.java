/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author yangchao
 * @2015-01-30
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class BsnsRepaylog extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "还款日志表";
	public static final String ALIAS_PAYMODE = "支付方式";
	public static final String ALIAS_FINANCEFLG = "财务复核标识";
	public static final String ALIAS_BSNSNO = "业务编号（同借据号）";
	public static final String ALIAS_SRLNO = "流水号";
	public static final String ALIAS_PAYDT = "还款日期";
	public static final String ALIAS_PAYONFLG = "是否继续还款标识";
	public static final String ALIAS_RCVAMNT = "实收金额";
	public static final String ALIAS_RCVPRINAMNT = "实收本金金额";
	public static final String ALIAS_RCVINSTAMNT = "实收利息金额";
	public static final String ALIAS_OVERINSTAMNT = "逾期利息金额";
	public static final String ALIAS_CMPDINSTAMNT = "复利利息金额";
	public static final String ALIAS_REPAYPRINAMNT = "提前还款本金金额";
	public static final String ALIAS_ACCNO = "银行账号";
	public static final String ALIAS_PAYTM = "还款时间";
	public static final String ALIAS_FNINSTAMNT = "罚息金额";
	public static final String ALIAS_DISCOUNTAMNT = "优惠金额";
	public static final String ALIAS_FNAMNT = "提前还款违约金";
	public static final String ALIAS_LOGID = "日志id";
	
	//date formats
	
	public BsnsRepaylog(){
	}

	public BsnsRepaylog(
		java.lang.String logid
	){
		this.setLogid(logid);
	}

	
	//columns START
	/**流水号==>db_column: LOGID*/
	private java.lang.String logid;
	/**支付方式==>db_column: PAYMODE*/
	private java.lang.String paymode;
	/**财务复核标识==>db_column: FINANCEFLG*/
	private java.lang.String financeflg;
	/**业务编号（同借据号）==>db_column: BSNSNO*/
	private java.lang.String bsnsno;
	/**流水号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**还款日期==>db_column: PAYDT*/
	private java.lang.String paydt;
	/**是否继续还款标识==>db_column: PAYONFLG*/
	private java.lang.String payonflg;
	/**实收金额==>db_column: RCVAMNT*/
	private BigDecimal rcvamnt;
	/**实收本金金额==>db_column: RCVPRINAMNT*/
	private BigDecimal rcvprinamnt;
	/**实收利息金额==>db_column: RCVINSTAMNT*/
	private BigDecimal rcvinstamnt;
	/**逾期利息金额==>db_column: OVERINSTAMNT*/
	private BigDecimal overinstamnt;
	/**复利利息金额==>db_column: CMPDINSTAMNT*/
	private BigDecimal cmpdinstamnt;
	/**提前还款本金金额==>db_column: REPAYPRINAMNT*/
	private BigDecimal repayprinamnt;
	/**银行账号==>db_column: ACCNO*/
	private java.lang.String accno;
	/**还款时间==>db_column: PAYTM*/
	private java.lang.String paytm;
	/**逾期滞纳金==>db_column: FNINSTAMNT*/
	private BigDecimal fninstamnt;
	/**优惠金额==>db_column: DISCOUNTAMNT*/
	private BigDecimal discountamnt=new BigDecimal(0);
	/**提前还款违约金==>db_column: FNAMNT*/
	private BigDecimal fnamnt=new BigDecimal(0);
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

	public void setPaymode(java.lang.String value) {
		this.paymode = value;
	}
	
	public java.lang.String getPaymode() {
		return this.paymode;
	}
	public void setFinanceflg(java.lang.String value) {
		this.financeflg = value;
	}
	
	public java.lang.String getFinanceflg() {
		return this.financeflg;
	}
	public void setBsnsno(java.lang.String value) {
		this.bsnsno = value;
	}
	
	public java.lang.String getBsnsno() {
		return this.bsnsno;
	}
	public void setSrlno(java.lang.String value) {
		this.srlno = value;
	}
	
	public java.lang.String getSrlno() {
		return this.srlno;
	}
	public void setPaydt(java.lang.String value) {
		this.paydt = value;
	}
	
	public java.lang.String getPaydt() {
		return this.paydt;
	}
	public void setPayonflg(java.lang.String value) {
		this.payonflg = value;
	}
	
	public java.lang.String getPayonflg() {
		return this.payonflg;
	}
	
	public void setAccno(java.lang.String value) {
		this.accno = value;
	}
	
	public java.lang.String getAccno() {
		return this.accno;
	}
	public void setPaytm(java.lang.String value) {
		this.paytm = value;
	}
	
	public java.lang.String getPaytm() {
		return this.paytm;
	}
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Paymode",getPaymode())
			.append("Financeflg",getFinanceflg())
			.append("Bsnsno",getBsnsno())
			.append("Srlno",getSrlno())
			.append("Paydt",getPaydt())
			.append("Payonflg",getPayonflg())
			.append("Rcvamnt",getRcvamnt())
			.append("Rcvprinamnt",getRcvprinamnt())
			.append("Rcvinstamnt",getRcvinstamnt())
			.append("Overinstamnt",getOverinstamnt())
			.append("Cmpdinstamnt",getCmpdinstamnt())
			.append("Repayprinamnt",getRepayprinamnt())
			.append("Accno",getAccno())
			.append("Paytm",getPaytm())
			.append("Fninstamnt",getFninstamnt())
			.append("Discountamnt",getDiscountamnt())
			.append("Fnamnt",getFnamnt())
			.toString();
	}
	
	public BigDecimal getFninstamnt() {
		return fninstamnt;
	}

	public void setFninstamnt(BigDecimal fninstamnt) {
		this.fninstamnt = fninstamnt;
	}

	public BigDecimal getDiscountamnt() {
		return discountamnt;
	}

	public void setDiscountamnt(BigDecimal discountamnt) {
		this.discountamnt = discountamnt;
	}

	public BigDecimal getRcvamnt() {
		return rcvamnt;
	}

	public void setRcvamnt(BigDecimal rcvamnt) {
		this.rcvamnt = rcvamnt;
	}

	public BigDecimal getRcvprinamnt() {
		return rcvprinamnt;
	}

	public void setRcvprinamnt(BigDecimal rcvprinamnt) {
		this.rcvprinamnt = rcvprinamnt;
	}

	public BigDecimal getRcvinstamnt() {
		return rcvinstamnt;
	}

	public void setRcvinstamnt(BigDecimal rcvinstamnt) {
		this.rcvinstamnt = rcvinstamnt;
	}

	public BigDecimal getOverinstamnt() {
		return overinstamnt;
	}

	public void setOverinstamnt(BigDecimal overinstamnt) {
		this.overinstamnt = overinstamnt;
	}

	public BigDecimal getCmpdinstamnt() {
		return cmpdinstamnt;
	}

	public void setCmpdinstamnt(BigDecimal cmpdinstamnt) {
		this.cmpdinstamnt = cmpdinstamnt;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getTableAlias() {
		return TABLE_ALIAS;
	}

	public static String getAliasPaymode() {
		return ALIAS_PAYMODE;
	}

	public static String getAliasFinanceflg() {
		return ALIAS_FINANCEFLG;
	}

	public static String getAliasBsnsno() {
		return ALIAS_BSNSNO;
	}

	public static String getAliasSrlno() {
		return ALIAS_SRLNO;
	}

	public static String getAliasPaydt() {
		return ALIAS_PAYDT;
	}

	public static String getAliasPayonflg() {
		return ALIAS_PAYONFLG;
	}

	public static String getAliasRcvamnt() {
		return ALIAS_RCVAMNT;
	}

	public static String getAliasRcvprinamnt() {
		return ALIAS_RCVPRINAMNT;
	}

	public static String getAliasRcvinstamnt() {
		return ALIAS_RCVINSTAMNT;
	}

	public static String getAliasOverinstamnt() {
		return ALIAS_OVERINSTAMNT;
	}

	public static String getAliasCmpdinstamnt() {
		return ALIAS_CMPDINSTAMNT;
	}

	public static String getAliasRepayprinamnt() {
		return ALIAS_REPAYPRINAMNT;
	}

	public static String getAliasAccno() {
		return ALIAS_ACCNO;
	}

	public static String getAliasPaytm() {
		return ALIAS_PAYTM;
	}

	public static String getAliasFninstamnt() {
		return ALIAS_FNINSTAMNT;
	}

	public static String getAliasDiscountamnt() {
		return ALIAS_DISCOUNTAMNT;
	}

	public static String getAliasFnamnt() {
		return ALIAS_FNAMNT;
	}

	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSrlno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsRepaylog == false) return false;
		if(this == obj) return true;
		BsnsRepaylog other = (BsnsRepaylog)obj;
		return new EqualsBuilder()
			.append(getSrlno(),other.getSrlno())
			.isEquals();
	}

	public java.lang.String getLogid() {
		return logid;
	}

	public void setLogid(java.lang.String logid) {
		this.logid = logid;
	}
}

