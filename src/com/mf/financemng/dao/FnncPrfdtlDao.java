/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncPrfdtl;
import com.mf.financemng.entity.FnncPrfdtlList;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-02-11
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncPrfdtlDao extends BaseDao<FnncPrfdtl>{
	public List<FnncPrfdtl> findAll() throws DataAccessException;
	
	public List<FnncPrfdtl> getByPrfrtcno(String prfrtcno)throws DataAccessException;
	
	public List<FnncPrfdtlList> querylist(String prfrtcno)throws DataAccessException;
	
	public void deleteBysqnno(String sqnno) throws DataAccessException;

	public List<FnncPrfdtlList> queryAccnt(@Param("pageView")PageView pageView, @Param("t")FnncPrfdtlList fnncprfdtllist) throws DataAccessException;
	
	public List<FnncPrfdtlList> queryAccntAll(@Param("pageView")PageView pageView, @Param("t")FnncPrfdtlList fnncprfdtllist) throws DataAccessException;

}
