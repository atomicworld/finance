package com.mf.sms.service;

import java.util.List;
import com.mf.sms.entity.*;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-06-17
 * @version 1.0
 * @param <T>
 */

public interface MessageModelService{

	public PageView query(PageView pageView,MessageModel messageModel);
	
	public void add(MessageModel messageModel);
	
	public void delete(String id);
	
	public void update(MessageModel messageModel);
	
	public MessageModel getById(String id);
	
	public List<MessageModel> findAll();
	
	public void changeStatus(String id,String isused);
	
}
