package com.mf.financemng.entity;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.mf.base.BaseEntity;

/**
 * @author chenenze
 * @2015-02-10
 * @version 1.0
 * @param <T>
 */

public class FnncShareholder extends BaseEntity implements java.io.Serializable{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "股东信息表";
	public static final String ALIAS_SHARHOLDNO = "股东编号";
	public static final String ALIAS_SHARHOLDNM = "股东姓名";
	public static final String ALIAS_GENDER = "股东性别";
	public static final String ALIAS_SHARHOLDSTT = "股东状态";
	public static final String ALIAS_CAPITALNO = "出资证明书编号";
	public static final String ALIAS_CERTTYPE = "证件类型";
	public static final String ALIAS_CERTNO = "证件号码";
	public static final String ALIAS_SHARHOLDTP = "股东类别";
	public static final String ALIAS_STOCKTYPE = "股权性质";
	public static final String ALIAS_INVTYPE = "出资形式";
	public static final String ALIAS_INVAMT = "出资金额";
	public static final String ALIAS_UPINVAMT = "变股后出资金额";
	public static final String ALIAS_CURTP = "币种";
	public static final String ALIAS_PRATE = "股权比列";
	public static final String ALIAS_UPPRATE = "变股后股权比例";
	public static final String ALIAS_STOCKNO = "股权证编号";
	public static final String ALIAS_STS = "质押标识";
	public static final String ALIAS_LINKMAN = "联系人";
	public static final String ALIAS_HOMETEL = "住址电话";
	public static final String ALIAS_MOBILETEL = "手机号码";
	public static final String ALIAS_COMPANY = "单位名称";
	public static final String ALIAS_OCCADDRESS = "单位地址";
	public static final String ALIAS_SHARESDATE = "入股日期";
	public static final String ALIAS_UPSHARESDATE = "变股日期";
	public static final String ALIAS_SCDATE = "登记日期";
	public static final String ALIAS_LASTMODDATE = "更新日期";
	public static final String ALIAS_REGOPNO = "登记人编号";
	public static final String ALIAS_DEPNO = "部门编号";
	public static final String ALIAS_REMARK = "备注";
	
	//date formats
	
	public FnncShareholder(){
	}

	public FnncShareholder(
		java.lang.Integer sharholdno
	){
		this.sharholdno = sharholdno;
	}

	
	//columns START
	/**股东编号==>db_column: sharholdno*/
	private java.lang.Integer sharholdno;
	/**股东姓名==>db_column: sharholdnm*/
	private java.lang.String sharholdnm;
	/**股东性别==>db_column: gender*/
	private java.lang.String gender;
	/**股东状态==>db_column: sharholdstt*/
	private java.lang.String sharholdstt;
	/**出资证明书编号==>db_column: capitalno*/
	private java.lang.String capitalno;
	/**证件类型==>db_column: certtype*/
	private java.lang.String certtype;
	/**证件号码==>db_column: certno*/
	private java.lang.String certno;
	/**股东类别==>db_column: sharholdtp*/
	private java.lang.String sharholdtp;
	/**股权性质==>db_column: stocktype*/
	private java.lang.String stocktype;
	/**出资形式==>db_column: invtype*/
	private java.lang.String invtype;
	/**出资金额==>db_column: invamt*/
	private java.lang.String invamt;
	/**变股后出资金额==>db_column: upinvamt*/
	private java.lang.String upinvamt;
	/**币种==>db_column: curtp*/
	private java.lang.String curtp;
	/**股权比列==>db_column: prate*/
	private java.lang.String prate;
	/**变股后股权比例==>db_column: upprate*/
	private java.lang.String upprate;
	/**股权证编号==>db_column: stockno*/
	private java.lang.String stockno;
	/**质押标识==>db_column: sts*/
	private java.lang.String sts;
	/**联系人==>db_column: linkman*/
	private java.lang.String linkman;
	/**住址电话==>db_column: hometel*/
	private java.lang.String hometel;
	/**手机号码==>db_column: mobiletel*/
	private java.lang.String mobiletel;
	/**单位名称==>db_column: company*/
	private java.lang.String company;
	/**单位地址==>db_column: occaddress*/
	private java.lang.String occaddress;
	/**入股日期==>db_column: sharesdate*/
	private java.lang.String sharesdate;
	/**变股日期==>db_column: upsharesdate*/
	private java.lang.String upsharesdate;
	/**登记日期==>db_column: scdate*/
	private java.lang.String scdate;
	/**更新日期==>db_column: lastmoddate*/
	private java.lang.String lastmoddate;
	/**登记人编号==>db_column: regopno*/
	private java.lang.String regopno;
	/**部门编号==>db_column: depno*/
	private java.lang.String depno;
	/**备注==>db_column: remark*/
	private java.lang.String remark;
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

	public void setSharholdno(java.lang.Integer value) {
		this.sharholdno = value;
	}
	
	public java.lang.Integer getSharholdno() {
		return this.sharholdno;
	}
	public void setSharholdnm(java.lang.String value) {
		this.sharholdnm = value;
	}
	
	public java.lang.String getSharholdnm() {
		return this.sharholdnm;
	}
	public void setGender(java.lang.String value) {
		this.gender = value;
	}
	
	public java.lang.String getGender() {
		return this.gender;
	}
	public void setSharholdstt(java.lang.String value) {
		this.sharholdstt = value;
	}
	
