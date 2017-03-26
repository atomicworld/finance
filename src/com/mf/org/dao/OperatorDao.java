package com.mf.org.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.org.entity.Operator;

public interface OperatorDao extends BaseDao<Operator> {
	//used for login - start
	public int checkUser(Operator operator);
	public Operator findOneUser(Operator operator);
	public Operator findByEmpno(String emplyno);
	public int checkpwd(Operator operator);
	//used for login - end
	
     public Operator getOpnm(String id);
     public List<Operator> getByCzy(String id);
     
     //判断该操作员是否有配置为客户经理
     public int countMngr(String id);

	 //判断该操作员是否配置有审批岗位
     public int countAppr(String id);
     
	 //判断该操作员名下是否有管理的客户
     public int countClnt(String id);
     
     //更新操作员启用停用状态
     public void changeUsed(Operator t);
     
     //查询登录名是否已经存在
     public int countByAcct(String vpnacct);
     
     //更新密码
     public void changePwd(Operator t);
     
     public List<Operator> getOperators(Operator t) throws DataAccessException;
}
