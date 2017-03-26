package com.mf.sys.service;

import java.util.List;

import com.mf.sys.entity.*;
import com.mf.util.*;

public interface SysMappingtoolService{

	public PageView query(PageView pageView,SysMappingtool sysMappingtool);
	
	public List<SysMappingtool> queryAll(SysMappingtool sysMappingtool);
	
	public void add(SysMappingtool sysMappingtool);
	
	public void addAll(SysMappingtool sysMappingtool);
	
	public void delete(String id);
	
	public void modify(SysMappingtool sysMappingtool);
	
	public SysMappingtool getByPreKey(String prekey);
	
	//add by hw
	public String getSerialnumber(SysMappingtool sysMappingtool);
	public void modifySerialnumber(SysMappingtool sysMappingtool);
	public void initSerialnumber(SysMappingtool sysMappingtool);
	
}
