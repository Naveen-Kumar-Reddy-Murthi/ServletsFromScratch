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
 * Servlet implementation class SessionTracker1
 */
@WebServlet("/sessionTracker1")
public class SessionTracker1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTracker1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw =	response.getWriter();
		String name	   =	request.getParameter("name");
		String id	   =	request.getParameter("id");
		String dept	   =	request.getParameter("dept");
		String domain  =	request.getParameter("domain");
		String email   = 	request.getParameter("email");
		String location=	request.getParameter("loc");
		String processTime	=	new SimpleDateFormat("DD-MM-YYYY hh:mm:ss.SSS").format(new Date()).toString();
		
		HttpSession session	=	request.getSession(true);
		Cookie	cookie =	new Cookie("sessionId",processTime+session.getId()+System.nanoTime());
		
		response.addCookie(cookie);
//		System.out.println(cookie.getName()+":"+cookie.getValue());
		session.setAttribute("name", name);
		session.setAttribute("id", id);
		session.setAttribute("dept", dept);
		session.setAttribute("domain", domain);
		session.setAttribute("email", email);
		session.setAttribute("loc", location);
		
		pw.println("<b>Skills</b>");
		pw.println("<form action="+response.encodeURL("sessionTracker2")+" >");
		pw.println("<table align=\"center\">");
		pw.println("<tr><td>Current CTC:</td><td><input type=\"text\" name=\"cctc\"></td></tr>");
		pw.println("<tr><td>Expected CTC:</td><td><input type=\"text\" name=\"ectc\"></td></tr>");
		pw.println("<tr><td>Preffered Location :</td><td><input type=\"text\" name=\"ploc\"></td></tr>");
		pw.println("<input type=\"hidden\" name=\"ptime\" value="+processTime+">");
		pw.println("<td><input type=\"submit\" name=\"submit\"></td>");
		pw.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
