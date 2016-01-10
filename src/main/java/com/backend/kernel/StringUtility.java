package com.backend.kernel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtility {
	public static boolean isDigitsOnly(String string) {
		Pattern phoneNumberPattern = Pattern.compile("\\d+");
		Matcher matcher = phoneNumberPattern.matcher(string);
		
		return matcher.matches();
	}
	
	public static String capitalize(String string) {
		string = string.substring(0, 1).toUpperCase() + string.substring(1);
		return string;
		
	}
}
