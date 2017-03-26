package com.mf.bsnsmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mf.bsnsmng.dao.ClientDao;
import com.mf.bsnsmng.entity.Client;
import com.mf.bsnsmng.service.ClientService;

import com.mf.util.PageView;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {
       @Autowired
       private ClientDao clientDao;
       @Override
       public PageView query(PageView pageView, Client client) {
   		 List<Client> list = clientDao.query(pageView, client);
   		 pageView.setRecords(list);
   		 return pageView;
   	}
       @Override
       public Client getById(String id){
    	   Client client = clientDao.getById(id);
    	   return client;
       }
       @Override
       public void delete(String id){
    	   clientDao.delete(id);
       }
       
}
