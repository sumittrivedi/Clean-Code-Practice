<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Location Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">

</head>
<body>
	<div class="main">
	<h1>Location Details</h1>
	<hr>
	<form action="addLocation" method="post">
	<table class="table-design">
	<caption>Location Details</caption>
	<th scope="row"></th>
	<tr>
		<td><input type="text" name="locationName" placeholder="location" required></td>
		<td><input type="submit" value="Add Location"></td>
	</tr>
	
	</table>
	</form>
	<table class="table-design">
	<caption></caption>
		<tr><th scope="row">Location Id</th>	<th scope="row">Location Name</th> </tr>
	
			<c:forEach var="location" items="${locationList}">
			
			<tr>
			<form action="updateLocation" method="post">
			<td><input type="text" name="locationId" placeholder="${location.locationId}" value="${location.locationId}" readonly="readonly"></td>	
			<td><input type="text" name="locationName" placeholder="${location.locationName}" value="${location.locationName}"> </td>	
			<td>
			<input type="submit" value="Update">
			</form>
			</td> 
			<td>
			<form action="deleteLocation" method="post">
				<input type="hidden" name="locationId" value="${location.locationId}"> 
				<input type="submit" value="Delete">
			</form>

			</td></tr>
				 
			</c:forEach>
			
	</table>
	</div>

</body>
</html>