package com.alarm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InputKategoriController {
	
	@RequestMapping(value = "/inputKategori")
	public String inputKategori() {
		return "inputKategori";
	}

}
