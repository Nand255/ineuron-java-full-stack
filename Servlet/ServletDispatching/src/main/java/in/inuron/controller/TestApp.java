package in.inuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

  	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
  		System.out.println("controll in 1st servlet");
		PrintWriter out = response.getWriter();
		out.println("<h1>welcome to servlet</h1>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet2");
		dispatcher.forward(request, response);
  	}
}
