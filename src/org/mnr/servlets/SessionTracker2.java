package org.mnr.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTracker2
 */
@WebServlet("/sessionTracker2")
public class SessionTracker2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTracker2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw	=	response.getWriter();
		Cookie[]	ck	=	request.getCookies();
		
		HttpSession session	 =	request.getSession(false);
		
		String name	  		 =	(String) session.getAttribute("name");
		String id	  		 =	(String) session.getAttribute("id");
		String dept	  		 =	(String) session.getAttribute("dept");
		String domain 		 =	(String) session.getAttribute("domain");
		String email  		 = 	(String) session.getAttribute("email");
		String location		 =	(String) session.getAttribute("loc");
		String processTime	 =	 request.getParameter("ptime");
		String cCTC			 =	 request.getParameter("cctc");
		String eCTC	 		 =	 request.getParameter("ectc");
		String pLOC			 =	 request.getParameter("ploc");
		String sessionId	 = 		null;
		for(Cookie cks: ck){
			System.out.println(cks.getName()+":"+cks.getValue());
			if("sessionId".equalsIgnoreCase(cks.getName()))
				sessionId=cks.getValue();
		}

		pw.println("<table title=\"Employee Details\">");
		pw.println("<tr><td>Name:</td><td>"+name+"</td></tr>");
		pw.println("<tr><td>Id:</td><td>"+id+"</td></tr>");
		pw.println("<tr><td>Dept:</td><td>"+dept+"</td></tr>");
		pw.println("<tr><td>Domain:</td><td>"+domain+"</td></tr>");
		pw.println("<tr><td>Email:</td><td>"+email+"</td></tr>");
		pw.println("<tr><td>Location:</td><td>"+location+"</td></tr>");
		pw.println("<tr><td>sessionId:</td><td>"+sessionId+"</td></tr>");
		pw.println("<tr><td>Hidden Value:</td><td>"+processTime+"</td></tr>");
		pw.println("<tr><td>CCTC:</td><td>"+cCTC+"</td></tr>");
		pw.println("<tr><td>ECTC:</td><td>"+eCTC+"</td></tr>");
		pw.println("<tr><td>PLOC:</td><td>"+pLOC+"</td></tr>");
		pw.println("</table>");
		
		session.invalidate();//invalidating the session. It will no longer be available
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
