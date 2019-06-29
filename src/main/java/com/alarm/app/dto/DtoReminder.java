package com.alarm.app.dto;

import java.util.Date;

public class DtoReminder {

	private Integer id;
	private String catatan;
	private Date setTanggal_aktif;
	private Date setTanggal_sebelum_aktif;

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

	public Date getSetTanggal_aktif() {
		return setTanggal_aktif;
	}

	public void setSetTanggal_aktif(Date setTanggal_aktif) {
		this.setTanggal_aktif = setTanggal_aktif;
	}

	public Date getSetTanggal_sebelum_aktif() {
		return setTanggal_sebelum_aktif;
	}

	public void setSetTanggal_sebelum_aktif(Date setTanggal_sebelum_aktif) {
		this.setTanggal_sebelum_aktif = setTanggal_sebelum_aktif;
	}

}
