<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Location Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
input {
	width: 40%;
}
</style>
</head>
<body>
	<div class="main">
	<h1>Location Details</h1>
	<hr>
	
	<form action="addLocation" method="post">
		<input type="text" name="locationName" placeholder="location">
		<input type="submit" value="Add Location">
	</form>
	<table>
		<tr><th>Location Id</th>	<th>Location Name</th> <th>Update</th>	<th>Delete</th></tr>
	
			<c:forEach var="location" items="${locationList}">
			
			<tr><td>${location.locationId}</td>	<td>${location.locationName}</td>	<td></td>	<td></td></tr>
				 
			</c:forEach>
			
	</table>
	</div>

</body>
</html>