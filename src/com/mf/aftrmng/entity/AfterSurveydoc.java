/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.aftrmng.entity;
import com.mf.base.BaseEntity;

/**
 * @author wangzhi
 * @2015-07-02
 * @version 1.0
 * @param <T>
 */

public class AfterSurveydoc extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "贷后跟踪报告表";
	public static final String ALIAS_CLNTNO = "客户编号";
	public static final String ALIAS_CLNTNM = "客户姓名";
	public static final String ALIAS_SRLNO = "流水号";
	public static final String ALIAS_REFINFNO = "关联信息编号";
	public static final String ALIAS_DOCTYP = "报告类型";
	public static final String ALIAS_DOCNM = "报告名称";
	public static final String ALIAS_CLNTINF = "借款人基本情况";
	public static final String ALIAS_ASSUERINF = "保证人情况";
	public static final String ALIAS_VOUCHINF = "担保品情况";
	public static final String ALIAS_CONCLUSION = "调查结论";
	public static final String ALIAS_DPTNO = "部门编号";
	public static final String ALIAS_OPNO = "操作员编号";
	public static final String ALIAS_DOCDT = "报告日期";
	public static final String ALIAS_UPDTDT = "更新日期";
	public static final String ALIAS_REMARK = "备注";
	public static final String ALIAS_USEINF = "贷款使用情况";
	public static final String ALIAS_LIABILITYINF = "企业或个人负债情况";
	public static final String ALIAS_RUNINF = "个人或企业经营情况";
	
	//date formats
	
	public AfterSurveydoc(){
	}

	public AfterSurveydoc(
		java.lang.String srlno
	){
		this.srlno = srlno;
	}

	
	//columns START
	/**客户编号==>db_column: CLNTNO*/
	private java.lang.String clntno;
	/**客户姓名==>db_column: CLNTNM*/
	private java.lang.String clntnm;
	/**流水号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**关联信息编号借据==>db_column: REFINFNO*/
	private java.lang.String refinfno;
	/**报告类型==>db_column: DOCTYP*/
	private java.lang.String doctyp;
	/**报告名称==>db_column: DOCNM*/
	private java.lang.String docnm;
	/**借款人基本情况==>db_column: CLNTINF*/
	private java.lang.String clntinf;
	/**保证人情况==>db_column: ASSUERINF*/
	private java.lang.String assuerinf;
	/**担保品情况==>db_column: VOUCHINF*/
	private java.lang.String vouchinf;
	/**调查结论==>db_column: CONCLUSION*/
	private java.lang.String conclusion;
	/**部门编号==>db_column: DPTNO*/
	private java.lang.String dptno;
	/**操作员编号==>db_column: OPNO*/
	private java.lang.String opno;
	/**报告日期==>db_column: DOCDT*/
	private java.lang.String docdt;
	/**更新日期==>db_column: UPDTDT*/
	private java.lang.String updtdt;
	/**备注==>db_column: REMARK*/
	private java.lang.String remark;
	/**贷款使用情况==>db_column: USEINF*/
	private java.lang.String useinf;
	/**企业或个人负债情况==>db_column: LIABILITYINF*/
	private java.lang.String liabilityinf;
	/**个人或企业经营情况==>db_column: RUNINF*/
	private java.lang.String runinf;
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
	public void setSrlno(java.lang.String value) {
		this.srlno = value;
	}
	
	public java.lang.String getSrlno() {
		return this.srlno;
	}
	public void setRefinfno(java.lang.String value) {
		this.refinfno = value;
	}
	
	public java.lang.String getRefinfno() {
		return this.refinfno;
	}
	public void setDoctyp(java.lang.String value) {
		this.doctyp = value;
	}
	
	public java.lang.String getDoctyp() {
		return this.doctyp;
	}
	public void setDocnm(java.lang.String value) {
		this.docnm = value;
	}
	
	public java.lang.String getDocnm() {
		return this.docnm;
	}
	public void setClntinf(java.lang.String value) {
		this.clntinf = value;
	}
	
	public java.lang.String getClntinf() {
		return this.clntinf;
	}
	public void setAssuerinf(java.lang.String value) {
		this.assuerinf = value;
	}
	
	public java.lang.String getAssuerinf() {
		return this.assuerinf;
	}
	public void setVouchinf(java.lang.String value) {
		this.vouchinf = value;
	}
	
	public java.lang.String getVouchinf() {
		return this.vouchinf;
	}
	public void setConclusion(java.lang.String value) {
		this.conclusion = value;
	}
	
	public java.lang.String getConclusion() {
		return this.conclusion;
	}
	public void setDptno(java.lang.String value) {
		this.dptno = value;
	}
	
	public java.lang.String getDptno() {
		return this.dptno;
	}
	public void setOpno(java.lang.String value) {
		this.opno = value;
	}
	
	public java.lang.String getOpno() {
		return this.opno;
	}
	public void setDocdt(java.lang.String value) {
		this.docdt = value;
	}
	
	public java.lang.String getDocdt() {
		return this.docdt;
	}
	public void setUpdtdt(java.lang.String value) {
		this.updtdt = value;
	}
	
	public java.lang.String getUpdtdt() {
		return this.updtdt;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}
	public void setUseinf(java.lang.String value) {
		this.useinf = value;
	}
	
	public java.lang.String getUseinf() {
		return this.useinf;
	}
	public void setLiabilityinf(java.lang.String value) {
		this.liabilityinf = value;
	}
	
	public java.lang.String getLiabilityinf() {
		return this.liabilityinf;
	}
	public void setRuninf(java.lang.String value) {
		this.runinf = value;
	}
	
	public java.lang.String getRuninf() {
		return this.runinf;
	}
}

