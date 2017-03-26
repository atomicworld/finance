/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.entity;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-08-22
 * @version 1.0
 * @param <T>
 */

public class CorpPersondetail extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CorpPersondetail";
	public static final String ALIAS_SHARENO = "股东编号";
	public static final String ALIAS_BIRTHDATE = "出生日期";
	public static final String ALIAS_GENDER = "婚姻状态";
	public static final String ALIAS_MARRY_STATUS = "组织机构代码";
	public static final String ALIAS_REG_ADDRESS = "户籍";
	public static final String ALIAS_EDUCATION = "学历";
	public static final String ALIAS_POLITICAL_STATE = "政治面貌";
	public static final String ALIAS_TITLE = "职称";
	public static final String ALIAS_JOB_RESUME = "工作简历";
	public static final String ALIAS_TEL = "办公电话";
	public static final String ALIAS_MOBILE = "移动电话";
	public static final String ALIAS_HOME_TEL = "家庭电话";
	public static final String ALIAS_FAX = "传真";
	public static final String ALIAS_POSTAL = "邮编";
	public static final String ALIAS_ADDRESS = "联系地址";
	
	//columns START
	/**股东编号==>db_column: shareno*/
	private java.lang.String shareno;
	/**出生日期==>db_column: Birthdate*/
	private java.lang.String birthdate;
	/**婚姻状态==>db_column: Gender*/
	private java.lang.String gender;
	/**组织机构代码==>db_column: MarryStatus*/
	private java.lang.String marryStatus;
	/**户籍==>db_column: RegAddress*/
	private java.lang.String regAddress;
	/**学历==>db_column: Education*/
	private java.lang.String education;
	/**政治面貌==>db_column: PoliticalState*/
	private java.lang.String politicalState;
	/**职称==>db_column: Title*/
	private java.lang.String title;
	/**工作简历==>db_column: JobResume*/
	private java.lang.String jobResume;
	/**办公电话==>db_column: Tel*/
	private java.lang.String tel;
	/**移动电话==>db_column: Mobile*/
	private java.lang.String mobile;
	/**家庭电话==>db_column: HomeTel*/
	private java.lang.String homeTel;
	/**传真==>db_column: Fax*/
	private java.lang.String fax;
	/**邮编==>db_column: Postal*/
	private java.lang.String postal;
	private java.lang.String email;
	/**联系地址==>db_column: Address*/
	private java.lang.String address;
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

	public void setShareno(java.lang.String value) {
		this.shareno = value;
	}
	
	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getShareno() {
		return this.shareno;
	}
	public void setBirthdate(java.lang.String value) {
		this.birthdate = value;
	}
	
	public java.lang.String getBirthdate() {
		return this.birthdate;
	}
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
	public java.lang.String getGender() {
		return this.gender;
	}
	public void setMarryStatus(java.lang.String value) {
		this.marryStatus = value;
	}
	
	public java.lang.String getMarryStatus() {
		return this.marryStatus;
	}
	public void setRegAddress(java.lang.String value) {
		this.regAddress = value;
	}
	
	public java.lang.String getRegAddress() {
		return this.regAddress;
	}
	public void setEducation(java.lang.String value) {
		this.education = value;
	}
	
	public java.lang.String getEducation() {
		return this.education;
	}
	public void setPoliticalState(java.lang.String value) {
		this.politicalState = value;
	}
	
	public java.lang.String getPoliticalState() {
		return this.politicalState;
	}
	public void setTitle(java.lang.String value) {
		this.title = value;
	}
	
	public java.lang.String getTitle() {
		return this.title;
	}
	public void setJobResume(java.lang.String value) {
		this.jobResume = value;
	}
	
	public java.lang.String getJobResume() {
		return this.jobResume;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
	public void setMobile(java.lang.String value) {
		this.mobile = value;
	}
	
	public java.lang.String getMobile() {
		return this.mobile;
	}
	public void setHomeTel(java.lang.String value) {
		this.homeTel = value;
	}
	
	public java.lang.String getHomeTel() {
		return this.homeTel;
	}
	public void setFax(java.lang.String value) {
		this.fax = value;
	}
	
	public java.lang.String getFax() {
		return this.fax;
	}
	public void setPostal(java.lang.String value) {
		this.postal = value;
	}
	
	public java.lang.String getPostal() {
		return this.postal;
	}
	public void setAddress(java.lang.String value) {
		this.address = value;
	}
	
	public java.lang.String getAddress() {
		return this.address;
	}

}

