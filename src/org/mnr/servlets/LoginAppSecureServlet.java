package org.mnr.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginAppSecureServlet
 */
@WebServlet("/loginAppSecureServlet")
public class LoginAppSecureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAppSecureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub loginAppSecureServlet
		HttpSession session	=	request.getSession(true);
		
		String name=request.getParameter("name");
		String pass=request.getParameter("password");
		if("admin".equals(name)&&"admin".equals(pass)){
			session.setAttribute("loggedin", "ok");
			String up=(String) session.getAttribute("target");
			RequestDispatcher rd	= request.getRequestDispatcher(up);
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd	= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
