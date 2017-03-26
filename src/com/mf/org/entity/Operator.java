package com.mf.org.entity;

/**
 * 操作员
 * @author Administrator
 */
public class Operator {
	String dptno, idnum, emplyno, pwd, opnm, rlid, rlnm, optype, isused,
			opright, uptdate, bsbsknd, inpostn, cstmrtype, vpnacct, reserved;

	//非数据库字段
	private String dptName;
	
	public String getDptName() {
		return dptName;
	}
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}
		
	public String getDptno() {
		return dptno;
	}

	public void setDptno(String dptno) {
		this.dptno = dptno;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getEmplyno() {
		return emplyno;
	}

	public void setEmplyno(String emplyno) {
		this.emplyno = emplyno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getOpnm() {
		return opnm;
	}

	public void setOpnm(String opnm) {
		this.opnm = opnm;
	}

	public String getRlid() {
		return rlid;
	}

	public void setRlid(String rlid) {
		this.rlid = rlid;
	}

	public String getRlnm() {
		return rlnm;
	}

	public void setRlnm(String rlnm) {
		this.rlnm = rlnm;
	}

	public String getOptype() {
		return optype;
	}

	public void setOptype(String optype) {
		this.optype = optype;
	}

	public String getIsused() {
		return isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
	}

	public String getOpright() {
		return opright;
	}

	public void setOpright(String opright) {
		this.opright = opright;
	}

	public String getUptdate() {
		return uptdate;
	}

	public void setUptdate(String uptdate) {
		this.uptdate = uptdate;
	}

	public String getBsbsknd() {
		return bsbsknd;
	}

	public void setBsbsknd(String bsbsknd) {
		this.bsbsknd = bsbsknd;
	}

	public String getInpostn() {
		return inpostn;
	}

	public void setInpostn(String inpostn) {
		this.inpostn = inpostn;
	}

	public String getCstmrtype() {
		return cstmrtype;
	}

	public void setCstmrtype(String cstmrtype) {
		this.cstmrtype = cstmrtype;
	}

	public String getVpnacct() {
		return vpnacct;
	}

	public void setVpnacct(String vpnacct) {
		this.vpnacct = vpnacct;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

}
