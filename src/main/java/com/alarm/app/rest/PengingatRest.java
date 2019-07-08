package com.alarm.app.rest;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoReminder;
import com.alarm.app.dto.DtoResponse;
import com.alarm.app.service.ReminderService;

@Controller
@RequestMapping("/rest/pengingat")
public class PengingatRest {

	@Autowired
	private ReminderService reminderService;

	@RequestMapping(value = "/get-all-pengingats")
	public @ResponseBody DataTablesResponse<DtoReminder> getAllPengingats() {
		DataTablesResponse<DtoReminder> dtoReminder = reminderService.getAllReminders();
		return dtoReminder;
	}
	
	@RequestMapping(value = "/get-dashboard")
	public @ResponseBody DataTablesResponse<DtoReminder> getDashboard() {
		DataTablesResponse<DtoReminder> dtoReminder = reminderService.findByDate();
		return dtoReminder;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody DtoResponse insertReminder(@RequestBody DtoReminder data) {
		return reminderService.insert(data);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody DtoResponse updateReminder(@RequestBody DtoReminder data) {
		return reminderService.update(data);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON)
	public @ResponseBody DtoResponse deleteReminder(@RequestBody Integer id) {
		return reminderService.delete(id);
	}

}
