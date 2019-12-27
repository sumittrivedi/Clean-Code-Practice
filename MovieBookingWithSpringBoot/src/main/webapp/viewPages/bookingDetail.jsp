<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Detail</title>
<link rel="stylesheet" type="text/css" href="../stylesheets/style.css">
<style type="text/css">
button {
	width: 90%;
}
</style>
</head>
<body>
	<div class="main">
		<p>
			Hey <strong>${cus_name}</strong>
		
		<hr>
		<br>
		<br> Here is your ticket details<br>
		<br>
		<table>
		
			<tr>
				<th>Booking Id</th>
				<td><c:out value="${ticketDetails.bookingId}"></c:out></td>
			</tr>

			<tr>
				<th>Location</th>
				<td><c:out value="${ticketDetails.locationName}"></c:out></td>
			</tr>

			<tr>
				<th>Movie</th>
				<td><c:out value="${ticketDetails.movieName}"></c:out></td>
			</tr>

			<tr>
				<th>Theatre</th>
				<td><c:out value="${ticketDetails.theatreName}"></c:out></td>
			</tr>
			<tr>
				<th>Date</th>
				<td><c:out value="${ticketDetails.date}"></c:out></td>
			</tr>

			<tr>
				<th>Time</th>
				<td><c:out value="${ticketDetails.time}"></c:out></td>
			</tr>

			<tr>
				<th>Seats</th>
				<td><c:out value="${ticketDetails.seatIds}"></c:out></td>
			</tr>
			<tr>
				<th>Total Price</th>
				<td><c:out value="${ticketDetails.price}"></c:out></td>
			</tr>

			<tr>
				<th>Contact No</th>
				<td><c:out value="${ticketDetails.customerName}"></c:out></td>
			</tr>
		</table>
		<form action="logout">
			<button type="submit">Log Out</button>
		</form>
		<form action="index">
			<button type="submit">Home</button>
		</form>

	</div>

</body>
</html>