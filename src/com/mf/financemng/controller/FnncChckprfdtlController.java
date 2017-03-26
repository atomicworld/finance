package com.mf.financemng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.financemng.service.FnncChckprfbsService;
import com.mf.financemng.service.FnncChckprfdtlService;
@Controller
@RequestMapping(value="/mf/financemng/fnncchckprfdtl/")
public class FnncChckprfdtlController {

	@Autowired
	private FnncChckprfdtlService fnncChckprfdtlService;
	
	
}
