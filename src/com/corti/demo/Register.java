package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet(description = "Process registration form", urlPatterns = { "/Register" })
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Get parms by name
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		String country = request.getParameter("country");
		String[] languages = request.getParameterValues("languages");
		
        response.setContentType("text/html");		
		PrintWriter pw = response.getWriter();
		
		pw.println("<div>");
		pw.println("<p>User name: " + userName + "</p>");
		pw.println("<p>Password: " + passWord + "</p>");
		pw.println("<p>Gender: " + gender + "</p>");
		pw.println("<p>Hobbies:</p>");
		for (int i = 0; i < hobbies.length; i++) {
			pw.println(hobbies[i]+"<br />");
		}
		pw.println("<p>Country: " + country + "</p>");
		pw.println("<p>Languages Known</p>");
		for (int i = 0; i < languages.length; i++) {
			pw.println(languages[i]+"<br />");
		}
		pw.println("</div>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
