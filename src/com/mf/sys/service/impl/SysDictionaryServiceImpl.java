package com.mf.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.sys.dao.SysDictionaryDao;
import com.mf.sys.entity.SysDictionary;
import com.mf.sys.service.SysDictionaryService;
import com.mf.util.PageView;

@Service("sysDictionaryService")
public class SysDictionaryServiceImpl implements SysDictionaryService{
	
	@Autowired
	private SysDictionaryDao sysDictionaryDao;

	@Override
	public PageView query(PageView pageView, SysDictionary sysDictionary) {
		List<SysDictionary> list = sysDictionaryDao.query(pageView, sysDictionary);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public void add(SysDictionary sysDictionary) {
		sysDictionaryDao.add(sysDictionary);
	}

	@Override
	public List<SysDictionary> findSdBySdtCode(String code) {
		List<SysDictionary> list = sysDictionaryDao.findSdBySdtCode(code);
		return list;
	}

	@Override
	public List<SysDictionary> findSdBySdtCode2(SysDictionary newDic) {
		List<SysDictionary> list = sysDictionaryDao.findSdBySdtCode2(newDic);
		return list;
	}
	
	@Override
	public List<SysDictionary> findKeyByCodeAndValue(SysDictionary sysDictionary) {
		List<SysDictionary> list = sysDictionaryDao.findKeyByCodeAndValue(sysDictionary);
		return list;
	}
	//chenze--start
		@Override
		public SysDictionary findByCode(String code) {
			SysDictionary sysDictionary = sysDictionaryDao.findByCode(code);
			return sysDictionary;
		}
	
		@Override
		public void modify(SysDictionary sysDictionary) {
			sysDictionaryDao.modify(sysDictionary);
		}

		@Override
		public SysDictionary findByCodeAndValue(SysDictionary sysDictionary) {
			//访问数据库查询code和value
			return sysDictionaryDao.findByCodeAndValue(sysDictionary);
		}
		public SysDictionary findSysDictionary(SysDictionary sysDictionary){
			return sysDictionaryDao.findSysDictionary(sysDictionary);
		}
	//chenze--end
		
		@Override
		public List<SysDictionary> findByCodeAndRemark(String code) {
			//访问数据库查询code和value
			return sysDictionaryDao.findByCodeAndRemark(code);
		}
}
