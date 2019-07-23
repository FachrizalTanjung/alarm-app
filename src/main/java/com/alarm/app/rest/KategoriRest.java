package com.alarm.app.rest;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoKategori;
import com.alarm.app.dto.DtoResponse;
import com.alarm.app.service.KategoriService;

@Controller
@RequestMapping("/rest/kategori")
public class KategoriRest {

	@Autowired
	private KategoriService kategoriService;

	@RequestMapping(value = "/get-all-kategoris")
	public @ResponseBody DataTablesResponse<DtoKategori> getAllKategoris() {
		DataTablesResponse<DtoKategori> dtoKategori = kategoriService.getAllKategori();
		return dtoKategori;
	}

	@RequestMapping(value = "/get-kategori-by-id")
	public ResponseEntity<ByteArrayResource> getKategoriById(@RequestParam(value = "id", required = true) Integer id) {
		DtoKategori dtoKategori = kategoriService.getKategoriById(id);
		byte[] byteFile = dtoKategori.getFileData();
		ByteArrayResource resource = new ByteArrayResource(byteFile);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION,
						"attachment;filename=" + dtoKategori.getKategori() + UUID.randomUUID().toString() + ".pdf")
				.contentType(MediaType.APPLICATION_PDF).contentLength(byteFile.length).body(resource);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public @ResponseBody DtoResponse insertKategori(@RequestParam(value = "kategori", required = true) String kategori,
			@RequestParam(value = "fileData", required = false) MultipartFile file) throws IOException {
		DtoKategori dtoKategori = new DtoKategori();
		dtoKategori.setKategori(kategori);
		dtoKategori.setFile(file);
		return kategoriService.insert(dtoKategori);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody DtoResponse updateKategori(@RequestParam(value = "id", required = true) Integer id,
			@RequestParam(value = "kategori", required = true) String kategori,
			@RequestParam(value = "fileData", required = false) MultipartFile file) throws IOException {
		DtoKategori dtoKategori = new DtoKategori();
		dtoKategori.setId(id);
		dtoKategori.setKategori(kategori);
		dtoKategori.setFile(file);
		return kategoriService.update(dtoKategori);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public @ResponseBody DtoResponse deleteKategori(@RequestBody Integer id) throws IOException {
		return kategoriService.delete(id);
	}

}
