package com.corti.demo;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class WriteParameters {
	
	public static void dumpParms(HttpServletRequest request, PrintWriter pw) {
		
		Enumeration<String> parms = request.getParameterNames();
	    while (parms.hasMoreElements()) {
		  String parmName = parms.nextElement();
		  String parmValue = request.getParameter(parmName);
		  //headerValue == null ) ? "" : headerValue;
	      pw.println("<p>"+parmName+":"+parmValue+"</p>");
		}	
		
	}
}
