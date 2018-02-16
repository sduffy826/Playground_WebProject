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
 * Servlet implementation class GuestBookStep3
 */
@WebServlet("/GuestBookStep3")
public class GuestBookStep3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBookStep3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String guestName = "";
		Cookie[] userData = request.getCookies();
		for (int i = 0; i < userData.length; i++) {
			if (userData[i].getName().equalsIgnoreCase("gName")) {
				guestName = userData[i].getValue();
			}
		}		
		guestName = URIHelper.deCodeIt(guestName);
		
        response.setContentType("text/html");
		
        // Store the guestName in a cookie
        Cookie emailCookie = new Cookie("email",email);
        emailCookie.setComment("Keep email address");
        // emailCookie.setMaxAge(60);  Don't want persistent
        response.addCookie(emailCookie);        
        
		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>Example of Cookies for Session Data</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    
	    pw.println("<h3>Guest Book Step3, shows cookie :)</h3>");
	    pw.println("<hr />");
	    pw.println("<p>Hi " + guestName + " again</p>");
	    pw.println("<p>We can now spam you at: " + email +"</p>");
	    	    	    
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
