<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seat Availability</title>

<style>
	.screen 
	{
		display: flex;
		wrap-flex: wrap;
	}
</style>

</head>
<body>
	<h1>Choose number of seats</h1>
	<form action="ticketPrice" method="get">
	
			
		<!--	<img alt="Movie screen" src="images/screen.jpg"><br><br>
			<div class="screen">
				<label>Premium (Rs150 each)</label></br>
				<c:forEach var="premium-row" begin="0" end="2"></br>
				<c:forEach var="premium" begin="0" end="10">
					<input type="checkbox" name="premium" value="a">
				</c:forEach>
				</c:forEach>
			</div>
			<br><br>
			
			 <div class="screen">
				 <label>Executive (Rs100 each)</label> </br>
				<c:forEach var="executive-row" begin="0" end="8"></br>
				<c:forEach var="executive" begin="0" end="10">
					<input type="checkbox" name="executive" value="b">
					</c:forEach>
				</c:forEach>
			</div>
			<br><br>
		-->
		
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
		
		
	 <input type="submit" value="Confirm Booking">
	</form>
			
</body>
</html>