package com.mf.bsnsmng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.util.PageView;

public interface BsnsApplyDtlDao extends BaseDao<BsnsApplydtl> {
	//public List<BsnsApplydtl> query1(PageView pageView,String apprvstt) throws DataAccessException;
	public List<BsnsApplydtl> query1(@Param("pageView")PageView pageView, @Param("t")BsnsApplydtl bsnsApplydtl) throws DataAccessException;
	public List<BsnsApplydtl> queryCancel(@Param("pageView")PageView pageView, @Param("t")BsnsApplydtl bsnsApplydtl) throws DataAccessException;
	public BsnsApplydtl getByApplyno(String applyno) throws DataAccessException;
	//wyy
	public void copyLog(String rcrdid);
	
	public void modifyByRcrdid(BsnsApplydtl bsnsApplydtl)throws DataAccessException;
	//wyy
	public void delApplyNo(String rcrdid);
	
	//hw
	public List<BsnsApplydtl> queryUndone(@Param("pageView")PageView pageView, @Param("t")BsnsApplydtl bsnsApplydtl) throws DataAccessException;
}
