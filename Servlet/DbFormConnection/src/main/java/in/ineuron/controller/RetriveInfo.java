package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetriveInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection connection = null;
	Statement stmt = null;
	ResultSet resultSet = null;
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
		
	// init() method will get executed first automatically because we are using load-on-startup in .xml file
	// load-on-startup load the servlet without needing of request // request ave ena pehla j load kari dese
	// building connection logic in init() method so before getting any request it(connection would be ready) will be ready 
	
	
	@Override
	public void init() throws ServletException {
		System.out.println("config object created and got values from config object...");

		String url = getInitParameter("url");
		String username = getInitParameter("username");
		String password = getInitParameter("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		try {
			stmt = connection.createStatement();
			String Sid = request.getParameter("sid");
			resultSet = stmt.executeQuery("select id,name,age,address from studentbatch");
			out.println("<table border='1' align='center'>");
			out.println("<tr><th>id</th><th>name</th><th>age</th><th>address</th></tr>");
		
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int age = resultSet.getInt(3);
				String address = resultSet.getString(4);
				out.println("<tr><td>"+id+"</td><td>"+name+"</td><td>"+age+"</td><td>"+address+"</td></tr>");
			}
			
			out.println("</table>");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

}
