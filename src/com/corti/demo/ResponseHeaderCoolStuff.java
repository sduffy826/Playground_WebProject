package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponseHeaderCoolStuff
 */
@WebServlet(description = "Show's how tweaking response can do cool stuff", urlPatterns = { "/ResponseHeaderCoolStuff" })
public class ResponseHeaderCoolStuff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResponseHeaderCoolStuff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Cool stuff, now the browser will open it with excel
		response.setContentType("application/vnd.ms-excel");	
		PrintWriter pw = response.getWriter();
		pw.println("Sean\tDuffy\t165 Canterbury Drive\tRamsey\tNJ\t07446");
		pw.println("Mary\tFluffer\t201 Dogwood Ct\tMahwah\tNJ\t07430");
		pw.println("Peter\tCrust\t9 Oxford Lane\tGlen Rock\tCA\t20921");
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
