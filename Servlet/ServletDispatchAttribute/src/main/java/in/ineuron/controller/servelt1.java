package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class servelt1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("controll in servlet 1");
		
		PrintWriter out = response.getWriter();
		request.setAttribute("nand", "ajp");
		request.setAttribute("harsh" ,"java");
		
		RequestDispatcher reqDisp = request.getRequestDispatcher("/servlet2");
		reqDisp.forward(request, response);
	}
}
