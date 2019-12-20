<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
</head>
<body>
	<div class="main">
	<h1>Select Location</h1>
	<form action="movie" method="get">
		<select name="locationChoice">
			<c:forEach var="location" items="${locationList}">
				<option>${location.locationName}</option>
			</c:forEach>
		</select> <input type="submit" value="Next">
	</form>
	</div>
</body>
</html>