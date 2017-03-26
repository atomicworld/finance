package com.mf.sms.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import com.mf.base.BaseDao;
import com.mf.sms.entity.MessageModel;

/**
 * @author wangyw
 * @2015-06-17
 * @version 1.0
 * @param <T>
 */
public interface MessageModelDao extends BaseDao<MessageModel>{
	public List<MessageModel> findAll() throws DataAccessException;
	
	public void delete(String id) throws DataAccessException;
	
	public void add(MessageModel messageModel) throws DataAccessException;
	
	public void update(MessageModel messageModel) throws DataAccessException;
	
	public void changeStatus(MessageModel messageModel) throws DataAccessException;
	
}
