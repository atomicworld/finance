package com.mf.bsnsmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.bsnsmng.dao.BsnsZyDao;
import com.mf.bsnsmng.entity.BsnsZhiya;
import com.mf.bsnsmng.service.BsnsZyService;
@Service("bsnsZyService")
public class BsnsZyServiceImpl implements BsnsZyService{
     @Autowired
     private BsnsZyDao bsnsZyDao;
 
    public void add(BsnsZhiya bsnsZhiya){
	  bsnsZyDao.add(bsnsZhiya);
   }
    
    
    public BsnsZhiya getById(String applyNo){
       return 	bsnsZyDao.getById(applyNo);
    }
    public BsnsZhiya getByCntrctno(String cntrctno){
        return 	bsnsZyDao.getByCntrctno(cntrctno);
     }
    
    
    public void modify(BsnsZhiya bsnsZhiya){
    	bsnsZyDao.modify(bsnsZhiya);
    }
    public void modifyCntrct(BsnsZhiya bsnsZhiya){
    	bsnsZyDao.modifyCntrct(bsnsZhiya);
    }
    
    public void delete(String applyNo){
    	bsnsZyDao.delete(applyNo);
    }
    public void deleteCntrctno(String cntrctno){
    	bsnsZyDao.deleteCntrctno(cntrctno);
    }
    
}
