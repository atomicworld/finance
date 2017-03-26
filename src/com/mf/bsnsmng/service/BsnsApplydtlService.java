package com.mf.bsnsmng.service;

import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.util.PageView;

public interface BsnsApplydtlService {
    public void add(BsnsApplydtl bsnsApplydtl);
    public PageView query(PageView pageView, BsnsApplydtl bsnsApplydtl); 
    public PageView query1(PageView pageView, BsnsApplydtl bsnsApplydtl); 
    public BsnsApplydtl getById(String rcrdid);
    public void modify(BsnsApplydtl bsnsApplydtl);
    /**
     * 获取可取消的申请列表
     * @param pageView
     * @param bsnsApplydtl
     * @return
     */
    public PageView queryCancel(PageView pageView, BsnsApplydtl bsnsApplydtl);
    
    public BsnsApplydtl getByApplyno(String applyno);
    
    public void delApply(String rcrdid);
    public void modifyByRcrdid(BsnsApplydtl bsnsApplydtl);
    
    public PageView queryUndone(PageView pageView, BsnsApplydtl bsnsApplydtl); 
}
