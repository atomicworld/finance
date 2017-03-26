package com.mf.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.client.entity.ClntClient;
import com.mf.util.PageView;

public interface ClntClientDao extends BaseDao<ClntClient>{

	ClntClient findByCertno(String certno);
	
	ClntClient FindById(String clntid);

	Integer findMaxId(String clnttype);

	List<ClntClient> findByClntType(String clnttype);
	
	List<ClntClient> queryType(ClntClient clntclient);
	
	public ClntClient queryClntno(int clntid);
	
	public List<ClntClient> queryCust(@Param("pageView")PageView pageView, @Param("t")ClntClient t) throws DataAccessException;

	/**********************addByGuo start**********************/
	public ClntClient getCustById(String id) throws DataAccessException;
	
	public void update(ClntClient clntClient) throws DataAccessException;
	//wyy
	public void updateAll(ClntClient clntClient);
	
	/********************addByGuo end************************/
	
}
