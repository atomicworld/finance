/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.financemng.entity.FnncAccntitem;

/**
 * @author xujiuhua
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
public interface FnncAccntitemDao extends BaseDao<FnncAccntitem>{
	public List<FnncAccntitem> findAll() throws DataAccessException;
	
	public FnncAccntitem getByUp(FnncAccntitem fnnc);
	public String getChild(String accntno) throws DataAccessException;
	public List<FnncAccntitem> getByAccntno(String stat)throws DataAccessException;
	public List<FnncAccntitem> getType(String accntkndcode)throws DataAccessException;

	
}
