<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>
<h2>Dear Employee, please enter your details</h2>
<br>
<br>
<!--<form action="showDetails" method="get">
    <input type="text" name="employeeName"
           placeholder="Write your name"/>
    <input type="submit"/>
</form>-->
<form:form action="showDetails" modelAttribute="employee">
    Name <form:input path="name"></form:input>
    <form:errors path="name"></form:errors>
    <br><br>
    Surname <form:input path="surname"></form:input>
    <form:errors path="surname"></form:errors>
    <br><br>
    Salary <form:input path="salary"></form:input>
    <form:errors path="salary"></form:errors>
    <br><br>

    Department <form:select path="department">
<%--<form:option value="Information Technology" label="IT"></form:option>
    <form:option value="Human Resources" label="HR"></form:option>
    <form:option value="Sales" label="Sales"></form:option>--%>
    <form:options items="${employee.departments}"></form:options>
</form:select><br><br>
    Which car do you want?
<%--BMW <form:radiobutton path="carBrand" value="BMW"></form:radiobutton>
    Audi <form:radiobutton path="carBrand" value="Audi"></form:radiobutton>
    MB <form:radiobutton path="carBrand" value="Mercedes-Benz"></form:radiobutton><br><br>--%>
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"></form:radiobuttons>
    <br><br>
    Foreign language(s)
<%--EN <form:checkbox path="languages" value="English"></form:checkbox>
    DE <form:checkbox path="languages" value="Deutch"></form:checkbox>
    FR <form:checkbox path="languages" value="French"></form:checkbox><br><br>--%>
    <form:checkboxes path="languages" items="${employee.languageList}"></form:checkboxes>
    <br><br>
    Phone number <form:input path="phoneNumber"></form:input>
    <form:errors path="phoneNumber"></form:errors>
    <br><br>
    Email <form:input path="email"></form:input>
    <form:errors path="email"></form:errors>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
