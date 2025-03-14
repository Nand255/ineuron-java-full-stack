package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String depName = request.getParameter("depName");
		String depAmount = request.getParameter("depAmount");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("depName", depName);
		session.setAttribute("depAmount", depAmount);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head>Deposit Form</head></html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red;'>Detail About Transection..</h1>");
		out.println("<table>");
		out.println("<tr><th>NAME</th><th>VALUE</th></tr>");
		Enumeration<String> attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributName = (String) attributeNames.nextElement();
			Object attributeValue = request.getAttribute(attributName);
			out.println("<tr>");
			out.println("<td>"+attributName+"</td><td>"+attributeValue+"</td>");
			out.println("</tr>");
		}
		
		out.println("<table>");
		out.println("</center>");
		out.println("</body>");
		
		out.close();
	}

}
