package com.corti.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowHeaderInfo
 */
@WebServlet(description = "Show the header info", urlPatterns = { "/ShowHeaderInfo" })
public class ShowHeaderInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHeaderInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  System.out.println("in doGet of showHeaderInfo");
	  
	  response.setContentType("text/html");		
	  PrintWriter pw = response.getWriter();
			
      pw.println("<!Doctype HTML>");		
      pw.println("<html><head>");
      pw.println("<title>Show Request Headers</title>");
      pw.println("</head>");
      pw.println("<body>");
      pw.println("<h1>All Request Headers</h1>");
      
      pw.println("<p><b>Request Method:</b> " +request.getMethod());
      pw.println("<p><b>Request URI:</b> " +request.getRequestURI());
      pw.println("<p><b>Request Protocol:</b> " +request.getProtocol());
      
      System.out.println("just before the getBody call");
      pw.println("<br/><p><b>Body:</b> " + this.getBody(request));
        
      
      Enumeration<String> headers = request.getHeaderNames();
      while (headers.hasMoreElements()) {
			String headerName = headers.nextElement();
			String headerValue = request.getHeader(headerName);
			//headerValue == null ) ? "" : headerValue;
			pw.println("<p>"+headerName+":"+headerValue+"</p>");
		}
      
      
      pw.println("</body></html>");
      pw.close();
	}

	// Get the body of the request and return it as a string
	private String getBody(HttpServletRequest request) throws IOException {
	  System.out.println("in getBody call");
	  String body = null;
	  StringBuilder stringBuilder = new StringBuilder();
	  BufferedReader bufferedReader = null;
	  try {
	    System.out.println("in try block");
	    InputStream inputStream = request.getInputStream();
	    if (inputStream != null) {
	      System.out.println("in if block1");
	      bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	      char[] charBuffer = new char[128];
	      int bytesRead = -1;
	      while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
	        stringBuilder.append(charBuffer, 0, bytesRead);
	      }
	    }
	    else {
	      stringBuilder.append("");
	    }
	  }
	  catch (IOException e) {
	    throw e;
	  }
	  finally {
	    if (bufferedReader != null) {
	      try {
	        bufferedReader.close();
	      }
	      catch (IOException e) {
	        throw e;
	      }
	    }
	  }
	  body = stringBuilder.toString();
	  System.out.println("Bodi is: " + body);
	  return body;
	}
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
