package com.mf.flowmng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.BsnsApplydtl;
import com.mf.flowmng.entity.FlowApprlcmmnts;
import com.mf.util.PageView;

public interface FlowApprlcmmntsDao extends BaseDao<FlowApprlcmmnts>{
	public List<FlowApprlcmmnts> query1(@Param("pageView")PageView pageView, @Param("applyno")String apprvstt) throws DataAccessException;   
}
