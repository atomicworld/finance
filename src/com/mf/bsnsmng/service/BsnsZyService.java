package com.mf.bsnsmng.service;

import com.mf.bsnsmng.entity.BsnsZhiya;

public interface BsnsZyService {
     public void add(BsnsZhiya bsnsZhiya);    
     public BsnsZhiya getById(String applyNo);
     public BsnsZhiya getByCntrctno(String cntrctno);
     public void modify(BsnsZhiya bsnsZhiya);
     public void modifyCntrct(BsnsZhiya bsnsZhiya);
     public void delete(String applyNo);
     public void deleteCntrctno(String cntrctno);
}
