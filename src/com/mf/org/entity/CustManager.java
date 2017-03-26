package com.mf.org.entity;

/**
 * 客户经理信息
 * 
 * @author Administrator
 * 
 */
public class CustManager {

	private String emplyno, emplynm, dptno, rcrdid, mngrlvl, sngltop, tel,
			sdate, edate, remark, isused, ttltop, crtno, crtdptno, crtdate,
			updtdate, bsnsknd, reserved;
	
	//非数据库字段
	private String dptName;
	
	public String getDptName() {
		return dptName;
	}
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public String getEmplyno() {
		return emplyno;
	}

	public void setEmplyno(String emplyno) {
		this.emplyno = emplyno;
	}

	public String getEmplynm() {
		return emplynm;
	}

	public void setEmplynm(String emplynm) {
		this.emplynm = emplynm;
	}

	public String getDptno() {
		return dptno;
	}

	public void setDptno(String dptno) {
		this.dptno = dptno;
	}

	public String getRcrdid() {
		return rcrdid;
	}

	public void setRcrdid(String rcrdid) {
		this.rcrdid = rcrdid;
	}

	public String getMngrlvl() {
		return mngrlvl;
	}

	public void setMngrlvl(String mngrlvl) {
		this.mngrlvl = mngrlvl;
	}

	public String getSngltop() {
		return sngltop;
	}

	public void setSngltop(String sngltop) {
		this.sngltop = sngltop;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsused() {
		return isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
	}

	public String getTtltop() {
		return ttltop;
	}

	public void setTtltop(String ttltop) {
		this.ttltop = ttltop;
	}

	public String getCrtno() {
		return crtno;
	}

	public void setCrtno(String crtno) {
		this.crtno = crtno;
	}

	public String getCrtdptno() {
		return crtdptno;
	}

	public void setCrtdptno(String crtdptno) {
		this.crtdptno = crtdptno;
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

	public String getBsnsknd() {
		return bsnsknd;
	}

	public void setBsnsknd(String bsnsknd) {
		this.bsnsknd = bsnsknd;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
}
