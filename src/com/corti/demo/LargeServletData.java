package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LargeServletData
 */
@WebServlet(description = "Show outputing a huge html page", urlPatterns = { "/LargeServletData" })
public class LargeServletData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LargeServletData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html");	
		  
		  // Now we'll use a gzip if available
		  PrintWriter pw;
		  if (GzipUtility.isGzipSupported(request) && !GzipUtility.isGzipDisabled(request)) {
			 pw = GzipUtility.getGzipWriter(response);
			 response.setHeader("Content-Encoding", "gzip");  // tell browser we're giving it gzip
		  }
		  else {
		    pw = response.getWriter();
		  }
				
	      pw.println("<!Doctype HTML>");		
	      pw.println("<html><head>");
	      pw.println("<title>Show Request Headers</title>");
	      pw.println("</head>");
	      pw.println("<body>");
	      pw.println("<h1>Lotsa data</h1>");
	      
	      String dumLine = "Mary had a little lamb, her fleece was white as snow and everywhere that mary went a wolf would surely go, one day Mary couldn't go, the wolf had eaten her toes :(";
	      for (int i = 0; i < 10000; i++) {
	    	  pw.println(dumLine + "<br />");
	      }	      	      
	      pw.println("</body></html>");
	      pw.close();	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
