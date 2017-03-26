package com.mf.sms.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import com.mf.base.BaseEntity;

public class Message extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	/*
	public static final String TABLE_ALIAS = "Message";
	public static final String ALIAS_NO = "短信编号date_num";
	public static final String ALIAS_MSTYPE = "短信类型";
	public static final String ALIAS_RECIPIENTNAME = "收件人姓名";
	public static final String ALIAS_RECIPIENTTYPE = "收件人类型";
	public static final String ALIAS_RECIPIENTCERTNO = "收件人证件号";
	public static final String ALIAS_RECIPIENTTEL = "收件人手机号码";
	public static final String ALIAS_MODELNO = "短信模板编号";
	public static final String ALIAS_SENDERNAME = "发件人姓名";
	public static final String ALIAS_SENDERID = "发件人编号";
	public static final String ALIAS_SDATE = "发送日期";
	public static final String ALIAS_STIME = "发送时间";
	public static final String ALIAS_STATE = "发送状态";
	public static final String ALIAS_REMARK = "备注";
	*/
	
	//date formats
	
	public Message(){
	}

	public Message(
		java.lang.String no
	){
		this.no = no;
	}

	
	//columns START
	/**短信编号date_num==>db_column: NO*/
	private java.lang.String no;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**还款计划编号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**短信类型==>db_column: MSTYPE*/
	private java.lang.String mstype;
	/**收件人姓名==>db_column: RECIPIENTNAME*/
	private java.lang.String recipientname;
	/**收件人类型==>db_column: RECIPIENTTYPE*/
	private java.lang.String recipienttype;
	/**收件人证件号==>db_column: RECIPIENTCERTNO*/
	private java.lang.String recipientcertno;
	/**收件人手机号码==>db_column: RECIPIENTTEL*/
	private java.lang.String recipienttel;
	/**短信模板编号==>db_column: MODELNO*/
	private java.lang.String modelno;
	/**发件人姓名==>db_column: SENDERNAME*/
	private java.lang.String sendername;
	/**发件人编号==>db_column: SENDERid*/
	private java.lang.String senderid;
	/**发送日期==>db_column: SDATE*/
	private java.lang.String sdate;
	/**发送时间==>db_column: SDATE*/
	private java.lang.String stime;
	/**发送状态==>db_column: STATE*/
	private java.lang.String state;
	/**备注  ==>db_column: REMARK*/
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

	public void setNo(java.lang.String value) {
		this.no = value;
	}
	
	public java.lang.String getNo() {
		return this.no;
	}
	
	public java.lang.String getCntrctno() {
		return cntrctno;
	}

	public void setCntrctno(java.lang.String cntrctno) {
		this.cntrctno = cntrctno;
	}

	public java.lang.String getSrlno() {
		return srlno;
	}

	public void setSrlno(java.lang.String srlno) {
		this.srlno = srlno;
	}

	public void setMstype(java.lang.String value) {
		this.mstype = value;
	}
	
	public java.lang.String getMstype() {
		return this.mstype;
	}
	public void setRecipientname(java.lang.String value) {
		this.recipientname = value;
	}
	
	public java.lang.String getRecipientname() {
		return this.recipientname;
	}
	public void setRecipienttype(java.lang.String value) {
		this.recipienttype = value;
	}
	
	public java.lang.String getRecipienttype() {
		return this.recipienttype;
	}
	public void setRecipienttel(java.lang.String value) {
		this.recipienttel = value;
	}
	
	public java.lang.String getRecipienttel() {
		return this.recipienttel;
	}
	public void setModelno(java.lang.String value) {
		this.modelno = value;
	}
	
	public java.lang.String getModelno() {
		return this.modelno;
	}
	public void setSendername(java.lang.String value) {
		this.sendername = value;
	}
	
	public java.lang.String getSendername() {
		return this.sendername;
	}
	public void setSdate(java.lang.String value) {
		this.sdate = value;
	}
	
	public java.lang.String getSdate() {
		return this.sdate;
	}
	public void setState(java.lang.String value) {
		this.state = value;
	}
	
	public java.lang.String getStime() {
		return stime;
	}

	public void setStime(java.lang.String stime) {
		this.stime = stime;
	}
	
	public java.lang.String getState() {
		return this.state;
	}
	
	public java.lang.String getRemark() {
		return remark;
	}
	
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	public java.lang.String getRecipientcertno() {
		return recipientcertno;
	}

	public void setRecipientcertno(java.lang.String recipientcertno) {
		this.recipientcertno = recipientcertno;
	}

	public java.lang.String getSenderid() {
		return senderid;
	}

	public void setSenderid(java.lang.String senderid) {
		this.senderid = senderid;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("No",getNo())
			.append("cntrctno",getCntrctno())
			.append("srlno",getSrlno())
			.append("Mstype",getMstype())
			.append("Recipientname",getRecipientname())
			.append("Recipienttype",getRecipienttype())
			.append("Recipienttel",getRecipienttel())
			.append("Modelno",getModelno())
			.append("Sendername",getSendername())
			.append("Sdate",getSdate())
			.append("Stime",getStime())
			.append("State",getState())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getNo())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Message == false) return false;
		if(this == obj) return true;
		Message other = (Message)obj;
		return new EqualsBuilder()
			.append(getNo(),other.getNo())
			.isEquals();
	}
}

