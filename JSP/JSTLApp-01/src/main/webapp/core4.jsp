<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>	Output of JSTL</title>
</head>
<body>
	
	<c:choose>
		<c:when test="${param.p > 0}">
			${param.p} is positive number
		</c:when>			
		<c:when test="${param.p < 0}">
			${param.p} is negative number
		</c:when>			
		<c:otherwise>
			${param.p} is zero
		</c:otherwise>		
	</c:choose>
	
</body>
</html>