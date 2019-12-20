<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Price</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
</head>
<body>
	<div class="main">
	Your Ticket Price =
	<c:out value="${ticketPrice}" />
	<br>
	<br>
	<form action="customer" method="get">
		<input type="submit" value="Next">
	</form>
	</div>
</body>
</html>