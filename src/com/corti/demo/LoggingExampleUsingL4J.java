package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class LoggingExampleUsingL4J
 */
@WebServlet(
		description = "Logging examp", 
		urlPatterns = { 
				"/LoggingExampleUsingL4J", 
				"/LoggingExample"
		})
public class LoggingExampleUsingL4J extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Logger logger = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoggingExampleUsingL4J() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parm = request.getParameter("parm");
		
		/* - Comment the context logger out for now
		// This shows using the context
		ServletContext context = getServletContext();
		
		// Show logging based on existance of parm passed, just for fun :)
		if (parm == null || parm.equals("")) {
			context.log("No parm",new IllegalStateException("No parm passed"));
		}
		else {
			context.log("Thanks for passing parm: " + parm);			
		}				
		*/
		
		/**
		 * This shows how to use log4j2
		 * 1) Create instance variable for the class, we'll init in doGet
		 */
		logger = LogManager.getLogger(LoggingExampleUsingL4J.class); //LoggingExampleUsingL4J.class);
		logger.info("Log Info: in doGet() method");
		
		// Just showing how can user logger that's defined in config, only made one call
		// so don't need to save instance of logger that it's returning.
		LogManager.getLogger("com.corti.errorOnly").error("This is an error record");
				
        response.setContentType("text/html");
		        
		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");		
	    pw.println("<html><head>");
	    pw.println("<title>Logger Example</title>");
	    pw.println("</head>");
	    pw.println("<body>");
	    pw.println("<h3>Logger Example</h3>");
	    pw.println("<hr />");
	    pw.println("<p>If this page is invoked without passing a parm");
	    pw.println("then an exception is thrown, otherwise parm is written");
	    pw.println("to log</p>");
	    pw.println("Class executed: " + this.getClass());
	    logger.info("Creating response document");
	    
	    if (parm == null || parm.equals("")) {
	    	pw.println("<p><strong>Please</strong> pass a 'parm' here</p>");
			logger.error("No parm");
		}
		else {
			pw.println("<p><strong>Thanks for giving me</strong> " + parm + "</p>");
			logger.warn("Got parm setting warnging message");			
		}	    
	    
	    pw.println("<p>Logger name: " + logger.getName());
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
