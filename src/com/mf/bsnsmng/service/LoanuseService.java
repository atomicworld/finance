package com.mf.bsnsmng.service;

import java.util.List;

import com.mf.bsnsmng.entity.Loanuse;

public interface LoanuseService {
       public List<Loanuse> findAll();
       public Loanuse getById(String id);
       
       public Loanuse getByUsenm(String usenm);
}
