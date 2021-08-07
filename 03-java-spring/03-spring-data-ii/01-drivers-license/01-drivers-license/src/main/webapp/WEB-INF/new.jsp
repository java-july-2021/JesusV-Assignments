<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create A New Person</title>
</head>
<body>
<h1>Create A New Person</h1>
<hr>
<form:form method="POST" action="/new" modelAttribute="person">
<p>
<form:label path="firstName">First Name</form:label>
<form:errors path="firstName"/>
<form:input path="firstName"/>
</p>
<p>
<form:label path="lastName">Last Name</form:label>
<form:errors path="lastName"/>
<form:input path="lastName"/>
</p>

<button>Add New Person</button>
</form:form>


</body>
</html>