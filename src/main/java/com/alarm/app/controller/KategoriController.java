package com.alarm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class KategoriController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/kategori")
	public String kategori() {

		return "kategori";
	}

}
