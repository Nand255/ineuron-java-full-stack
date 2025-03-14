package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/valid")
public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("controll in servlet");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(userName+" "+password);
		
		if (userName.equals("nand") && password.equals("1234")) {
			RequestDispatcher reqDisp = request.getRequestDispatcher("/home.jsp");
			reqDisp.forward(request, response);
		} else {
			//request dispatcher using Servlet context
			ServletContext context = request.getServletContext();
			RequestDispatcher reqDisp = context.getRequestDispatcher("/error.jsp");
			reqDisp.forward(request, response);
		}
		
	}

}
