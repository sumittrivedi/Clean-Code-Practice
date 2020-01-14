<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Date Time</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
</head>
<body>
	<div class="main">
	<h1>Select Date</h1>
	<form action="time" method="get">
		<select name="dateChoice">
			<c:forEach var="date" items="${dateList}">
				<option>${date}</option>
			</c:forEach>
		</select> 
		<input type="submit" value="Next">
	</form>
	</div>
</body>
</html>