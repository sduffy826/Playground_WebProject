package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAnnotationsExample
 */
//@WebServlet("/ServletAnnotationsExample")  // Same as @WebServlet(value="/xxxx")
@WebServlet(name = "HelloAnnotations",
            description = "Demo Annotations",
            urlPatterns = {"/ServletAnnotationsExample", 
            		       "/Annotations",
            		       "/HiAnnotations"},
            initParams = {@WebInitParam(name="support", value="Sean Duffy"),
            		     @WebInitParam(name="supportPhone", value="555-1212")})
public class ServletAnnotationsExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAnnotationsExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		PrintWriter pw = response.getWriter();
		pw.println("<!Doctype HTML>");
		pw.println("<html><head>");
		
		pw.println("<title>Servlet Annotations Example</title>");
		pw.println("</head>");
		pw.println("<body>");
	    String supportPerson = getServletConfig().getInitParameter("support");
	    String supportPhone = getServletConfig().getInitParameter("supportPhone");
		pw.println("<p>Hi Mom!  if you have any problems please feel free");
		pw.println("to call " + supportPerson + " at " + supportPhone+" </p>");
		
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
