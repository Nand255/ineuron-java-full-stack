package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class AttributeDataApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();													
		ServletContext context = getServletContext();
		context.setAttribute("username", "root");
		context.setAttribute("password", "2525");
		
		out.println("<html>");
		out.println("<head><title>Attribute Data</title></head>");
		out.println("<center>");
		out.println("<h1 style='color:magenta;'>Dynamic information in ApplicationScope/ContextScope...</h1>");
		out.println("<body>");
		out.println("<table border='1'>");
		out.println("<tr><th>AttributrName</th><th>value</th></tr>");
		
		Enumeration<String> attributeNames = context.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attributeName = (String) attributeNames.nextElement();
			Object attributeValue = context.getAttribute(attributeName);
			out.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</center>");
		out.println("</html>");
		out.close();
	}

}
