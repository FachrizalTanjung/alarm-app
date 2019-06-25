package com.alarm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputPengingatController {
	
	@RequestMapping(value = "/inputPengingat")
	public String inputPengingat() {
		return "inputPengingat";
	}

}
