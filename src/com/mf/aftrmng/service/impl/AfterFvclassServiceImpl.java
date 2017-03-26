package com.mf.aftrmng.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mf.aftrmng.dao.AfterFvclassDao;
import com.mf.aftrmng.entity.AfterFvclass;
import com.mf.aftrmng.service.AfterFvclassService;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.common.util.StringUtil;
import com.mf.util.PageView;
/**
 * @author chenenze
 * @2015-01-21
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("afterFvclassService")
public class AfterFvclassServiceImpl implements AfterFvclassService {
	@Autowired
	private AfterFvclassDao afterFvclassDao;
	
	@Autowired
	private BsnsBillService bsnsBillService;
	/**
	 * 分页查询
	 * @param pageView
	 * @param afterFvclass
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, AfterFvclass afterFvclass) {
		List<AfterFvclass> list = afterFvclassDao.query(pageView, afterFvclass);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param AfterFvclass afterFvclass
	 * @return List<AfterFvclass>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterFvclass> queryAll(AfterFvclass afterFvclass) {
		List<AfterFvclass> list = afterFvclassDao.queryAll(afterFvclass);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param afterFvclass
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(AfterFvclass afterFvclass) {
		afterFvclassDao.add(afterFvclass);
	}
	
	/**
	 * 新增操作
	 * @param afterFvclass
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(AfterFvclass afterFvclass) {
		afterFvclassDao.addAll(afterFvclass);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		afterFvclassDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public AfterFvclass getById(String id) {
		
		return afterFvclassDao.getById(id);
	}
	/**
	 * 根据借据号查找实体类
	 * @param due
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public AfterFvclass getByDue(String id,HttpServletRequest request) {
		
		return afterFvclassDao.getByDue(id);
	}
	
	/**
	 * 修改实体类
	 * @param afterFvclass
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(AfterFvclass afterFvclass) {
		afterFvclassDao.modify(afterFvclass);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<AfterFvclass> findAll() {
		return afterFvclassDao.findAll();
	}
	/**
	 * 新增自动五级分类操作，提供接口
	 * @param afterFvclass
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addauto(BsnsBill bsnsbill) {
		AfterFvclass afterfvclass=new AfterFvclass();
		
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMdd");
		afterfvclass.setAutodt(nowDt);
		afterfvclass.setClntno(bsnsbill.getClntno());
		afterfvclass.setClntnm(bsnsbill.getClntnm());
		afterfvclass.setCntrctno(bsnsbill.getCntrctno());
		afterfvclass.setDueno(bsnsbill.getDueno());
		afterfvclass.setAutorslt("1");
		afterfvclass.setClsstyp("1");
		afterFvclassDao.addauto(afterfvclass);
	}
	
	
	//add by hw
	public AfterFvclass getByCntrctno(String cntrctno){
		return afterFvclassDao.getByCntrctno(cntrctno);
	}
	
}
