package com.mf.bsnsmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.bsnsmng.dao.BsnsApplyDao;
import com.mf.bsnsmng.entity.BsnsApply;
import com.mf.bsnsmng.service.BsnsApplyService;
@Service("bsnsApplyService")
public class BsnsApplyServiceImpl implements BsnsApplyService {
       @Autowired
       private BsnsApplyDao bsnsApplyDao;
       public void add(BsnsApply bsnsApply){
    	   bsnsApplyDao.add(bsnsApply); 
       }
       
       public BsnsApply getById(String applyNo){
    	    return  bsnsApplyDao.getById(applyNo);
       }
       
       public String getByClntNo(String clntNo){
    	     return bsnsApplyDao.getByClntNo(clntNo);
       }
       
       public int isHave(String clntno){
    	   return bsnsApplyDao.isHave(clntno);
       }
       
       public List<BsnsApply> queryAll(String clntNo){
    	    return bsnsApplyDao.queryAll(clntNo);
       }
       
       public void modify(BsnsApply bsnsApply){
    	      bsnsApplyDao.modify(bsnsApply);
       }
       
       public void delete(String applyNo){
    	      bsnsApplyDao.delete(applyNo);
       }
}
