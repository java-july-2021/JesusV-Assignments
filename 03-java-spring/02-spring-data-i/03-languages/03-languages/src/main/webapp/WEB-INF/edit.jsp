<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
     
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Edit Language</h1>
<form:form action="/edit/${language.id}" method="POST" modelAttribute="language">
<p>
<form:label path="name">Name</form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>
<p>
<form:label path="creator">Creator</form:label>
<form:errors path="creator"/>
<form:input path="creator"/>
</p>
<p>
<form:label path="version">Version</form:label>
<form:errors path="version"/>
<form:input path="version"/>
</p>

<input type="hidden" name="_method" value="put">
<button>Edit Language</button>
</form:form>

</body>
</html>