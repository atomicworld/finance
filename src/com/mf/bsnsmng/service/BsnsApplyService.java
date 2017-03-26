package com.mf.bsnsmng.service;



import java.util.List;

import com.mf.bsnsmng.entity.BsnsApply;

public interface BsnsApplyService {
   public void add(BsnsApply bsnsApply);
   public BsnsApply getById(String applyNo);
   public String getByClntNo(String clntNo);
   public int isHave(String clntno);
   public List<BsnsApply> queryAll(String clntNo);
   
   public void modify(BsnsApply bsnsApply);
   public void delete(String applyNo);
}
