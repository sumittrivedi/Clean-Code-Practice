<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seat Availability</title>
</head>
<body>
	<h1>Choose number of seats</h1>
	<form action="ticketPrice" method="get">
		
		<label>Premium (Rs150 each)</label> 
		<select	name="premiumSeatChoice">
			<c:forEach var="premium" begin="0"
				end="${availableSeatDto.premiumAvailability}">
				<option>${premium}</option>
			</c:forEach>
		</select> 
		<br><br>
		
		 <label>Executive (Rs100 each)</label> 
		 <select name="executiveSeatChoice">
			<c:forEach var="executive" begin="0"
				end="${availableSeatDto.executiveAvailabilty}">
				<option>${executive}</option>
			</c:forEach>
		</select> <br>
		<br> <input type="submit" value="Confirm Booking">
	</form>

</body>
</html>