package com.mf.bsnsmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.bsnsmng.dao.BsnsApplyDtlDao;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.bsnsmng.service.BsnsApplydtlService;
import com.mf.util.PageView;

@Service("bsnsApplydtlService")
public class BsnsApplydtlServiceImpl implements BsnsApplydtlService{
	  @Autowired
	  private BsnsApplyDtlDao bsnsApplyDtlDao;
       public void add(BsnsApplydtl bsnsApplydtl){
    	   bsnsApplyDtlDao.add(bsnsApplydtl);
       }
       
       public PageView query(PageView pageView, BsnsApplydtl bsnsApplydtl){
    	     List<BsnsApplydtl> list = bsnsApplyDtlDao.query(pageView, bsnsApplydtl);
     		 pageView.setRecords(list);
     		 return pageView;
       }
       
       public PageView query1(PageView pageView,BsnsApplydtl bsnsApplydtl){
  	     List<BsnsApplydtl> list = bsnsApplyDtlDao.query1(pageView, bsnsApplydtl);
   		 pageView.setRecords(list);
   		 return pageView;
     }
     
       public BsnsApplydtl getById(String rcrdid){
    	   
    	   return bsnsApplyDtlDao.getById(rcrdid);
    			   
       }
       
       public void modify(BsnsApplydtl bsnsApplydtl){
    	   bsnsApplyDtlDao.modify(bsnsApplydtl);
    	   
       }
      
       /**
	    * @param pageView
	    * @param bsnsApplydtl
        * @return
        */
       public PageView queryCancel(PageView pageView, BsnsApplydtl bsnsApplydtl){
  	     List<BsnsApplydtl> list = bsnsApplyDtlDao.queryCancel(pageView, bsnsApplydtl);
   		 pageView.setRecords(list);
   		 return pageView;
       }
       
      public BsnsApplydtl getByApplyno(String applyno){
    	   return bsnsApplyDtlDao.getByApplyno(applyno);
       }
      //wyy
      public void delApply(String rcrdid){
    	  bsnsApplyDtlDao.copyLog(rcrdid);
    	  bsnsApplyDtlDao.delApplyNo(rcrdid);
      }

	@Override
	public void modifyByRcrdid(BsnsApplydtl bsnsApplydtl) {
		bsnsApplyDtlDao.modifyByRcrdid(bsnsApplydtl);
		
	}
	
	@Override
	public PageView queryUndone(PageView pageView, BsnsApplydtl bsnsApplydtl){
		List<BsnsApplydtl> list = bsnsApplyDtlDao.queryUndone(pageView, bsnsApplydtl);
		pageView.setRecords(list);
		return pageView;
	}
	
}
