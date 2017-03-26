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

import com.mf.base.BaseEntity;

/**
 * @author wangzhi
 * @2015-08-23
 * @version 1.0
 * @param <T>
 */

public class FinanceShareholder extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FinanceShareholder";
	public static final String ALIAS_ID = "主键id";
	public static final String ALIAS_EQUITY = "股本";
	public static final String ALIAS_CAPITAL_RESERVE = "资本公积";
	public static final String ALIAS_SURPLUS_RESERVE = "盈余公积";
	public static final String ALIAS_GENERAL_RISK_PREPARATION = "一般风险准备";
	public static final String ALIAS_NO_PROFIT_DISTRIBUTION = "未分配利润";
	public static final String ALIAS_TRANSLATION_STATEMENTS = "外币报表折算差额";
	public static final String ALIAS_PARED_ID = "关联id";
	
	//date formats
	
	public FinanceShareholder(){
	}

	public FinanceShareholder(
		String id
	){
		this.id = id;
	}

	
	//columns START
	/**主键id==>db_column: id*/
	private String id;
	/**股本==>db_column: Equity*/
	private BigDecimal equity;
	/**资本公积==>db_column: CapitalReserve*/
	private BigDecimal capitalReserve;
	/**盈余公积==>db_column: SurplusReserve*/
	private BigDecimal surplusReserve;
	/**一般风险准备==>db_column: GeneralRiskPreparation*/
	private BigDecimal generalRiskPreparation;
	/**未分配利润==>db_column: NoProfitDistribution*/
	private BigDecimal noProfitDistribution;
	/**外币报表折算差额==>db_column: TranslationStatements*/
	private BigDecimal translationStatements;
	/**关联id==>db_column: paredId*/
	private String paredId;//外键
	private String rptmonth;//报表月份
	
	public String getRptmonth() {
		return rptmonth;
	}

	public void setRptmonth(String rptmonth) {
		this.rptmonth = rptmonth;
	}


	private String orgcode;
	private String itemcode;
	private String rptbatch;
	public String getOrgcode() {
		return orgcode;
	}

	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}

	public String getItemcode() {
		return itemcode;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getRptbatch() {
		return rptbatch;
	}

	public void setRptbatch(String rptbatch) {
		this.rptbatch = rptbatch;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getRptstatus() {
		return rptstatus;
	}

	public void setRptstatus(String rptstatus) {
		this.rptstatus = rptstatus;
	}


	private String deleteflag;//删除标志
	private String validate;
	private String rptstatus;//上报状态
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

	public void setId(String value) {
		this.id = value;
	}
	
	public String getId() {
		return this.id;
	}
	public void setEquity(BigDecimal value) {
		this.equity = value;
	}
	
	public BigDecimal getEquity() {
		return this.equity;
	}
	public void setCapitalReserve(BigDecimal value) {
		this.capitalReserve = value;
	}
	
	public BigDecimal getCapitalReserve() {
		return this.capitalReserve;
	}
	public void setSurplusReserve(BigDecimal value) {
		this.surplusReserve = value;
	}
	
	public BigDecimal getSurplusReserve() {
		return this.surplusReserve;
	}
	public void setGeneralRiskPreparation(BigDecimal value) {
		this.generalRiskPreparation = value;
	}
	
	public BigDecimal getGeneralRiskPreparation() {
		return this.generalRiskPreparation;
	}
	public void setNoProfitDistribution(BigDecimal value) {
		this.noProfitDistribution = value;
	}
	
	public BigDecimal getNoProfitDistribution() {
		return this.noProfitDistribution;
	}
	public void setTranslationStatements(BigDecimal value) {
		this.translationStatements = value;
	}
	
	public BigDecimal getTranslationStatements() {
		return this.translationStatements;
	}
	public void setParedId(String value) {
		this.paredId = value;
	}
	
	public String getParedId() {
		return this.paredId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Equity",getEquity())
			.append("CapitalReserve",getCapitalReserve())
			.append("SurplusReserve",getSurplusReserve())
			.append("GeneralRiskPreparation",getGeneralRiskPreparation())
			.append("NoProfitDistribution",getNoProfitDistribution())
			.append("TranslationStatements",getTranslationStatements())
			.append("ParedId",getParedId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FinanceShareholder == false) return false;
		if(this == obj) return true;
		FinanceShareholder other = (FinanceShareholder)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

