package com.alarm.app.dto;

import java.util.Date;

public class DtoReminder {

	private Integer id;
	private String catatan;
	private Date tanggal_aktif;
	private Date tanggal_sebelum_aktif;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCatatan() {
		return catatan;
	}

	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}

	public Date getTanggal_aktif() {
		return tanggal_aktif;
	}

	public void setTanggal_aktif(Date tanggal_aktif) {
		this.tanggal_aktif = tanggal_aktif;
	}

	public Date getTanggal_sebelum_aktif() {
		return tanggal_sebelum_aktif;
	}

	public void setTanggal_sebelum_aktif(Date tanggal_sebelum_aktif) {
		this.tanggal_sebelum_aktif = tanggal_sebelum_aktif;
	}

}
