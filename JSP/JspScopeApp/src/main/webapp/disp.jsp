<h1 style='color:blue; text-align:center;'>
	page Scope attribute is:<%= pageContext.getAttribute("p") %>
</h1>
<h1 style='color:blue; text-align:center;'>
	<%-- pageContext.findAttribute :: it will search in page scope, request scope, session scope, application scope in order if found in any cope any particular value will be returned otherwise it would returen null --%>
	page Scope attribute is:<%= pageContext.findAttribute("p") %>
</h1>
<h1 style='color:blue; text-align:center;'>
	<%-- here u can give order value --%>
	page Scope attribute is:<%= pageContext.getAttribute("p",2) %>
</h1>
<h1 style='text-align:center;'>
	request Scope attribute is:<%= request.getAttribute("r") %>
</h1>
<h1 style='color:red; text-align:center;'>
	session Scope attribute is:<%= session.getAttribute("s") %>
</h1>
<h1 style='color:green; text-align:center;'>
	application Scope attribute is:<%= application.getAttribute("a") %>
</h1>