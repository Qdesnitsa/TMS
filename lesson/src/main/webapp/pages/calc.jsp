<%@ page isELIgnored="false" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<html>
<head>
	<title>Calculator</title>
</head>
<body>
<h3>Welcome to my super four operation ( +  ,- , * , / ) with brackets calculator!</h3>
<form action="/calculator" method="post">
	<input type="text" name="expression" placeholder="Enter expression" />
	<button type="submit">Calculate</button>
</form>
<p>${message}</p>
<p>${result_double}</p>
<p>${result_string}</p>
</body>
</html>
