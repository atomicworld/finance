package com.mf.login.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.higinet.es.trans.TokenService;

import com.mf.common.util.StringUtil;
import com.mf.org.entity.Operator;
import com.mf.login.service.LoginService;
import com.mf.org.dao.OperatorDao;
import com.mf.sys.dao.SysRightDao;
import com.mf.sys.dao.SysMenuDao;
import com.mf.sys.dao.SysRoleDao;
import com.mf.sys.entity.SysRight;
import com.mf.sys.entity.SysMenu;
import com.mf.sys.entity.SysRole;
import com.mf.util.Common;
import com.mf.util.ConvertUtil;
import com.mf.org.dao.DeptDao;
import com.mf.org.entity.Dept;
import com.mf.common.pub.PubConstants;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private OperatorDao loginDao;
	
	@Autowired
	private SysRightDao sysRightDao;
	
	@Autowired
	private SysMenuDao sysMenuDao;
	
	@Autowired
	private SysRoleDao sysRoleDao;
	
	@Autowired
	private DeptDao DeptDao;
	
	@Override
	public int checkUser(Operator operator) {
		// 首先判断用户名是否存在
		int checkRslt = PubConstants.LOGIN_UNKNOWN;
		Operator op = loginDao.findOneUser(operator);
		
		if(op == null){
			checkRslt = PubConstants.LOGIN_NOTEXIST;
		}else{
			if(op.getIsused().equals("2")){//2-停用
				checkRslt = PubConstants.LOGIN_NOTINUSE;
			}else if(op.getInpostn().equals("2")){//2-离职
				checkRslt = PubConstants.LOGIN_NOTINPOS;
			}else{
				//用户存在且在职且启用, 再判断动态口令是否正确 - 当前版本暂不使用动态口令牌
				//checkRslt = this.checkDymPWD(operator.getVpnacct(), operator.getPwd());
				//验证静态密码
				checkRslt = this.checkStaticPWD(operator);
			}
		}
		
		return checkRslt;
	}
	
	//验证静态密码
	public int checkStaticPWD(Operator operator){
		int checkRslt = PubConstants.LOGIN_UNKNOWN;
		operator.setPwd(ConvertUtil.getMd5(operator.getPwd()));
		int count = loginDao.checkpwd(operator);
		if(count == 0){
			//pwd not right
			checkRslt = PubConstants.LOGIN_STTCPWDERR;
		}else if(count == 1){
			//pwd right
			checkRslt = PubConstants.LOGIN_SUCCESS;
		}else{
			//exception
			checkRslt = PubConstants.LOGIN_MULTIUSER;
		}
		return checkRslt;
	}
	
	/**
	 * 验证动态口令是否正确
	 * @param userName
	 * @param pwd
	 * @return int
	 */
	public int checkDymPWD(String userName,String pwd){
		if(StringUtil.isEmpty(userName) || StringUtil.isEmpty(pwd))return 3001502;
			//if(pwd.equals( getPassword())) //定制万能密码
		if(pwd.equals("333666"))
			return PubConstants.LOGIN_SUCCESS;
		//TokenService ts = new TokenService("192.168.1.23",8010);
		TokenService ts = new TokenService("192.168.88.36",8010);
		try {
			return ts.verify(userName, "1002", "", pwd, "", "").getRetCode();				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PubConstants.LOGIN_DYNMPWDERR;
	}
	
	/**
	 * 登录验证成功后向session中写入内容
	 * @param request
	 * @param operator
	 * @return void
	 */
	public void setSeesionCntnt(HttpServletRequest request, Operator operator){
		//find user info by vpnacct
		Operator user = loginDao.findOneUser(operator);
		//then set session content
		Map<String, List<SysMenu>> menuMap = null;
		
		if(user.getOptype().equals(PubConstants.OPTYPE_SUPERADMIN)){
			//super admin
			menuMap = this.getSpecialMenuMap(PubConstants.OPTYPE_SUPERADMIN);
		}else if(user.getOptype().equals(PubConstants.OPTYPE_DEVELOPER)){
			//developer
			menuMap = this.getSpecialMenuMap(PubConstants.OPTYPE_DEVELOPER);
		}else{
			//business operator
			//由roleid查询对应角色的权限字符组
			SysRole sysRole = sysRoleDao.getById(user.getRlid());
			String rightStr = sysRole.getRlright();
			//由权限标识获取的菜单显示图
			menuMap = this.getMenuMap(rightStr);
		}
		
		//查询操作员所属机构名称-start
		Dept dept = DeptDao.getById(user.getDptno());
		if(dept != null){
			request.getSession().setAttribute("dptname",dept.getDptname());
		}
		//查询操作员所属机构名称-end
		
		//设置所属省的地区代码-start
		Common comUtil = new Common();		
		request.getSession().setAttribute("areaCode", comUtil.getPropField("areaCode"));
		//设置所属省的地区代码-end
		
		request.getSession().setAttribute("menuMap", menuMap);
		request.getSession().setAttribute("opname", user.getOpnm());
		request.getSession().setAttribute("operator", user);
	}
	
	/**
	 * get super admin's menuMap
	 * @return Map<String, List<SysMenu>>
	 */
	public Map<String, List<SysMenu>> getSpecialMenuMap(String opTyp){
		Map menuMap = new HashMap<String, List<SysMenu>>();
		
		List<SysMenu> matchMenuOne = null;
		List<SysMenu> matchMenuTwo = null;
		List<SysMenu> matchMenuThree = null;
		
		if(opTyp.equals(PubConstants.OPTYPE_SUPERADMIN)){
			matchMenuOne = this.sysMenuDao.findSuperByMnLen(1);
			matchMenuTwo = this.sysMenuDao.findSuperByMnLen(2);
			matchMenuThree = this.sysMenuDao.findSuperByMnLen(3);
		}else if(opTyp.equals(PubConstants.OPTYPE_DEVELOPER)){
			matchMenuOne = this.sysMenuDao.findDevByMnLen(1);
			matchMenuTwo = this.sysMenuDao.findDevByMnLen(2);
			matchMenuThree = this.sysMenuDao.findDevByMnLen(3);
		}
		menuMap.put("A", matchMenuOne);
		menuMap.put("B", matchMenuTwo);
		menuMap.put("C", matchMenuThree);
		
		return menuMap;
	}
	
	/**
	 * 由权限标识获取的菜单显示图
	 * @param opright
	 * @return Map<String, List<SysMenu>>
	 */
	public Map<String, List<SysMenu>> getMenuMap(String opright){
		Map menuMap = new HashMap<String, List<SysMenu>>();
		
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<opright.length(); i++){
			if(opright.charAt(i) == '1'){
				//listright.add(String.valueOf(i + 1));
				sb.append(String.valueOf(i + 1)  + ",");
			}
		}
		String listright = sb.toString();
		if(listright.length() > 0){
			listright = listright.substring(0, listright.length() - 1);
		}
        //以上获得形如(110,112,113,115)之类的字符串
		List<SysRight> rightList = sysRightDao.getMnnoByRght(listright);
		System.out.println("rightMenulist size = " + rightList.size());
		
		List<String> rightMenuNoOne = getRightMenu(rightList, 1);   //拥有权限的一级菜单
		List<String> rightMenuNoTwo = getRightMenu(rightList, 2);   //拥有权限的二级菜单
		List<String> rightMenuNoThree = getRightMenu(rightList, 3); //拥有权限的三级菜单
		
		List<SysMenu> matchMenuOne = getMatchMenu(rightMenuNoOne, 1);
		List<SysMenu> matchMenuTwo = getMatchMenu(rightMenuNoTwo, 2);
		List<SysMenu> matchMenuThree = getMatchMenu(rightMenuNoThree, 3);
		
		menuMap.put("A", matchMenuOne);
		menuMap.put("B", matchMenuTwo);
		menuMap.put("C", matchMenuThree);
		
		return menuMap;
	}
	
	/**
	 * 匹配每个级别的具有权限的菜单项目
	 * @param rightMenuNo
	 * @param len
	 * @return List<SysMenu>
	 */
	public List<SysMenu> getMatchMenu(List<String> rightMenuNo, int len){
		List<SysMenu> rightMenuList = new ArrayList<SysMenu>();
		//查询现有系统中所有菜单编号为相应长度的菜单信息
		List<SysMenu> sysMenuList = sysMenuDao.findByMnLen(len);
		
		Iterator<String> it = rightMenuNo.iterator();
		while (it.hasNext()){
			String menuNo = (String)it.next();
			for (int i = 0; i < sysMenuList.size(); i++) {
				SysMenu menu = sysMenuList.get(i);
				if(menu.getMnno().equals(menuNo)){
					rightMenuList.add(menu);
					break;
				}
			}
		}
		return rightMenuList;
	}
	
	/**
	 * 由rightno的列表得出对应级别权限菜单列表
	 * @param rightList
	 * @param lvl
	 * @return List<String>
	 */
	public List<String> getRightMenu(List<SysRight> rightList, int lvl){
		List<String> rightMenu = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < rightList.size(); i++){
			set.add(rightList.get(i).getMnno().substring(0, lvl));
		}
		
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			rightMenu.add(it.next());
		}
		Collections.sort(rightMenu);
		return rightMenu;
	}
	public Operator findByEmpno(String emplyno){
		return loginDao.findByEmpno(emplyno);
	}
}
