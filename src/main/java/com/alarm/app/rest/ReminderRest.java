package com.alarm.app.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.app.dao.KategoriDao;
import com.alarm.app.dao.ReminderDao;
import com.alarm.app.dto.DtoKategori;
import com.alarm.app.dto.DtoReminder;
import com.alarm.app.dto.DtoResponse;
import com.alarm.app.model.Kategori;
import com.alarm.app.model.Reminder;
import com.alarm.app.util.ResponseUtil;

@Controller
@RequestMapping("/rest/reminder")
public class ReminderRest {
	
	@Autowired
	private ReminderDao reminderDao;
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody DtoResponse insertReminder(@RequestBody DtoReminder data){
		
		Reminder reminder = new Reminder();
		
		reminder.setCatatan(data.getCatatan());
		reminder.setTanggalAktif(data.getTanggal_aktif());
		reminder.setTanggalSebelumAktif(data.getTanggal_sebelum_aktif());
		
		
		reminderDao.save(reminder);
		return ResponseUtil.response(1, "Sukses");
	}

}
