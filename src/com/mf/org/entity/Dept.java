package com.mf.org.entity;

import java.math.BigDecimal;

public class Dept {

	private String dptno, dptname,  addr, postcd, tel, fax, updptno,
			headerno, crtdate, updtdate, isnormal, reserved;
	private BigDecimal dptmax;
	
	private String headernoName;
	
	public String getHeadernoName() {
		return headernoName;
	}

	public void setHeadernoName(String headernoName) {
		this.headernoName = headernoName;
	}

	public String getDptno() {
		return dptno;
	}

	public void setDptno(String dptno) {
		this.dptno = dptno;
	}

	public String getDptname() {
		return dptname;
	}

	public void setDptname(String dptname) {
		this.dptname = dptname;
	}

	public BigDecimal getDptmax() {
		return dptmax;
	}

	public void setDptmax(BigDecimal dptmax) {
		this.dptmax = dptmax;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPostcd() {
		return postcd;
	}

	public void setPostcd(String postcd) {
		this.postcd = postcd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUpdptno() {
		return updptno;
	}

	public void setUpdptno(String updptno) {
		this.updptno = updptno;
	}

	public String getHeaderno() {
		return headerno;
	}

	public void setHeaderno(String headerno) {
		this.headerno = headerno;
	}

	public String getCrtdate() {
		return crtdate;
	}

	public void setCrtdate(String crtdate) {
		this.crtdate = crtdate;
	}

	public String getUpdtdate() {
		return updtdate;
	}

	public void setUpdtdate(String updtdate) {
		this.updtdate = updtdate;
	}

	public String getIsnormal() {
		return isnormal;
	}

	public void setIsnormal(String isnormal) {
		this.isnormal = isnormal;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}
