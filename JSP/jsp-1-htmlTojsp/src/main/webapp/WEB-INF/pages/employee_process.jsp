<%@ page language="java" import='java.sql.*'%>

<%!
	Connection connection = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	
	public void jspInit(){
		System.out.println("Bootstraping the Environment...");
		ServletConfig config = getServletConfig();
		String jdbcUrl = config.getInitParameter("jdbcUrl");
		String username = config.getInitParameter("username");
		String password = config.getInitParameter("password");
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(jdbcUrl, username, password);
		pstmt1 = connection.prepareStatement("insert into employee(ename,eaddr,esal) values (?,?,?)");
		pstmt2 = connection.prepareStatement("select eid,ename,eaddr,esal from employee");
		}
		catch(ClassNotFoundException ce){
			ce.printStackTrace();
		}
		catch(SQLException e){
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
		%>
		
		<% }else{
		//get the data from the database using select operation
		ResultSet resultSet = pstmt2.executeQuery();
		%>
	<table bgcolor='pink' align='center' border='1'>
		<tr>
			<th>EID</th>
			<th>ENAME</th>
			<th>EADDR</th>
			<th>ESAL</th>
		</tr>

<%
		while (resultSet.next()) {
%>
		<tr>
			<td><%=resultSet.getInt(1)%></td>
			<td><%=resultSet.getString(2)%></td>
			<td><%=resultSet.getString(3)%></td>
			<td><%=resultSet.getInt(4)%></td>
		</tr>
<%
	}
%>
</table>
<%
}
%>

<br/>
<br/>
<h1 style='text-align:center;'><a href='./index.html'>|HOMEPAGE|</a></h1>

<%!public void jspDestroy() {
		System.out.println("Cleaning the environment....");
		try {
			if (pstmt1 != null)
				pstmt1.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (pstmt2 != null)
				pstmt2.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (connection != null)
				connection.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}%>