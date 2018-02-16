package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuestBookStep2
 */
@WebServlet("/GuestBookStep2")
public class GuestBookStep2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBookStep2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
        response.setContentType("text/html");
		
        String uriGuestName = URIHelper.enCodeIt(guestName);
        // Store the guestName in a cookie
        Cookie guestNameCookie = new Cookie("gName",uriGuestName);
        // guestNameCookie.setComment("Testing cookies :)");
        // guestNameCookie.setMaxAge(60);  Don't need it to be persistent
        response.addCookie(guestNameCookie);
        
        
		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>Error Handler</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<form name=\"frmGuestBook2\" action=\"GuestBookStep3\" method=\"POST\">");
	    pw.println("<h3>Guest Book Step2</h3>");
	    pw.println("<hr />");
	    pw.println("<p>Hi " + guestName + " enjoy our site</p>");
	    pw.println("<p>Enter email: </p>");
	    pw.println("<p><input type=\"text\" name=\"email\"/></p>");
	    pw.println("<p><input type=\"submit\" name=\"btnSubmit\" value=\"Submit\"/></p>");
	    	    	    
	    pw.println("</body></html>");
	    pw.close();			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
