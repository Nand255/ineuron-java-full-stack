package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderServlet1
 */
@WebServlet("/test")
public class RequestHeaderServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red; text-align:center;'>Request header Information...</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>header Name</th><th>Header Value</th></tr>");
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			out.println("<tr>");
			String headerName = (String) headerNames.nextElement();
			String value = request.getHeader(headerName);
			out.println("<td>"+headerName+"</td>");
			out.println("<td>"+value+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("<center>");
		out.println("</body>");
		out.close();
	}
	

}
