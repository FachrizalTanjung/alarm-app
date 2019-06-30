package com.alarm.app.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alarm.app.dto.DtoKategori;
import com.alarm.app.dto.DtoResponse;
import com.alarm.app.service.KategoriService;

@Controller
@RequestMapping("/rest/kategori")
public class KategoriRest {

	@Autowired
	private KategoriService kategoriService;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody DtoResponse insertKategori(@RequestParam(value = "kategori", required = true) String kategori,
			@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
		DtoKategori dtoKategori = new DtoKategori();
		dtoKategori.setKategori(kategori);
		dtoKategori.setFile(file);
		return kategoriService.insert(dtoKategori);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody DtoResponse updateKategori(@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "kategori", required = true) String kategori,
			@RequestParam(value = "file", required = true) MultipartFile file) throws IOException {
		DtoKategori dtoKategori = new DtoKategori();
		dtoKategori.setId(id);
		dtoKategori.setKategori(kategori);
		dtoKategori.setFile(file);
		return kategoriService.update(dtoKategori);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody DtoResponse deleteKategori(@RequestParam(value = "id", required = true) Integer id)
			throws IOException {
		return kategoriService.delete(id);
	}

}
