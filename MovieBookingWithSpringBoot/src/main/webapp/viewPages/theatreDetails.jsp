<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Theatre Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
input {
	width: 25%;
}
</style>
</head>
<body>
	<div class="main">
	<h1>Theatre Details</h1>
	<hr>
	<form action="" method="post">
		<input type="text" name="theatreName" placeholder="theatre name">
		<input type="text" name="locationId" placeholder="locationId">
		<input type="submit" value="Add Theatre">
	</form>
	
	<table>
		<tr><th>Theatre Id</th>	<th>Theatre Name</th> <th>Location Id</th> <th>Update</th>	<th>Delete</th></tr>
	
			<c:forEach var="theatre" items="${theatreList}">
			
			<tr><td>${theatre.theatreId}</td>	<td>${theatre.theatreName}</td> <td>${theatre.locationId}</td>	<td></td>	<td></td></tr>
				 
			</c:forEach>
			
	</table>
	</div>
	
</body>
</html>