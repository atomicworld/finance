package com.mf.bsnsmng.service;

import com.mf.bsnsmng.entity.BsnsDiya;

public interface BsnsDiyaService {
     public void add(BsnsDiya bsnsDiya);
     public BsnsDiya getById(String applyNo);
     public BsnsDiya getByCntrctno(String cntrctno);
     public void delete(String applyNo);
     public void deleteCntrctno(String applyNo);
     
     public void modify(BsnsDiya bsnsDiya);
     public void modifyCntrct(BsnsDiya bsnsDiya);
     
}
