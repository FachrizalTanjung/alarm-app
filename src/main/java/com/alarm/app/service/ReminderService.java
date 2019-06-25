package com.alarm.app.service;

import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoReminder;

public interface ReminderService {
	
	DataTablesResponse<DtoReminder> getAllReminders();

}
