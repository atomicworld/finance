package com.mf.sendFileImpl.entity;

public class BlackList {
	
	//alias
//	public static final String TABLE_ALIAS = "非正常客户名单";
//	public static final String ALIAS_CUSTNAME = "客户姓名";
//	public static final String ALIAS_CUSTDOCNO = "客户证件号";
//	public static final String ALIAS_CUSTDOC = "客户证件类型";
//	public static final String ALIAS_CUSTTYPE = "客户类别";
//	public static final String ALIAS_REASON = "加入原因";
//	public static final String ALIAS_TRADE = "客户所属行业";
//	public static final String ALIAS_LOANTRADE = "投放行业";
//	public static final String ALIAS_LOANAREA = "投放区域";
//	public static final String ALIAS_VALIDDATE = "有效起始日期";
//	public static final String ALIAS_INVALIDDATE = "有效终止日期";
//	public static final String ALIAS_REMARK = "备注";
//	public static final String ALIAS_STATUS = "状态";
	
	//date formats
	public BlackList(){}
	
	
	//columns START
	/**客户姓名==>db_column: CUSTNAME*/
	private java.lang.String CustName;
	/**客户证件号==>db_column: CUSTDOCNO*/
	private java.lang.String CustDocNo;
	/**客户证件类型==>db_column: CUSTDOC*/
	private java.lang.String CustDoc;
	/**客户类型==>db_column: CUSTTYPE*/
	private java.lang.String CustType;
	/**加入原因==>db_column: REASON*/
	private java.lang.String Reason;
	/**客户所属行业==>db_column: TRADE*/
	private java.lang.String Trade;
	/**投放行业==>db_column: LOANTRADE*/
	private java.lang.String loantrade;
	/**投放区域==>db_column: AREA*/
	private java.lang.String Area;
	/**有效起始日期==>db_column: VALIDDATE*/
	private java.lang.String ValidDate;
	/**有效终止日期==>db_column: INVALIDDATE*/
	private java.lang.String InvalidDate;
	/**备注==>db_column: REMARK*/
	private java.lang.String Remark;
	/**状态==>db_column: STATUS*/
	private java.lang.String Status;
	public java.lang.String getCustName() {
		return CustName;
	}
	public void setCustName(java.lang.String custName) {
		CustName = custName;
	}
	public java.lang.String getCustDocNo() {
		return CustDocNo;
	}
	public void setCustDocNo(java.lang.String custDocNo) {
		CustDocNo = custDocNo;
	}
	public java.lang.String getCustDoc() {
		return CustDoc;
	}
	public void setCustDoc(java.lang.String custDoc) {
		CustDoc = custDoc;
	}
	public java.lang.String getCustType() {
		return CustType;
	}
	public void setCustType(java.lang.String custType) {
		CustType = custType;
	}
	public java.lang.String getReason() {
		return Reason;
	}
	public void setReason(java.lang.String reason) {
		Reason = reason;
	}
	public java.lang.String getTrade() {
		return Trade;
	}
	public void setTrade(java.lang.String trade) {
		Trade = trade;
	}
	public java.lang.String getLoantrade() {
		return loantrade;
	}
	public void setLoantrade(java.lang.String loantrade) {
		this.loantrade = loantrade;
	}
	public java.lang.String getArea() {
		return Area;
	}
	public void setArea(java.lang.String area) {
		Area = area;
	}
	public java.lang.String getValidDate() {
		return ValidDate;
	}
	public void setValidDate(java.lang.String validDate) {
		ValidDate = validDate;
	}
	public java.lang.String getInvalidDate() {
		return InvalidDate;
	}
	public void setInvalidDate(java.lang.String invalidDate) {
		InvalidDate = invalidDate;
	}
	public java.lang.String getRemark() {
		return Remark;
	}
	public void setRemark(java.lang.String remark) {
		Remark = remark;
	}
	public java.lang.String getStatus() {
		return Status;
	}
	public void setStatus(java.lang.String status) {
		Status = status;
	}
	
}
