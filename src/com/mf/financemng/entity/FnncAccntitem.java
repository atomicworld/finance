/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.entity;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * @author shenguangdong
 * @2015-02-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */

public class FnncAccntitem{
	private static final long serialVersionUID = 5454155825314635342L;
	
	//alias
	public static final String TABLE_ALIAS = "会计科目表";
	public static final String ALIAS_ACCNTNO = "科目编号";
	public static final String ALIAS_ACCNTKNDCODE = "科目归类编码";
	public static final String ALIAS_UPACCNTNO = "所属科目编号";
	public static final String ALIAS_ACCNTNM = "科目名称";
	public static final String ALIAS_HASCHILDACCNT = "是否存在子科目";
	public static final String ALIAS_ACCNTLVL = "科目级别";
	public static final String ALIAS_ACCNTDRCT = "科目余额方向";
	public static final String ALIAS_ACCNTTYP = "科目类型";
	public static final String ALIAS_FRGNFLG = "本币或外币使用";
	public static final String ALIAS_EQLFLG = "是否检查平衡";
	public static final String ALIAS_AMTDRCN = "发生额方向";
	public static final String ALIAS_JAMNT = "科目余额借";
	public static final String ALIAS_DAMNT = "科目余额贷";
	
	//date formats
	
	public FnncAccntitem(){
	}

	public FnncAccntitem(
		java.lang.String accntno
	){
		this.accntno = accntno;
	}

	
	//columns START
	/**科目编号==>db_column: ACCNTNO*/
	private java.lang.String accntno;
	/**科目归类编码==>db_column: ACCNTKNDCODE*/
	private java.lang.String accntkndcode;
	/**所属科目编号==>db_column: UPACCNTNO*/
	private java.lang.String upaccntno;
	/**科目名称==>db_column: ACCNTNM*/
	private java.lang.String accntnm;
	/**是否存在子科目==>db_column: HASCHILDACCNT*/
	private java.lang.String haschildaccnt;
	/**科目级别==>db_column: ACCNTLVL*/
	private java.lang.String accntlvl;
	/**科目余额方向==>db_column: ACCNTDRCT*/
	private java.lang.String accntdrct;
	/**科目类型==>db_column: ACCNTTYP*/
	private java.lang.String accnttyp;
	/**本币或外币使用==>db_column: FRGNFLG*/
	private java.lang.String frgnflg;
	/**是否检查平衡==>db_column: EQLFLG*/
	private java.lang.String eqlflg;
	/**发生额方向==>db_column: AMTDRCN*/
	private java.lang.String amtdrcn;
	/**科目余额借==>db_column: JAMNT*/
	private BigDecimal jamnt;
	/**科目余额贷==>db_column: DAMNT*/
	private BigDecimal damnt;
	//columns END
	private List<FnncAccntitem> list;
	//系统框架字段 start
	
	private java.lang.String sort;
	public List<FnncAccntitem> getList() {
		return list;
	}

	public void setList(List<FnncAccntitem> list) {
		this.list = list;
	}


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

	public void setAccntno(java.lang.String value) {
		this.accntno = value;
	}
	
	public java.lang.String getAccntno() {
		return this.accntno;
	}
	
	public void setAccntkndcode(java.lang.String value) {
		this.accntkndcode = value;
	}
	
	public java.lang.String getAccntkndcode() {
		return this.accntkndcode;
	}
	public void setUpaccntno(java.lang.String value) {
		this.upaccntno = value;
	}
	
	public java.lang.String getUpaccntno() {
		return this.upaccntno;
	}
	public void setAccntnm(java.lang.String value) {
		this.accntnm = value;
	}
	
	public java.lang.String getAccntnm() {
		return this.accntnm;
	}
	public void setHaschildaccnt(java.lang.String value) {
		this.haschildaccnt = value;
	}
	
	public java.lang.String getHaschildaccnt() {
		return this.haschildaccnt;
	}
	public void setAccntlvl(java.lang.String value) {
		this.accntlvl = value;
	}
	
	public java.lang.String getAccntlvl() {
		return this.accntlvl;
	}
	public void setAccntdrct(java.lang.String value) {
		this.accntdrct = value;
	}
	
	public java.lang.String getAccntdrct() {
		return this.accntdrct;
	}
	public void setAccnttyp(java.lang.String value) {
		this.accnttyp = value;
	}
	
	public java.lang.String getAccnttyp() {
		return this.accnttyp;
	}
	public void setFrgnflg(java.lang.String value) {
		this.frgnflg = value;
	}
	
	public java.lang.String getFrgnflg() {
		return this.frgnflg;
	}
	public void setEqlflg(java.lang.String value) {
		this.eqlflg = value;
	}
	
	public java.lang.String getEqlflg() {
		return this.eqlflg;
	}
	public void setAmtdrcn(java.lang.String value) {
		this.amtdrcn = value;
	}
	
	public java.lang.String getAmtdrcn() {
		return this.amtdrcn;
	}
	public void setJamnt(BigDecimal value) {
		this.jamnt = value;
	}
	
	public BigDecimal getJamnt() {
		return this.jamnt;
	}
	public void setDamnt(BigDecimal value) {
		this.damnt = value;
	}
	
	public BigDecimal getDamnt() {
		return this.damnt;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Accntno",getAccntno())
			.append("Accntkndcode",getAccntkndcode())
			.append("Upaccntno",getUpaccntno())
			.append("Accntnm",getAccntnm())
			.append("Haschildaccnt",getHaschildaccnt())
			.append("Accntlvl",getAccntlvl())
			.append("Accntdrct",getAccntdrct())
			.append("Accnttyp",getAccnttyp())
			.append("Frgnflg",getFrgnflg())
			.append("Eqlflg",getEqlflg())
			.append("Amtdrcn",getAmtdrcn())
			.append("Jamnt",getJamnt())
			.append("Damnt",getDamnt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getAccntno())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof FnncAccntitem == false) return false;
		if(this == obj) return true;
		FnncAccntitem other = (FnncAccntitem)obj;
		return new EqualsBuilder()
			.append(getAccntno(),other.getAccntno())
			.isEquals();
	}
}