	public java.lang.String getSharholdstt() {
		return this.sharholdstt;
	}
	public void setCapitalno(java.lang.String value) {
		this.capitalno = value;
	}
	
	public java.lang.String getCapitalno() {
		return this.capitalno;
	}
	public void setCerttype(java.lang.String value) {
		this.certtype = value;
	}
	
	public java.lang.String getCerttype() {
		return this.certtype;
	}
	public void setCertno(java.lang.String value) {
		this.certno = value;
	}
	
	public java.lang.String getCertno() {
		return this.certno;
	}
	public void setSharholdtp(java.lang.String value) {
		this.sharholdtp = value;
	}
	
	public java.lang.String getSharholdtp() {
		return this.sharholdtp;
	}
	public void setStocktype(java.lang.String value) {
		this.stocktype = value;
	}
	
	public java.lang.String getStocktype() {
		return this.stocktype;
	}
	public void setInvtype(java.lang.String value) {
		this.invtype = value;
	}
	
	public java.lang.String getInvtype() {
		return this.invtype;
	}
	public void setInvamt(java.lang.String value) {
		this.invamt = value;
	}
	
	public java.lang.String getInvamt() {
		return this.invamt;
	}
	public void setUpinvamt(java.lang.String value) {
		this.upinvamt = value;
	}
	
	public java.lang.String getUpinvamt() {
		return this.upinvamt;
	}
	public void setCurtp(java.lang.String value) {
		this.curtp = value;
	}
	
	public java.lang.String getCurtp() {
		return this.curtp;
	}
	public void setPrate(java.lang.String value) {
		this.prate = value;
	}
	
	public java.lang.String getPrate() {
		return this.prate;
	}
	public void setUpprate(java.lang.String value) {
		this.upprate = value;
	}
	
	public java.lang.String getUpprate() {
		return this.upprate;
	}
	public void setStockno(java.lang.String value) {
		this.stockno = value;
	}
	
	public java.lang.String getStockno() {
		return this.stockno;
	}
	public void setSts(java.lang.String value) {
		this.sts = value;
	}
	
	public java.lang.String getSts() {
		return this.sts;
	}
	public void setLinkman(java.lang.String value) {
		this.linkman = value;
	}
	
	public java.lang.String getLinkman() {
		return this.linkman;
	}
	public void setHometel(java.lang.String value) {
		this.hometel = value;
	}
	
	public java.lang.String getHometel() {
		return this.hometel;
	}
	public void setMobiletel(java.lang.String value) {
		this.mobiletel = value;
	}
	
	public java.lang.String getMobiletel() {
		return this.mobiletel;
	}
	public void setCompany(java.lang.String value) {
		this.company = value;
	}
	
	public java.lang.String getCompany() {
		return this.company;
	}
	public void setOccaddress(java.lang.String value) {
		this.occaddress = value;
	}
	
	public java.lang.String getOccaddress() {
		return this.occaddress;
	}
	public void setSharesdate(java.lang.String value) {
		this.sharesdate = value;
	}
	
	public java.lang.String getSharesdate() {
		return this.sharesdate;
	}
	public void setUpsharesdate(java.lang.String value) {
		this.upsharesdate = value;
	}
	
	public java.lang.String getUpsharesdate() {
		return this.upsharesdate;
	}
	public void setScdate(java.lang.String value) {
		this.scdate = value;
	}
	
	public java.lang.String getScdate() {
		return this.scdate;
	}
	public void setLastmoddate(java.lang.String value) {
		this.lastmoddate = value;
	}
	
	public java.lang.String getLastmoddate() {
		return this.lastmoddate;
	}
	public void setRegopno(java.lang.String value) {
		this.regopno = value;
	}
	
	public java.lang.String getRegopno() {
		return this.regopno;
	}
	public void setDepno(java.lang.String value) {
		this.depno = value;
	}
	
	public java.lang.String getDepno() {
		return this.depno;
	}
	public void setRemark(java.lang.String value) {
		this.remark = value;
	}
	
	public java.lang.String getRemark() {
		return this.remark;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Sharholdno",getSharholdno())
			.append("Sharholdnm",getSharholdnm())
			.append("Gender",getGender())
			.append("Sharholdstt",getSharholdstt())
			.append("Capitalno",getCapitalno())
			.append("Certtype",getCerttype())
			.append("Certno",getCertno())
			.append("Sharholdtp",getSharholdtp())
			.append("Stocktype",getStocktype())
			.append("Invtype",getInvtype())
			.append("Invamt",getInvamt())
			.append("Upinvamt",getUpinvamt())
			.append("Curtp",getCurtp())
			.append("Prate",getPrate())
			.append("Upprate",getUpprate())
			.append("Stockno",getStockno())
			.append("Sts",getSts())
			.append("Linkman",getLinkman())
			.append("Hometel",getHometel())
			.append("Mobiletel",getMobiletel())
			.append("Company",getCompany())
			.append("Occaddress",getOccaddress())
			.append("Sharesdate",getSharesdate())
			.append("Upsharesdate",getUpsharesdate())
			.append("Scdate",getScdate())
			.append("Lastmoddate",getLastmoddate())
			.append("Regopno",getRegopno())
			.append("Depno",getDepno())
			.append("Remark",getRemark())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getSharholdno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncShareholder == false) return false;
		if(this == obj) return true;
		FnncShareholder other = (FnncShareholder)obj;
		return new EqualsBuilder()
			.append(getSharholdno(),other.getSharholdno())
			.isEquals();
	}
}

