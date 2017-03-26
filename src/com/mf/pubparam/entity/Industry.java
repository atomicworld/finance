/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.pubparam.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author xujiuhua
 * @2015-02-08
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class Industry extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "行业分类";
	public static final String ALIAS_INDUSTRY_CODE = "行业类别编码";
	public static final String ALIAS_INDUSTRY_NAME = "行业类别名称";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_TIERCODE = "行业类别层级";
	
	//date formats
	
	public Industry(){
	}

	public Industry(
		java.lang.String industryCode
	){
		this.industryCode = industryCode;
	}

	
	//columns START
	/**行业类别编码==>db_column: INDUSTRY_CODE*/
	private java.lang.String industryCode;
	/**行业类别名称==>db_column: INDUSTRY_NAME*/
	private java.lang.String industryName;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**行业类别层级==>db_column: TIERCODE*/
	private java.lang.String tiercode;
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

	public void setIndustryCode(java.lang.String value) {
		this.industryCode = value;
	}
	
	public java.lang.String getIndustryCode() {
		return this.industryCode;
	}
	public void setIndustryName(java.lang.String value) {
		this.industryName = value;
	}
	
	public java.lang.String getIndustryName() {
		return this.industryName;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setTiercode(java.lang.String value) {
		this.tiercode = value;
	}
	
	public java.lang.String getTiercode() {
		return this.tiercode;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("IndustryCode",getIndustryCode())
			.append("IndustryName",getIndustryName())
			.append("Remark",getRemark())
			.append("Tiercode",getTiercode())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIndustryCode())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Industry == false) return false;
		if(this == obj) return true;
		Industry other = (Industry)obj;
		return new EqualsBuilder()
			.append(getIndustryCode(),other.getIndustryCode())
			.isEquals();
	}
}

