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

public class ClntPersonInout implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "收支情况";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_MAININCOME = "主要经济来源";
	public static final String ALIAS_OTHERINCOME = "其他经济来源";
	public static final String ALIAS_PMONTYLYINCOME = "个人月收入";
	public static final String ALIAS_FMONTYLYINCOME = "家庭月收入";
	public static final String ALIAS_FAMILYNUM = "家庭人口数";
	public static final String ALIAS_MAINPERSONNUM = "主要供养人口";
	public static final String ALIAS_COMRELATION = "与本公司关系";
	
	//date formats
	
	public ClntPersonInout(){
	}

	public ClntPersonInout(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**主要经济来源==>db_column: MAININCOME*/
	private java.lang.String mainincome;
	/**其他经济来源==>db_column: OTHERINCOME*/
	private java.lang.String otherincome;
	/**个人月收入==>db_column: PMONTYLYINCOME*/
	private BigDecimal pmontylyincome;
	/**家庭月收入==>db_column: FMONTYLYINCOME*/
	private BigDecimal fmontylyincome;
	/**家庭人口数==>db_column: FAMILYNUM*/
	private java.lang.Integer familynum;
	/**主要供养人口==>db_column: MAINPERSONNUM*/
	private java.lang.String mainpersonnum;
	/**与本公司关系==>db_column: COMRELATION*/
	private java.lang.String comrelation;
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
	public void setMainincome(java.lang.String value) {
		this.mainincome = value;
	}
	
	public java.lang.String getMainincome() {
		return this.mainincome;
	}
	public void setOtherincome(java.lang.String value) {
		this.otherincome = value;
	}
	
	public java.lang.String getOtherincome() {
		return this.otherincome;
	}
	
	public BigDecimal getPmontylyincome() {
		return pmontylyincome;
	}

	public void setPmontylyincome(BigDecimal pmontylyincome) {
		this.pmontylyincome = pmontylyincome;
	}

	public BigDecimal getFmontylyincome() {
		return fmontylyincome;
	}

	public void setFmontylyincome(BigDecimal fmontylyincome) {
		this.fmontylyincome = fmontylyincome;
	}

	public void setFamilynum(java.lang.Integer value) {
		this.familynum = value;
	}
	
	public java.lang.Integer getFamilynum() {
		return this.familynum;
	}
	public void setMainpersonnum(java.lang.String value) {
		this.mainpersonnum = value;
	}
	
	public java.lang.String getMainpersonnum() {
		return this.mainpersonnum;
	}
	public void setComrelation(java.lang.String value) {
		this.comrelation = value;
	}
	
	public java.lang.String getComrelation() {
		return this.comrelation;
	}

}

