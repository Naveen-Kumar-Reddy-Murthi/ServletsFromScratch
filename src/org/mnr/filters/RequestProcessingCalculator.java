package org.mnr.filters;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RequestProcessingCalculator
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, /*urlPatterns = { "/RequestProcessingCalculator"*/
					servletNames= {"LoginServlet"})
public class RequestProcessingCalculator implements Filter {

    /**
     * Default constructor. 
     */
    public RequestProcessingCalculator() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		System.out.println("Requested Resource::"+uri);
		
		long beforeProcessing	=	System.currentTimeMillis();
		chain.doFilter(request, response);
		long afterProcessing	=	System.currentTimeMillis();
		context.log("Take taken for processing "+(afterProcessing-beforeProcessing)+" milliseconds");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config=fConfig;
		this.context=fConfig.getServletContext();
		
		context.log("RequestProcessingCalculator filter initialized");
	}
	private FilterConfig config;
	private ServletContext context;
}
