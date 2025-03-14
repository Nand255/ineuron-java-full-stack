<%-- pageContext implicit object to perform attribute management in any scope --%>
<%

	// The order of Scope is :: page << request << session << application 
	pageContext.setAttribute("p", "page"); 			// page scope
	request.setAttribute("r", "request");  			// request scope
	session.setAttribute("s", "session");  			// session scope
	application.setAttribute("a", "application");   // application scope
	
	pageContext.forward("./disp.jsp");
%>

