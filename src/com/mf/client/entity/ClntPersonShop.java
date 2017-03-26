/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;


/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonShop implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "门店信息";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_SHOPNO = "门店名称";
	public static final String ALIAS_RECAPITAL = "注册资本";
	public static final String ALIAS_RUNSCALE = "经营规模";
	public static final String ALIAS_SHOPADDRESS = "门店地址";
	public static final String ALIAS_LICENSENO = "营业执照号码";
	public static final String ALIAS_TAXRENO = "税务登记证号码";
	public static final String ALIAS_REDATE = "注册时间";
	public static final String ALIAS_NEWASDATE = "最新年检日期";
	public static final String ALIAS_WAGENO = "基本账号";
	public static final String ALIAS_WAGEBANK = "基本账号开户行";
	
	//date formats
	
	public ClntPersonShop(){
	}

	public ClntPersonShop(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**门店名称==>db_column: SHOPNO*/
	private java.lang.String shopno;
	/**注册资本==>db_column: RECAPITAL*/
	private BigDecimal recapital;
	/**经营规模==>db_column: RUNSCALE*/
	private java.lang.String runscale;
	/**门店地址==>db_column: SHOPADDRESS*/
	private java.lang.String shopaddress;
	/**营业执照号码==>db_column: LICENSENO*/
	private java.lang.String licenseno;
	/**税务登记证号码==>db_column: TAXRENO*/
	private java.lang.String taxreno;
	/**注册时间==>db_column: REDATE*/
	private java.lang.String redate;
	/**最新年检日期==>db_column: NEWASDATE*/
	private java.lang.String newasdate;
	/**基本账号==>db_column: WAGENO*/
	private java.lang.String wageno;
	/**基本账号开户行==>db_column: WAGEBANK*/
	private java.lang.String wagebank;
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

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setShopno(java.lang.String value) {
		this.shopno = value;
	}
	
	public java.lang.String getShopno() {
		return this.shopno;
	}
	
	public BigDecimal getRecapital() {
		return recapital;
	}

	public void setRecapital(BigDecimal recapital) {
		this.recapital = recapital;
	}

	public void setRunscale(java.lang.String value) {
		this.runscale = value;
	}
	
	public java.lang.String getRunscale() {
		return this.runscale;
	}
	public void setShopaddress(java.lang.String value) {
		this.shopaddress = value;
	}
	
	public java.lang.String getShopaddress() {
		return this.shopaddress;
	}
	public void setLicenseno(java.lang.String value) {
		this.licenseno = value;
	}
	
	public java.lang.String getLicenseno() {
		return this.licenseno;
	}
	public void setTaxreno(java.lang.String value) {
		this.taxreno = value;
	}
	
	public java.lang.String getTaxreno() {
		return this.taxreno;
	}
	public void setRedate(java.lang.String value) {
		this.redate = value;
	}
	
	public java.lang.String getRedate() {
		return this.redate;
	}
	public void setNewasdate(java.lang.String value) {
		this.newasdate = value;
	}
	
	public java.lang.String getNewasdate() {
		return this.newasdate;
	}
	public void setWageno(java.lang.String value) {
		this.wageno = value;
	}
	
	public java.lang.String getWageno() {
		return this.wageno;
	}
	public void setWagebank(java.lang.String value) {
		this.wagebank = value;
	}
	
	public java.lang.String getWagebank() {
		return this.wagebank;
	}

}

