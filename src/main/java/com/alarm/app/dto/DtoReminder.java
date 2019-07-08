package com.alarm.app.dto;

import java.util.Date;

import com.alarm.app.util.CustomDateJsonDeserializer;
import com.alarm.app.util.CustomDateJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class DtoReminder {

	private Integer id;
	private String catatan;
	private Date membuatTanggal;
	@JsonSerialize(using = CustomDateJsonSerializer.class)
	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	private Date tanggalAktif;
	@JsonSerialize(using = CustomDateJsonSerializer.class)
	@JsonDeserialize(using = CustomDateJsonDeserializer.class)
	private Date tanggalSebelumAktif;
	private Integer idKategori;
	private String kategori;

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

	public Date getMembuatTanggal() {
		return membuatTanggal;
	}

	public void setMembuatTanggal(Date membuatTanggal) {
		this.membuatTanggal = membuatTanggal;
	}

	public Date getTanggalAktif() {
		return tanggalAktif;
	}

	public void setTanggalAktif(Date tanggalAktif) {
		this.tanggalAktif = tanggalAktif;
	}

	public Date getTanggalSebelumAktif() {
		return tanggalSebelumAktif;
	}

	public void setTanggalSebelumAktif(Date tanggalSebelumAktif) {
		this.tanggalSebelumAktif = tanggalSebelumAktif;
	}

	public Integer getIdKategori() {
		return idKategori;
	}

	public void setIdKategori(Integer idKategori) {
		this.idKategori = idKategori;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

}
