package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AutoPageRefresh
 */
@WebServlet("/AutoPageRefresh")
public class AutoPageRefresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoPageRefresh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		response.setIntHeader("Refresh", 3);  // Want page to refreesh every 3 seconds
		
		PrintWriter pw = response.getWriter();
		
		// Have varabiel for date/time
		Date currentDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("E dd-MM-yyyy 'at' hh:mm:ss a");
		String currentDateAndTime = sdf.format(currentDate);
		
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>Auto Page Refresh</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<h1>Lotsa data</h1>");
	    
	    pw.println("<p>Page last refreshed at " + currentDateAndTime + "</p>");
	    
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
