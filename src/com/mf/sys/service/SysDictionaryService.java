package com.mf.sys.service;

import java.util.List;
import java.util.Map;

import com.mf.sys.entity.SysDictionary;
import com.mf.util.PageView;


public interface SysDictionaryService {

	public PageView query(PageView pageView, SysDictionary sysDictionary);
	public void add(SysDictionary sysDictionary);
	public List<SysDictionary> findSdBySdtCode(String code);
	public List<SysDictionary> findSdBySdtCode2(SysDictionary newDic);
	public List<SysDictionary> findKeyByCodeAndValue(SysDictionary sysDictionary);
	public SysDictionary findSysDictionary(SysDictionary sysDictionary);
	
	//chenze--start
		public SysDictionary findByCode(String code);
		public void modify(SysDictionary sysDictionary);
		public SysDictionary findByCodeAndValue(SysDictionary sysDictionary);
	//chenze--end
	public List<SysDictionary> findByCodeAndRemark(String code);
}
