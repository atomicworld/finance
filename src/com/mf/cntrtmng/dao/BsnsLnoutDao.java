

package com.mf.cntrtmng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.cntrtmng.entity.BsnsLnout;
import com.mf.util.PageView;


public interface BsnsLnoutDao extends BaseDao<BsnsLnout>{
	public List<BsnsLnout> findAll() throws DataAccessException;
	
	public List<BsnsCntrct> queryExcel(BsnsCntrct bsnscntrct);
	
	public List<BsnsLnout> bsnsLnoutDao() throws DataAccessException;
	
	public List<BsnsLnout> queryoutable(@Param("pageView")PageView pageView, @Param("t")BsnsLnout t) throws DataAccessException;
	//wyy
	public List<BsnsLnout> queryList(BsnsLnout bsnslnout);
	
	public List<BsnsLnout> showoutInfo(@Param("pageView")PageView pageView, @Param("t")BsnsLnout t) throws DataAccessException;

	public BsnsLnout findOneByOutno(String outno) throws DataAccessException;

	public void exeout(String outno) throws DataAccessException;

	public void billoutEnd(BsnsLnout bsnsLnout);
	
	public BsnsLnout findBySrlno(String srlno)throws DataAccessException;

	public List<BsnsLnout> queryOuted(@Param("pageView")PageView pageView, @Param("t")BsnsLnout t);
}
