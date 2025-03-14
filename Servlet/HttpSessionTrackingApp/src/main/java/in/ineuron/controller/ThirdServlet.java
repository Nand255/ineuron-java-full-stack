package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//collect request parameter data
		String mail = request.getParameter("mail");
		String mobile = request.getParameter("mobile");
	
		//creating a session object and store these request parameter data in session object
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("email", mail);
		httpSession.setAttribute("mobile", mobile);		
	
		// retrieve the data from session object
		Object name = httpSession.getAttribute("name");
		Object age = httpSession.getAttribute("age");
		Object qual = httpSession.getAttribute("qual");
		Object design = httpSession.getAttribute("design");
		Object email = httpSession.getAttribute("email");
		Object emobile = httpSession.getAttribute("mobile");
		
		// create a html page take data from session object and then send the response
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<center>");
		out.println("<table border='1'>");
		out.println("<tr><td>NAME</td><td>"+name+"</td></tr>");
		out.println("<tr><td>AGE</td><td>"+age+"</td></tr>");
		out.println("<tr><td>QUAL</td><td>"+qual+"</td></tr>");
		out.println("<tr><td>DESIGN</td><td>"+design+"</td></tr>");
		out.println("<tr><td>EMAIL</td><td>"+email+"</td></tr>");
		out.println("<tr><td>MOBILE</td><td>"+emobile+"</td></tr>");
		out.println("</table>");
		out.println("</center>");

		out.close();
	}

}
