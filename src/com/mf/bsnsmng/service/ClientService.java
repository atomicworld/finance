package com.mf.bsnsmng.service;




import com.mf.bsnsmng.entity.Client;
import com.mf.util.PageView;

public interface ClientService {
	public PageView query(PageView pageView, Client client);
	public Client getById(String id);
	public void delete(String id);
}
