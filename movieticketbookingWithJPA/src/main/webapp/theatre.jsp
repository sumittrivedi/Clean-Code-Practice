
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>theatre</title>
</head>
<body>
	<h1>Select Theatre</h1>
	<form action="dateTime" method="get">
		<select name="theatreChoice">
			<c:forEach var="theatre" items="${theatreList}">
				<option>${theatre}</option>
			</c:forEach>
		</select> <input type="submit" value="Next">
	</form>
</body>
</html>