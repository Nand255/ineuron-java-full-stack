<h1 style='color:red; text-align:center'>Setting values to Student object</h1>
<jsp:useBean id="student" class="in.ineuron.bean.Student" scope="session" />
<jsp:setProperty name="student" property="sid" value="1"/>
<jsp:setProperty name="student" property="sname" value="nisarg"/>
<jsp:setProperty name="student" property="saddr" value="yoh"/>
<jsp:setProperty name="student" property="sage" value="10"/>

<h1 style='color:red; text-align:center'><%= student %></h1>
<br/>
<br/>
<%--setting the request parameter to student bean--%>
<%-- pass the value of parameter as substring --%>
<jsp:setProperty name="student" property="sid" param="sid"/>
<jsp:setProperty name="student" property="sname" param="sname"/>
<jsp:setProperty name="student" property="saddr" param="saddr"/>
<jsp:setProperty name="student" property="sage" param="sage"/>
<h1 style='color:red; text-align:center'><%= student %></h1>
<br/>
<br/>

<%-- if java bean properties and parameters are same then map property with '*' --%>
<jsp:setProperty name="student" property="*"/>
<h1 style='color:green; text-align:center'><%= student %></h1>