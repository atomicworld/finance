package com.mf.businessData.entity;
/**
 * 利率历史
 * @author Administrator
 *
 */
public class RateHistory {
	
	
	private String srlno, rtno, adjdate, rate, type, lowerlmt, upperlmt;

	public String getSrlno() {
		return srlno;
	}

	public void setSrlno(String srlno) {
		this.srlno = srlno;
	}

	public String getRtno() {
		return rtno;
	}

	public void setRtno(String rtno) {
		this.rtno = rtno;
	}

	public String getAdjdate() {
		return adjdate;
	}

	public void setAdjdate(String adjdate) {
		this.adjdate = adjdate;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLowerlmt() {
		return lowerlmt;
	}

	public void setLowerlmt(String lowerlmt) {
		this.lowerlmt = lowerlmt;
	}

	public String getUpperlmt() {
		return upperlmt;
	}

	public void setUpperlmt(String upperlmt) {
		this.upperlmt = upperlmt;
	}

}
