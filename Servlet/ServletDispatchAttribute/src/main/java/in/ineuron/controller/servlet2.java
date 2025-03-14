package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("controll in servlet 2");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Attribute Data</title></head>");
		out.println("<center>");
		out.println("<h1 style='color:magenta;'>Printing Attributes...</h1>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th>AttributrName</th><th>value</th></tr>");
		Enumeration<String> attributeNames = request.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue = request.getAttribute(attributeName);
			out.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");	
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</center>");
		out.println("</html>");
	}
}
