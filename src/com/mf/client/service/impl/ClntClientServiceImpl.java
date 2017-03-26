package com.mf.client.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.base.AutoCompleteEntity;
import com.mf.client.dao.ClntClientDao;
import com.mf.client.dao.ClntPersonDao;
import com.mf.client.entity.ClntClient;
import com.mf.client.entity.ClntPerson;
import com.mf.client.service.ClntClientService;
import com.mf.common.util.StringUtil;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.util.PageView;

@Transactional
@Service("clntService")
public class ClntClientServiceImpl implements ClntClientService{
	
	@Autowired
	private ClntClientDao clntClientDao;
	
	@Autowired
	private ClntPersonDao clntPersonDao;

	@Override
	public PageView query(PageView pageView, ClntClient clntClient) {
		List<ClntClient> list = clntClientDao.query(pageView, clntClient);
		pageView.setRecords(list);
		return pageView;
	}

	@Override
	public ClntClient findByCertno(String certno) {
		return clntClientDao.findByCertno(certno);
	}

	@Override
	public void add(ClntClient clntClient, ClntPerson clntPerson) {
		// 保存客户基本信息
		clntClientDao.add(clntClient);
		if(null != clntPerson){
			clntPersonDao.add(clntPerson);
		}
	}

	@Override
	public ClntClient getById(String id) {
		return clntClientDao.getById(id);
	}
	
	@Override
	public ClntClient FindById(String id) {
		return clntClientDao.FindById(id);
	}
	
	@Override
	public Integer  findMaxIdByClntType(String clntType) {
		return clntClientDao.findMaxId(clntType);
	}

	@Override
	public List<ClntClient> findByClntType(String clnttype) {
		return clntClientDao.findByClntType(clnttype);
	}
	
	@Override
	public List<ClntClient> queryType(ClntClient clntclient) {
		return clntClientDao.queryType(clntclient);
	}
	
	
	@Override
	public ClntClient queryClntno(Integer clntid) {
		return clntClientDao.queryClntno(clntid);
	}
	
	@Override
	public PageView queryCust(PageView pageView, ClntClient clntClient) {
		List<ClntClient> list = clntClientDao.queryCust(pageView, clntClient);
		pageView.setRecords(list);
		return pageView;
	}
	
	
	/***************addByGuo  start*****************/
	public ClntClient getCustById(String id) throws DataAccessException{
		
		return clntClientDao.getCustById(id);
		
	}
	
	
	public void update(ClntClient clntClient) throws DataAccessException{
		clntClientDao.update(clntClient);
	}
	
	
	public void delete(String id) throws DataAccessException{
		
		clntClientDao.delete(id);
	}
	/***************addByGuo  end*****************/
	
	
	/* wangyaowei */
	@Transactional(readOnly=true)
	public Map<String,List<AutoCompleteEntity>> getAllItemForAutoCmp(ClntClient clnttype){
		Map<String,List<AutoCompleteEntity>> map = new HashMap<String, List<AutoCompleteEntity>>();
		List<ClntClient> list = clntClientDao.queryAll(clnttype);
		List<AutoCompleteEntity> autoCmpList = new ArrayList<AutoCompleteEntity>();
		
		for(int i=0; i<list.size(); i++){
			AutoCompleteEntity autoCmpEntity = new AutoCompleteEntity();
			ClntClient clntclient = list.get(i);
			String accntNo = clntclient.getCertno();
			String accntNm = clntclient.getClntname();
			String pinyinHead = StringUtil.getFirstPinYin(accntNm);
			autoCmpEntity.setValue(accntNo);
			autoCmpEntity.setKey(accntNm);
			autoCmpEntity.setSuggest(accntNo + "|" + accntNm + "|" + pinyinHead);
			autoCmpList.add(autoCmpEntity);
		}
		map.put("list", autoCmpList);
		return map;
	}
	/* wangyaowei */
	@Transactional(readOnly=true)
	public Map<String,List<AutoCompleteEntity>> getClientItemForAutoCmp(ClntClient clnttype){
		Map<String,List<AutoCompleteEntity>> map = new HashMap<String, List<AutoCompleteEntity>>();
		List<ClntClient> list = clntClientDao.queryAll(clnttype);
		List<AutoCompleteEntity> autoCmpList = new ArrayList<AutoCompleteEntity>();
		
		for(int i=0; i<list.size(); i++){
			AutoCompleteEntity autoCmpEntity = new AutoCompleteEntity();
			ClntClient clntclient = list.get(i);
			String accntNo = clntclient.getClntid().toString();
			String accntNm = clntclient.getClntname();
			String pinyinHead = StringUtil.getFirstPinYin(accntNm);
			autoCmpEntity.setValue(accntNo);
			autoCmpEntity.setKey(accntNm);
			autoCmpEntity.setSuggest(accntNo + "|" + accntNm + "|" + pinyinHead);
			autoCmpList.add(autoCmpEntity);
		}
		map.put("list", autoCmpList);
		return map;
	}
}
