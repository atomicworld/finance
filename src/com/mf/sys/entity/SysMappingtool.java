package com.mf.sys.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

public class SysMappingtool extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "SysMappingtool";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_PREKEY = "preKey";
	public static final String ALIAS_VALUE = "value";
	public static final String ALIAS_DATE = "date";
	
	//date formats
	public static final String FORMAT_DATE = DATE_FORMAT;
	
	public SysMappingtool(){
	}

	public SysMappingtool(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**preKey==>db_column: PREKEY*/
	private java.lang.String preKey;
	/**value==>db_column: VALUE*/
	private java.lang.String value;
	/**date==>db_column: DATE*/
	private java.lang.String date;
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
	public void setPreKey(java.lang.String value) {
		this.preKey = value;
	}
	
	public java.lang.String getPreKey() {
		return this.preKey;
	}
	public void setValue(java.lang.String value) {
		this.value = value;
	}
	
	public java.lang.String getValue() {
		return this.value;
	}
	public void setDate(java.lang.String date) {
		this.date = date;
	}
	
	public java.lang.String getDate() {
		return this.date;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("PreKey",getPreKey())
			.append("Value",getValue())
			.append("Date",getDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysMappingtool == false) return false;
		if(this == obj) return true;
		SysMappingtool other = (SysMappingtool)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

