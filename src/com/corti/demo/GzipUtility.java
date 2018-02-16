package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GzipUtility {
	
	// See if gzip encoding is accepted, return true if it is
	public static boolean isGzipSupported(HttpServletRequest request) {
		String encodings = request.getHeader("Accept-Encoding");
		return (encodings != null) && (encodings.contains("gzip"));
	}
	
	// Return true if gzip is disabled
	public static boolean isGzipDisabled(HttpServletRequest request) {
		String flag = request.getParameter("disableGzip");
		return (flag != null) && (!flag.equalsIgnoreCase("false"));
	}
	
	// Return a PrintWriter that is GZIP'd output stream (compressed)
	public static PrintWriter getGzipWriter(HttpServletResponse response) 
	  throws IOException {
		return (new PrintWriter(new GZIPOutputStream(response.getOutputStream())));		
	}
}
