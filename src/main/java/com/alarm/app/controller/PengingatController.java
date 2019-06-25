package com.alarm.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alarm.app.dto.DataTablesResponse;
import com.alarm.app.dto.DtoReminder;
import com.alarm.app.service.ReminderService;

@Controller
public class PengingatController {
	
	@Autowired
	private ReminderService reminderService;
	
	@RequestMapping(value = "/pengingat")
	public String pengingat() {
		return "pengingat";
	}
	
	@RequestMapping(value = "/get-all-reminders")
	public @ResponseBody DataTablesResponse<DtoReminder> getAllReminders() {
		DataTablesResponse<DtoReminder> dtoReminder = reminderService.getAllReminders();
		return dtoReminder;
	}

}
