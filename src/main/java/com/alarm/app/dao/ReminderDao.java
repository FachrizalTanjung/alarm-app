package com.alarm.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.alarm.app.model.Reminder;

public interface ReminderDao extends CrudRepository<Reminder, Integer> {
	
	@Query(value = "SELECT * FROM Reminder WHERE DATE(SYSDATE()) = DATE(tanggal_sebelum_aktif)", nativeQuery = true)
	List<Reminder> findByDateBefore();
	
	@Query(value = "SELECT * FROM Reminder WHERE DATE(SYSDATE()) = DATE(tanggal_aktif)", nativeQuery = true)
	List<Reminder> findByDateAfter();

}
