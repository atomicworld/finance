package com.mf.login.service;

import javax.servlet.http.HttpServletRequest;

import com.mf.org.entity.Operator;

public interface LoginService {
	public int checkUser(Operator operator);
	public void setSeesionCntnt(HttpServletRequest request, Operator operator);
	public Operator findByEmpno(String emplyno);
}
