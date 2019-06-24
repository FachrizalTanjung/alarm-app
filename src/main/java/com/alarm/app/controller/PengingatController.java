package com.alarm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PengingatController {
	
	@RequestMapping(value = "/pengingat")
	public String pengingat() {
		return "pengingat";
	}

}
