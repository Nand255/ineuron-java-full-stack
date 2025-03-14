package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accType = request.getParameter("accType");
		String accBranch = request.getParameter("accBranch");
		
		HttpSession session = request.getSession(false);
		session.setAttribute("accNo", accType);
		session.setAttribute("accName", accBranch);
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head>Deposit Form</head></html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:red;'>Deposit Form...</h1>");
		out.println("<form method='post' action='"+ response.encodeURL("./form2") +"'>");
		out.println("<table>");
		out.println("<tr><th>Dposister Name</th><td><input type='text' name='depName'/></td></tr>");
		out.println("<tr><th>Deposit Amount</th><td><input type='text' name='depAmount'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='next'/></td></tr>");
		out.println("<table>");
		out.println("</form>");
		out.println("</center>");
		out.println("</body>");
		
		out.close();
	}

}
