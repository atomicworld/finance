/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */

package com.mf.cntrtmng.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.cntrtmng.entity.BsnsRepaylog;
import com.mf.cntrtmng.entity.BsnsRepaylogList;

/**      
* 类名称：BsnsRepaylogDao   
* 创建人：wangyaowei  
* 创建时间：2015-2-2 下午6:58:30   
* 修改人：wangyaowei  
* 修改时间：2015-2-2 下午6:58:30   
*/
public interface BsnsRepaylogDao extends BaseDao<BsnsRepaylog>{
	public List<BsnsRepaylog> findAll() throws DataAccessException;
	
	public int getCountPlan(String dueno)throws DataAccessException;
	
	public  List<BsnsRepaylogList> getByDueno(String dueno)throws DataAccessException;
	
	public  List<BsnsRepaylogList> getByDuenoCount(String dueno)throws DataAccessException;
	
/*	public  BsnsRepaylog getBySrlno(String srlno)throws DataAccessException;*/
	//edit by hw
	public  List<BsnsRepaylog> getBySrlno(String srlno)throws DataAccessException;
	
	// add by hw
	public BsnsRepaylog getForMaxDt(String srlno)throws DataAccessException;
	
	public void update(BsnsRepaylog bsnsRepaylog)throws DataAccessException;
	
}
