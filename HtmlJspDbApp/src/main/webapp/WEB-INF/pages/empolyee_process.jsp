<%@ page language="java" import='java.sql.*'%>

<%!
	Connection connection = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	
	public void jspInit(){
		System.out.println("Bootstraping the Environment...");
		ServletConfig config = getServletConfig();
		String url = config.getInitParameter("jdbcUrl");
		String user = config.getInitParameter("user");
		String password = config.getInitParameter("password");
		try{
		Class.forName("com.mysql.cj.jsbc.Driver");
		connection = DriverManager.getConnection(url, user, password);
		pstmt1 = connection.prepareStatement("inser into employee values(?,?,?)");
		pstmt2 = connection.prepareStatement("select eid,ename,eaddr,esal from employee");
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<%
	String action = request.getParameter("s1");
	if(action.equalsIgnoreCase("register")){
		//take the data and perform insert operation
		String ename = request.getParameter("ename");
		String eaddr = request.getParameter("eaddr");
		String esal = request.getParameter("esal");
		
		pstmt1.setString(1, ename);
		pstmt1.setString(2, eaddr);
		pstmt1.setInt(3, Integer.parseInt(esal));
		
		int rowCount = pstmt1.executeUpdate();
		if(rowCount == 1){
			out.print("<h1 style='color:green; text-align:center>Employee Registered</h1>");
		}else {
			out.print("<h1 style='color:red; text-align:center>Employee Not Registered</h1>");
		}
		}else{
		//get the data from the database using select operation
		ResultSet resultset = pstmt2.executeQuery();
		out.print("<table border='1'>");
		out.print("<tr><th>EID</th><th>ENAME</th><th>EADDRESS</th><th>ESALARY</th></tr>");
		while(resultset.next()){ %>		
			<td><%= resultset.getInt(1) %></td>
			<td><%= resultset.getString(2) %></td>
			<td><%= resultset.getString(3) %></td>
			<td><%= resultset.getInt(4) %></td>
		<%
		}
		out.print("</table>");
	}
%>

<br/>
<br/>
<a href='./index.html'>|HOMEPAGE|</a>
<%! 
	public void jspDestory(){
		System.out.println("Bootstraping the Environment...");
		try{
			if(pstmt1 != null)
				pstmt1.close();
		}catch (SQLException se) {
			se.printStackTrace();
		}
		try{
			if(pstmt2 != null)
				pstmt2.close();
		}catch (SQLException se) {
			se.printStackTrace();
		}
		try{
			if(connection != null)
				connection.close();
		}catch(SQLException se){
			se.printStackTrace();
		}
	}
%>