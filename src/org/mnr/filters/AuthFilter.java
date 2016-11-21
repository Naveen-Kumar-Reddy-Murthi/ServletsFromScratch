package org.mnr.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					/*, urlPatterns = { "/firstFilter" }*/,
					  servletNames= {"LoginServlet"}
			/**
			 * between urlPatterns and servletNames, either one is mandatory
			 * while creating FilterChain object, url patterns are loaded first
			 * so if order is important, we must be careful
			 * with same tags, these can be defined in web.xml files
			 * 
			 * A url/servlet can have any number of filters.
			 */
		)
public class AuthFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFilter() {
        System.out.println("First Filter object created");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		 System.out.println("First Filter object created");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req =(HttpServletRequest)request;
		
		String name= request.getParameter("uname");
		String pwd = request.getParameter("password");
		context.log("uname:"+name);
		context.log("pwd"+pwd);
		if(name.equals(pwd)){
		  chain.doFilter(request, response);
		
		}
		  else
		{
			RequestDispatcher rd =context.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.context=fConfig.getServletContext();
		this.config=fConfig;
		context.log("First Filter is initialized");
	}
	
	private ServletContext context;
	private FilterConfig   config;
}
