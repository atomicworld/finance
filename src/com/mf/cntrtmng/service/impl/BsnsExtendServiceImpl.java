package com.mf.cntrtmng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import com.mf.cntrtmng.dao.BsnsExtendDao;
import com.mf.cntrtmng.entity.BsnsBill;
import com.mf.cntrtmng.entity.BsnsExtend;
import com.mf.cntrtmng.entity.BsnsRepayplan;
import com.mf.cntrtmng.service.BsnsBillService;
import com.mf.cntrtmng.service.BsnsExtendService;
import com.mf.cntrtmng.service.BsnsLnmainService;
import com.mf.cntrtmng.service.BsnsRepaylogService;
import com.mf.cntrtmng.service.BsnsRepayplanService;
import com.mf.common.util.StringUtil;
import com.mf.util.*;
/*
 * @author wangyw
 * @2015-08-12
 * @version 1.0
 * @param <T>
 */
@Transactional
@Service("bsnsExtendService")
public class BsnsExtendServiceImpl implements BsnsExtendService {
	@Autowired
	private BsnsExtendDao bsnsExtendDao;
	@Autowired
	private BsnsBillService bsnsBillService;
	@Autowired
	private BsnsRepaylogService bsnsRepaylogService;
	@Autowired
	private BsnsRepayplanService bsnsRepayplanService;
	@Autowired
	private BsnsLnmainService bsnsLnmainService;
	/**
	 * 分页查询
	 * @param pageView
	 * @param bsnsExtend
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public PageView query(PageView pageView, BsnsExtend bsnsExtend) {
		List<BsnsExtend> list = bsnsExtendDao.query(pageView, bsnsExtend);
		pageView.setRecords(list);
		return pageView;
	}
	
	/**
	 * 不分页查询
	 * @param BsnsExtend bsnsExtend
	 * @return List<BsnsExtend>
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsExtend> queryAll(BsnsExtend bsnsExtend) {
		List<BsnsExtend> list = bsnsExtendDao.queryAll(bsnsExtend);
		return list;
	}
	
	/**
	 * 新增操作
	 * @param bsnsExtend
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void add(BsnsExtend bsnsExtend) {
		bsnsExtendDao.add(bsnsExtend);
	}
	
	/**
	 * 新增操作
	 * @param bsnsExtend
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void addAll(BsnsExtend bsnsExtend) {
		bsnsExtendDao.addAll(bsnsExtend);
	}
	
	/**
	 * 删除操作
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void delete(String id) {
		bsnsExtendDao.delete(id);
	}
	
	/**
	 * 根据id查找实体类
	 * @param id
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public BsnsExtend getById(String id) {
		return bsnsExtendDao.getById(id);
	}
	
	/**
	 * 修改实体类
	 * @param bsnsExtend
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	public void modify(BsnsExtend bsnsExtend) {
		bsnsExtendDao.modify(bsnsExtend);
	}

	/**
	 * 查找所有
	 * @return
	 */
	//@PreAuthorize("hasRole('ROLE_*')")
	@Transactional(readOnly=true)
	public List<BsnsExtend> findAll() {
		return bsnsExtendDao.findAll();
	}
	
	public boolean extend(BsnsExtend bsnsExtend) {
		//借据信息
	    BsnsBill bsnsBill = bsnsBillService.findByDueno(bsnsExtend.getBsnsno());
	    
		//上一期还款计划
		BsnsRepayplan bsnsrepayplan=bsnsRepayplanService.getMaxByDueno(bsnsExtend.getBsnsno());
		if(bsnsrepayplan != null){
			bsnsExtend.setExtendsdate(bsnsrepayplan.getCycleedt());//上一期还款计划结束时间作为展期开始时间
			bsnsBill.setClssflg(bsnsrepayplan.getRepaytermno());//还款期数（保存在五级分类标志字段）
		}else{
			bsnsExtend.setExtendsdate(bsnsBill.getOutdate());//上一期还款计划结束时间作为展期开始时间
			bsnsBill.setClssflg("0");//还款期数（保存在五级分类标志字段）
		}
		
		//删除未还款的还款计划(包括部分还款)
		bsnsRepayplanService.delete(bsnsExtend.getBsnsno());
		//同时计算展期的还款计划
		List<BsnsRepayplan> planlist = bsnsRepayplanService.createExtendPlan(bsnsExtend.getBsnsno(),bsnsExtend,bsnsBill);
		bsnsRepayplanService.addExtendList(planlist, bsnsExtend.getBsnsno());
		
		String nowDt = StringUtil.getFormatDate(new Date(), "yyyyMMddHHmmss");
		String extendno = "EX" + nowDt;
		bsnsExtend.setExtendno(extendno);
		bsnsExtend.setApplydate(nowDt.substring(0, 8));//展期申请时间
		bsnsExtend.setCntrctno(bsnsBill.getCntrctno());
		if("".equals(bsnsExtend.getNum()) || bsnsExtend.getNum() == null){
			bsnsExtend.setNum("1");
		}else{
			Integer num = Integer.valueOf(bsnsExtend.getNum()) + 1;
			bsnsExtend.setNum(num.toString());
		}
		
		this.add(bsnsExtend);
		
		//修改借据中的展期编号,到期日期
		bsnsBill = new BsnsBill();
		bsnsBill.setDueno(bsnsExtend.getBsnsno());
		bsnsBill.setExtno(extendno);
		bsnsBill.setMtrtydate(bsnsExtend.getExtendedate());
		bsnsBillService.modify(bsnsBill);
		return true;
	}

	@Override
	public BsnsExtend getByDueno(String dueno) {
		return bsnsExtendDao.getByDueno(dueno);
	}
	
}