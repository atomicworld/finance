package com.mf.client.service;

import com.mf.client.entity.ClntPerson;
import com.mf.util.PageView;

public interface ClntPersonService {
	public PageView query(PageView pageView, ClntPerson clntPerson);
	public ClntPerson findByCertno(String certno);
	public void add(ClntPerson clntPerson);
	public ClntPerson findByClntno(String clntno);
	public ClntPerson getByClntno(String clntno);
	public void update(ClntPerson clntPerson);
}
