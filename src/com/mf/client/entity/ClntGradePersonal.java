/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.client.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-04-09
 * @version 1.0
 * @param <T>
 */

public class ClntGradePersonal extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "ClntGradePersonal";
	public static final String ALIAS_BASE = "基础评估";
	public static final String ALIAS_OCCUP = "职业评估";
	public static final String ALIAS_VITAE = "履历评估";
	public static final String ALIAS_ASSET = "固定资产";
	public static final String ALIAS_EXPREC = "收支评估";
	public static final String ALIAS_SAFE = "保险评估";
	public static final String ALIAS_TAX = "纳税评估";
	public static final String ALIAS_IMMASSET = "无形资产评估";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_SCORE = "总分";
	
	
	//date formats
	
	public ClntGradePersonal(){
	}

	public ClntGradePersonal(
		java.lang.String clntno
	){
		this.clntno = clntno;
	}

	
	//columns START
	/**基础评估==>db_column: base*/
	private java.lang.String base;
	/**职业评估==>db_column: occup*/
	private java.lang.String occup;
	/**履历评估==>db_column: vitae*/
	private java.lang.String vitae;
	/**固定资产==>db_column: asset*/
	private java.lang.String asset;
	/**收支评估==>db_column: exprec*/
	private java.lang.String exprec;
	/**保险评估==>db_column: safe*/
	private java.lang.String safe;
	/**纳税评估==>db_column: tax*/
	private java.lang.String tax;
	/**无形资产评估==>db_column: immasset*/
	private java.lang.String immasset;
	/**客户编号==>db_column: clntno*/
	private java.lang.String clntno;
	/**总分==>db_column: score*/
	private java.lang.String score="0";
	
	/**评分情况说明==>db_column: memo*/
	private java.lang.String memo;
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

	public void setBase(java.lang.String value) {
		this.base = value;
	}
	
	public java.lang.String getBase() {
		return this.base;
	}
	public void setVitae(java.lang.String value) {
		this.vitae = value;
	}
	
	public java.lang.String getVitae() {
		return this.vitae;
	}
	public void setAsset(java.lang.String value) {
		this.asset = value;
	}
	
	public java.lang.String getAsset() {
		return this.asset;
	}
	public void setExprec(java.lang.String value) {
		this.exprec = value;
	}
	
	public java.lang.String getExprec() {
		return this.exprec;
	}
	public void setSafe(java.lang.String value) {
		this.safe = value;
	}
	
	public java.lang.String getSafe() {
		return this.safe;
	}
	public void setTax(java.lang.String value) {
		this.tax = value;
	}
	
	public java.lang.String getTax() {
		return this.tax;
	}
	public void setImmasset(java.lang.String value) {
		this.immasset = value;
	}
	
	public java.lang.String getImmasset() {
		return this.immasset;
	}
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setScore(java.lang.String value) {
		this.score = value;
	}
	
	public java.lang.String getScore() {
		return this.score;
	}
	public java.lang.String getMemo() {
		return memo;
	}
	public void setMemo(java.lang.String memo) {
		this.memo = memo;
	}
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Base",getBase())
			.append("Occup",getOccup())
			.append("Vitae",getVitae())
			.append("Asset",getAsset())
			.append("Exprec",getExprec())
			.append("Safe",getSafe())
			.append("Tax",getTax())
			.append("Immasset",getImmasset())
			.append("Clntno",getClntno())
			.append("Score",getScore())
			.append("Memo",getMemo())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getClntno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntGradePersonal == false) return false;
		if(this == obj) return true;
		ClntGradePersonal other = (ClntGradePersonal)obj;
		return new EqualsBuilder()
			.append(getClntno(),other.getClntno())
			.isEquals();
	}

	public void setOccup(java.lang.String occup) {
		this.occup = occup;
	}

	public java.lang.String getOccup() {
		return occup;
	}
}

