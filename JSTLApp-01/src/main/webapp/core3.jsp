<%@page import="java.util.ArrayList"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>	Output of JSTL</title>
</head>
<body>
	<% 
		int[] arr = {};
		java.util.ArrayList<Integer> al = new java.util.ArrayList();
	%>
	<h1 style='color:green; text-align:center;'>
	<%-- "empty" is boolean operator --%>
		${empty nand} <br/>
		${empty "nand" } <br/>
		${empty null } <br/>
		${empty arr } <br/>
		${empty al } <br/>
		${empty !null} <br/>
		${!null}
	</h1>
</body>
</html>