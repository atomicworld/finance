/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sendFileImpl.entity;

import java.math.BigDecimal;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author wangzhi
 * @2015-09-08
 * @version 1.0
 * @param <T>
 */

public class BsnsApplyData {
	//date formats
	
	public BsnsApplyData(){
	}

	public BsnsApplyData(
		java.lang.Integer id
	){
		this.id = id;
	}

	
	//columns START
	/**id==>db_column: id*/
	private java.lang.Integer id;
	/**合同编号==>db_column: ConCode*/
	private java.lang.String conCode;
	/**合同金额==>db_column: ConAmount*/
	private BigDecimal conAmount;
	/**合同签订日期==>db_column: ConSignDate*/
	private java.lang.String conSignDate;
	/**合同有效起始日期==>db_column: ConStartDate*/
	private java.lang.String conStartDate;
	/**合同月利率(‰)==>db_column: ConYearRate*/
	private BigDecimal conYearRate;
	/**合同状态==>db_column: ConStatus*/
	private java.lang.Integer conStatus;
	/**合同逾期月利率(‰)==>db_column: ConDelayYearRate*/
	private BigDecimal conDelayYearRate;
	/**贷款编号==>db_column: LoanCode*/
	private java.lang.String loanCode;
	/**贷款主体==>db_column: LoanClass*/
	private java.lang.Integer loanClass;
	/**贷款类别==>db_column: ConType*/
	private java.lang.Integer conType;
	/**借款人类别==>db_column: CustClass*/
	private java.lang.Integer custClass;
	/**借款人名称==>db_column: CustName*/
	private java.lang.String custName;
	/**借款人证件类别==>db_column: CustDocType*/
	private java.lang.Integer custDocType;
	/**借款人证件号==>db_column: CustIDNo*/
	private java.lang.String custIdno;
	/**贷款对象规模==>db_column: CustScale*/
	private java.lang.Integer custScale;
	/**贷款签约日期==>db_column: LoanDate*/
	private java.lang.String loanDate;
	/**贷款发放日期==>db_column: SendDate*/
	private java.lang.String sendDate;
	/**贷款到期日期==>db_column: EndDate*/
	private java.lang.String endDate;
	/**贷款展期到期日期==>db_column: ExpireDate*/
	private java.lang.String expireDate;
	/**贷款月利率（‰）==>db_column: YearRate*/
	private BigDecimal yearRate;
	/**贷款逾期月利率(‰)==>db_column: DelayMonRate*/
	private BigDecimal delayMonRate;
	/**贷款金额（元）==>db_column: Amount*/
	private BigDecimal amount;
	/**争议解决方式==>db_column: SolutionWay*/
	private java.lang.Integer solutionWay;
	/**贷款对象==>db_column: LoanerType*/
	private java.lang.Integer loanerType;
	/**贷款用途==>db_column: LoanUsage*/
	private java.lang.Integer loanUsage;
	/**投放行业==>db_column: LoanTrade*/
	private java.lang.Integer loanTrade;
	/**投放区域==>db_column: LoanArea*/
	private java.lang.Integer loanArea;
	/**扣款方式==>db_column: RepaymentWay*/
	private java.lang.Integer repaymentWay;
	/**计息方式==>db_column: ReturnMode*/
	private java.lang.Integer returnMode;
	/**担保方式==>db_column: DanbaoMode*/
	private java.lang.Integer danbaoMode;
	/**利率性质==>db_column: RateProp*/
	private java.lang.Integer rateProp;
	/**委托人==>db_column: WtName*/
	private java.lang.String wtName;
	/**委托人证件类别==>db_column: WtDocType*/
	private java.lang.String wtDocType;
	/**委托人证件号码==>db_column: WtDocNo*/
	private java.lang.String wtDocNo;
	/**委托方法定代表人/负责人==>db_column: WtChargerName*/
	private java.lang.String wtChargerName;
	/**委托人联系电话==>db_column: WtTel*/
	private java.lang.String wtTel;
	/**委托人住所地==>db_column: WtAddr*/
	private java.lang.String wtAddr;
	/**委托人邮编==>db_column: WtPostal*/
	private java.lang.String wtPostal;
	/**委托人开户金融机构==>db_column: WtBank*/
	private java.lang.String wtBank;
	/**委托人账户==>db_column: WtBankAcc*/
	private java.lang.String wtBankAcc;
	/**受托人联系电话==>db_column: StTel*/
	private java.lang.String stTel;
	/**委托人类别==>db_column: WtClass*/
	private java.lang.Integer wtClass;
	/**代理费（元）==>db_column: ChargeFees*/
	private BigDecimal chargeFees;
	/**受托人住所地==>db_column: StAddr*/
	private java.lang.String stAddr;
	/**受托人邮编==>db_column: StPostal*/
	private java.lang.String stPostal;
	/**贷款状态==>db_column: Status*/
	private java.lang.Integer status;
	/**还款日期==>db_column: ReturnDate*/
	private java.lang.String returnDate;
	/**起息日期==>db_column: RBeginDate*/
	private java.lang.String rbeginDate;
	/**止息日期==>db_column: REndDate*/
	private java.lang.String rendDate;
	/**收回逾期滞纳金(元)==>db_column: DelayFee*/
	private BigDecimal delayFee;
	/**收回逾期利息(元)==>db_column: DelayInterest*/
	private BigDecimal delayInterest;
	/**收回利息（元）==>db_column: ReturnInterest*/
	private BigDecimal returnInterest;
	/**收回本金（元）==>db_column: ReturnAmt*/
	private BigDecimal returnAmt;
	/**收回状态==>db_column: IsDelay*/
	private java.lang.Integer isDelay;
	/**是否同城化业务==>db_column: IsTCH*/
	private java.lang.Integer isTch;
	/**是否已经生成XML接口文件==>db_column: Flag*/
	private java.lang.Integer flag;
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
	public void setConCode(java.lang.String value) {
		this.conCode = value;
	}
	
