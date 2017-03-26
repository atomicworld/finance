/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.bsnsmng.entity;

import java.math.BigDecimal;



/**
 * @author yangchao
 * @2015-01-08
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class BsnsApplydtl {
	
	
	//alias
	public static final String TABLE_ALIAS = "BsnsApplydtl";
	public static final String ALIAS_RCRDID = "记录id";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_APPLYNO = "申请编号";
	public static final String ALIAS_SRLNO = "流水号";
	public static final String ALIAS_KNDNO = "业务种类编号";
	public static final String ALIAS_LNTMDY = "贷款期限（天）";
	public static final String ALIAS_GRTWAY = "担保类型";
	public static final String ALIAS_APPLYAMNT = "贷款金额";
	public static final String ALIAS_REGOPNO = "登记人编号";
	public static final String ALIAS_REGOPNM = "登记人姓名";
	public static final String ALIAS_DEPNO = "部门编号";
	public static final String ALIAS_SUBDATE = "申请提交日期";
	public static final String ALIAS_CURSTEP = "当前审批步骤";
	public static final String ALIAS_APPRVSTT = "当前审批状态";
	public static final String ALIAS_APPRVTYP = "审批类型";
	public static final String ALIAS_APPRVPRCSSNO = "审批流程编号";
	public static final String ALIAS_APPRVPRCSS = "审批流程";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_TRMYR = "期限（年）";
	public static final String ALIAS_TRMMNTH = "期限（月）";
	public static final String ALIAS_TRMDAY = "期限（日）";
	
	//date formats
	
	public BsnsApplydtl(){
	}

	public BsnsApplydtl(
		java.lang.Long rcrdid
	){
		this.rcrdid = rcrdid;
	}

	
	//columns START
	/**记录id==>db_column: RCRDID*/
	private java.lang.Long rcrdid;
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**申请编号==>db_column: APPLYNO*/
	private java.lang.String applyno;
	/**流水号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**业务种类编号==>db_column: KNDNO*/
	private java.lang.String kndno;
	/**贷款期限（天）==>db_column: LNTMDY*/
	private java.lang.String lntmdy;
	/**担保类型==>db_column: GRTWAY*/
	private java.lang.String grtway;
	/**贷款金额==>db_column: APPLYAMNT*/
	private BigDecimal applyamnt;
	/**登记人编号==>db_column: REGOPNO*/
	private java.lang.String regopno;
	/**登记人姓名==>db_column: REGOPNM*/
	private java.lang.String regopnm;
	/**部门编号==>db_column: DEPNO*/
	private java.lang.String depno;
	/**申请提交日期==>db_column: SUBDATE*/
	private java.lang.String subdate;
	/**当前审批步骤==>db_column: CURSTEP*/
	private java.lang.String curstep;
	/**当前审批状态==>db_column: APPRVSTT*/
	private java.lang.String apprvstt;
	/**审批类型==>db_column: APPRVTYP*/
	private java.lang.String apprvtyp;
	/**审批流程编号==>db_column: APPRVPRCSSNO*/
	private java.lang.String apprvprcssno;
	/**审批流程==>db_column: APPRVPRCSS*/
	private java.lang.String apprvprcss;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**期限（年）==>db_column: TRMYR*/
	private Integer trmyr;
	/**期限（月）==>db_column: TRMMNTH*/
	private Integer trmmnth;
	/**期限（日）==>db_column: TRMDAY*/
	private Integer trmday;
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

	public void setRcrdid(java.lang.Long value) {
		this.rcrdid = value;
	}
	
	public java.lang.Long getRcrdid() {
		return this.rcrdid;
	}
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
	public void setSrlno(java.lang.String value) {
		this.srlno = value;
	}
	
	public java.lang.String getSrlno() {
		return this.srlno;
	}
	public void setKndno(java.lang.String value) {
		this.kndno = value;
	}
	
	public java.lang.String getKndno() {
		return this.kndno;
	}
	public void setLntmdy(java.lang.String value) {
		this.lntmdy = value;
	}
	
	public java.lang.String getLntmdy() {
		return this.lntmdy;
	}
	public void setGrtway(java.lang.String value) {
		this.grtway = value;
	}
	
	public java.lang.String getGrtway() {
		return this.grtway;
	}
	public void setApplyamnt(BigDecimal value) {
		this.applyamnt = value;
	}
	
	public BigDecimal getApplyamnt() {
		return this.applyamnt;
	}
	public void setRegopno(java.lang.String value) {
		this.regopno = value;
	}
	
	public java.lang.String getRegopno() {
		return this.regopno;
	}
	public void setRegopnm(java.lang.String value) {
		this.regopnm = value;
	}
	
	public java.lang.String getRegopnm() {
		return this.regopnm;
	}
	public void setDepno(java.lang.String value) {
		this.depno = value;
	}
	
	public java.lang.String getDepno() {
		return this.depno;
	}
	public void setSubdate(java.lang.String value) {
		this.subdate = value;
	}
	
	public java.lang.String getSubdate() {
		return this.subdate;
	}
	public void setCurstep(java.lang.String value) {
		this.curstep = value;
	}
	
	public java.lang.String getCurstep() {
		return this.curstep;
	}
	public void setApprvstt(java.lang.String value) {
		this.apprvstt = value;
	}
	
	public java.lang.String getApprvstt() {
		return this.apprvstt;
	}
	public void setApprvtyp(java.lang.String value) {
		this.apprvtyp = value;
	}
	
	public java.lang.String getApprvtyp() {
		return this.apprvtyp;
	}
	public void setApprvprcssno(java.lang.String value) {
		this.apprvprcssno = value;
	}
	
	public java.lang.String getApprvprcssno() {
		return this.apprvprcssno;
	}
	public void setApprvprcss(java.lang.String value) {
		this.apprvprcss = value;
	}
	
	public java.lang.String getApprvprcss() {
		return this.apprvprcss;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setTrmyr(Integer value) {
		this.trmyr = value;
	}
	
	public Integer getTrmyr() {
		return this.trmyr;
	}
	public void setTrmmnth(Integer value) {
		this.trmmnth = value;
	}
	
	public Integer getTrmmnth() {
		return this.trmmnth;
	}
	public void setTrmday(Integer value) {
		this.trmday = value;
	}
	
	public Integer getTrmday() {
		return this.trmday;
	}


	
}

