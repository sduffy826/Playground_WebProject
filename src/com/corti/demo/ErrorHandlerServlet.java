package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandlerServlet
 */
@WebServlet("/ErrorHandlerServlet")
public class ErrorHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the different error attributes we'll then show them to the user		
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String errorMessage = (String) request.getAttribute("javax.servlet.error.message");
		String requestURI = (String) request.getAttribute("javax.servlet.error.request_uri");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>Error Handler</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<h3>Error Page</h3>");
	    pw.println("<hr />");
	    pw.println("<p>Status code: " + statusCode.toString() + "</p>");
	    pw.println("<p>Error message: " + errorMessage + "</p>");
	    pw.println("<p>Request URI: " + requestURI + "</p>");
	    pw.println("<p>Servlet name: " + servletName + "</p>");
	    	    
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
