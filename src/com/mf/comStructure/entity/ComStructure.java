package com.mf.comStructure.entity;

/**
 * @author zhangcong
 * @2015-04-14
 * @version 1.0
 * @param <T>
 */

public class ComStructure implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	public ComStructure(){
	}

	/**主键自增长==>db_column: ID*/
	private Integer id;
	/**最大股东名称==>db_column: STOCK_NAME*/
	private String stockName;
	/**持股比例==>db_column: SHARE_RATIO*/
	private String shareRatio;
	/**董事长姓名==>db_column: PRE_NAME*/
	private String preName;
	/**董事长办公电话==>db_column: PRE_PHONE*/
	private String prePhone;
	/**董事长移动电话==>db_column: PRE_MOBILE*/
	private String preMobile;
	/**总经理姓名==>db_column: MGR_NAME*/
	private String mgrName;
	/**总经理办公电话==>db_column: MGR_PHONE*/
	private String mgrPhone;
	/**总经理移动电话==>db_column: MGR_MOBILE*/
	private String mgrMobile;
	/**开业日期==>db_column: START_DATE*/
	private String startDate;
	private String status; //状态（0：未提交1：已提交）
	private String submitDate;  //提交时间
	private String createDate;  //保存时间
	//columns END

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getShareRatio() {
		return shareRatio;
	}
	public void setShareRatio(String shareRatio) {
		this.shareRatio = shareRatio;
	}
	public String getPreName() {
		return preName;
	}
	public void setPreName(String preName) {
		this.preName = preName;
	}
	public String getPrePhone() {
		return prePhone;
	}
	public void setPrePhone(String prePhone) {
		this.prePhone = prePhone;
	}
	public String getPreMobile() {
		return preMobile;
	}
	public void setPreMobile(String preMobile) {
		this.preMobile = preMobile;
	}
	public String getMgrName() {
		return mgrName;
	}
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}
	public String getMgrPhone() {
		return mgrPhone;
	}
	public void setMgrPhone(String mgrPhone) {
		this.mgrPhone = mgrPhone;
	}
	public String getMgrMobile() {
		return mgrMobile;
	}
	public void setMgrMobile(String mgrMobile) {
		this.mgrMobile = mgrMobile;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSubmitDate() {
		return submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}

