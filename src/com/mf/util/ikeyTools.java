package com.mf.util;

import net.people2000.auth.UserAuthServiceStub;
import net.people2000.auth.UserAuthServiceStub.TtokenAuthReq;
import net.people2000.auth.UserAuthServiceStub.TtokenAuthRes;
import net.people2000.auth.UserAuthServiceStub.TtokenVerifyTimeReq;
import net.people2000.auth.UserAuthServiceStub.TtokenVerifyTimeRes;

public class ikeyTools {
	
	/**
	 * 令牌验证
	 * 根据令牌串号，动态密码返回一个状态值
	 * @param AuthName
	 * @param AuthPasswd
	 * @return int
	 */
	public int CheckIkey(String AuthName,String AuthPasswd){
		//默认返回失败
		int result = -650;
		try {
			//如果参数为空，直接返回结果
			if (Common.isEmpty(AuthName) || Common.isEmpty(AuthPasswd)) {
				return result;
			}
			UserAuthServiceStub ikey = new UserAuthServiceStub(SysParamUtil.getParam("Adress"));
			TtokenAuthReq req_auth = new TtokenAuthReq();
			req_auth.setMi32Reserve(0);
			req_auth.setMsAuthFromIP("");
			req_auth.setMui8AuthType((short)1);//认证类型1:令牌串号2:用户名 
			req_auth.setMsAuthName(AuthName);//认证名,对应认证类型 
			req_auth.setMsAuthPasswd(AuthPasswd);//动态口令 
			req_auth.setMsChanllengeCode("");//挑战码
			req_auth.setMsHashResult("");
			req_auth.setMsReserve1("");
			req_auth.setMsReserve2("");
			req_auth.setUi32LocalSid(0);
			req_auth.setUi32ResId(0);
			//获取返回结果信息
			TtokenAuthRes res_auth = ikey.tokenAuth(req_auth);
			//取得结果状态值
			result = res_auth.getI32Ret();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 *  令牌校时
	 * 传入令牌串号跟两个（第一分钟，第二分钟）动态密码，返回一个状态值 
	 * @param VerifyName
	 * @param pwd1
	 * @param pwd2
	 * @return int
	 */
	public int CheckTime(String VerifyName,String pwd1,String pwd2){
		//默认返回失败
		int result = -751;
		try {
			//如果参数为空，直接返回结果
			if (Common.isEmpty(VerifyName) || Common.isEmpty(pwd1) ||Common.isEmpty(pwd2)) {
				return result;
			}
			UserAuthServiceStub auth = new UserAuthServiceStub(SysParamUtil.getParam("Adress"));
			TtokenVerifyTimeReq req_vt = new TtokenVerifyTimeReq(); 
			req_vt.setMui8VerifyNameType((short)1);//校时类型1:串号2用户名
			req_vt.setMsVerifyName(VerifyName);//校时名,对应校时类型
			req_vt.setMui8VerifyType((short)3);
			req_vt.setMsPasswd1(pwd1);//密码1
			req_vt.setMsPasswd2(pwd2);//密码2
			req_vt.setMsChanllengeCode1("");//挑战码1
			req_vt.setMsChanllengeCode2("");//挑战码2
			req_vt.setMi32Reserve(0);
			req_vt.setMsoperator("");
			req_vt.setMsReserve1("");
			req_vt.setMsReserve2("");
			req_vt.setMsVerifyFromIP("");
			req_vt.setUi32LocalSid(0);
			req_vt.setUi32ResId(0);
			//接收返回结果信息
			TtokenVerifyTimeRes res_vt = auth.tokenVerifyTime(req_vt);
			//取出返回结果状态值
			result = res_vt.getI32Ret();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; 
		
		
	}
	
}
