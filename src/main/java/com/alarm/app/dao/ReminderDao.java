package com.alarm.app.dao;

import org.springframework.data.repository.CrudRepository;

import com.alarm.app.model.Reminder;

public interface ReminderDao extends CrudRepository<Reminder, Integer>{

}
