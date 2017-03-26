/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.entity;

import com.mf.base.BaseEntity;

/**
 * @author xujiuhua
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncPrfbsList extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	//date formats
	
	public FnncPrfbsList(){
	}

	public FnncPrfbsList(
		java.lang.String prfno
	){
		this.prfno = prfno;
	}

	
	//columns START
	/**凭证流水号==>db_column: PRFTRCNO*/
	private java.lang.String prftrcno;
	/**凭证编号==>db_column: PRFNO*/
	private java.lang.String prfno;
	/**借方合计==>db_column: JAMNT*/
	private java.lang.String jamnt;
	/**借方笔数==>db_column: JTOTAL*/
	private java.lang.String jtotal;
	/**贷方合计==>db_column: DAMNT*/
	private java.lang.String damnt;
	/**贷方笔数==>db_column: DTOTAL*/
	private java.lang.String dtotal;
	/**操作员编号==>db_column: OPNM*/
	private java.lang.String opnm;
	/**凭证状态==>db_column: STT*/
	private java.lang.String stt;
	/**登记日期*/
	private java.lang.String regdt;
	/**摘要内容*/
	private java.lang.String remark;
	// xjh start
	/**凭证发生日期==>db_column: TXDT*/
	private java.lang.String txdt;
	/**凭证复核日期==>db_column: CHECKDT*/
	private java.lang.String checkdt;
	//状态
	private java.lang.String accntflg;
	// xjh end
	
	//columns END
	
	//系统框架字段 start
	public java.lang.String getJamnt() {
		return jamnt;
	}

	public void setJamnt(java.lang.String jamnt) {
		this.jamnt = jamnt;
	}

	public java.lang.String getJtotal() {
		return jtotal;
	}

	public void setJtotal(java.lang.String jtotal) {
		this.jtotal = jtotal;
	}

	public java.lang.String getDamnt() {
		return damnt;
	}

	public void setDamnt(java.lang.String damnt) {
		this.damnt = damnt;
	}

	public java.lang.String getDtotal() {
		return dtotal;
	}

	public void setDtotal(java.lang.String dtotal) {
		this.dtotal = dtotal;
	}

	public java.lang.String getOpnm() {
		return opnm;
	}

	public void setOpnm(java.lang.String opnm) {
		this.opnm = opnm;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public java.lang.String getRegdt() {
		return regdt;
	}

	public void setRegdt(java.lang.String regdt) {
		this.regdt = regdt;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}


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
	public void setPrfno(java.lang.String value) {
		this.prfno = value;
	}
	
	public java.lang.String getPrfno() {
		return this.prfno;
	}
	public void setStt(java.lang.String value) {
		this.stt = value;
	}
	
	public java.lang.String getStt() {
		return this.stt;
	}

	public java.lang.String getPrftrcno() {
		return prftrcno;
	}

	public void setPrftrcno(java.lang.String prftrcno) {
		this.prftrcno = prftrcno;
	}

	public java.lang.String getTxdt() {
		return txdt;
	}

	public void setTxdt(java.lang.String txdt) {
		this.txdt = txdt;
	}

	public java.lang.String getCheckdt() {
		return checkdt;
	}

	public void setCheckdt(java.lang.String checkdt) {
		this.checkdt = checkdt;
	}

	public java.lang.String getAccntflg() {
		return accntflg;
	}

	public void setAccntflg(java.lang.String accntflg) {
		this.accntflg = accntflg;
	}
	
}

