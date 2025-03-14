package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		//collect request parameter
		String man_date = request.getParameter("man_date");
		String exp_date = request.getParameter("exp_date");
		
		//collect the cookies from the request object
		Cookie[] cookies = request.getCookies();
		int length = cookies.length;
		System.out.println(length);
		String pid = cookies[0].getValue();
		String pname = cookies[2].getValue();
		String pcost = cookies[3].getValue();
		String pquantity = cookies[1].getValue();
	
		//sending the response through html page
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><th>Product ID</th><td>"+pid+"</td></tr>");
		out.println("<tr><th>Product NAME</th><td>"+pname+"</td></tr>");
		out.println("<tr><th>Product COST</th><td>"+pcost+"</td></tr>");
		out.println("<tr><th>Product QUANTITY</th><td>"+pquantity+"</td></tr>");
		out.println("<tr><th>Product MANUFACTURE DATE</th><td>"+man_date+"</td></tr>");
		out.println("<tr><th>Product EXPIRY DATE</th><td>"+exp_date+"</td></tr>");
		out.println("</table>");
		out.println("</center>");
		
		out.close();
	}

}
