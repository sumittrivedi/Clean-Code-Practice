<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Detail</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="main">
		<p>
			Hey <strong>${cus_name}</strong>
		</p>
		<hr>
		<br>
		<br> Here is your ticket details<br>
		<br>
		<table>

			<tr>
				<th>Location</th>
				<td><c:out value="${locationChoice}"></c:out></td>
			</tr>

			<tr>
				<th>Movie</th>
				<td><c:out value="${movieChoice}"></c:out></td>
			</tr>

			<tr>
				<th>Theatre</th>
				<td><c:out value="${theatreChoice}"></c:out></td>
			</tr>
			<tr>
				<th>Date</th>
				<td><c:out value="${dateChoice}"></c:out></td>
			</tr>

			<tr>
				<th>Time</th>
				<td><c:out value="${timeChoice}"></c:out></td>
			</tr>

			<tr>
				<th>Premium Seats</th>
				<td><c:out value="${premiumSeatChoice}"></c:out></td>
			</tr>

			<tr>
				<th>Executive Seats</th>
				<td><c:out value="${executiveSeatChoice}"></c:out></td>
			</tr>

			<tr>
				<th>Total Price</th>
				<td><c:out value="${ticketPrice}"></c:out></td>
			</tr>

			<tr>
				<th>Contact No</th>
				<td><c:out value="${contact_no}"></c:out></td>
			</tr>
		</table>
		<form action="logout">
			<button type="submit">Log Out</button>
		</form>
		<form action="index.jsp">
			<button type="submit">Home</button>
		</form>


	</div>


</body>
</html>