package com.mf.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.sms.entity.*;
import com.mf.sms.dao.*;
import com.mf.sms.service.*;
import com.mf.util.*;

@Transactional
@Service("messageService")
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param message
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, Message message) {
		List<Message> list = messageDao.query(pageView, message);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param Message message
	 * @return List<Message>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
//	@Transactional(readOnly=true)
//	public List<Message> queryAll(Message message) {
//		List<Message> list = messageDao.queryAll(message);
//		return list;
//	}
	
	/**
	 * 新增操作
	 * @param message
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(Message message) {
		messageDao.add(message);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		messageDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public Message getById(String id) {
		return messageDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param message
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
//	public void modify(Message message) {
//		messageDao.modify(message);
//	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<Message> findAll() {
		return messageDao.findAll();
	}
	
	
	/**
	 * 根据时间判断 当天是否 是第一条 流水号
	 * @return
	 */
	public Integer getSerialNO(String date) {
		return messageDao.findSerialNoByDate(date);
	}
	
}
