<h1 style='color:red; text-align:center'>Getting values from student object</h1>
<jsp:useBean id="student" class="in.ineuron.bean.Student" scope='session' />

<%-- Reading values from bean and printing on the console --%>
<b>SID:: <jsp:getProperty name='student' property='sid' /></b><br/>
<b>SNAME:: <jsp:getProperty name='student' property='sname' /></b><br/>
<b>SADDRESS:: <jsp:getProperty name='student' property='saddr' /></b><br/>
<b>SAGE:: <jsp:getProperty name='student' property='sage' /></b>