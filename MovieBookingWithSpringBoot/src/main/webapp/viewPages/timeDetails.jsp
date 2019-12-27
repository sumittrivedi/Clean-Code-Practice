<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
input {
	width: 40%;
}
</style>
</head>
<body>
	<div class="main">
	<h1>Time Details</h1>
	<hr>
	
	<form action="" method="post">
		<input type="text" name="time" placeholder="time">
		<input type="submit" value="Add Time">
	</form>
	
	<table>
		<tr><th>Time Id</th>	<th>Time</th> <th>Update</th>	<th>Delete</th></tr>
	
			<c:forEach var="time" items="${timeList}">
			
			<tr><td>${time.timeId}</td>	<td>${time.time}</td>	<td></td>	<td></td></tr>
				 
			</c:forEach>
			
	</table>
	</div>
	
</body>
</html>