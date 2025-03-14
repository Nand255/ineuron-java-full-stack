<%@ page language="java"%>

<%-- Creating a DTO object to hold the data of the user entered in index.html(coming from request object) --%>
<jsp:useBean id='dto' class='in.ineuron.dto.EmployeeDto' scope='request'/>

<%-- Setting the values to the DTO object --%>
<jsp:setProperty name='dto' property='*'/>

<%-- Creating a service object to hold the data of the user at application level--%>
<jsp:useBean id="service" class='in.ineuron.service.SalaryDetailGeneratorImpl' scope='application'/>

<% 
	service.generateSalaryDetails(dto);
%>

<%-- Displaying the details in the table format --%>
<table border='1' align='center'>
	<caption>Salary Detail</caption>
	<tr>
		<th>Employee ID</th>
		<td><jsp:getProperty name="dto" property="eno"/></td>
		<%--you can also use this <td><%= dto.getEno()%></td> --%>
	</tr>
	<tr>
		<th>Employee Name</th>
		<td><jsp:getProperty name="dto" property="ename"/></td>
		<%-- <td><%= dto.getEname() %></td> --%>
	</tr>
	<tr>
		<th>Employee Salary</th>
		<td><jsp:getProperty name="dto" property="bsalary"/></td>
		<%-- <td><%= dto.getBsalary()%></td> --%>
	</tr>
	<tr>
		<th>Gross Salary</th>
		<td><jsp:getProperty name="dto" property="grossSalary"/></td>
		<%-- <td><%= dto.getGrossSalary()%></td> --%>
	</tr>
	<tr>
		<th>Net Salary</th>
		<td><jsp:getProperty name="dto" property="netSalary"/></td>
		<%-- <td><%= dto.getNetSalary()%></td> --%>
	</tr>
</table>

<h1 style='color:blue; text-align:center;'><a href="index.html">|HOMEPAGE|</a></h1>