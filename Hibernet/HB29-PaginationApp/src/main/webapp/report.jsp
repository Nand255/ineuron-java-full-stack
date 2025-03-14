<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report Page</title>
</head>
<body bgcolor="cyan">
	<center>
		<c:choose>
			<c:when test="${policiesList ne null || !empty policiesList }">
				<table border="2">
					<tr>
						<th>PolicyId</th>
						<th>PolicyName</th>
						<th>PolicyType</th>
						<th>Company</th>
						<th>Tenure</th>
					</tr>
					<c:forEach var="dto" items="${policiesList }">
						<tr>
							<td>${dto.pid}</td>
							<td>${dto.pname}</td>
							<td>${dto.ptype}</td>
							<td>${dto.compny}</td>
							<td>${dto.tenure}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
		</c:choose>
		
		<c:if test="${pageNo > 1}">			
			<a href="./controller?pageNo=${pageNo - 1}&s1=link">Previous</a>
		</c:if>
		
		<c:forEach var="i" begin="1" end="${pageCount}" step="1">
			<a href="./controller?pageNo=${i}&s1=link">[${i}]</a>
		</c:forEach>

		<c:if test="${pageNo < pageCount}">			
			<a href="./controller?pageNo=${pageNo + 1}&s1=link">Next</a>
		</c:if>
		
		<h3 style='colr:red;'>
			<a href='./index.jsp'>HOME</a>
		</h3>
	</center>
</body>
</html>