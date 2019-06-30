package com.alarm.app.model;
// Generated Jun 24, 2019 11:01:53 AM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import groovy.transform.stc.ClosureParams;

/**
 * Kategori generated by hbm2java
 */
@Entity
@Table(name = "kategori", catalog = "dbalarm")
public class Kategori implements java.io.Serializable {

	private Integer idKategori;
	private String kategori;
	private byte[] file;
	private Set<Reminder> reminders = new HashSet<Reminder>(0);

	public Kategori() {
	}

	public Kategori(String kategori) {
		this.kategori = kategori;
	}

	public Kategori(String kategori, byte[] file, Set<Reminder> reminders) {
		this.kategori = kategori;
		this.file = file;
		this.reminders = reminders;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_kategori", unique = true, nullable = false)
	public Integer getIdKategori() {
		return this.idKategori;
	}

	public void setIdKategori(Integer idKategori) {
		this.idKategori = idKategori;
	}

	@Column(name = "kategori", nullable = false, length = 50)
	public String getKategori() {
		return this.kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

//	@Lob
	@Column(name = "file")
	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "kategori")
	public Set<Reminder> getReminders() {
		return this.reminders;
	}

	public void setReminders(Set<Reminder> reminders) {
		this.reminders = reminders;
	}

}
