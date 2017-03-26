/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sys.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;
import com.mf.util.*;

/**
 * @author wangzhi
 * @2015-08-17
 * @version 1.0
 * @param <T>
 */

public class Banknames extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Banknames";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BANKNAME = "银行名称";
	public static final String ALIAS_URL = "url";
	public static final String ALIAS_LEAF = "leaf";
	public static final String ALIAS_PARENT_ID = "上级";
	
	//date formats
	
	public Banknames(){
	}

	public Banknames(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: id*/
	private java.lang.Integer id;
	/**银行名称==>db_column: bankname*/
	private java.lang.String bankname;
	/**url==>db_column: url*/
	private java.lang.String url;
	/**leaf==>db_column: leaf*/
	private java.lang.String leaf;
	/**上级==>db_column: parentId*/
	private java.lang.Integer parentId;
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
	public void setBankname(java.lang.String value) {
		this.bankname = value;
	}
	
	public java.lang.String getBankname() {
		return this.bankname;
	}
	public void setUrl(java.lang.String value) {
		this.url = value;
	}
	
	public java.lang.String getUrl() {
		return this.url;
	}
	public void setLeaf(java.lang.String value) {
		this.leaf = value;
	}
	
	public java.lang.String getLeaf() {
		return this.leaf;
	}
	public void setParentId(java.lang.Integer value) {
		this.parentId = value;
	}
	
	public java.lang.Integer getParentId() {
		return this.parentId;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Bankname",getBankname())
			.append("Url",getUrl())
			.append("Leaf",getLeaf())
			.append("ParentId",getParentId())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Banknames == false) return false;
		if(this == obj) return true;
		Banknames other = (Banknames)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

