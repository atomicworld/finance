package com.mf.sys.dao;

import java.util.List;
import com.mf.base.BaseDao;
import com.mf.sys.entity.SysDicType;

public interface SysDicTypeDao extends BaseDao<SysDicType>{
	public SysDicType findByCode(String code);
	//chenze--start
	public List findAll();
	//chenze--end
}
