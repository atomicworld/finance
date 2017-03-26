package com.mf.bsnsmng.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mf.base.BaseDao;
import com.mf.bsnsmng.entity.BsnsApply;

public interface BsnsApplyDao extends BaseDao<BsnsApply> {
    public String getByClntNo(String clntNo)throws DataAccessException;
    public int isHave(String clntno);
    public List<BsnsApply> queryAll(String clntNo)throws DataAccessException;
}
