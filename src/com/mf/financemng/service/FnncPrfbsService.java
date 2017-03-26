/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.financemng.service;

import java.util.List;
import com.mf.financemng.entity.*;
import com.mf.financemng.dao.*;
import com.mf.financemng.service.*;
import com.mf.common.util.*;
import com.mf.util.PageView;
/**
 * @author xujiuhua
 * @2015-01-29
 * @Email: xujiuhua798@foxmail.com
 * @version 1.0
 * @param <T>
 */

public interface FnncPrfbsService{

	public PageView query(PageView pageView,FnncPrfbs fnncPrfbs);
	
	public PageView querylist(PageView pageView,FnncPrfbsList fnncaccntitem);

	/*查询未复核凭证基础数据*/
	public PageView queryWFHBase(PageView pageView, FnncPrfbs fnncPrfbs);
	
	public List<FnncPrfbs> queryAll(FnncPrfbs fnncPrfbs);
	
	public void add(FnncPrfbs fnncPrfbs);
	
	public void addAll(FnncPrfbs fnncPrfbs);
	
	public void delete(String id);
	
	public void modify(FnncPrfbs fnncPrfbs);
	
	public FnncPrfbs getById(String id);
	
	public FnncPrfbs getByprfno(String prfno);
	
	public List<FnncPrfbs> findAll();
	
	
}
