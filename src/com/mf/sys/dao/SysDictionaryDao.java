package com.mf.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.sys.entity.SysDictionary;

public interface SysDictionaryDao extends BaseDao<SysDictionary>{


	List<SysDictionary> findSdBySdtCode(String code);
	List<SysDictionary> findSdBySdtCode2(SysDictionary newDic);
	List<SysDictionary> findKeyByCodeAndValue(SysDictionary sysDictionary);
	//chenze--start
	public SysDictionary findByCode(String code);
	public SysDictionary findByCodeAndValue(SysDictionary sysDictionary);
	//chenze--end
	public SysDictionary findSysDictionary(SysDictionary sysDictionary);
	public List<SysDictionary> findByCodeAndRemark(String code);
}
