<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>	Output of JSTL</title>
</head>
<body>
	<%-- Defining the URL to send the request --%>
	<c:url value="https://www.youtube.com/" var="googleUri" scope="request"></c:url>
	
	<%-- Perform sendRedirection --%>
	<c:redirect url="${googleUri}" />
</body>
</html>