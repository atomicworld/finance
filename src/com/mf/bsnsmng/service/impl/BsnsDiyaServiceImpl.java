package com.mf.bsnsmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.bsnsmng.dao.BsnsDiyaDao;
import com.mf.bsnsmng.entity.BsnsDiya;
import com.mf.bsnsmng.service.BsnsDiyaService;

@Service("bsnsDiyaService")
public class BsnsDiyaServiceImpl implements BsnsDiyaService {
	@Autowired
	private BsnsDiyaDao bsnsDiyaDao;
	public void add(BsnsDiya bsnsDiya){
    	 bsnsDiyaDao.add(bsnsDiya);
    	 
     }
     
    
     public BsnsDiya getById(String applyNo){
    	 return bsnsDiyaDao.getById(applyNo);
     }
     public BsnsDiya getByCntrctno(String cntrctno){
    	 return bsnsDiyaDao.getByCntrctno(cntrctno);
     }
     
     public void delete(String applyNo){
    	 bsnsDiyaDao.delete(applyNo);
     }
     public void deleteCntrctno(String cntrctno){
    	 bsnsDiyaDao.deleteCntrctno(cntrctno);
     }
     
     public void modify(BsnsDiya bsnsDiya){
    	 bsnsDiyaDao.modify(bsnsDiya);
    	 
     }
     public void modifyCntrct(BsnsDiya bsnsDiya){
    	 bsnsDiyaDao.modifyCntrct(bsnsDiya);
    	 
     }
     
}
