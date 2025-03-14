package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection connection = null;
	PreparedStatement pstmt = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
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

	// you can use doGet as well
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		// getting input from user
		String Sid = request.getParameter("sid");
		String Sname = request.getParameter("sname");
		String Sage = request.getParameter("sage");
		String Saddress = request.getParameter("saddress");
				
		try {
			
			String inserQuery = "insert into studentbatch(id,name,age,address) values (?,?,?,?)";
			if (connection != null) {
				pstmt = connection.prepareStatement(inserQuery);
				if (pstmt != null) {
					
					pstmt.setInt(1, Integer.parseInt(Sid));
					pstmt.setString(2, Sname);
					pstmt.setInt(3, Integer.parseInt(Sage));
					pstmt.setString(4, Saddress);				
				}
				if (pstmt != null) {					
					int rowEffected = pstmt.executeUpdate();
					if (rowEffected == 1) {
						out.println("<h1 style='color:green; text-align:center;'>REGISTRATION SUCCEFULL</h1>");
					} else {
						out.println("<h1 style='color:red; text-align:center;'>Registration Failed try again with the following link</h1>");
						out.println("<a href='./Form.html'>|REGISTRATION|</a>");
					}
					out.println("<a href='./retive' style='text-align:center;'>Get Information</a>");
					out.close();
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void destroy() {
		try {
		if(connection != null) 
			connection.close();
		if (pstmt != null) 
			pstmt.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
}
