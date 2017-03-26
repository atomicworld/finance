/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * @author xujiuhua
 * @2014-12-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonEcoHouse implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "房屋土地";
	public static final String ALIAS_ID = "ID";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_ASSETTYPE = "资产类型";
	public static final String ALIAS_HOUSESTRU = "房屋结构";
	public static final String ALIAS_ACREAGE = "面积";
	public static final String ALIAS_HOUSEVALUE = "价值";
	public static final String ALIAS_CREATEDATE = "建设日期";
	public static final String ALIAS_OBTAINDATE = "取得日期";
	public static final String ALIAS_HOUSECARD = "房产证号";
	public static final String ALIAS_GIVECARDORG = "发证机构名称";
	public static final String ALIAS_BUYFLAG = "购置情况";
	public static final String ALIAS_USEFLAG = "使用情况";
	public static final String ALIAS_POSITION = "位置";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonEcoHouse(){
	}

	public ClntPersonEcoHouse(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**ID==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**资产类型==>db_column: ASSETTYPE*/
	private java.lang.String assettype;
	/**房屋结构==>db_column: HOUSESTRU*/
	private java.lang.String housestru;
	/**面积==>db_column: ACREAGE*/
	private BigDecimal acreage;
	/**价值==>db_column: HOUSEVALUE*/
	private BigDecimal housevalue;
	/**建设日期==>db_column: CREATEDATE*/
	private java.lang.String createdate;
	/**取得日期==>db_column: OBTAINDATE*/
	private java.lang.String obtaindate;
	/**房产证号==>db_column: HOUSECARD*/
	private java.lang.String housecard;
	/**发证机构名称==>db_column: GIVECARDORG*/
	private java.lang.String givecardorg;
	/**购置情况==>db_column: BUYFLAG*/
	private java.lang.String buyflag;
	/**使用情况==>db_column: USEFLAG*/
	private java.lang.String useflag;
	/**位置==>db_column: POSITION*/
	private java.lang.String position;
	/**备注==>db_column: REMARK*/
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
	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setAssettype(java.lang.String value) {
		this.assettype = value;
	}
	
	public java.lang.String getAssettype() {
		return this.assettype;
	}
	public void setHousestru(java.lang.String value) {
		this.housestru = value;
	}
	
	public java.lang.String getHousestru() {
		return this.housestru;
	}
	
	public BigDecimal getAcreage() {
		return acreage;
	}

	public void setAcreage(BigDecimal acreage) {
		this.acreage = acreage;
	}

	public BigDecimal getHousevalue() {
		return housevalue;
	}

	public void setHousevalue(BigDecimal housevalue) {
		this.housevalue = housevalue;
	}

	public void setCreatedate(java.lang.String value) {
		this.createdate = value;
	}
	
	public java.lang.String getCreatedate() {
		return this.createdate;
	}
	public void setObtaindate(java.lang.String value) {
		this.obtaindate = value;
	}
	
	public java.lang.String getObtaindate() {
		return this.obtaindate;
	}
	public void setHousecard(java.lang.String value) {
		this.housecard = value;
	}
	
	public java.lang.String getHousecard() {
		return this.housecard;
	}
	public void setGivecardorg(java.lang.String value) {
		this.givecardorg = value;
	}
	
	public java.lang.String getGivecardorg() {
		return this.givecardorg;
	}
	public void setBuyflag(java.lang.String value) {
		this.buyflag = value;
	}
	
	public java.lang.String getBuyflag() {
		return this.buyflag;
	}
	public void setUseflag(java.lang.String value) {
		this.useflag = value;
	}
	
	public java.lang.String getUseflag() {
		return this.useflag;
	}
	public void setPosition(java.lang.String value) {
		this.position = value;
	}
	
	public java.lang.String getPosition() {
		return this.position;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Clntno",getClntno())
			.append("Assettype",getAssettype())
			.append("Housestru",getHousestru())
			.append("Acreage",getAcreage())
			.append("Housevalue",getHousevalue())
			.append("Createdate",getCreatedate())
			.append("Obtaindate",getObtaindate())
			.append("Housecard",getHousecard())
			.append("Givecardorg",getGivecardorg())
			.append("Buyflag",getBuyflag())
			.append("Useflag",getUseflag())
			.append("Position",getPosition())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ClntPersonEcoHouse == false) return false;
		if(this == obj) return true;
		ClntPersonEcoHouse other = (ClntPersonEcoHouse)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

