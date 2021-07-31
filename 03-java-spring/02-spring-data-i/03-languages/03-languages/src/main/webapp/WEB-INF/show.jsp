<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
</head>
<body>

<a href="/">Dash Board</a>
	
	<c:out value="${thisLang.name}"/>
	<c:out value="${thisLang.creator}"/>
	<c:out value="${thisLang.version}"/>

	<p><a href="/edit/${thisLang.id}">Edit</a> | 
	<form method="POST" action="/delete/${thisLang.id}">
	<input type="hidden" name="_method" value="delete">
	<button>Delete Language</button>
	</form>

</body>
</html>