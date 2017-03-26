/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.sms.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.sms.entity.Message;

/**
 * @author wangyw
 * @2015-06-17
 * @version 1.0
 * @param <T>
 */
public interface MessageDao extends BaseDao<Message>{
	public List<Message> findAll() throws DataAccessException;

	public Integer findSerialNoByDate(String date) throws DataAccessException;
	
	public Message getById(String id) throws DataAccessException;
	
}
