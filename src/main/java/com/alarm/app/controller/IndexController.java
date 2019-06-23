package com.alarm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	/*index controller*/
	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

}
