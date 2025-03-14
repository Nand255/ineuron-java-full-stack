<%@ taglib prefix="myTag" uri="/WEB-INF/hello.tld" %>
<h1>this is before hello tag</h1>
<myTag:hello name="nand">
	<h1>This is the body of custom tag</h1>
</myTag:hello>
<myTag:hello>
	<h1>This is the body of custom tag</h1>
</myTag:hello>
<h1>this is after hello tag</h1>