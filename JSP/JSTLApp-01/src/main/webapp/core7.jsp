<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>	Output of JSTL</title>
</head>
<body>

	<%-- <h1>welcome!! here is what i know about advance java</h1>
	<c:import url="core8.jsp" scope="request"> 
		<c:param name="sub1" value='jdbc'/>
		<c:param name="sub2" value='jsp'/>
		<c:param name="sub3" value='servlet'/>
		<c:param name="sub4" value='java'/>
	</c:import>
	<h1><b><u>now get losttttttttt</u></b></h1>  --%>
	
	
	<c:url value="core8.jsp" var="y" scope="request">
		<c:param name="sub1" value='jdbc'/>
		<c:param name="sub2" value='jsp'/>
		<c:param name="sub3" value='servlet'/>
		<c:param name="sub4" value='java'/>		
	</c:url> 
		<h1>The modified url is :: ${y}</h1>
		<h1><a href="${y}">|click here to go to next page|</a></h1>
</body>
</html>