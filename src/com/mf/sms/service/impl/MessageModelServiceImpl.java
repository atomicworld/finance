package com.mf.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.businessParam.entity.BusinessKind;
import com.mf.sms.entity.*;
import com.mf.sms.dao.*;
import com.mf.sms.service.*;
import com.mf.util.*;
/**
 * @author wangyw
 * @2015-06-17
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("messageModelService")
public class MessageModelServiceImpl implements MessageModelService {
	@Autowired
	private MessageModelDao messageModelDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param messageModel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, MessageModel messageModel) {
		List<MessageModel> list = messageModelDao.query(pageView, messageModel);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param MessageModel messageModel
	 * @return List<MessageModel>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<MessageModel> queryAll(MessageModel messageModel) {
		List<MessageModel> list = messageModelDao.queryAll(messageModel);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param messageModel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(MessageModel messageModel) {
		messageModelDao.add(messageModel);
	}
	
	/**
	 * 新增操作
	 * @param messageModel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(MessageModel messageModel) {
		messageModelDao.addAll(messageModel);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		messageModelDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public MessageModel getById(String id) {
		return messageModelDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param messageModel
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void update(MessageModel messageModel) {
		messageModelDao.update(messageModel);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<MessageModel> findAll() {
		return messageModelDao.findAll();
	}
	
	/**
	 * 
	 * @param id
	 * @param status
	 */
	public void changeStatus(String id,String isused){
		MessageModel msgModel=new MessageModel();
		msgModel.setId(id);
		msgModel.setIsused(isused);
		messageModelDao.changeStatus(msgModel);
		
	}
	
}
