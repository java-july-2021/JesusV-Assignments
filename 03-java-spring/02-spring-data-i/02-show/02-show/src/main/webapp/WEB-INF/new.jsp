<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Show</title>
</head>
<body>

<h1>New Book</h1>
<form:form action="/books" method="POST" modelAttribute="book">
	<p>
		<form:label path="title">Title</form:label>
		<form:errors path="title"/>
		<form:input path="title"/>
	</p>
	<p>
		<form:label path="description">Description</form:label>
		<form:errors path="description"/>
		<form:input path="description"/>
	</p>
	<p>
		<form:label path="language">Language</form:label>
		<form:errors path="language"/>
		<form:input path="language"/>
	</p>
	<p>
		<form:label path="numberOfPages">Pages</form:label>
		<form:errors path="numberOfPages"/>
		<form:input type="number" path="numberOfPages"/>
	</p>
	<input type="submit" value="Submit"/>
</form:form>

</body>
</html>