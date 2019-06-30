package com.alarm.app.service;

import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoReminder;
import com.alarm.app.dto.DtoResponse;

public interface ReminderService {

	DataTablesResponse<DtoReminder> getAllReminders();

	DataTablesResponse<DtoReminder> getReminderById(Integer id);

	DtoResponse insert(DtoReminder dtoReminder);

	DtoResponse update(DtoReminder dtoReminder);

	DtoResponse delete(Integer id);

}
