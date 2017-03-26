package com.mf.bsnsmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.bsnsmng.dao.LoanuseDao;
import com.mf.bsnsmng.entity.Loanuse;
import com.mf.bsnsmng.service.LoanuseService;

@Service("loanuseService")
public class LoanuseServiceImpl  implements LoanuseService{
   @Autowired
   private LoanuseDao  loanuseDao;
   public List<Loanuse> findAll(){
	   return loanuseDao.findAll();
   }
   
   public Loanuse getById(String id ){
	   return loanuseDao.getById(id);
   }

@Override
public Loanuse getByUsenm(String usenm) {
	// TODO Auto-generated method stub
	return loanuseDao.getByUsenm(usenm);
}
}
