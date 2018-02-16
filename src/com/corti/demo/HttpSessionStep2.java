package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionStep2
 */
@WebServlet("/HttpSessionStep2")
public class HttpSessionStep2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpSessionStep2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String guestName = request.getParameter("guestName");
        response.setContentType("text/html");

        // Get the session object
        HttpSession session = request.getSession();
        session.setAttribute("guestName", guestName);
                
		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>HttpSession Example</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<form name='frmHttpSessionStep2' action='HttpSessionStep3' method='POST'>");
	    pw.println("<h3>Guest Book Step2</h3>");
	    pw.println("<hr />");
	    pw.println("<p>Hi " + guestName + " enjoy our site</p>");
	    pw.println("<p>Enter email: </p>");
	    pw.println("<p><input type='text' name='email'/></p>");
	    pw.println("<p><input type='submit' name='btnSubmit' value='Submit'/></p>");
	    
	    // Call utility method to dump all the session information out
	    DumpSessionInfo.toPrintWriter(session, pw);
	    	    
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
