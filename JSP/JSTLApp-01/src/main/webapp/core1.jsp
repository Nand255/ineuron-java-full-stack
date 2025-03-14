<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>	Output of JSTL</title>
</head>
<body>
	<h1>
		<c:set var="data" value="10"/><br/> <%-- data = 10 --%>
		<c:out value="${data}" /> <%-- out.println(data) --%>
	</h1>
	
	<c:set var="x" value="15"/>
	<c:set var="y" value="5"/>
	<c:set var="z" value="${x+y}" scope="application"/>
	
	<h1 style='color:green; text-align:center;'>
		The result is::
		<c:out value="${z}"/>
	</h1>

	<c:set scope="request" var="username" value="${param.username}" />
	
	<h1 style='color:blue; text-align:center;'>
		The data from query string is::
		<c:out value="${username}" default="nand"/> <%-- you can set default in out but can not in set --%>
	</h1>
		
	<c:remove var="z" scope="application"/>
	<%-- If we don't specify the scope, by default the searching for an attribute would be done in the following order
	  		page >> request >> session >> application --%>

	<h1 style='color:green; text-align:center;'>
		After removing the result is::
		<c:out value="${z}" /> <%-- you can set a default value --%>
	</h1>

	<%-- write risky code in c:catch tag --%>
		<h1 style='color:red; text-align:center'>THE USERNAME IS:: ${param.userName}</h1> 
	<c:catch var="e">
		<jsp:scriptlet>
			Integer userAge = Integer.parseInt(request.getParameter("userAge"));
		</jsp:scriptlet>	
		<%-- Integer userAge = Integer.parseInt(<%= request.getParameter("userAge")%>); --%>			
		<h1 style='color:purple; text-align:center'>THE USERAge IS:: ${param.userAge}</h1> 
	</c:catch>
	
	
	<c:if test="${!empty e}">
		<h1 style='color:red; text-align:center'> The exception raise is :: ${e}</h1><br/> 
	</c:if>
	
</body>
</html>