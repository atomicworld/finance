package com.mf.client.dao;

import com.mf.base.BaseDao;
import com.mf.client.entity.ClntPerson;

public interface ClntPersonDao extends BaseDao<ClntPerson>{

	public ClntPerson findByCertno(String certno);

	public ClntPerson findByClntno(String clntno);
	
	public ClntPerson getByClntno(String clntno);

}
