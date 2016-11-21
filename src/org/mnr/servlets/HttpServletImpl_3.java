package org.mnr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpServletImpl_3
 */
@WebServlet(
		urlPatterns = { "/HttpServletImpl_3_7" }, 
		initParams = { 
				@WebInitParam(name = "name", value = "naveen", description   = "my name"), 
				@WebInitParam(name = "id", value = "13123", description = "my id")	
		//either annotation init params or web.xml init params entries should be used. Both shouldn't be used to config init params
		//otherwise we will get null for init param values
		},
		loadOnStartup = -1,
        asyncSupported = true )

public class HttpServletImpl_3 extends HttpServlet {
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}

	@Override
	public ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return super.getServletContext();
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HttpServletImpl_3() {
    	System.out.println("HttpServletImpl_3 constructor called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    @Override
	public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	System.out.println("HttpServletImpl_3 constructor called at "+new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date()));
    
    	}
	
//	public ServletConfig getServletConfig(){
//		return 
//	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw	=	response.getWriter();
		String time	=	new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date());
		pw.println("Get Method called bro<br>");
		pw.println("<b>HttpServletImpl_3 called at "+time+" </b><br>");
		pw.println("req="+request.getParameter("req"));
		/**
		 * This is called when request method is not mentioned i.e., 
		 * default request method
		 * parameters are passed in the url and visible in the url so not secure
		 * Only ASCII characters allowed
		 * The size limit is dependent on both the server and the client used 
		  (and if applicable, also the proxy the server or the client is using).
		   Most webservers have a limit of 8192 bytes (8KB), which is usually 
		   configureable somewhere in the server configuration.
		   Normally 2kb to 8kb varies as mentioned above. 
		 * It is idompotent
		 * GET reqeusts don't have request body
		 * GET requests can be cached
		 * GET requests remain in the browser history
		 * GET requests can be bookmarked
		 * GET requests should never be used when dealing with sensitive data
		 * GET requests have length restrictions
		 * GET requests should be used only to retrieve data
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw	=	response.getWriter();
		String time	=	new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date());
		pw.println("Post Method called<br>");
		pw.println("<b>HttpServletImpl_3 called at "+time+" </b><br>");
		pw.println("req="+request.getParameter("req"));
		
		ServletConfig config=getServletConfig();
    	Enumeration<String> params=config.getInitParameterNames();
    	String name=config.getInitParameter("name");
    	System.out.println("name="+name);//used to retrieve web.xml init parameter
    	System.out.println("id="+getInitParameter("id"));//used to retrieve annototaed init params
		
    	ServletContext context	=	getServletContext();
    	System.out.println(context.getInitParameter("project"));
		/**
		 * Some imp notes about post method
		 * It has unlimited data limit
		 * No restrictions. Binary data is also allowed
		 * Parameters are sent in the request body hence not visible in the url
		 * It is not idompotent
		 * It is secure method
		 * POST requests are never cached
		 * POST requests do not remain in the browser history
		 * POST requests cannot be bookmarked
		 * POST requests have no restrictions on data length
		 * 
		 */
	}

//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
////		System.out.println("req="+request.getParameter("req"));
////		System.out.println("HttpServletImpl_3  service() called at "+new SimpleDateFormat("dd-mm-yyyy hh:mm24:ss.SSS").format(new Date()));
//		response.setContentType("text/html");
//		PrintWriter pw	=	response.getWriter();
//		String time	=	new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date());
//		pw.println("<b>HttpServletImpl_3 protected service called at "+time+" </b><br>");
//		pw.println("req="+request.getParameter("req"));
//	}

//	@Override
//	public void service(ServletRequest request, ServletResponse response)
//			throws ServletException, IOException {
//		
//		ServletConfig config=getServletConfig();
//    	Enumeration<String> params=config.getInitParameterNames();
//    	String name=config.getInitParameter("name");
//    	System.out.println("name="+name);//used to retrieve web.xml init parameter
//    	System.out.println("id="+getInitParameter("id"));//used to retrieve annototaed init params
//		
//    	ServletContext context	=	getServletContext();
//    	System.out.println(context.getInitParameter("project"));
//		
//		
//		response.setContentType("text/html");
//		PrintWriter pw	=	response.getWriter();
//		String time	=	new SimpleDateFormat("dd-MM-yyyy hh:mm24:ss.SSS").format(new Date());
//		pw.println("<b>HttpServletImpl_3 public service called at "+time+" </b><br>");
//		pw.println("req="+request.getParameter("req"));
//		/**
//		 * This method is of highest prioriy if all http methods are defined
//		 * like doGet,doPost etc
//		 * After this method, protected service method has the priority
//		 */
//	}

}
