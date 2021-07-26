<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Getting Familiar With Routing</title>
</head>
<body>
<h1>Coding <c:out value="${name}"/>is awesome!</h1>

<h1><c:out value="${location}"/> <c:out value="${name}"/>is in Southern California</h1>

<h1><c:out value="${headquarters}"/> <c:out value="${name}"/>is the Headquarters</h1>
</body>
</html>