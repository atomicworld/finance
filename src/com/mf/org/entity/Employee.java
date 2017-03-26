package com.mf.org.entity;

public class Employee {
	private String emplyno;//员工编号
	private String emplynm, dptno, lvl, indate, state;//员工姓名；归属部门编号；职务级别编号；入职时间；员工状态
	private String pos;//职务编号
	private String degree;//学历编号
	private String cllg;//毕业院校名称
	private String majors;//专业
	private String ttl;//职称编号
	private String probation;//试用期（月）
	private String outdate;//离职日期
	private String remark;//备注
	private String idnum;//身份证号
	private String sex;//性别
	private String birthday;//生日日期
	private String reserved;//保留字段
	//一下是自行添加属性
	private String marstate;//婚姻状态
	private String birthplace;//户籍
	private String polstate;//政治面貌
	private String postype;//职位类别
	private String reqfile;//任职资格核准编号
	private String workyear;//从业年限
	private String reward;//奖励
	private String punish;//惩罚
	private int finexperienceflg     ;//是否有银行从业经验
	private String resume;//简历
	//
	private String tel;//办公电话
	private String mobile;//移动电话
	private String hometel;//家庭电话
	private String  fax;//传真
	private String zip_code;//邮编
	private String email;
	private String address;//联系地址
	private String subposist;//职务
	
	//非数据库字段
	private String dptName;
	
	public String getSubposist() {
		return subposist;
	}
	public void setSubposist(String subposist) {
		this.subposist = subposist;
	}
	public String getDptName() {
		return dptName;
	}
	public void setDptName(String dptName) {
		this.dptName = dptName;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getCllg() {
		return cllg;
	}
	public void setCllg(String cllg) {
		this.cllg = cllg;
	}
	public String getMajors() {
		return majors;
	}
	public void setMajors(String majors) {
		this.majors = majors;
	}
	public String getTtl() {
		return ttl;
	}
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	public String getProbation() {
		return probation;
	}
	public void setProbation(String probation) {
		this.probation = probation;
	}
	public String getOutdate() {
		return outdate;
	}
	public void setOutdate(String outdate) {
		this.outdate = outdate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
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
	public String getLvl() {
		return lvl;
	}
	public void setLvl(String lvl) {
		this.lvl = lvl;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getMarstate() {
		return marstate;
	}
	public void setMarstate(String marstate) {
		this.marstate = marstate;
	}
	public String getBirthplace() {
		return birthplace;
	}
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	public String getPolstate() {
		return polstate;
	}
	public void setPolstate(String polstate) {
		this.polstate = polstate;
	}
	
	public String getPostype() {
		return postype;
	}
	public void setPostype(String postype) {
		this.postype = postype;
	}
	public String getReqfile() {
		return reqfile;
	}
	public void setReqfile(String reqfile) {
		this.reqfile = reqfile;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public String getPunish() {
		return punish;
	}
	public void setPunish(String punish) {
		this.punish = punish;
	}
	public int getFinexperienceflg() {
		return finexperienceflg;
	}
	public void setFinexperienceflg(int finexperienceflg) {
		this.finexperienceflg = finexperienceflg;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getHometel() {
		return hometel;
	}
	public void setHometel(String hometel) {
		this.hometel = hometel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWorkyear() {
		return workyear;
	}
	public void setWorkyear(String workyear) {
		this.workyear = workyear;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	
	

	
	
	
}
