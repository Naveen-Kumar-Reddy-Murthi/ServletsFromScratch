package org.mnr.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/login"},
			name="LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw	=	response.getWriter();
		response.setContentType("text/html");
		
		
		String name= request.getParameter("uname");
		String pswd= request.getParameter("password");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(name.equals(pswd))
		{
			RequestDispatcher rd1	=	request.getRequestDispatcher("header");
			//header is a servlet url, this forward this request as it is to Header servlet 
			rd1.include(request, response);
			RequestDispatcher rd2	=	request.getRequestDispatcher("validLogin");
			rd2.include(request, response);
		}
		else{
			RequestDispatcher rd2	=	request.getRequestDispatcher("header");
			rd2.include(request, response);
			RequestDispatcher rd3	=	request.getRequestDispatcher("invalidLogin");
			rd3.forward(request, response);
			
		}
		RequestDispatcher rd1	=	request.getRequestDispatcher("Footer.html");
		rd1.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
