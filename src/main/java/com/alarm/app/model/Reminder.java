package com.alarm.app.model;
// Generated Jun 24, 2019 11:01:53 AM by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Reminder generated by hbm2java
 */
@Entity
@Table(name = "reminder", catalog = "dbalarm")
public class Reminder implements java.io.Serializable {

	private Integer id;
	private Kategori kategori;
	private User userByMembuatNama;
	private User userByMengupdateNama;
	private String catatan;
	private Date tanggalAktif;
	private Date tanggalSebelumAktif;
	private Date membuatTanggal;
	private Date mengupdateTanggal;

	public Reminder() {
	}

	public Reminder(Kategori kategori, String catatan, Date tanggalAktif, Date membuatTanggal) {
		this.kategori = kategori;
		this.catatan = catatan;
		this.tanggalAktif = tanggalAktif;
		this.membuatTanggal = membuatTanggal;
	}

	public Reminder(Kategori kategori, User userByMembuatNama, User userByMengupdateNama, String catatan,
			Date tanggalAktif, Date tanggalSebelumAktif, Date membuatTanggal, Date mengupdateTanggal) {
		this.kategori = kategori;
		this.userByMembuatNama = userByMembuatNama;
		this.userByMengupdateNama = userByMengupdateNama;
		this.catatan = catatan;
		this.tanggalAktif = tanggalAktif;
		this.tanggalSebelumAktif = tanggalSebelumAktif;
		this.membuatTanggal = membuatTanggal;
		this.mengupdateTanggal = mengupdateTanggal;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_kategori", nullable = false)
	public Kategori getKategori() {
		return this.kategori;
	}

	public void setKategori(Kategori kategori) {
		this.kategori = kategori;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "membuat_nama")
	public User getUserByMembuatNama() {
		return this.userByMembuatNama;
	}

	public void setUserByMembuatNama(User userByMembuatNama) {
		this.userByMembuatNama = userByMembuatNama;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mengupdate_nama")
	public User getUserByMengupdateNama() {
		return this.userByMengupdateNama;
	}

	public void setUserByMengupdateNama(User userByMengupdateNama) {
		this.userByMengupdateNama = userByMengupdateNama;
	}

	@Column(name = "catatan", nullable = false, length = 65535)
	public String getCatatan() {
		return this.catatan;
	}

	public void setCatatan(String catatan) {
		this.catatan = catatan;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tanggal_aktif", nullable = false, length = 19)
	public Date getTanggalAktif() {
		return this.tanggalAktif;
	}

	public void setTanggalAktif(Date tanggalAktif) {
		this.tanggalAktif = tanggalAktif;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tanggal_sebelum_aktif", length = 19)
	public Date getTanggalSebelumAktif() {
		return this.tanggalSebelumAktif;
	}

	public void setTanggalSebelumAktif(Date tanggalSebelumAktif) {
		this.tanggalSebelumAktif = tanggalSebelumAktif;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "membuat_tanggal", nullable = false, length = 19)
	public Date getMembuatTanggal() {
		return this.membuatTanggal;
	}

	public void setMembuatTanggal(Date membuatTanggal) {
		this.membuatTanggal = membuatTanggal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "mengupdate_tanggal", length = 19)
	public Date getMengupdateTanggal() {
		return this.mengupdateTanggal;
	}

	public void setMengupdateTanggal(Date mengupdateTanggal) {
		this.mengupdateTanggal = mengupdateTanggal;
	}

}
