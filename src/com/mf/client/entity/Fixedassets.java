/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.client.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.client.entity.*;

/**
 * @author wangyw
 * @2016-01-06
 * @version 1.0
 * @param <T>
 */

public class Fixedassets extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Fixedassets";
	public static final String ALIAS_FIXASSETID = "fixassetid";
	public static final String ALIAS_ORGCODE = "orgcode";
	public static final String ALIAS_ASSETSTYPE = "assetstype";
	public static final String ALIAS_STATISYEAR = "statisyear";
	public static final String ALIAS_ASSETSOLD = "assetsold";
	public static final String ALIAS_ASSETCURRENT = "assetcurrent";
	public static final String ALIAS_ASSETTOTAL = "assettotal";
	public static final String ALIAS_ASSETLIMITYEAR = "assetlimityear";
	public static final String ALIAS_LEAVEAMOUNT = "leaveamount";
	public static final String ALIAS_PURCHASEDATE = "purchasedate";
	public static final String ALIAS_AREA = "area";
	public static final String ALIAS_LOCATION = "location";
	public static final String ALIAS_REMARK = "remark";
	public static final String ALIAS_DELETEFLAG = "deleteflag";
	public static final String ALIAS_RPTSTATUS = "rptstatus";
	public static final String ALIAS_RPTBATCH = "rptbatch";
	public static final String ALIAS_RPTDATE = "rptdate";
	public static final String ALIAS_PROCESSSTATUS = "processstatus";
	public static final String ALIAS_CREATEBY = "createby";
	public static final String ALIAS_CREATEDATE = "createdate";
	public static final String ALIAS_UPDATEBY = "updateby";
	public static final String ALIAS_UPDATEDATE = "updatedate";
	
	//date formats
	public static final String FORMAT_PURCHASEDATE = DATE_FORMAT;
	public static final String FORMAT_RPTDATE = DATE_FORMAT;
	public static final String FORMAT_CREATEDATE = DATE_FORMAT;
	public static final String FORMAT_UPDATEDATE = DATE_FORMAT;
	
	public Fixedassets(){
	}

	public Fixedassets(
		java.lang.String fixassetid
	){
		this.fixassetid = fixassetid;
	}

	
	//columns START
	/**fixassetid==>db_column: FIXASSETID*/
	private java.lang.String fixassetid;
	/**orgcode==>db_column: ORGCODE*/
	private java.lang.String orgcode;
	/**assetstype==>db_column: ASSETSTYPE*/
	private java.lang.String assetstype;
	/**statisyear==>db_column: STATISYEAR*/
	private java.lang.Integer statisyear;
	/**assetsold==>db_column: ASSETSOLD*/
	private String assetsold;
	/**assetcurrent==>db_column: ASSETCURRENT*/
	private String assetcurrent;
	/**assettotal==>db_column: ASSETTOTAL*/
	private String assettotal;
	/**assetlimityear==>db_column: ASSETLIMITYEAR*/
	private String assetlimityear;
	/**leaveamount==>db_column: LEAVEAMOUNT*/
	private String leaveamount;
	private String purchasedateBegin;
	private String purchasedateEnd;
	private String purchasedate;//购置时间
	
	public String getPurchasedateBegin() {
		return this.purchasedateBegin;
	}
	
	public void setPurchasedateBegin(String value) {
		this.purchasedateBegin = value;
	}	
	
	public String getPurchasedateEnd() {
		return this.purchasedateEnd;
	}
	
	public void setPurchasedateEnd(String value) {
		this.purchasedateEnd = value;
	}
	
	/**area==>db_column:房产面积.只对固定资产为房产时记录 AREA*/
	private String area;
	/**location==>db_column:房产坐落位置.只对固定资产为房产时记录 LOCATION*/
	private java.lang.String location;
	/**remark==>db_column: REMARK*/
	private java.lang.String remark;
	/**deleteflag==>db_column: DELETEFLAG*/
	private java.lang.Integer deleteflag;
	/**rptstatus==>db_column: RPTSTATUS*/
	private java.lang.Integer rptstatus;
	/**rptbatch==>db_column: RPTBATCH*/
	private java.lang.String rptbatch;
	private String rptdateBegin;
	private String rptdateEnd;
	private String rptdate;
	
	public String getRptdateBegin() {
		return this.rptdateBegin;
	}
	
	public void setRptdateBegin(String value) {
		this.rptdateBegin = value;
	}	
	
	public String getRptdateEnd() {
		return this.rptdateEnd;
	}
	
	public void setRptdateEnd(String value) {
		this.rptdateEnd = value;
	}
	
	/**processstatus==>db_column: PROCESSSTATUS*/
	private java.lang.Integer processstatus;
	/**createby==>db_column: CREATEBY*/
	private java.lang.String createby;
	private String createdateBegin;
	private String createdateEnd;
	private String createdate;
	
	public String getCreatedateBegin() {
		return this.createdateBegin;
	}
	
	public void setCreatedateBegin(String value) {
		this.createdateBegin = value;
	}	
	
	public String getCreatedateEnd() {
		return this.createdateEnd;
	}
	
	public void setCreatedateEnd(String value) {
		this.createdateEnd = value;
	}
	
	/**updateby==>db_column: UPDATEBY*/
	private java.lang.String updateby;
	private String updatedateBegin;
	private String updatedateEnd;
	private String updatedate;
	
	public String getUpdatedateBegin() {
		return this.updatedateBegin;
	}
	
	public void setUpdatedateBegin(String value) {
		this.updatedateBegin = value;
	}	
	
	public String getUpdatedateEnd() {
		return this.updatedateEnd;
	}
	
	public void setUpdatedateEnd(String value) {
		this.updatedateEnd = value;
	}
	
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

	public void setFixassetid(java.lang.String value) {
		this.fixassetid = value;
	}
	
	public java.lang.String getFixassetid() {
		return this.fixassetid;
	}
	public void setOrgcode(java.lang.String value) {
		this.orgcode = value;
	}
	
	public java.lang.String getOrgcode() {
		return this.orgcode;
	}
	public void setAssetstype(java.lang.String value) {
		this.assetstype = value;
	}
	
	public java.lang.String getAssetstype() {
		return this.assetstype;
	}
	public void setStatisyear(java.lang.Integer value) {
		this.statisyear = value;
	}
	
	public java.lang.Integer getStatisyear() {
		return this.statisyear;
	}
	public void setAssetsold(String value) {
		this.assetsold = value;
	}
	
	public String getAssetsold() {
		return this.assetsold;
	}
	public void setAssetcurrent(String value) {
		this.assetcurrent = value;
	}
	
	public String getAssetcurrent() {
		return this.assetcurrent;
	}
	public void setAssettotal(String value) {
		this.assettotal = value;
	}
	
	public String getAssettotal() {
		return this.assettotal;
	}
	public void setAssetlimityear(String value) {
		this.assetlimityear = value;
	}
	
	public String getAssetlimityear() {
		return this.assetlimityear;
	}
	public void setLeaveamount(String value) {
		this.leaveamount = value;
	}
	
	public String getLeaveamount() {
		return this.leaveamount;
	}
	public void setPurchasedate(String value) {
		this.purchasedate = value;
	}
	
	public String getPurchasedate() {
		return this.purchasedate;
	}
	public void setArea(String value) {
		this.area = value;
	}
	
	public String getArea() {
		return this.area;
	}
	public void setLocation(java.lang.String value) {
		this.location = value;
	}
	
	public java.lang.String getLocation() {
		return this.location;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setDeleteflag(java.lang.Integer value) {
		this.deleteflag = value;
	}
	
	public java.lang.Integer getDeleteflag() {
		return this.deleteflag;
	}
	public void setRptstatus(java.lang.Integer value) {
		this.rptstatus = value;
	}
	
	public java.lang.Integer getRptstatus() {
		return this.rptstatus;
	}
	public void setRptbatch(java.lang.String value) {
		this.rptbatch = value;
	}
	
	public java.lang.String getRptbatch() {
		return this.rptbatch;
	}
	public void setRptdate(String value) {
		this.rptdate = value;
	}
	
	public String getRptdate() {
		return this.rptdate;
	}
	public void setProcessstatus(java.lang.Integer value) {
		this.processstatus = value;
	}
	
	public java.lang.Integer getProcessstatus() {
		return this.processstatus;
	}
	public void setCreateby(java.lang.String value) {
		this.createby = value;
	}
	
	public java.lang.String getCreateby() {
		return this.createby;
	}
	public void setCreatedate(String value) {
		this.createdate = value;
	}
	
	public String getCreatedate() {
		return this.createdate;
	}
	public void setUpdateby(java.lang.String value) {
		this.updateby = value;
	}
	
	public java.lang.String getUpdateby() {
		return this.updateby;
	}
	public void setUpdatedate(String value) {
		this.updatedate = value;
	}
	
	public String getUpdatedate() {
		return this.updatedate;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Fixassetid",getFixassetid())
			.append("Orgcode",getOrgcode())
			.append("Assetstype",getAssetstype())
			.append("Statisyear",getStatisyear())
			.append("Assetsold",getAssetsold())
			.append("Assetcurrent",getAssetcurrent())
			.append("Assettotal",getAssettotal())
			.append("Assetlimityear",getAssetlimityear())
			.append("Leaveamount",getLeaveamount())
			.append("Purchasedate",getPurchasedate())
			.append("Area",getArea())
			.append("Location",getLocation())
			.append("Remark",getRemark())
			.append("Deleteflag",getDeleteflag())
			.append("Rptstatus",getRptstatus())
			.append("Rptbatch",getRptbatch())
			.append("Rptdate",getRptdate())
			.append("Processstatus",getProcessstatus())
			.append("Createby",getCreateby())
			.append("Createdate",getCreatedate())
			.append("Updateby",getUpdateby())
			.append("Updatedate",getUpdatedate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getFixassetid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Fixedassets == false) return false;
		if(this == obj) return true;
		Fixedassets other = (Fixedassets)obj;
		return new EqualsBuilder()
			.append(getFixassetid(),other.getFixassetid())
			.isEquals();
	}
}

