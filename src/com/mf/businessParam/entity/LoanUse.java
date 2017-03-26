package com.mf.businessParam.entity;

import java.util.List;

public class LoanUse {

	private String useno, usenm, usedes, isused, frstfthr, scndfthr, thrdfthr,
			lvl, isbttm, reserved;
	
	private List<LoanUse> sonLoanUseList;//用于储存当前用途下的子用途信息
	
	public List<LoanUse> getSonLoanUseList() {
		return sonLoanUseList;
	}

	public void setSonLoanUseList(List<LoanUse> sonLoanUseList) {
		this.sonLoanUseList = sonLoanUseList;
	}

	public String getUseno() {
		return useno;
	}

	public void setUseno(String useno) {
		this.useno = useno;
	}

	public String getUsenm() {
		return usenm;
	}

	public void setUsenm(String usenm) {
		this.usenm = usenm;
	}

	public String getUsedes() {
		return usedes;
	}

	public void setUsedes(String usedes) {
		this.usedes = usedes;
	}

	public String getIsused() {
		return isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
	}

	public String getFrstfthr() {
		return frstfthr;
	}

	public void setFrstfthr(String frstfthr) {
		this.frstfthr = frstfthr;
	}

	public String getScndfthr() {
		return scndfthr;
	}

	public void setScndfthr(String scndfthr) {
		this.scndfthr = scndfthr;
	}

	public String getThrdfthr() {
		return thrdfthr;
	}

	public void setThrdfthr(String thrdfthr) {
		this.thrdfthr = thrdfthr;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getIsbttm() {
		return isbttm;
	}

	public void setIsbttm(String isbttm) {
		this.isbttm = isbttm;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}
