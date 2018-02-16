package com.corti.demo;

import java.io.UnsupportedEncodingException;

public class URIHelper {
	
	public static String enCodeIt(String _theArg) {
		try {
			return java.net.URLEncoder.encode(_theArg,"UTF-8");
		}
		catch (UnsupportedEncodingException uee) {
			return "";
		}
	}
	public static String deCodeIt(String _theArg) {
		try {
			return java.net.URLDecoder.decode(_theArg,"UTF-8");
		}
		catch (UnsupportedEncodingException uee) {
			return "";
		}
	}
	

}
