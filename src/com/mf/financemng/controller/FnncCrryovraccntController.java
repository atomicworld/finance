/*
 * Powered By [yc_genetrator]
 * version 1.0
 * Since 2013 - 2015
 */
package com.mf.financemng.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mf.financemng.service.FnncCrryovraccntService;

/**
 * @author yangchao
 * @2015-03-09
 * @Email: bobiy@foxmail.com
 * @version 1.0
 * @param <T>
 */
@Controller
@RequestMapping(value="/mf/fnnccrryovraccnt/")
public class FnncCrryovraccntController {
	@Autowired
	private FnncCrryovraccntService fnncCrryovraccntService;
}

