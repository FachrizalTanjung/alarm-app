package com.alarm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KategoriController {
	
	@RequestMapping(value = "/kategori")
	public String kategori() {
		return "kategori";
	}

}
