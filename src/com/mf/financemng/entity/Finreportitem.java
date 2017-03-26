/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2016
 */

package com.mf.financemng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.util.*;

/**
 * @author wangyw
 * @2016-01-05
 * @version 1.0
 * @param <T>
 */

public class Finreportitem extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Finreportitem";
	public static final String ALIAS_ITEMID = "itemid";
	public static final String ALIAS_RPTTYPE = "科目类别 ";
	public static final String ALIAS_ITEMCODE = "科目编号";
	public static final String ALIAS_ITEMNAME = "科目名称";
	public static final String ALIAS_PITEMCODE = "上级科目编号";
	public static final String ALIAS_ITEMLEVEL = "目录级数, 默认为1";
	public static final String ALIAS_ISSUMITEM = "是否合计项科目 ";
	public static final String ALIAS_ITEMCALNOTE = "科目计算说明";
	public static final String ALIAS_STATUS = "科目状态 0无效,1有效";
	public static final String ALIAS_POSITION = "定位";
	public static final String ALIAS_RELATEITEM = "relateitem";
	
	//date formats
	
	public Finreportitem(){
	}

	public Finreportitem(
		java.lang.String itemid
	){
		this.itemid = itemid;
	}

	
	//columns START
	/**itemid==>db_column: ITEMID*/
	private java.lang.String itemid;
	/**科目类别 ==>db_column: RPTTYPE*/
	private java.lang.String rpttype;
	/**科目编号==>db_column: ITEMCODE*/
	private java.lang.String itemcode;
	/**科目名称==>db_column: ITEMNAME*/
	private java.lang.String itemname;
	/**上级科目编号==>db_column: PITEMCODE*/
	private java.lang.String pitemcode;
	/**目录级数, 默认为1==>db_column: ITEMLEVEL*/
	private java.lang.Integer itemlevel;
	/**是否合计项科目 ==>db_column: ISSUMITEM*/
	private java.lang.Integer issumitem;
	/**科目计算说明==>db_column: ITEMCALNOTE*/
	private java.lang.String itemcalnote;
	/**科目状态 0无效,1有效==>db_column: STATUS*/
	private java.lang.Integer status;
	/**定位==>db_column: Position*/
	private java.lang.String position;
	/**relateitem==>db_column: RELATEITEM*/
	private java.lang.String relateitem;
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

	public void setItemid(java.lang.String value) {
		this.itemid = value;
	}
	
	public java.lang.String getItemid() {
		return this.itemid;
	}
	public void setRpttype(java.lang.String value) {
		this.rpttype = value;
	}
	
	public java.lang.String getRpttype() {
		return this.rpttype;
	}
	public void setItemcode(java.lang.String value) {
		this.itemcode = value;
	}
	
	public java.lang.String getItemcode() {
		return this.itemcode;
	}
	public void setItemname(java.lang.String value) {
		this.itemname = value;
	}
	
	public java.lang.String getItemname() {
		return this.itemname;
	}
	public void setPitemcode(java.lang.String value) {
		this.pitemcode = value;
	}
	
	public java.lang.String getPitemcode() {
		return this.pitemcode;
	}
	public void setItemlevel(java.lang.Integer value) {
		this.itemlevel = value;
	}
	
	public java.lang.Integer getItemlevel() {
		return this.itemlevel;
	}
	public void setIssumitem(java.lang.Integer value) {
		this.issumitem = value;
	}
	
	public java.lang.Integer getIssumitem() {
		return this.issumitem;
	}
	public void setItemcalnote(java.lang.String value) {
		this.itemcalnote = value;
	}
	
	public java.lang.String getItemcalnote() {
		return this.itemcalnote;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setPosition(java.lang.String value) {
		this.position = value;
	}
	
	public java.lang.String getPosition() {
		return this.position;
	}
	public void setRelateitem(java.lang.String value) {
		this.relateitem = value;
	}
	
	public java.lang.String getRelateitem() {
		return this.relateitem;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Itemid",getItemid())
			.append("Rpttype",getRpttype())
			.append("Itemcode",getItemcode())
			.append("Itemname",getItemname())
			.append("Pitemcode",getPitemcode())
			.append("Itemlevel",getItemlevel())
			.append("Issumitem",getIssumitem())
			.append("Itemcalnote",getItemcalnote())
			.append("Status",getStatus())
			.append("Position",getPosition())
			.append("Relateitem",getRelateitem())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getItemid())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Finreportitem == false) return false;
		if(this == obj) return true;
		Finreportitem other = (Finreportitem)obj;
		return new EqualsBuilder()
			.append(getItemid(),other.getItemid())
			.isEquals();
	}
}

