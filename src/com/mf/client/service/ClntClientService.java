package com.mf.client.service;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.mf.base.AutoCompleteEntity;
import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntPerson;
import com.mf.util.PageView;

public interface ClntClientService {
	public PageView query(PageView pageView, ClntClient clntClient);

	public ClntClient findByCertno(String certno);

//	public void add(ClntClient clntClient);

	public ClntClient getById(String id);
	
	public ClntClient FindById(String id);

	public Integer findMaxIdByClntType(String clntType);

	public List<ClntClient> findByClntType(String clnttype);
	
	public void add(ClntClient clntClient, ClntPerson clntPerson);

	public ClntClient queryClntno(Integer clntid);
	
	public PageView queryCust(PageView pageView, ClntClient clntClient);
	
	/***************addByGuo  start*****************/
	public ClntClient getCustById(String id) throws DataAccessException;
	
	public void update(ClntClient clntClient) throws DataAccessException;
	
	public void delete(String id) throws DataAccessException;
	
	public List<ClntClient> queryType(ClntClient clntClient);
	
	public Map<String,List<AutoCompleteEntity>> getAllItemForAutoCmp(ClntClient clntClient);
	public Map<String,List<AutoCompleteEntity>> getClientItemForAutoCmp(ClntClient clntClient);

	
	/***************addByGuo  end*****************/
	
}
