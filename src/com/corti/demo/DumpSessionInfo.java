package com.corti.demo;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;

public class DumpSessionInfo {
	
	// Some static methods to dump out session information to the printwriter 
	// passed in... mainly for debugging	
	public static void toPrintWriter(HttpSession session, PrintWriter pw) {
		pw.println("<h4>Attributes</h4>");
		Enumeration<String> attributes = session.getAttributeNames();
	    while (attributes.hasMoreElements()) {
		  String attrName = attributes.nextElement();
		  String attrValue = session.getAttribute(attrName).toString();
		  //headerValue == null ) ? "" : headerValue;
	      pw.println("<p>"+attrName+":"+attrValue+"</p>");
		}
	    
	    pw.println("<h4>Properties</h4>");
	    DumpSessionInfo.dumpString("SessionId", session.getId(), pw);
	    DumpSessionInfo.dumpString("getCreationTime",
	    		    DumpSessionInfo.date2String(session.getCreationTime()),
	    		    pw);
	    DumpSessionInfo.dumpString("getLastAccessedTime",
    		    DumpSessionInfo.date2String(session.getLastAccessedTime()),
    		    pw);
	    DumpSessionInfo.dumpString("getMaxInactiveInterval",
    		    Integer.toString(session.getMaxInactiveInterval()),
    		    pw);
	    DumpSessionInfo.dumpString("isNew",
    		    (session.isNew() ? "true" : "false"),
    		    pw);
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
