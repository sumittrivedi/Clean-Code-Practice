<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Theatre Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
.main {
	max-width:fit-content;
}
</style>
</head>
<body>
	<div class="main">
	<h1>Theatre Details</h1>
	<hr>
	
	<form action="addTheatre" method="post">
	<table class="table-design">
	<caption></caption>
	<th scope="row"></th>
	<tr>
		<td><input type="text" name="theatreName" placeholder="theatre name" required></td>
		<td><input type="number" name="locationId" placeholder="locationId" required></td>
		<td><input type="submit" value="Add Theatre"></td>
	</tr>
	
	</table>
	</form>
	<table class="table-design">
	<caption></caption>
		<tr><th scope="row">Theatre Id</th>	<th scope="row">Theatre Name</th> <th scope="row">Location Id</th> </tr>
	
			<c:forEach var="theatre" items="${theatreList}">
			
			<tr>
			<form action="updateTheatre" method="post">
			<td><input type="text" name="theatreId" placeholder="${theatre.theatreId}" value="${theatre.theatreId}" readonly="readonly"></td>	
			<td><input type="text" name="theatreName" placeholder="${theatre.theatreName}" value="${theatre.theatreName}"> </td>	
			<td><input type="text" name="locationId" placeholder="${theatre.locationId}" value="${theatre.locationId}"></td>
			<td>
			<input type="submit" value="Update">
			</form>
			</td> 
			<td>
			<form action="deleteTheatre" method="post">
				<input type="hidden" name="theatreId" value="${theatre.theatreId}"> 
				<input type="submit" value="Delete">
			</form>

			</td></tr>
				 
			</c:forEach>
			
	</table>
	
	</div>
	
</body>
</html>