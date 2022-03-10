<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Index</title>
</head>
<body>
	<c:forEach items="${userlist}" var="e">
		${e.id}
		${e.name}
		${e.password}
	</c:forEach>
</body>
</html>