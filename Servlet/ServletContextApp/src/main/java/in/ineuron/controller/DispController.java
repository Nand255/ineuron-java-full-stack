package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:green; text-align:center'>CONTEXT PARAMATER INFORMATION</h1>");
		out.println("<table border='1'>");
		out.println("<tr><th>ContextParameter</th><th>ParameterValue</th></tr>");
		ServletContext context = getServletContext();
		Enumeration<String> parameterNames = context.getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramaterName = (String) parameterNames.nextElement();
			String value = context.getInitParameter(paramaterName);
			out.println("<tr><td>"+paramaterName+"</td><td>"+value+"</td></tr>");
		}
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
	}

}
