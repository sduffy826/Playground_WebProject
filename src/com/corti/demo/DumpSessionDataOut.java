package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HttpSessionStep4
 */
@WebServlet("/DumpSessionDataOut")
public class DumpSessionDataOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DumpSessionDataOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String interval = request.getParameter("maxInactive").trim();
		HttpSession session = request.getSession();
		if (interval.length() > 0) {
		   session.setMaxInactiveInterval(Integer.parseInt(interval));
		}		
		
        response.setContentType("text/html");
        
		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>Dump out all the session info</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    
	    pw.println("<h3>Dump Session Data Out - show session data</h3>");
	    pw.println("<hr />");
	    
	    // Write out the session in :)
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
