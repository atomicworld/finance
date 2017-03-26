package com.mf.sms.service;

import java.util.List;
import com.mf.sms.entity.*;
import com.mf.util.*;

public interface MessageService{

	public PageView query(PageView pageView,Message message);
	
//	public List<Message> queryAll(Message message);
	
	public void add(Message message);
	
//	public void addAll(Message message);
	
	public void delete(String id);
	
//	public void modify(Message message);
	
	public Message getById(String id);
	
	public List<Message> findAll();
	
	public Integer getSerialNO(String date); 
	
}
