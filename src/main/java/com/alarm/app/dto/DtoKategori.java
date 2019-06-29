package com.alarm.app.dto;

import java.util.HashSet;
import java.util.Set;

import com.alarm.app.model.Reminder;

public class DtoKategori {
	
	private String kategori;
	private byte[] file;
	private Set<Reminder> reminders = new HashSet<Reminder>(0);
	
	public String getKategori() {
		return kategori;
	}
	public void setKategori(String kategori) {
		this.kategori = kategori;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Set<Reminder> getReminders() {
		return reminders;
	}
	public void setReminders(Set<Reminder> reminders) {
		this.reminders = reminders;
	}
	
}
