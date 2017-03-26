/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.entity;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-07-14
 * @version 1.0
 * @param <T>
 */

public class BsnsZhengxin extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	public BsnsZhengxin(){
	}

	//columns START
	/**clntno==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**appliedAt==>db_column: appliedAt*/
	private java.lang.String appliedAt;
	/**confirmedAt==>db_column: confirmedAt*/
	private java.lang.String confirmedAt;
	/**loanType==>db_column: loanType*/
	private java.lang.String loanType;
	/**confirmType==>db_column: confirmType*/
	private java.lang.String confirmType;
	/**confirmDetails==>db_column: confirmDetails*/
	private java.lang.String confirmDetails;
	/**name==>db_column: name*/
	private java.lang.String name;
	/**pid==>db_column: pid*/
	private java.lang.String pid;
	/**mobile==>db_column: mobile*/
	private java.lang.String mobile;
	/**workName==>db_column: workName*/
	private java.lang.String workName;
	/**workAddress==>db_column: workAddress*/
	private java.lang.String workAddress;
	/**homeAddress==>db_column: homeAddress*/
	private java.lang.String homeAddress;
	/**homePhone==>db_column: homePhone*/
	private java.lang.String homePhone;
	/**createTime==>db_column: createTime*/
	private java.lang.String createTime;
	private java.lang.String idStatus;
	//columns END
	
	public java.lang.String getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(java.lang.String idStatus) {
		this.idStatus = idStatus;
	}

	private java.lang.String applied_at;   //String  转 json
	private java.lang.String confirmed_at;
	private java.lang.String loan_type;
	private java.lang.String confirm_type;
	private java.lang.String confirm_details;
	
	private java.lang.String id_status;


	public java.lang.String getId_status() {
		return id_status;
	}
	public void setId_status(java.lang.String id_status) {
		this.id_status = id_status;
	}
	public java.lang.String getClntno() {
		return clntno;
	}
	public void setClntno(java.lang.String clntno) {
		this.clntno = clntno;
	}
	public java.lang.String getAppliedAt() {
		return appliedAt;
	}
	public void setAppliedAt(java.lang.String appliedAt) {
		this.appliedAt = appliedAt;
	}
	public java.lang.String getConfirmedAt() {
		return confirmedAt;
	}
	public void setConfirmedAt(java.lang.String confirmedAt) {
		this.confirmedAt = confirmedAt;
	}
	public java.lang.String getLoanType() {
		return loanType;
	}
	public void setLoanType(java.lang.String loanType) {
		this.loanType = loanType;
	}
	public java.lang.String getConfirmType() {
		return confirmType;
	}
	public void setConfirmType(java.lang.String confirmType) {
		this.confirmType = confirmType;
	}
	public java.lang.String getConfirmDetails() {
		return confirmDetails;
	}
	public void setConfirmDetails(java.lang.String confirmDetails) {
		this.confirmDetails = confirmDetails;
	}
	public java.lang.String getName() {
		return name;
	}
	public void setName(java.lang.String name) {
		this.name = name;
	}
	public java.lang.String getPid() {
		return pid;
	}
	public void setPid(java.lang.String pid) {
		this.pid = pid;
	}
	public java.lang.String getMobile() {
		return mobile;
	}
	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}
	public java.lang.String getWorkName() {
		return workName;
	}
	public void setWorkName(java.lang.String workName) {
		this.workName = workName;
	}
	public java.lang.String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(java.lang.String workAddress) {
		this.workAddress = workAddress;
	}
	public java.lang.String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(java.lang.String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public java.lang.String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(java.lang.String homePhone) {
		this.homePhone = homePhone;
	}
	public java.lang.String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(java.lang.String createTime) {
		this.createTime = createTime;
	}
	public java.lang.String getApplied_at() {
		return applied_at;
	}
	public void setApplied_at(java.lang.String applied_at) {
		this.applied_at = applied_at;
	}
	public java.lang.String getConfirmed_at() {
		return confirmed_at;
	}
	public void setConfirmed_at(java.lang.String confirmed_at) {
		this.confirmed_at = confirmed_at;
	}
	public java.lang.String getLoan_type() {
		return loan_type;
	}
	public void setLoan_type(java.lang.String loan_type) {
		this.loan_type = loan_type;
	}
	public java.lang.String getConfirm_type() {
		return confirm_type;
	}
	public void setConfirm_type(java.lang.String confirm_type) {
		this.confirm_type = confirm_type;
	}
	public java.lang.String getConfirm_details() {
		return confirm_details;
	}
	public void setConfirm_details(java.lang.String confirm_details) {
		this.confirm_details = confirm_details;
	}

}

