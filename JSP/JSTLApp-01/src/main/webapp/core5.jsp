<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>	Output of JSTL</title>
</head>
<body>
	<%-- Traditional for loop --%>
	<c:forEach var="i" begin="1" end="10">
		2 * ${i} = ${2 * i} <br/>
	</c:forEach>
	
	<%
		String[] names = {"alex","pit","ash"};
		request.setAttribute("names", names);
		ArrayList<String> list = new ArrayList<String>();
		list.add("back");
		list.add("leg");
		list.add("chest");
		request.setAttribute("list", list);
	%>
	<br><br>
	
	<%-- Enhanced for loop for iterate collection and array --%>
	<c:forEach var="name" items="${names}">
		<h1>Name is :: ${name}</h1>
	</c:forEach>

	<%-- Enhanced for loop for iterate collection and array --%>
	<c:forEach var="list" items="${ list}">
		<h1>List Name is :: ${list}</h1>
	</c:forEach>
	
	<%-- for loop for param object --%>
	<c:forEach var='p' items="${param}">
		<h1>key is :: ${p.key}  value is :: ${p.value}</h1><br>
	</c:forEach>
	
	<%-- forToken --%>                                <%-- you can take any thing as delims --%>   
	<c:forTokens items="sachin.kohli.dhoni.rohit.ABD" delims="." var='name'>
		<h1>Player name is :: ${name}</h1>
	</c:forTokens>
</body>
</html>