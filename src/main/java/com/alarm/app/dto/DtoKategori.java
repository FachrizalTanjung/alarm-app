package com.alarm.app.dto;

import org.springframework.web.multipart.MultipartFile;

public class DtoKategori {

	private Integer id;
	private String kategori;
	private MultipartFile file;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
