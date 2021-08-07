<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A New License</title>
</head>
<body>
<h1>Create A New License</h1>
<hr>
<form:form method="POST" action="/newlicense" modelAttribute="license">
<p>
<form:label path="person">Select Person</form:label>
<form:errors path="person"/>
<form:select path="person">
<c:forEach items="${people}" var="person">
<option value="${person.id}">${person.firstName} ${person.lastName}</option>
</c:forEach>
</form:select>
</p>

<p>
<form:label path="expirationdate">Expiration Date</form:label>
<form:errors path="expirationdate"/>
<form:input type="date" path="expirationdate"/>
</p>
<p>
<form:label path="state">State</form:label>
<form:errors path="state"/>
<form:input path="state"/>
</p>

<button>Add License</button>
</form:form>

</body>
</html>