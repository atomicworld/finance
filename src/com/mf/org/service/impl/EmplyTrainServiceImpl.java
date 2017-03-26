package com.mf.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.mf.org.entity.*;
import com.mf.org.dao.*;
import com.mf.org.service.*;
import com.mf.util.*;
/**
 * @author  hw
 * @2015-08-24
 */
@Transactional
@Service("emplyTrainService")
public class EmplyTrainServiceImpl implements EmplyTrainService {
	@Autowired
	private EmplyTrainDao emplyTrainDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param emplyTrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, EmplyTrain emplyTrain) {
		List<EmplyTrain> list = emplyTrainDao.query(pageView, emplyTrain);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param EmplyTrain emplyTrain
	 * @return List<EmplyTrain>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<EmplyTrain> queryAll(EmplyTrain emplyTrain) {
		List<EmplyTrain> list = emplyTrainDao.queryAll(emplyTrain);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param emplyTrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(EmplyTrain emplyTrain) {
		emplyTrainDao.add(emplyTrain);
	}
	
	/**
	 * 新增操作
	 * @param emplyTrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(EmplyTrain emplyTrain) {
		emplyTrainDao.addAll(emplyTrain);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		emplyTrainDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public EmplyTrain getById(String id) {
		return emplyTrainDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param emplyTrain
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(EmplyTrain emplyTrain) {
		emplyTrainDao.modify(emplyTrain);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<EmplyTrain> findAll() {
		return emplyTrainDao.findAll();
	}
	
	//	add by  hw
	public List<EmplyTrain> getByTraino(String trainno){
		return emplyTrainDao.getByTraino(trainno);
	}
	
	public void deleteByTrainno(String trainno){
		//找到所有trainno的记录
		List<EmplyTrain> list = emplyTrainDao.getByTraino(trainno);
		for(int i=0;i<list.size();i++){
			emplyTrainDao.deleteEmplyTrain(list.get(i).getTrainno());
		}
	}
	
}
