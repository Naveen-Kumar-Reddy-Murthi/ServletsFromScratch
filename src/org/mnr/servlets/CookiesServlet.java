package org.mnr.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookiesServlet
 */
@WebServlet("/cookiesServlet")
public class CookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			Cookie c1,c2,c3,c4; 
			//default max age is -1
			//in memory, cookies are available only to current browsing session
			//cookies are only valid for one hour regardless whether user quits, closes the browser or shuts down the computer
			c1= new Cookie("name", "naveen");
			c2= new Cookie("id", "13123");
			c3= new Cookie("Dept", "GCC");
			c4= new Cookie("City", "Noida");
			
			c3.setMaxAge(3600);
			c4.setMaxAge(3600);
			
			response.addCookie(c1);
			response.addCookie(c2);
			response.addCookie(c3);
			response.addCookie(c4);
			
			PrintWriter pw	=	response.getWriter();
			
			pw.print("cookies are set");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
