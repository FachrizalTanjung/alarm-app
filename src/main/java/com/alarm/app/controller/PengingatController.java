package com.alarm.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PengingatController {

	@RequestMapping(value = "/pengingat")
	public String pengingat() {
		return "pengingat";
	}

	@RequestMapping(value = "/tambah-pengingat")
	public String tambahPengingat() {
		return "tambah-pengingat";
	}

	@RequestMapping(value = "/ubah-pengingat")
	public String ubahPengingat() {
		return "ubah-pengingat";
	}

}
