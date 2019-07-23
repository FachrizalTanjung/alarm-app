package com.alarm.app.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateToString(Date date, String format) {
		if (date == null) {
			return "-";
		}
		return new SimpleDateFormat(format).format(date);
	}

	public static Date stringToDate(String dateString, String format) {
		try {
			return (new SimpleDateFormat(format)).parse(dateString);
		} catch (Exception e) {
			return null;
		}
	}

}
