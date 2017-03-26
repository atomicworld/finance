/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.flowmng.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author wangzhi
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */

public class FlowIncreaseCapital extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "FlowIncreaseCapital";
	public static final String ALIAS_ID = "唯一编号";
	public static final String ALIAS_FILENO = "文件号";
	public static final String ALIAS_COMPANYNM = "公司名称";
	public static final String ALIAS_BEFORE_CAPITAL = "增资前注册资本(万元)";
	public static final String ALIAS_INCREASE_AMOUNT = "增资金额(万元)";
	public static final String ALIAS_AFTER_AMOUNT = "增资后注册资本";
	public static final String ALIAS_ISAPPROVE = "是否获得批准";
	public static final String ALIAS_SIGNER = "文件签发人";
	public static final String ALIAS_SIGNE_DATE = "签发日期";
	public static final String ALIAS_COMPANYAREA = "公司所在区域";
	public static final String ALIAS_UNIT = "批准单位";
	public static final String ALIAS_FILEPOSITION = "文件存放的位置";
	public static final String ALIAS_FILECONTENT = "文件内容";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public FlowIncreaseCapital(){
	}

	public FlowIncreaseCapital(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**唯一编号==>db_column: ID*/
	private java.lang.Integer id;
	/**文件号==>db_column: FILENO*/
	private java.lang.String fileno;
	/**公司名称==>db_column: COMPANYNM*/
	private java.lang.String companynm;
	/**增资前注册资本(万元)==>db_column: beforeCapital*/
	private BigDecimal beforeCapital;
	/**增资金额(万元)==>db_column: increaseAmount*/
	private BigDecimal increaseAmount;
	/**增资后注册资本==>db_column: afterAmount*/
	private BigDecimal afterAmount;
	/**是否获得批准==>db_column: isapprove*/
	private java.lang.String isapprove;
	/**文件签发人==>db_column: Signer*/
	private java.lang.String signer;
	/**签发日期==>db_column: signeDate*/
	private java.lang.String signeDate;
	/**公司所在区域==>db_column: Companyarea*/
	private java.lang.String companyarea;
	/**批准单位==>db_column: unit*/
	private java.lang.String unit;
	/**文件存放的位置==>db_column: fileposition*/
	private java.lang.String fileposition;
	/**文件内容==>db_column: filecontent*/
	private java.lang.String filecontent;
	/**备注==>db_column: remark*/
	private java.lang.String remark;
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
	public void setFileno(java.lang.String value) {
		this.fileno = value;
	}
	
	public java.lang.String getFileno() {
		return this.fileno;
	}
	public void setCompanynm(java.lang.String value) {
		this.companynm = value;
	}
	
	public java.lang.String getCompanynm() {
		return this.companynm;
	}
	public void setBeforeCapital(BigDecimal value) {
		this.beforeCapital = value;
	}
	
	public BigDecimal getBeforeCapital() {
		return this.beforeCapital;
	}
	public void setIncreaseAmount(BigDecimal value) {
		this.increaseAmount = value;
	}
	
	public BigDecimal getIncreaseAmount() {
		return this.increaseAmount;
	}
	public void setAfterAmount(BigDecimal value) {
		this.afterAmount = value;
	}
	
	public BigDecimal getAfterAmount() {
		return this.afterAmount;
	}
	public void setIsapprove(java.lang.String value) {
		this.isapprove = value;
	}
	
	public java.lang.String getIsapprove() {
		return this.isapprove;
	}
	public void setSigner(java.lang.String value) {
		this.signer = value;
	}
	
	public java.lang.String getSigner() {
		return this.signer;
	}
	public void setSigneDate(java.lang.String value) {
		this.signeDate = value;
	}
	
	public java.lang.String getSigneDate() {
		return this.signeDate;
	}
	public void setCompanyarea(java.lang.String value) {
		this.companyarea = value;
	}
	
	public java.lang.String getCompanyarea() {
		return this.companyarea;
	}
	public void setUnit(java.lang.String value) {
		this.unit = value;
	}
	
	public java.lang.String getUnit() {
		return this.unit;
	}
	public void setFileposition(java.lang.String value) {
		this.fileposition = value;
	}
	
	public java.lang.String getFileposition() {
		return this.fileposition;
	}
	public void setFilecontent(java.lang.String value) {
		this.filecontent = value;
	}
	
	public java.lang.String getFilecontent() {
		return this.filecontent;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
}

