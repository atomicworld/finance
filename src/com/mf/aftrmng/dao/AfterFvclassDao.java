package com.mf.aftrmng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.base.BaseDao;

/**
 * @author chenenze
 * @2015-01-20
 * @version 1.0
 * @param <T>
 */
public interface AfterFvclassDao extends BaseDao<AfterFvclass>{
	public List<AfterFvclass> findAll() throws DataAccessException;
	
	public AfterFvclass getByDue(String id);
	public void addauto(AfterFvclass afterFvclass);
	//add by hw
	public AfterFvclass getByCntrctno(String cntrctno);
	public void deleteById(String id) throws DataAccessException;

}
