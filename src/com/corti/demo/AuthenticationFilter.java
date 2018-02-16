package com.corti.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AuthenticationFilter
 */
@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// Output message on server console
		System.out.println("destroy method called in " + this.getClass().getName());
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter method called in " + this.getClass().getName());
		
		String userName = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String ipAddress = request.getRemoteAddr();
		
		if (userName.equals("sduffy") && passwd.equals("foof")) {
			System.out.println("User logged in from " + ipAddress + " at " + new Date().toString());
			chain.doFilter(request, response); // Pass control 
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.println("<h3>Sorry you are not allowe here, please depart</h3>");
			pw.close();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init method called in " + this.getClass().getName());
	}

}
