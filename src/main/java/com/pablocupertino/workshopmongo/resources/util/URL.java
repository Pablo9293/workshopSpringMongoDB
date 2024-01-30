package com.pablocupertino.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	//criando o metodo
	
	public static String decodePara(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			 return " ";
			
		}
	}
	//metodo para converter a data
	public static Date converteDate(String textDate, Date defaultValue) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textDate);
		} catch (ParseException e) {
			return defaultValue;
		}
	}

}
