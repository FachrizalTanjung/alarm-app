package com.alarm.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alarm.app.dao.KategoriDao;
import com.alarm.app.dao.ReminderDao;
import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoReminder;
import com.alarm.app.dto.DtoResponse;
import com.alarm.app.model.Reminder;
import com.alarm.app.service.ReminderService;
import com.alarm.app.util.ResponseUtil;

@Service
@Transactional(readOnly = true)
public class ReminderServiceImpl implements ReminderService {

	@Autowired
	private ReminderDao reminderDao;
	@Autowired
	private KategoriDao kategoriDao;

	@Override
	public DataTablesResponse<DtoReminder> getAllReminders() {
		DataTablesResponse<DtoReminder> response = new DataTablesResponse<>();
		List<DtoReminder> dtoReminders = new ArrayList<>();
		List<Reminder> reminders = (List<Reminder>) reminderDao.findAll();
		for (Reminder reminder : reminders) {
			DtoReminder dtoReminder = new DtoReminder();

			dtoReminder.setId(reminder.getId());
			dtoReminder.setCatatan(reminder.getCatatan());
			dtoReminder.setTanggalAktif(reminder.getTanggalAktif());
			dtoReminder.setTanggalSebelumAktif(reminder.getTanggalSebelumAktif());
			dtoReminder.setIdKategori(reminder.getKategori().getIdKategori());
			dtoReminder.setKategori(reminder.getKategori().getKategori());

			dtoReminders.add(dtoReminder);
		}

		response.setData(dtoReminders);
		return response;
	}

	@Override
	public DataTablesResponse<DtoReminder> getReminderById(Integer id) {
		DataTablesResponse<DtoReminder> response = new DataTablesResponse<>();
		List<DtoReminder> dtoReminders = new ArrayList<>();
		Reminder reminder = reminderDao.findOne(id);

		DtoReminder dtoReminder = new DtoReminder();

		dtoReminder.setId(reminder.getId());
		dtoReminder.setCatatan(reminder.getCatatan());
		dtoReminder.setTanggalAktif(reminder.getTanggalAktif());
		dtoReminder.setTanggalSebelumAktif(reminder.getTanggalSebelumAktif());

		response.setData(dtoReminders);
		return response;
	}

	@Override
	public DataTablesResponse<DtoReminder> findByDate() {
		DataTablesResponse<DtoReminder> response = new DataTablesResponse<>();
		List<DtoReminder> dtoReminders = new ArrayList<>();
		List<Reminder> reminders = (List<Reminder>) reminderDao.findByDateBefore();
		if (reminders.isEmpty()) {
			reminders = (List<Reminder>) reminderDao.findByDateAfter();
		}

		for (Reminder reminder : reminders) {
			DtoReminder dtoReminder = new DtoReminder();

			dtoReminder.setId(reminder.getId());
			dtoReminder.setCatatan(reminder.getCatatan());
			dtoReminder.setTanggalAktif(reminder.getTanggalAktif());
			dtoReminder.setTanggalSebelumAktif(reminder.getTanggalSebelumAktif());
			dtoReminder.setIdKategori(reminder.getKategori().getIdKategori());
			dtoReminder.setKategori(reminder.getKategori().getKategori());

			dtoReminders.add(dtoReminder);
		}

		response.setData(dtoReminders);
		return response;
	}

	@Override
	public DtoResponse insert(DtoReminder dtoReminder) {
		Reminder reminder = new Reminder();

		reminder.setCatatan(dtoReminder.getCatatan());
		reminder.setMembuatTanggal(new Date());
		reminder.setTanggalAktif(dtoReminder.getTanggalAktif());
		reminder.setTanggalSebelumAktif(dtoReminder.getTanggalSebelumAktif());
		reminder.setKategori(kategoriDao.findOne(dtoReminder.getIdKategori()));

		reminderDao.save(reminder);
		return ResponseUtil.response(1, "Sukses");
	}

	@Override
	@Transactional(readOnly = false)
	public DtoResponse update(DtoReminder dtoReminder) {
		Reminder reminder = reminderDao.findOne(dtoReminder.getId());
		if (reminder != null) {
			reminder.setCatatan(dtoReminder.getCatatan());
			reminder.setTanggalAktif(dtoReminder.getTanggalAktif());
			reminder.setTanggalSebelumAktif(dtoReminder.getTanggalSebelumAktif());
			reminder.setKategori(kategoriDao.findOne(dtoReminder.getIdKategori()));
			reminderDao.save(reminder);
		}
		return ResponseUtil.response(1, "Sukses");
	}

	@Override
	@Transactional(readOnly = false)
	public DtoResponse delete(Integer id) {
		reminderDao.delete(id);
		return ResponseUtil.response(1, "Sukses");
	}

}
