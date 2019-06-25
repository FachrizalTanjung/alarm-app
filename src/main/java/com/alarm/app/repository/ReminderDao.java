package com.alarm.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alarm.app.model.Reminder;

public interface ReminderDao extends JpaRepository<Reminder, Integer> {

}