	public java.lang.String getConCode() {
		return this.conCode;
	}
	public void setConAmount(BigDecimal value) {
		this.conAmount = value;
	}
	
	public BigDecimal getConAmount() {
		return this.conAmount;
	}
	public void setConSignDate(java.lang.String value) {
		this.conSignDate = value;
	}
	
	public java.lang.String getConSignDate() {
		return this.conSignDate;
	}
	public void setConStartDate(java.lang.String value) {
		this.conStartDate = value;
	}
	
	public java.lang.String getConStartDate() {
		return this.conStartDate;
	}
	public void setConYearRate(BigDecimal value) {
		this.conYearRate = value;
	}
	
	public BigDecimal getConYearRate() {
		return this.conYearRate;
	}
	public void setConStatus(java.lang.Integer value) {
		this.conStatus = value;
	}
	
	public java.lang.Integer getConStatus() {
		return this.conStatus;
	}
	public void setConDelayYearRate(BigDecimal value) {
		this.conDelayYearRate = value;
	}
	
	public BigDecimal getConDelayYearRate() {
		return this.conDelayYearRate;
	}
	public void setLoanCode(java.lang.String value) {
		this.loanCode = value;
	}
	
	public java.lang.String getLoanCode() {
		return this.loanCode;
	}
	public void setLoanClass(java.lang.Integer value) {
		this.loanClass = value;
	}
	
	public java.lang.Integer getLoanClass() {
		return this.loanClass;
	}
	public void setConType(java.lang.Integer value) {
		this.conType = value;
	}
	
	public java.lang.Integer getConType() {
		return this.conType;
	}
	public void setCustClass(java.lang.Integer value) {
		this.custClass = value;
	}
	
	public java.lang.Integer getCustClass() {
		return this.custClass;
	}
	public void setCustName(java.lang.String value) {
		this.custName = value;
	}
	
	public java.lang.String getCustName() {
		return this.custName;
	}
	public void setCustDocType(java.lang.Integer value) {
		this.custDocType = value;
	}
	
	public java.lang.Integer getCustDocType() {
		return this.custDocType;
	}
	public void setCustIdno(java.lang.String value) {
		this.custIdno = value;
	}
	
	public java.lang.String getCustIdno() {
		return this.custIdno;
	}
	public void setCustScale(java.lang.Integer value) {
		this.custScale = value;
	}
	
	public java.lang.Integer getCustScale() {
		return this.custScale;
	}
	public void setLoanDate(java.lang.String value) {
		this.loanDate = value;
	}
	
	public java.lang.String getLoanDate() {
		return this.loanDate;
	}
	public void setSendDate(java.lang.String value) {
		this.sendDate = value;
	}
	
	public java.lang.String getSendDate() {
		return this.sendDate;
	}
	public void setEndDate(java.lang.String value) {
		this.endDate = value;
	}
	
	public java.lang.String getEndDate() {
		return this.endDate;
	}
	public void setExpireDate(java.lang.String value) {
		this.expireDate = value;
	}
	
