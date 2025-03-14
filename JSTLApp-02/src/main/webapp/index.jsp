<%@ page isELIgnored='false' %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSTL Function library</title>
</head>
<body>
	<c:set var="data" value="Learning JSTL is easy"/>
	
	Length :: ${fn:length(data)}<br>
	UpperCase :: ${fn:toUpperCase(data)}<br>
	LowerCase :: ${fn:toLowerCase(data)}<br>
	Substring :: ${fn:substring(data , 4,8) }<br>
	Does Contain JSTL :: ${fn:contains(data,"JSTL") }<br>
		
	<c:set var='data' value='rohit.mohit.monit' />
	<c:set var="names" value='${fn:split(data,".")}'/>
	<h1>
	The result of split method is ::
	<c:forEach var="name" items="${names }">
			${name}<br>
	</c:forEach>
	
	<c:set var="result" value="${fn:join(names,';') }" />
		result of join is :: ${result}
	</h1>
	
</body>
</html>