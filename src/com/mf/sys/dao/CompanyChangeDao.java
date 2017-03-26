package com.mf.sys.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.sys.entity.CompanyChange;

/**
 * @author hw
 * @2015-08-20
 */
public interface CompanyChangeDao extends BaseDao<CompanyChange>{
	public List<CompanyChange> findAll() throws DataAccessException;
	
	public void deleteById(String id) throws DataAccessException;

}
