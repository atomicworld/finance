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

public class CorpShareassets extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CorpShareassets";
	public static final String ALIAS_SHARENO = "股东编号";
	public static final String ALIAS_YEARS0 = "年份";
	public static final String ALIAS_ASSETS0 = "资产合计(万元";
	public static final String ALIAS_LIABILITIES0 = "负债合计(万元)";
	public static final String ALIAS_PROFIT0 = "总利润(万元)";
	public static final String ALIAS_EQUITY0 = "所有者权益(万元)";
	public static final String ALIAS_INVEREST0 = "对外投资合计(万元)";
	public static final String ALIAS_YEARS1 = "years1";
	public static final String ALIAS_ASSETS1 = "assets1";
	public static final String ALIAS_LIABILITIES1 = "liabilities1";
	public static final String ALIAS_PROFIT1 = "profit1";
	public static final String ALIAS_EQUITY1 = "equity1";
	public static final String ALIAS_INVEREST1 = "inverest1";
	
	//columns START
	/**股东编号==>db_column: shareno*/
	private java.lang.String shareno;
	/**年份==>db_column: Years0*/
	private java.lang.String years0;
	/**资产合计(万元==>db_column: Assets0*/
	private java.lang.String assets0;
	/**负债合计(万元)==>db_column: Liabilities0*/
	private java.lang.String liabilities0;
	/**总利润(万元)==>db_column: Profit0*/
	private java.lang.String profit0;
	/**所有者权益(万元)==>db_column: Equity0*/
	private java.lang.String equity0;
	/**对外投资合计(万元)==>db_column: Inverest0*/
	private java.lang.String inverest0;
	/**years1==>db_column: Years1*/
	private java.lang.String years1;
	/**assets1==>db_column: Assets1*/
	private java.lang.String assets1;
	/**liabilities1==>db_column: Liabilities1*/
	private java.lang.String liabilities1;
	/**profit1==>db_column: Profit1*/
	private java.lang.String profit1;
	/**equity1==>db_column: Equity1*/
	private java.lang.String equity1;
	/**inverest1==>db_column: Inverest1*/
	private java.lang.String inverest1;
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
	public void setYears0(java.lang.String value) {
		this.years0 = value;
	}
	
	public java.lang.String getYears0() {
		return this.years0;
	}
	public void setAssets0(java.lang.String value) {
		this.assets0 = value;
	}
	
	public java.lang.String getAssets0() {
		return this.assets0;
	}
	public void setLiabilities0(java.lang.String value) {
		this.liabilities0 = value;
	}
	
	public java.lang.String getLiabilities0() {
		return this.liabilities0;
	}
	public void setProfit0(java.lang.String value) {
		this.profit0 = value;
	}
	
	public java.lang.String getProfit0() {
		return this.profit0;
	}
	public void setEquity0(java.lang.String value) {
		this.equity0 = value;
	}
	
	public java.lang.String getEquity0() {
		return this.equity0;
	}
	public void setInverest0(java.lang.String value) {
		this.inverest0 = value;
	}
	
	public java.lang.String getInverest0() {
		return this.inverest0;
	}
	public void setYears1(java.lang.String value) {
		this.years1 = value;
	}
	
	public java.lang.String getYears1() {
		return this.years1;
	}
	public void setAssets1(java.lang.String value) {
		this.assets1 = value;
	}
	
	public java.lang.String getAssets1() {
		return this.assets1;
	}
	public void setLiabilities1(java.lang.String value) {
		this.liabilities1 = value;
	}
	
	public java.lang.String getLiabilities1() {
		return this.liabilities1;
	}
	public void setProfit1(java.lang.String value) {
		this.profit1 = value;
	}
	
	public java.lang.String getProfit1() {
		return this.profit1;
	}
	public void setEquity1(java.lang.String value) {
		this.equity1 = value;
	}
	
	public java.lang.String getEquity1() {
		return this.equity1;
	}
	public void setInverest1(java.lang.String value) {
		this.inverest1 = value;
	}
	
	public java.lang.String getInverest1() {
		return this.inverest1;
	}

}

