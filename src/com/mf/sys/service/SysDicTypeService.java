package com.mf.sys.service;


import java.util.List;
import com.mf.sys.entity.SysDicType;
import com.mf.util.PageView;


public interface SysDicTypeService {

	public PageView query(PageView pageView, SysDicType sysDicType);
	public void add(SysDicType sysDicType);
	public SysDicType findByCode(String code);
	public void modify(SysDicType sysDicType);
	//chenze--start
	public List<SysDicType> findAll();
	//chenze--end
}
