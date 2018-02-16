package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet(description = "Gets user info", urlPatterns = { "/UserInfoServlet" })
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
				
		// Get parms by name
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		pw.println("<h3>Reading data from QueryString using 'request.getParameter(..)'</h3>");
		pw.println("<div>");
		pw.println("<p>First name: " + firstname + "</p>");
		pw.println("<p>Last name: " + lastname + "</p>");
		pw.println("</div>");
		
		// Use parameter enumeration
		pw.println("<h3>Reading data from QueryString using 'request.getParameterNames()'</h3>");
		Enumeration<String> parms = request.getParameterNames();
		while (parms.hasMoreElements()) {
			String aParm = parms.nextElement();
			String aParmValue = request.getParameter(aParm);
			pw.println("<p>"+aParm+":"+aParmValue+"</p>");
		}
		
		// Get parms using a map object
		Map<String, String[]> parmMap = request.getParameterMap();
		Set<String> parmNameSet = parmMap.keySet();
		pw.println("<h3>Reading data from QueryString using 'request.getParameterMap()'</h3>");
		pw.println("<div>");
		for (String parmName : parmNameSet) {
			String[] parmValues = parmMap.get(parmName);
			pw.println("<p>" + parmName);
			for (int i = 0; i < parmValues.length; i++) {
				pw.println(parmValues[i]);
			}
			pw.println("</p>");
		}
		pw.println("</div>");
		
		pw.append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
