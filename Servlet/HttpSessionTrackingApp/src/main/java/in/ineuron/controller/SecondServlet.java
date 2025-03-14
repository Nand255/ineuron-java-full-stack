package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//collect request parameter data
		
		String qual = request.getParameter("qual");
		String design = request.getParameter("design");
	
		//creating a session object and store these request parameter data in session object
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("qual", qual);
		httpSession.setAttribute("design", design);
		
		//forward the response to form2.html
		RequestDispatcher rd = request.getRequestDispatcher("/form3.html");
		rd.forward(request, response);
		
	}

}
