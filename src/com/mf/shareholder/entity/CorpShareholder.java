/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.shareholder.entity;

import com.mf.base.BaseEntity;

/**
 * @author wangyw
 * @2015-08-20
 * @version 1.0
 * @param <T>
 */

public class CorpShareholder extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "CorpShareholder";
	public static final String ALIAS_SHARENO = "股东编号";
	public static final String ALIAS_SHARENAME = "股东名称";
	public static final String ALIAS_CORPNO = "公司编号";
	public static final String ALIAS_SHARE_TYPE = "股东类别";
	public static final String ALIAS_CARD_TYPE = "股东证件类型";
	public static final String ALIAS_HOLDER_DOC_NO = "股东证件号";
	public static final String ALIAS_AREA = "股东所在地";
	public static final String ALIAS_HOLD_AMOUNT = "持股金额(万元)";
	public static final String ALIAS_HOLD_PROPORTION = "占比(%)";
	public static final String ALIAS_SORT_NO = "序号";
	public static final String ALIAS_REMARK = "备注";
	
	
	//columns START
	/**股东编号==>db_column: shareno*/
	private java.lang.String shareno;
	/**股东名称==>db_column: sharename*/
	private java.lang.String sharename;
	/**公司编号==>db_column: corpno*/
	private java.lang.String corpno;
	/**股东类别==>db_column: shareType*/
	private java.lang.String shareType;
	/**股东证件类型==>db_column: CardType*/
	private java.lang.String cardType;
	/**股东证件号==>db_column: HolderDocNo*/
	private java.lang.String holderDocNo;
	/**股东所在地==>db_column: Area*/
	private java.lang.String area;
	/**持股金额(万元)==>db_column: HoldAmount*/
	private Long holdAmount;
	/**占比(%)==>db_column: HoldProportion*/
	private java.lang.String holdProportion;
	/**序号==>db_column: SortNo*/
	private java.lang.String sortNo;
	/**备注==>db_column: remark*/
	private java.lang.String remark;
	private java.lang.Integer delFlg;
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

	public void setShareno(java.lang.String value) {
		this.shareno = value;
	}
	
	public java.lang.Integer getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(java.lang.Integer delFlg) {
		this.delFlg = delFlg;
	}

	public java.lang.String getShareno() {
		return this.shareno;
	}
	public void setSharename(java.lang.String value) {
		this.sharename = value;
	}
	
	public java.lang.String getSharename() {
		return this.sharename;
	}
	public void setCorpno(java.lang.String value) {
		this.corpno = value;
	}
	
	public java.lang.String getCorpno() {
		return this.corpno;
	}
	public void setShareType(java.lang.String value) {
		this.shareType = value;
	}
	
	public java.lang.String getShareType() {
		return this.shareType;
	}
	public void setCardType(java.lang.String value) {
		this.cardType = value;
	}
	
	public java.lang.String getCardType() {
		return this.cardType;
	}
	public void setHolderDocNo(java.lang.String value) {
		this.holderDocNo = value;
	}
	
	public java.lang.String getHolderDocNo() {
		return this.holderDocNo;
	}
	public void setArea(java.lang.String value) {
		this.area = value;
	}
	
	public java.lang.String getArea() {
		return this.area;
	}
	public void setHoldAmount(Long value) {
		this.holdAmount = value;
	}
	
	public Long getHoldAmount() {
		return this.holdAmount;
	}
	public void setHoldProportion(java.lang.String value) {
		this.holdProportion = value;
	}
	
	public java.lang.String getHoldProportion() {
		return this.holdProportion;
	}
	public void setSortNo(java.lang.String value) {
		this.sortNo = value;
	}
	
	public java.lang.String getSortNo() {
		return this.sortNo;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

}

