package com.alarm.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoReminder;
import com.alarm.app.model.Reminder;
import com.alarm.app.repository.ReminderDao;
import com.alarm.app.service.ReminderService;

@Service
@Transactional(readOnly = true)
public class ReminderServiceImpl implements ReminderService {

	@Autowired
	private ReminderDao reminderDao;

	@Override
	public DataTablesResponse<DtoReminder> getAllReminders() {
		DataTablesResponse<DtoReminder> response = new DataTablesResponse<>();
		List<DtoReminder> dtoReminders = new ArrayList<>();
		List<Reminder> reminders = reminderDao.findAll();
		for (Reminder reminder : reminders) {
			DtoReminder dtoReminder = new DtoReminder();
			
			dtoReminder.setId(reminder.getId());
			dtoReminder.setCatatan(reminder.getCatatan());
			dtoReminder.setSetTanggal_aktif(reminder.getTanggalSebelumAktif());
			dtoReminder.setSetTanggal_sebelum_aktif(reminder.getTanggalSebelumAktif());
			
			dtoReminders.add(dtoReminder);
		}

		response.setData(dtoReminders);
		return response;
	}

}
