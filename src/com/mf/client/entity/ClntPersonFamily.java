/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;


/**
 * @author xujiuhua
 * @2014-12-16
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class ClntPersonFamily implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "家庭成员";
	public static final String ALIAS_ID = "id";
	public static final String ALIAS_CLNTNO = "客户号";
	public static final String ALIAS_CLNTRELATION = "与客户关系";
	public static final String ALIAS_NAME = "姓名";
	public static final String ALIAS_CERTTYPE = "证件类型";
	public static final String ALIAS_CERTNO = "证件号码";
	public static final String ALIAS_GENDER = "性别";
	public static final String ALIAS_TEL = "联系电话";
	public static final String ALIAS_COMPANY = "工作单位";
	public static final String ALIAS_HEALTH = "个人健康状况";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public ClntPersonFamily(){
	}

	public ClntPersonFamily(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: ID*/
	private java.lang.Integer id;
	/**客户号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**与客户关系==>db_column: CLNTRELATION*/
	private java.lang.String clntrelation;
	/**姓名==>db_column: NAME*/
	private java.lang.String name;
	/**证件类型==>db_column: CERTTYPE*/
	private java.lang.String certtype;
	/**证件号码==>db_column: CERTNO*/
	private java.lang.String certno;
	/**性别==>db_column: GENDER*/
	private java.lang.String gender;
	/**联系电话==>db_column: TEL*/
	private java.lang.String tel;
	/**工作单位==>db_column: COMPANY*/
	private java.lang.String company;
	/**个人健康状况==>db_column: HEALTH*/
	private java.lang.String health;
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
	public void setClntrelation(java.lang.String value) {
		this.clntrelation = value;
	}
	
	public java.lang.String getClntrelation() {
		return this.clntrelation;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setCerttype(java.lang.String value) {
		this.certtype = value;
	}
	
	public java.lang.String getCerttype() {
		return this.certtype;
	}
	public void setCertno(java.lang.String value) {
		this.certno = value;
	}
	
	public java.lang.String getCertno() {
		return this.certno;
	}
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
	public java.lang.String getGender() {
		return this.gender;
	}
	public void setTel(java.lang.String value) {
		this.tel = value;
	}
	
	public java.lang.String getTel() {
		return this.tel;
	}
	public void setCompany(java.lang.String value) {
		this.company = value;
	}
	
	public java.lang.String getCompany() {
		return this.company;
	}
	public void setHealth(java.lang.String value) {
		this.health = value;
	}
	
	public java.lang.String getHealth() {
		return this.health;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
}