	public java.lang.String getExpireDate() {
		return this.expireDate;
	}
	public void setYearRate(BigDecimal value) {
		this.yearRate = value;
	}
	
	public BigDecimal getYearRate() {
		return this.yearRate;
	}
	public void setDelayMonRate(BigDecimal value) {
		this.delayMonRate = value;
	}
	
	public BigDecimal getDelayMonRate() {
		return this.delayMonRate;
	}
	public void setAmount(BigDecimal value) {
		this.amount = value;
	}
	
	public BigDecimal getAmount() {
		return this.amount;
	}
	public void setSolutionWay(java.lang.Integer value) {
		this.solutionWay = value;
	}
	
	public java.lang.Integer getSolutionWay() {
		return this.solutionWay;
	}
	public void setLoanerType(java.lang.Integer value) {
		this.loanerType = value;
	}
	
	public java.lang.Integer getLoanerType() {
		return this.loanerType;
	}
	public void setLoanUsage(java.lang.Integer value) {
		this.loanUsage = value;
	}
	
	public java.lang.Integer getLoanUsage() {
		return this.loanUsage;
	}
	public void setLoanTrade(java.lang.Integer value) {
		this.loanTrade = value;
	}
	
	public java.lang.Integer getLoanTrade() {
		return this.loanTrade;
	}
	public void setLoanArea(java.lang.Integer value) {
		this.loanArea = value;
	}
	
	public java.lang.Integer getLoanArea() {
		return this.loanArea;
	}
	public void setRepaymentWay(java.lang.Integer value) {
		this.repaymentWay = value;
	}
	
	public java.lang.Integer getRepaymentWay() {
		return this.repaymentWay;
	}
	public void setReturnMode(java.lang.Integer value) {
		this.returnMode = value;
	}
	
	public java.lang.Integer getReturnMode() {
		return this.returnMode;
	}
	public void setDanbaoMode(java.lang.Integer value) {
		this.danbaoMode = value;
	}
	
	public java.lang.Integer getDanbaoMode() {
		return this.danbaoMode;
	}
	public void setRateProp(java.lang.Integer value) {
		this.rateProp = value;
	}
	
	public java.lang.Integer getRateProp() {
		return this.rateProp;
	}
	public void setWtName(java.lang.String value) {
		this.wtName = value;
	}
	
	public java.lang.String getWtName() {
		return this.wtName;
	}
	public void setWtDocType(java.lang.String value) {
		this.wtDocType = value;
	}
	
	public java.lang.String getWtDocType() {
		return this.wtDocType;
	}
	public void setWtDocNo(java.lang.String value) {
		this.wtDocNo = value;
	}
	
	public java.lang.String getWtDocNo() {
		return this.wtDocNo;
	}
	public void setWtChargerName(java.lang.String value) {
		this.wtChargerName = value;
	}
	
	public java.lang.String getWtChargerName() {
		return this.wtChargerName;
	}
	public void setWtTel(java.lang.String value) {
		this.wtTel = value;
	}
	
	public java.lang.String getWtTel() {
		return this.wtTel;
	}
	public void setWtAddr(java.lang.String value) {
		this.wtAddr = value;
	}
	
	public java.lang.String getWtAddr() {
		return this.wtAddr;
	}
	public void setWtPostal(java.lang.String value) {
		this.wtPostal = value;
	}
	
	public java.lang.String getWtPostal() {
		return this.wtPostal;
	}
	public void setWtBank(java.lang.String value) {
		this.wtBank = value;
	}
	
	public java.lang.String getWtBank() {
		return this.wtBank;
	}
	public void setWtBankAcc(java.lang.String value) {
		this.wtBankAcc = value;
	}
	
	public java.lang.String getWtBankAcc() {
		return this.wtBankAcc;
	}
	public void setStTel(java.lang.String value) {
		this.stTel = value;
	}
	
	public java.lang.String getStTel() {
		return this.stTel;
	}
	public void setWtClass(java.lang.Integer value) {
		this.wtClass = value;
	}
	
	public java.lang.Integer getWtClass() {
		return this.wtClass;
	}
	public void setChargeFees(BigDecimal value) {
		this.chargeFees = value;
	}
	
	public BigDecimal getChargeFees() {
		return this.chargeFees;
	}
	public void setStAddr(java.lang.String value) {
		this.stAddr = value;
	}
	
	public java.lang.String getStAddr() {
		return this.stAddr;
	}
	public void setStPostal(java.lang.String value) {
		this.stPostal = value;
	}
	
