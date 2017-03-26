package com.mf.org.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.org.entity.Employeetrain;

/**
 * @author hw
 * @2015-08-21
 */
public interface EmployeetrainDao extends BaseDao<Employeetrain>{
	public List<Employeetrain> findAll() throws DataAccessException;

	public void deleteByTrainno(String id) throws DataAccessException;

}
