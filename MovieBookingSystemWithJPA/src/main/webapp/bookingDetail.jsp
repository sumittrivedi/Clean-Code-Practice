<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Detail</title>
</head>
<body>
<strong>Hey Man, We booked your movie ticket</strong>
<br><br><br>
Here is your ticket details<br><br>


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
<th>Theatre </th>
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

</table>

</body>
</html>