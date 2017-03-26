/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.base.AutoCompleteEntity;
import com.mf.common.util.StringUtil;
import com.mf.financemng.dao.FnncAccntitemDao;
import com.mf.financemng.entity.FnncAccntitem;
import com.mf.financemng.entity.FnncPrfbsList;
import com.mf.financemng.service.FnncAccntitemService;
import com.mf.util.PageView;

/**
 * @author xujiuhua
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("fnncAccntitemService")
public class FnncAccntitemServiceImpl implements FnncAccntitemService {
	@Autowired
	private FnncAccntitemDao fnncAccntitemDao;
	
	/**
	 * 分页查询
	 * @param pageView
	 * @param fnncAccntitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, FnncAccntitem fnncAccntitem) {
		List<FnncAccntitem> list = fnncAccntitemDao.query(pageView, fnncAccntitem);
		pageView.setRecords(list);
		return pageView;
	}
	
	//为自动提示框查询json数据
	@Transactional(readOnly=true)
	public Map<String,List<AutoCompleteEntity>> getAllItemForAutoCmp(){
		Map<String,List<AutoCompleteEntity>> map = new HashMap<String, List<AutoCompleteEntity>>();
		List<FnncAccntitem> list = fnncAccntitemDao.queryAll(new FnncAccntitem());
		List<AutoCompleteEntity> autoCmpList = new ArrayList<AutoCompleteEntity>();
		
		for(int i=0; i<list.size(); i++){
			AutoCompleteEntity autoCmpEntity = new AutoCompleteEntity();
			FnncAccntitem accntItem = list.get(i);
			String accntNo = accntItem.getAccntno();
			String accntNm = accntItem.getAccntnm();
			String pinyinHead = StringUtil.getFirstPinYin(accntNm);
			autoCmpEntity.setValue(accntNo);
			autoCmpEntity.setKey(accntNo + " - " + accntNm);
			autoCmpEntity.setSuggest(accntNo + "|" + accntNm + "|" + pinyinHead);
			autoCmpList.add(autoCmpEntity);
		}
		map.put("list", autoCmpList);
		return map;
	}
	
	/**
	 * 不分页查询
	 * @param FnncAccntitem fnncAccntitem
	 * @return List<FnncAccntitem>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncAccntitem> queryAll(FnncAccntitem fnncAccntitem) {
		List<FnncAccntitem> list = fnncAccntitemDao.queryAll(fnncAccntitem);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param fnncAccntitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(FnncAccntitem fnncAccntitem) {
		fnncAccntitemDao.add(fnncAccntitem);
	}
	
	/**
	 * 新增操作
	 * @param fnncAccntitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(FnncAccntitem fnncAccntitem) {
		fnncAccntitemDao.addAll(fnncAccntitem);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		fnncAccntitemDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public FnncAccntitem getById(String id) {
		return fnncAccntitemDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param fnncAccntitem
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(FnncAccntitem fnncAccntitem) {
		fnncAccntitemDao.modify(fnncAccntitem);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<FnncAccntitem> findAll() {
		return fnncAccntitemDao.findAll();
	}
	
	public String getChild(String accntno){
		return fnncAccntitemDao.getChild(accntno);
	}
	public List<FnncAccntitem> getByAccntno(String stat){
		return fnncAccntitemDao.getByAccntno(stat);
	}
	public List<FnncAccntitem> getType(String accntkndcode){
		return fnncAccntitemDao.getType(accntkndcode);
	}
	
	public FnncAccntitem getByUp(FnncAccntitem fnnc){
		return fnncAccntitemDao.getByUp(fnnc);
	}
	
}
