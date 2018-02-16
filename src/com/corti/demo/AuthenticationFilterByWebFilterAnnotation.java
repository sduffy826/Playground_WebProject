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
@WebFilter(filterName="AutenticateWithAnnotation",
           urlPatterns={"/ServletAnnotationsExample","/Annotations"},
           servletNames="ResponseHeaderCoolStuff")
public class AuthenticationFilterByWebFilterAnnotation implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilterByWebFilterAnnotation() {
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
		
		String parm = request.getParameter("parm");
		String ipAddress = request.getRemoteAddr();  // Just to show how
		
		if (!(parm == null) && (parm.equals("foof"))) {
			System.out.println("User logged in from " + ipAddress + " at " + new Date().toString());
			chain.doFilter(request, response); // Pass control 
		}
		else {
			PrintWriter pw = response.getWriter();
			pw.println("<h3>Sorry must pass parm=foof to continue</h3>");
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
