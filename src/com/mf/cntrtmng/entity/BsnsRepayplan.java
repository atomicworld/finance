/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;
import java.math.BigDecimal;

/**
 * @author xujiuhua
 * @2015-01-13
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class BsnsRepayplan extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "还款计划表";
	public static final String ALIAS_SRLNO = "计划编号";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_TBREPAYPTTL = "待还款本金金额";
	public static final String ALIAS_TBREPAYBAL = "待还款本金余额";
	public static final String ALIAS_ACTUALREPAYDT = "实际还款日期";
	public static final String ALIAS_CURREPAYAMNT = "需归还本金金额";
	public static final String ALIAS_REPAYEDPRINSUM = "累计归还本金金额";
	public static final String ALIAS_DPTNO = "管户部门编号";
	public static final String ALIAS_OPNO = "管户人编号";
	public static final String ALIAS_CYCLESDT = "还款周期开始日期";
	public static final String ALIAS_CYCLEEDT = "还款周期结束日期";
	public static final String ALIAS_DUENO = "借据编号";
	public static final String ALIAS_INTRSTMD = "计息方式";
	public static final String ALIAS_REPAYINSTAMNT = "需归还利息金额";
	public static final String ALIAS_REPAYSTT = "还款状态";
	public static final String ALIAS_REPAYTERMNO = "还款期数";
	public static final String ALIAS_CREATEDATE = "新建时间";
	public static final String ALIAS_UPDATEDATE = "更新时间";
	
	//date formats
	
	public BsnsRepayplan(){
	}

	public BsnsRepayplan(
		java.lang.String srlno
	){
		this.srlno = srlno;
	}

	
	//columns START
	/**计划编号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**待还款本金金额==>db_column: TBREPAYPTTL*/
	private BigDecimal tbrepaypttl;
	/**待还款本金余额==>db_column: TBREPAYBAL*/
	private BigDecimal tbrepaybal;
	/**实际还款日期==>db_column: ACTUALREPAYDT*/
	private java.lang.String actualrepaydt;
	/**需归还本金金额==>db_column: CURREPAYAMNT*/
	private BigDecimal currepayamnt;
	/**累计归还本金金额==>db_column: REPAYEDPRINSUM*/
	private BigDecimal repayedprinsum;
	/**管户部门编号==>db_column: DPTNO*/
	private java.lang.String dptno;
	/**管户人编号==>db_column: OPNO*/
	private java.lang.String opno;
	/**还款周期开始日期==>db_column: CYCLESDT*/
	private java.lang.String cyclesdt;
	/**还款周期结束日期==>db_column: CYCLEEDT*/
	private java.lang.String cycleedt;
	/**借据编号==>db_column: DUENO*/
	private java.lang.String dueno;
	/**计息方式==>db_column: INTRSTMD*/
	private java.lang.String intrstmd;
	/**需归还利息金额==>db_column: REPAYINSTAMNT*/
	private BigDecimal repayinstamnt;
	/**还款状态==>db_column: REPAYSTT*/
	private java.lang.String repaystt;
	/**还款期数==>db_column: REPAYTERMNO*/
	private java.lang.String repaytermno;
	/**新建时间==>db_column: CREATEDATE*/
	private java.lang.String createdate;
	/**更新时间==>db_column: UPDATEDATE*/
	private java.lang.String updatedate;
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

	public void setSrlno(java.lang.String value) {
		this.srlno = value;
	}
	
	public java.lang.String getSrlno() {
		return this.srlno;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setClntnm(java.lang.String value) {
		this.clntnm = value;
	}
	
	public java.lang.String getClntnm() {
		return this.clntnm;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	public void setTbrepaypttl(BigDecimal value) {
		this.tbrepaypttl = value;
	}
	
	public BigDecimal getTbrepaypttl() {
		return this.tbrepaypttl;
	}
	public void setTbrepaybal(BigDecimal value) {
		this.tbrepaybal = value;
	}
	
	public BigDecimal getTbrepaybal() {
		return this.tbrepaybal;
	}
	public void setActualrepaydt(java.lang.String value) {
		this.actualrepaydt = value;
	}
	
	public java.lang.String getActualrepaydt() {
		return this.actualrepaydt;
	}
	public void setCurrepayamnt(BigDecimal value) {
		this.currepayamnt = value;
	}
	
	public BigDecimal getCurrepayamnt() {
		return this.currepayamnt;
	}
	public void setRepayedprinsum(BigDecimal value) {
		this.repayedprinsum = value;
	}
	
	public BigDecimal getRepayedprinsum() {
		return this.repayedprinsum;
	}
	public void setDptno(java.lang.String value) {
		this.dptno = value;
	}
	
	public java.lang.String getDptno() {
		return this.dptno;
	}
	public void setOpno(java.lang.String value) {
		this.opno = value;
	}
	
	public java.lang.String getOpno() {
		return this.opno;
	}
	public void setCyclesdt(java.lang.String value) {
		this.cyclesdt = value;
	}
	
	public java.lang.String getCyclesdt() {
		return this.cyclesdt;
	}
	public void setCycleedt(java.lang.String value) {
		this.cycleedt = value;
	}
	
	public java.lang.String getCycleedt() {
		return this.cycleedt;
	}
	public void setDueno(java.lang.String value) {
		this.dueno = value;
	}
	
	public java.lang.String getDueno() {
		return this.dueno;
	}
	public void setIntrstmd(java.lang.String value) {
		this.intrstmd = value;
	}
	
	public java.lang.String getIntrstmd() {
		return this.intrstmd;
	}
	public void setRepayinstamnt(BigDecimal value) {
		this.repayinstamnt = value;
	}
	
	public BigDecimal getRepayinstamnt() {
		return this.repayinstamnt;
	}
	public void setRepaystt(java.lang.String value) {
		this.repaystt = value;
	}
	
	public java.lang.String getRepaystt() {
		return this.repaystt;
	}
	public void setRepaytermno(java.lang.String value) {
		this.repaytermno = value;
	}
	
	public java.lang.String getRepaytermno() {
		return this.repaytermno;
	}
	
	public java.lang.String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(java.lang.String createdate) {
		this.createdate = createdate;
	}

	public java.lang.String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(java.lang.String updatedate) {
		this.updatedate = updatedate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Srlno",getSrlno())
			.append("Clntno",getClntno())
			.append("Clntnm",getClntnm())
			.append("Cntrctno",getCntrctno())
			.append("Tbrepaypttl",getTbrepaypttl())
			.append("Tbrepaybal",getTbrepaybal())
			.append("Actualrepaydt",getActualrepaydt())
			.append("Currepayamnt",getCurrepayamnt())
			.append("Repayedprinsum",getRepayedprinsum())
			.append("Dptno",getDptno())
			.append("Opno",getOpno())
			.append("Cyclesdt",getCyclesdt())
			.append("Cycleedt",getCycleedt())
			.append("Dueno",getDueno())
			.append("Intrstmd",getIntrstmd())
			.append("Repayinstamnt",getRepayinstamnt())
			.append("Repaystt",getRepaystt())
			.append("Repaytermno",getRepaytermno())
			.append("Credatedate",getCreatedate())
			.append("Updatedate",getUpdatedate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSrlno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsRepayplan == false) return false;
		if(this == obj) return true;
		BsnsRepayplan other = (BsnsRepayplan)obj;
		return new EqualsBuilder()
			.append(getSrlno(),other.getSrlno())
			.isEquals();
	}
}

