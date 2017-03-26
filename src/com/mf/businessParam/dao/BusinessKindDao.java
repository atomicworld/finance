package com.mf.businessParam.dao;

import java.util.List;

import com.mf.base.BaseDao;
import com.mf.businessParam.entity.BusinessKind;


public interface BusinessKindDao extends BaseDao<BusinessKind> {
	
	
	public void changeStatus(BusinessKind t);
	public  List<BusinessKind>  getType(String cstmrtyp);
	public  List<BusinessKind>  getTypeAll(String cstmrtyp);
	public  List<BusinessKind>  queryAll();
	
	//add by hw
	public  List<BusinessKind>  getAbleType(String cstmrtyp);
	
}
