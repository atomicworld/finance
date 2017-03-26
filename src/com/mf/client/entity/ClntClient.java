/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2014
 */

package com.mf.client.entity;


public class ClntClient implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	
	public ClntClient(){
	}

	
	public ClntClient(Integer clntid, String clntname, String certtype,
			String certno, String clnttype, String userid, String scdate) {
		super();
		this.clntid = clntid;
		this.clntname = clntname;
		this.certtype = certtype;
		this.certno = certno;
		this.clnttype = clnttype;
		this.userid = userid;
		this.scdate = scdate;
	}




	//columns START
	/**客户号*/
	private java.lang.Integer clntid;
	/**客户名称==>db_column: CLNTNAME*/
	private java.lang.String clntname;
	/**证件类型==>db_column: CERTTYPE*/
	private java.lang.String certtype;
	/**证件号码==>db_column: CERTNO*/
	private java.lang.String certno;
	/**客户类型==>db_column: CLNTTYPE*/
	private java.lang.String clnttype;
	/**登记人ID==>db_column: USERID*/
	private java.lang.String userid;
	/**登记日期==>db_column: SCDATE*/
	private java.lang.String scdate;
	//columns END
	
	// add by xjh for List展示 20150120 start 
	private String opnm; // 员工姓名
	private String dptno; // 员工所属部门编号
	private String dptname; // 员工所属部门名称
	
	public String getOpnm() {
		return opnm;
	}
	
	public void setOpnm(String opnm) {
		this.opnm = opnm;
	}
	
	public String getDptno() {
		return dptno;
	}
	
	public void setDptno(String dptno) {
		this.dptno = dptno;
	}
	
	public String getDptname() {
		return dptname;
	}
	
	public void setDptname(String dptname) {
		this.dptname = dptname;
	}
	// add by xjh for List展示 20150120 end


	// 系统框架字段 start
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
	// 系统框架字段 end

	

	public java.lang.String getClntname() {
		return clntname;
	}


	public java.lang.Integer getClntid() {
		return clntid;
	}


	public void setClntid(java.lang.Integer clntid) {
		this.clntid = clntid;
	}


	public void setClntname(java.lang.String clntname) {
		this.clntname = clntname;
	}


	public java.lang.String getCerttype() {
		return certtype;
	}


	public void setCerttype(java.lang.String certtype) {
		this.certtype = certtype;
	}


	public java.lang.String getCertno() {
		return certno;
	}


	public void setCertno(java.lang.String certno) {
		this.certno = certno;
	}


	public java.lang.String getClnttype() {
		return clnttype;
	}


	public void setClnttype(java.lang.String clnttype) {
		this.clnttype = clnttype;
	}


	public java.lang.String getUserid() {
		return userid;
	}


	public void setUserid(java.lang.String userid) {
		this.userid = userid;
	}


	public java.lang.String getScdate() {
		return scdate;
	}


	public void setScdate(java.lang.String scdate) {
		this.scdate = scdate;
	}
	
}

