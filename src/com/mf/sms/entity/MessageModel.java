package com.mf.sms.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-06-17
 * @version 1.0
 * @param <T>
 */

public class MessageModel extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "MessageModel";
	public static final String ALIAS_ID = "短信编号";
	public static final String ALIAS_TYPEID = "短信ID";
	public static final String ALIAS_TYPENM = "短信类型";
	public static final String ALIAS_CONTENT = "内容";
	public static final String ALIAS_ISUSED = "是否启用";
	
	//date formats
	
	public MessageModel(){
	}

	public MessageModel(
		java.lang.String id
	){
		this.id = id;
	}

	
	//columns START
	/**短信编号==>db_column: ID*/
	private java.lang.String id;
	/**短信ID==>db_column: TYPEID*/
	private java.lang.String typeid;
	/**短信类型==>db_column: TYPE*/
	private java.lang.String typenm;
	/**内容==>db_column: CONTENT*/
	private java.lang.String content;
	/**是否启用==>db_column: ISUSED*/
	private java.lang.String isused;
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

	public void setId(java.lang.String value) {
		this.id = value;
	}
	
	public java.lang.String getId() {
		return this.id;
	}
	
	public java.lang.String getTypeid() {
		return typeid;
	}

	public void setTypeid(java.lang.String typeid) {
		this.typeid = typeid;
	}

	public java.lang.String getTypenm() {
		return typenm;
	}

	public void setTypenm(java.lang.String typenm) {
		this.typenm = typenm;
	}

	public void setContent(java.lang.String value) {
		this.content = value;
	}
	
	public java.lang.String getContent() {
		return this.content;
	}

	public java.lang.String getIsused() {
		return isused;
	}

	public void setIsused(java.lang.String isused) {
		this.isused = isused;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Typeid",getTypeid())
			.append("Typenm",getTypenm())
			.append("Content",getContent())
			.append("Isused",getIsused())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof MessageModel == false) return false;
		if(this == obj) return true;
		MessageModel other = (MessageModel)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

