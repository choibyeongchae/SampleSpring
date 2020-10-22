package com.spring.util;

public class StringUtil {
	
	public static String convertRegDate(String date) {
		String reg_date = date.substring(0, date.indexOf("."));
		
		return reg_date;
	}
	
}
