<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Ticket Price</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
</head>
<body>
	<div class="main">
		
		<h1>Movie Booking System</h1>
		<hr>
		<br>
		<table>
			<caption>Your have chosen</caption>
			<tr>
				<th scope="row">Location</th>
				<td><c:out value="${locationChoice}"></c:out></td>
			</tr>

			<tr>
				<th scope="row">Movie</th>
				<td><c:out value="${movieChoice}"></c:out></td>
			</tr>

			<tr>
				<th scope="row">Theatre</th>
				<td><c:out value="${theatreChoice}"></c:out></td>
			</tr>
			<tr>
				<th scope="row">Date</th>
				<td><c:out value="${dateChoice}"></c:out></td>
			</tr>

			<tr>
				<th scope="row">Time</th>
				<td><c:out value="${timeChoice}"></c:out></td>
			</tr>

			<tr>
				<th scope="row">Seats</th>
				<td><c:out value="${seatIds}"></c:out></td>
			</tr>
			<tr>
				<th scope="row"><strong>Price to pay (in Rs)</strong></th>
				<td><c:out value="${totalticketPrice}"></c:out></td>
			</tr>
			
		</table>
		<form action="customer" method="get">
			<input type="submit" value="Confirm Selection">
		</form>
		
		<form action="index" method="get">
			<input type="submit" value="Reset">
		</form>
		
		<form action="logout">
			<input type="submit" value="Log Out">
		</form>
</body>
</html>