	public java.lang.String getStPostal() {
		return this.stPostal;
	}
	public void setStatus(java.lang.Integer value) {
		this.status = value;
	}
	
	public java.lang.Integer getStatus() {
		return this.status;
	}
	public void setReturnDate(java.lang.String value) {
		this.returnDate = value;
	}
	
	public java.lang.String getReturnDate() {
		return this.returnDate;
	}
	public void setRbeginDate(java.lang.String value) {
		this.rbeginDate = value;
	}
	
	public java.lang.String getRbeginDate() {
		return this.rbeginDate;
	}
	public void setRendDate(java.lang.String value) {
		this.rendDate = value;
	}
	
	public java.lang.String getRendDate() {
		return this.rendDate;
	}
	public void setDelayFee(BigDecimal value) {
		this.delayFee = value;
	}
	
	public BigDecimal getDelayFee() {
		return this.delayFee;
	}
	public void setDelayInterest(BigDecimal value) {
		this.delayInterest = value;
	}
	
	public BigDecimal getDelayInterest() {
		return this.delayInterest;
	}
	public void setReturnInterest(BigDecimal value) {
		this.returnInterest = value;
	}
	
	public BigDecimal getReturnInterest() {
		return this.returnInterest;
	}
	public void setReturnAmt(BigDecimal value) {
		this.returnAmt = value;
	}
	
	public BigDecimal getReturnAmt() {
		return this.returnAmt;
	}
	public void setIsDelay(java.lang.Integer value) {
		this.isDelay = value;
	}
	
	public java.lang.Integer getIsDelay() {
		return this.isDelay;
	}
	public void setIsTch(java.lang.Integer value) {
		this.isTch = value;
	}
	
	public java.lang.Integer getIsTch() {
		return this.isTch;
	}
	public void setFlag(java.lang.Integer value) {
		this.flag = value;
	}
	
	public java.lang.Integer getFlag() {
		return this.flag;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ConCode",getConCode())
			.append("ConAmount",getConAmount())
			.append("ConSignDate",getConSignDate())
			.append("ConStartDate",getConStartDate())
			.append("ConYearRate",getConYearRate())
			.append("ConStatus",getConStatus())
			.append("ConDelayYearRate",getConDelayYearRate())
			.append("LoanCode",getLoanCode())
			.append("LoanClass",getLoanClass())
			.append("ConType",getConType())
			.append("CustClass",getCustClass())
			.append("CustName",getCustName())
			.append("CustDocType",getCustDocType())
			.append("CustIdno",getCustIdno())
			.append("CustScale",getCustScale())
			.append("LoanDate",getLoanDate())
			.append("SendDate",getSendDate())
			.append("EndDate",getEndDate())
			.append("ExpireDate",getExpireDate())
			.append("YearRate",getYearRate())
			.append("DelayMonRate",getDelayMonRate())
			.append("Amount",getAmount())
			.append("SolutionWay",getSolutionWay())
			.append("LoanerType",getLoanerType())
			.append("LoanUsage",getLoanUsage())
			.append("LoanTrade",getLoanTrade())
			.append("LoanArea",getLoanArea())
			.append("RepaymentWay",getRepaymentWay())
			.append("ReturnMode",getReturnMode())
			.append("DanbaoMode",getDanbaoMode())
			.append("RateProp",getRateProp())
			.append("WtName",getWtName())
			.append("WtDocType",getWtDocType())
			.append("WtDocNo",getWtDocNo())
			.append("WtChargerName",getWtChargerName())
			.append("WtTel",getWtTel())
			.append("WtAddr",getWtAddr())
			.append("WtPostal",getWtPostal())
			.append("WtBank",getWtBank())
			.append("WtBankAcc",getWtBankAcc())
			.append("StTel",getStTel())
			.append("WtClass",getWtClass())
			.append("ChargeFees",getChargeFees())
			.append("StAddr",getStAddr())
			.append("StPostal",getStPostal())
			.append("Status",getStatus())
			.append("ReturnDate",getReturnDate())
			.append("RbeginDate",getRbeginDate())
			.append("RendDate",getRendDate())
			.append("DelayFee",getDelayFee())
			.append("DelayInterest",getDelayInterest())
			.append("ReturnInterest",getReturnInterest())
			.append("ReturnAmt",getReturnAmt())
			.append("IsDelay",getIsDelay())
			.append("IsTch",getIsTch())
			.append("Flag",getFlag())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof BsnsApplyData == false) return false;
		if(this == obj) return true;
		BsnsApplyData other = (BsnsApplyData)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

