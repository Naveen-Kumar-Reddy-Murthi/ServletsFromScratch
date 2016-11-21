package org.mnr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class GenericServletImpl_2
 */
@WebServlet("/GenericServletImpl_2_7")
public class GenericServletImpl_2 extends GenericServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see GenericServlet#GenericServlet()
     */
    public GenericServletImpl_2() {
    	System.out.println("GenericServletImpl_2 constructor called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("GenericServletImpl_2 init called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("GenericServletImpl_2 destroy called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
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
		return null; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		System.out.println("req="+request.getParameter("req"));
//		System.out.println("GenericServletImpl_2 service() called at "+new SimpleDateFormat("dd-mm-yyyy hh:mm24:ss.SSS").format(new Date()));
		response.setContentType("text/html");
		PrintWriter pw	=	response.getWriter();
		String time	=	new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date());
		pw.println("<b>GenericServletImpl_2 called at "+time+" </b><br>");
		pw.println("req="+request.getParameter("req"));
	}

}
