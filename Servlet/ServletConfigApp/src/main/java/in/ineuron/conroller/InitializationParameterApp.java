package in.ineuron.conroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitializationParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<center style='color:red; text-align:center;'><h1>Initialization Parameter</h1></center> <hr/>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><td>Parameter-Name</td><td>Parameter-Value</td></tr>");
		Enumeration<String> parameterNames = getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String ParameterName = (String) parameterNames.nextElement();
			String value = getInitParameter(ParameterName);
			out.println("<tr><td>"+ParameterName+"</td><td>"+value+"</td></tr>");
		}
		out.println("</table>");

		out.close();
	
	}

}
