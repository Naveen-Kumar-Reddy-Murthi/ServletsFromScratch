package org.mnr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ServletInterfaceImpl
 */
@WebServlet("/ServletInterfaceImpl_1_7")
public class ServletInterfaceImpl_1 implements Servlet {

    /**
     * Default constructor. 
     */
    public ServletInterfaceImpl_1() {
       System.out.println("ServletInterfaceImpl constructor called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("ServletInterfaceImpl init called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("ServletInterfaceImpl destroy called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "crap"; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//			System.out.println("req="+request.getParameter("req"));
//			System.out.println("ServletInterfaceImpl service() called at "+new SimpleDateFormat("dd-mm-yyyy hh:mm24:ss.SSS").format(new Date()));
			response.setContentType("text/html");
			PrintWriter pw	=	response.getWriter();
			String time	=	new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date());
			pw.println("<b>ServletInterfaceImpl called at "+time+" </b><br>");
			pw.println("req="+request.getParameter("req"));
			
		/**
		 * Important points regarding this impl
		 * 1. We only need to override service method while implementing javax.servlet.Servlet(I)
		 * @WebServlet annotation and web.xml entry both are supported. But urls should not be same
		 * otherwise container will not start. Urls of web.xml entry and WebServlet entry should be 
		 * different and both will work without any issues. To verify this, enter following urls.
		 * Both will work
		 * http://localhost:8080/ServletsFromScratch/ServletInterfaceImpl_1_7?req=ServletInterfaceImpl_1_7
		 * http://localhost:8080/ServletsFromScratch/ServletInterfaceImpl_1?req=ServletInterfaceImpl_1
		 * disAdv:
		 * This impl has only one method i.e., service() which is not designed
		 * according to Internet protocols like http/https
		 * service method doesn't allow to implement separate logics for get and 
		 * post method requests. So it is not recommended to use this impl
		 */
	}

}
