package com.mf.cntrtmng.entity;

import java.math.BigDecimal;

import com.mf.base.BaseEntity;


/**      
* 类名称：BsnsRepaylogList   
* 类描述：还款计划补录修改查询
* 创建人：wangyaowei  
* 创建时间：2015-2-2 下午6:18:43   
* 修改人：wangyaowei  
* 修改时间：2015-2-2 下午6:18:43   
* 修改备注：  方便查询新增的查询类。
* @version    
*    
*/
public class BsnsRepaylogList extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	
	public BsnsRepaylogList(){
	}

	public BsnsRepaylogList(
		java.lang.String srlno
	){
		this.srlno = srlno;
	}
	
	/**计划编号==>db_column: SRLNO*/
	private java.lang.String srlno;
	/**业务编号（同借据号）==>db_column: BSNSNO*/
	private java.lang.String bsnsno;
	/**还款期数==>db_column: REPAYTERMNO*/
	private java.lang.String repaytermno;
	/**还款周期开始日期==>db_column: CYCLESDT*/
	private java.lang.String cyclesdt;
	/**还款周期结束日期==>db_column: CYCLEEDT*/
	private java.lang.String cycleedt;
	/**需归还本金金额==>db_column: CURREPAYAMNT*/
	private BigDecimal currepayamnt;
	/**需归还利息金额==>db_column: REPAYINSTAMNT*/
	private BigDecimal repayinstamnt;
	/**实收本金金额==>db_column: RCVPRINAMNT*/
	private BigDecimal rcvprinamnt=new BigDecimal(0.0);
	/**实收利息金额==>db_column: RCVINSTAMNT*/
	private BigDecimal rcvinstamnt;
	/**实收金额==>db_column: RCVAMNT*/
	private BigDecimal rcvamnt;
	/**财务复核标识==>db_column: FINANCEFLG*/
	private java.lang.String financeflg;
	
	/**还款状态==>db_column: REPAYSTT*/
	private java.lang.String repaystt;
	
	
	public java.lang.String getSrlno() {
		return srlno;
	}

	public void setSrlno(java.lang.String srlno) {
		this.srlno = srlno;
	}

	public java.lang.String getBsnsno() {
		return bsnsno;
	}

	public void setBsnsno(java.lang.String bsnsno) {
		this.bsnsno = bsnsno;
	}

	public java.lang.String getRepaytermno() {
		return repaytermno;
	}

	public void setRepaytermno(java.lang.String repaytermno) {
		this.repaytermno = repaytermno;
	}

	public java.lang.String getCyclesdt() {
		return cyclesdt;
	}

	public void setCyclesdt(java.lang.String cyclesdt) {
		this.cyclesdt = cyclesdt;
	}

	public java.lang.String getCycleedt() {
		return cycleedt;
	}

	public void setCycleedt(java.lang.String cycleedt) {
		this.cycleedt = cycleedt;
	}

	public BigDecimal getCurrepayamnt() {
		return currepayamnt;
	}

	public void setCurrepayamnt(BigDecimal currepayamnt) {
		this.currepayamnt = currepayamnt;
	}

	public BigDecimal getRepayinstamnt() {
		return repayinstamnt;
	}

	public void setRepayinstamnt(BigDecimal repayinstamnt) {
		this.repayinstamnt = repayinstamnt;
	}

	public BigDecimal getRcvprinamnt() {
		return rcvprinamnt;
	}

	public void setRcvprinamnt(BigDecimal rcvprinamnt) {
		this.rcvprinamnt = rcvprinamnt;
	}

	public BigDecimal getRcvinstamnt() {
		return rcvinstamnt;
	}

	public void setRcvinstamnt(BigDecimal rcvinstamnt) {
		this.rcvinstamnt = rcvinstamnt;
	}

	public BigDecimal getRcvamnt() {
		return rcvamnt;
	}

	public void setRcvamnt(BigDecimal rcvamnt) {
		this.rcvamnt = rcvamnt;
	}

	public java.lang.String getFinanceflg() {
		return financeflg;
	}

	public void setFinanceflg(java.lang.String financeflg) {
		this.financeflg = financeflg;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public java.lang.String getRepaystt() {
		return repaystt;
	}

	public void setRepaystt(java.lang.String repaystt) {
		this.repaystt = repaystt;
	}

}
