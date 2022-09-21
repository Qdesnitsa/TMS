<%@ page isELIgnored="false" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Hello, ${username}!</h2>
<h3>Welcome to my super-puper four operation ( +  ,- , * , / ) with brackets calculator!</h3>
<form action="/calculator">
    <input type="text" name="expression" placeholder="Enter expression" />
    <button type="submit">Calculate</button>
</form>
<ul>
    <c:forEach var="exp" items="${expressions}">
        <li>${exp}</li>
    </c:forEach>
</ul>
<p>${param.expression}</p>
<p>${message}</p>
<p>${result_double}</p>
<p>${result_string}</p>
</body>
</html>

