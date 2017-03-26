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
import com.mf.cntrtmng.entity.BsnsCntrct;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.financemng.entity.FnncVoucher;
import com.mf.util.PageView;

/**
 * @author yangchao
 * @2015-03-03
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncVoucherDao extends BaseDao<FnncVoucher>{
	public List<BsnsCntrct> queryOutmnt(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct bsnscntrct) throws DataAccessException;
	public List<BsnsCntrct> queryPaymnt(@Param("pageView")PageView pageView, @Param("t")BsnsCntrct bsnscntrct) throws DataAccessException;
	//wyy
	public void deleteDueno(String dueno);
}
