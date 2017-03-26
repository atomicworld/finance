package com.mf.comStructure.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

public class Fundtable extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "Fundtable";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_BUSIAMT = "busiamt";
	public static final String ALIAS_SSEGAMT = "ssegamt";
	public static final String ALIAS_ADDNO = "addno";
	public static final String ALIAS_ADDAMT = "addamt";
	public static final String ALIAS_BANKNO = "bankno";
	public static final String ALIAS_BANKAMT = "bankamt";
	public static final String ALIAS_OTHERFORM = "otherform";
	public static final String ALIAS_OTHERNO = "otherno";
	public static final String ALIAS_OTHERAMT = "otheramt";
	public static final String ALIAS_YEARMONTH = "yearmonth";
	public static final String ALIAS_SUBTIME = "subtime";
	public static final String ALIAS_STATE = "state";
	
	//date formats
	public static final String FORMAT_SUBTIME = DATE_FORMAT;
	
	public Fundtable(){
	}

	public Fundtable(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: id*/
	private java.lang.Integer id;
	/**busiamt==>db_column: BUSIAMT*/
	private java.lang.String busiamt;
	/**ssegamt==>db_column: SSEGAMT*/
	private java.lang.String ssegamt;
	/**addno==>db_column: ADDNO*/
	private java.lang.String addno;
	/**addamt==>db_column: ADDAMT*/
	private java.lang.String addamt;
	/**bankno==>db_column: BANKNO*/
	private java.lang.String bankno;
	/**bankamt==>db_column: BANKAMT*/
	private java.lang.String bankamt;
	/**otherform==>db_column: OTHERFORM*/
	private java.lang.String otherform;
	/**otherno==>db_column: OTHERNO*/
	private java.lang.String otherno;
	/**otheramt==>db_column: OTHERAMT*/
	private java.lang.String otheramt;
	/**yearmonth==>db_column: YEARMONTH*/
	private java.lang.String yearmonth;
	private java.util.Date subtimeBegin;
	private java.util.Date subtimeEnd;
	private java.util.Date subtime;
	
	public java.util.Date getSubtimeBegin() {
		return this.subtimeBegin;
	}
	
	public void setSubtimeBegin(java.util.Date value) {
		this.subtimeBegin = value;
	}	
	
	public java.util.Date getSubtimeEnd() {
		return this.subtimeEnd;
	}
	
	public void setSubtimeEnd(java.util.Date value) {
		this.subtimeEnd = value;
	}
	
	/**state==>db_column: STATE*/
	private java.lang.String state;
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
	public void setBusiamt(java.lang.String value) {
		this.busiamt = value;
	}
	
	public java.lang.String getBusiamt() {
		return this.busiamt;
	}
	public void setSsegamt(java.lang.String value) {
		this.ssegamt = value;
	}
	
	public java.lang.String getSsegamt() {
		return this.ssegamt;
	}
	public void setAddno(java.lang.String value) {
		this.addno = value;
	}
	
	public java.lang.String getAddno() {
		return this.addno;
	}
	public void setAddamt(java.lang.String value) {
		this.addamt = value;
	}
	
	public java.lang.String getAddamt() {
		return this.addamt;
	}
	public void setBankno(java.lang.String value) {
		this.bankno = value;
	}
	
	public java.lang.String getBankno() {
		return this.bankno;
	}
	public void setBankamt(java.lang.String value) {
		this.bankamt = value;
	}
	
	public java.lang.String getBankamt() {
		return this.bankamt;
	}
	public void setOtherform(java.lang.String value) {
		this.otherform = value;
	}
	
	public java.lang.String getOtherform() {
		return this.otherform;
	}
	public void setOtherno(java.lang.String value) {
		this.otherno = value;
	}
	
	public java.lang.String getOtherno() {
		return this.otherno;
	}
	public void setOtheramt(java.lang.String value) {
		this.otheramt = value;
	}
	
	public java.lang.String getOtheramt() {
		return this.otheramt;
	}
	public void setYearmonth(java.lang.String value) {
		this.yearmonth = value;
	}
	
	public java.lang.String getYearmonth() {
		return this.yearmonth;
	}
	public void setSubtime(java.util.Date value) {
		this.subtime = value;
	}
	
	public java.util.Date getSubtime() {
		return this.subtime;
	}
	public void setState(java.lang.String value) {
		this.state = value;
	}
	
	public java.lang.String getState() {
		return this.state;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Busiamt",getBusiamt())
			.append("Ssegamt",getSsegamt())
			.append("Addno",getAddno())
			.append("Addamt",getAddamt())
			.append("Bankno",getBankno())
			.append("Bankamt",getBankamt())
			.append("Otherform",getOtherform())
			.append("Otherno",getOtherno())
			.append("Otheramt",getOtheramt())
			.append("Yearmonth",getYearmonth())
			.append("Subtime",getSubtime())
			.append("State",getState())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Fundtable == false) return false;
		if(this == obj) return true;
		Fundtable other = (Fundtable)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

