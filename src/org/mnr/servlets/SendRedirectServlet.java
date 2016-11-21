package org.mnr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendRedirectServlet
 */
@WebServlet("/sendRedirectServlet")
public class SendRedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendRedirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String browser	=	request.getParameter("se");
		String query	=	request.getParameter("query");
		StringBuilder url = new StringBuilder();
		
		if("Google".equals(browser)){
			url.append("http://www.google.co.in/search?q=")
			   .append(query);
		}
		else if("Yahoo".equals(browser)){
			url.append("http://search.yahoo.com/search?q=")
			   .append(query);
		}
		else if("Bing".equals(browser)){
			url.append("http://www.bing.com/search?q=")
			   .append(query);
		}
		
		response.sendRedirect(url.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
