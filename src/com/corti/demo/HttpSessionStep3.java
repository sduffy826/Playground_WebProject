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
 * Servlet implementation class HttpSessionStep3
 */
@WebServlet("/HttpSessionStep3")
public class HttpSessionStep3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpSessionStep3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get email from the request data
		String email = request.getParameter("email");
        
		HttpSession session = request.getSession();
		
		// Put the email into the session object, then get the guestName
		// from the session object.
        session.setAttribute("email", email);
		String guestName = (String) session.getAttribute("guestName");
		
        response.setContentType("text/html");
        
		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>Example of HttpSession Step3</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<form name='frmHttpSessionStep3' action='DumpSessionDataOut' method='POST'>");	    
	    pw.println("<h3>HttpSession Step3, show session data</h3>");
	    pw.println("<hr />");
	    pw.println("<p>Hi " + guestName + " again</p>");
	    pw.println("<p>We can now spam you at: " + email +"</p>");
	    pw.println("<p><input type='text' name='maxInactive' value='3' /></p>");
	    // Write out the session in :)
	    DumpSessionInfo.toPrintWriter(session, pw);
	    
	    pw.println("<p><input type='submit' name='btnSubmit' value='Submit'/></p>");
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
