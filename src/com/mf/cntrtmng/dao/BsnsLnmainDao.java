/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsLnmain;
import com.mf.util.PageView;

/**
 * @author xujiuhua
 * @2015-01-21
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface BsnsLnmainDao extends BaseDao<BsnsLnmain>{
	public List<BsnsLnmain> findAll() throws DataAccessException;

	public BsnsLnmain findByBsnsno(String bsnsno);
	//wyy
	public BsnsLnmain cougtCntrctno(String cntrctno);

	//wyy
	public void deleteDueno(String bsnsno);
	
	public List<BsnsLnmain> queryextend(@Param("pageView")PageView pageView, @Param("t")BsnsLnmain t) throws DataAccessException;

}
