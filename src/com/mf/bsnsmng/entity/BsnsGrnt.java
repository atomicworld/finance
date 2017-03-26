

package com.mf.bsnsmng.entity;



/**
 * @author shengd
 * @2015-01-07
 * @Email: 1017768302@qq.com
 * @version 1.0
 * @param <T>
 */

public class BsnsGrnt {
	public static final String TABLE_ALIAS = "BsnsGrnt";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_APPLYNO = "申请编号";
	public static final String ALIAS_RCRDID = "记录ID";
	public static final String ALIAS_CNTRCTNO = "合同编号";
	public static final String ALIAS_GRNTYR = "保证类型";
	public static final String ALIAS_GRNTNO = "保证编号";
	public static final String ALIAS_GRNTERNO = "grnterno";
	public static final String ALIAS_GRNTERNM = "保证人姓名";
	public static final String ALIAS_GRNTAMNT = "保证金额";
	public static final String ALIAS_GRNTRT = "保证比例";
	public static final String ALIAS_RLTN = "与借款人关系";
	public static final String ALIAS_DEPNO = "登记人部门编号";
	public static final String ALIAS_REGOPNO = "登记人编号";
	public static final String ALIAS_REGDATE = "登记日期";
	public static final String ALIAS_UPDTDATE = "更新日期";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_GRNTERCLNTNO = "保证人客户号";
	public static final String ALIAS_POLNO = "保单编号";
	public static final String ALIAS_ISPOL = "是否保险公司保险";
	public static final String ALIAS_GRNTERIDTYP = "保证人证据类型";
	//date formats
	public BsnsGrnt(){
	}

	public BsnsGrnt(
		java.lang.Integer rcrdid
	){
		this.rcrdid = rcrdid;
	}
	//columns START
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**申请编号==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**记录ID==>db_column: RCRDID*/
	private java.lang.Integer rcrdid;
	/**合同编号==>db_column: CNTRCTNO*/
	private java.lang.String cntrctno;
	/**保证类型==>db_column: GRNTYR*/
	private java.lang.String grntyr;
	/**保证编号==>db_column: GRNTNO*/
	private java.lang.String grntno;
	/**grnterno==>db_column: GRNTERNO*/
	private java.lang.String grnterno;
	/**保证人姓名==>db_column: GRNTERNM*/
	private java.lang.String grnternm;
	/**保证金额==>db_column: GRNTAMNT*/
	private Long grntamnt;
	/**保证比例==>db_column: GRNTRT*/
	private Long grntrt;
	/**与借款人关系==>db_column: RLTN*/
	private java.lang.String rltn;
	/**登记人部门编号==>db_column: DEPNO*/
	private java.lang.String depno;
	/**登记人编号==>db_column: REGOPNO*/
	private java.lang.String regopno;
	/**登记日期==>db_column: REGDATE*/
	private java.lang.String regdate;
	/**更新日期==>db_column: UPDTDATE*/
	private java.lang.String updtdate;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**保证人客户号==>db_column: GRNTERCLNTNO*/
	private java.lang.String grnterclntno;
	/**保单编号==>db_column: POLNO*/
	private java.lang.String polno;
	/**是否保险公司保险==>db_column: ISPOL*/
	private java.lang.String ispol;
	/**保证人证据类型==>db_column: GRNTERIDTYP*/
	private java.lang.String grnteridtyp;
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

	public void setClntno(java.lang.String value) {
		this.clntno = value;
	}
	
	public java.lang.String getClntno() {
		return this.clntno;
	}
	public void setClntnm(java.lang.String value) {
		this.clntnm = value;
	}
	
	public java.lang.String getClntnm() {
		return this.clntnm;
	}
	public void setApplyno(java.lang.String value) {
		this.applyno = value;
	}
	
	public java.lang.String getApplyno() {
		return this.applyno;
	}
	public void setRcrdid(java.lang.Integer value) {
		this.rcrdid = value;
	}
	
	public java.lang.Integer getRcrdid() {
		return this.rcrdid;
	}
	public void setCntrctno(java.lang.String value) {
		this.cntrctno = value;
	}
	
	public java.lang.String getCntrctno() {
		return this.cntrctno;
	}
	public void setGrntyr(java.lang.String value) {
		this.grntyr = value;
	}
	
	public java.lang.String getGrntyr() {
		return this.grntyr;
	}
	public void setGrntno(java.lang.String value) {
		this.grntno = value;
	}
	
	public java.lang.String getGrntno() {
		return this.grntno;
	}
	public void setGrnterno(java.lang.String value) {
		this.grnterno = value;
	}
	
	public java.lang.String getGrnterno() {
		return this.grnterno;
	}
	public void setGrnternm(java.lang.String value) {
		this.grnternm = value;
	}
	
	public java.lang.String getGrnternm() {
		return this.grnternm;
	}
	public void setGrntamnt(Long value) {
		this.grntamnt = value;
	}
	
	public Long getGrntamnt() {
		return this.grntamnt;
	}
	public void setGrntrt(Long value) {
		this.grntrt = value;
	}
	
	public Long getGrntrt() {
		return this.grntrt;
	}
	public void setRltn(java.lang.String value) {
		this.rltn = value;
	}
	
	public java.lang.String getRltn() {
		return this.rltn;
	}
	public void setDepno(java.lang.String value) {
		this.depno = value;
	}
	
	public java.lang.String getDepno() {
		   return this.depno;
	}
	public void setRegopno(java.lang.String value) {
		   this.regopno = value;
	}
	
	public java.lang.String getRegopno() {
		   return this.regopno;
	}
	public void setRegdate(java.lang.String value) {
		   this.regdate = value;
	}
	
	public java.lang.String getRegdate() {
		   return this.regdate;
	}
	public void setUpdtdate(java.lang.String value) {
		   this.updtdate = value;
	}
	
	public java.lang.String getUpdtdate() {
		   return this.updtdate;
	}
	public void setRemark(java.lang.String value) {
		   this.remark = value;
	}
	
	public java.lang.String getRemark() {
		   return this.remark;
	}
	public void setGrnterclntno(java.lang.String value) {
		   this.grnterclntno = value;
	}
	
	public java.lang.String getGrnterclntno() {
		   return this.grnterclntno;
	}
	public void setPolno(java.lang.String value) {
		   this.polno = value;
	}
	
	public java.lang.String getPolno() {
		   return this.polno;
	}
	public void setIspol(java.lang.String value) {
		   this.ispol = value;
	}
	
	public java.lang.String getIspol() {
		   return this.ispol;
	}
	public void setGrnteridtyp(java.lang.String value) {
		   this.grnteridtyp = value;
	}
	
	public java.lang.String getGrnteridtyp() {
		return this.grnteridtyp;
	}
}

