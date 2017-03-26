/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.entity;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-08-24
 * @version 1.0
 * @param <T>
 */

public class CorpSharecorp extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CorpSharecorp";
	public static final String ALIAS_SHARENO = "股东编号";
	public static final String ALIAS_CORPNO = "控股公司编号";
	public static final String ALIAS_CORP_NAME = "企业全称";
	public static final String ALIAS_REG_CAPITAL = "注册资本(万元)";
	public static final String ALIAS_AMOUNT = "出资额(万元)";
	public static final String ALIAS_PROPORTION = "持股比例(%)";
	public static final String ALIAS_WORK_INFO2 = "任职情况";
	
	//columns START
	/**股东编号==>db_column: shareno*/
	private java.lang.String shareno;
	/**控股公司编号==>db_column: corpno*/
	private java.lang.String corpno;
	/**企业全称==>db_column: CorpName*/
	private java.lang.String corpName;
	/**注册资本(万元)==>db_column: RegCapital*/
	private java.lang.String regCapital;
	/**出资额(万元)==>db_column: Amount*/
	private java.lang.String amount;
	/**持股比例(%)==>db_column: Proportion*/
	private java.lang.String proportion;
	/**任职情况==>db_column: WorkInfo2*/
	private java.lang.String workInfo2;
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

	public void setShareno(java.lang.String value) {
		this.shareno = value;
	}
	
	public java.lang.String getShareno() {
		return this.shareno;
	}
	public void setCorpno(java.lang.String value) {
		this.corpno = value;
	}
	
	public java.lang.String getCorpno() {
		return this.corpno;
	}
	public void setCorpName(java.lang.String value) {
		this.corpName = value;
	}
	
	public java.lang.String getCorpName() {
		return this.corpName;
	}
	public void setRegCapital(java.lang.String value) {
		this.regCapital = value;
	}
	
	public java.lang.String getRegCapital() {
		return this.regCapital;
	}
	public void setAmount(java.lang.String value) {
		this.amount = value;
	}
	
	public java.lang.String getAmount() {
		return this.amount;
	}
	public void setProportion(java.lang.String value) {
		this.proportion = value;
	}
	
	public java.lang.String getProportion() {
		return this.proportion;
	}
	public void setWorkInfo2(java.lang.String value) {
		this.workInfo2 = value;
	}
	
	public java.lang.String getWorkInfo2() {
		return this.workInfo2;
	}

}

