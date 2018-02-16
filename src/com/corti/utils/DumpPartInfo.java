package com.corti.utils;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.corti.demo.DumpSessionInfo;

public class DumpPartInfo {

	// Some static methods to dump out part information to the printwriter 
	// passed in... mainly for debugging	
	public static void toPrintWriter(Part part, PrintWriter pw) {
		pw.println("<h4>Part Attributes</h4>");
		
		DumpPartInfo.dumpString("getContentType", part.getContentType(), pw);
		
		Collection<String> headerNames = part.getHeaderNames();
		for (String header : headerNames) {
		  DumpPartInfo.dumpString("getHeader(" + header + ")",
				  part.getHeader(header), pw);
		}
		
		DumpPartInfo.dumpString("getName",  part.getName(), pw);
		
		DumpPartInfo.dumpString("getSize",Long.toString(part.getSize()), pw);
		
		DumpPartInfo.dumpString("getSubmittedFileName",  part.getSubmittedFileName(), pw);
	}
	public static void dumpString(String msg, String theString, PrintWriter pw) {
		pw.println("<p>" + msg+" : " + theString + "</p>");
	}
	public static String date2String(long theDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss:SSSSSS");
		Date dumDate = new Date(theDate);
		return sdf.format(dumDate);
	}



}
