<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>	Output of JSTL</title>
</head>
<body>
	<h1 style='color:green; text-align:center;'>
		The result is :: ${2+3} <br/>
		The result is :: ${""+3} <br/> 
		The result is :: ${null+3} <br/>
		<%-- There is no operator overloading--%>
		The result is :: ${abc+3} <br/>
		<%-- number format exception The result is :: ${"abc"+3} <br/>  --%>
	</h1>
</body>
</html>