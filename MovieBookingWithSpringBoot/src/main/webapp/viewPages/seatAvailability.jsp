<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seat Availability</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style>
	.screen 
	{
		display: flex;
		wrap-flex: wrap;
	}
</style>

</head>
<body>
	<div class="main">
	<h1>Choose number of seats</h1>
	<form action="ticketPrice" method="get">
	
			
		
			<img alt="Movie screen" src="images/screen.jpg"><br><br>
			<div class="screen">
				<label>Premium (Rs150 each)</label></br>
				<c:forEach var="premium-row" begin="0" end="2">
				<c:forEach var="premium" begin="0" end="10">
					<input type="checkbox" name="premium" value="a">
				</c:forEach>
				</c:forEach>
			</div>
			<br><br>
			
			 <div class="screen">
				 <label>Executive (Rs100 each)</label> 
				<c:forEach var="executive-row" begin="0" end="8">
				<c:forEach var="executive" begin="0" end="10">
					<input type="checkbox" name="executive" value="b">
				</c:forEach>
				</c:forEach>
			</div>
			<br><br>
		
		<!--  
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
		

			<ol class="seat-matrix">
				<li class="row-A">
					<ol class="seats">
						<li class="seat"><input type="checkbox" id="A1"> <label for="A1">A1</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="A2"> <label for="A2">A2</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="A3"> <label for="A3">A3</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="A4"> <label for="A4">A4</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="A5"> <label for="A5">A5</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="A6"> <label for="A6">A6</label>
						</li>
					</ol>
				</li>
				
				<li class="row-B">
					<ol class="seats">
						<li class="seat"><input type="checkbox" id="B1"> <label for="B1">B1</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="B2"> <label for="B2">B2</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="B3"> <label for="B3">B3</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="B4"> <label for="B4">B4</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="B5"> <label for="B5">B5</label>
						</li>
						
						<li class="seat"><input type="checkbox" id="B6"> <label for="B6">B6</label>
						</li>
					</ol>
				</li>
				
				
			</ol>
-->

			<input type="submit" value="Confirm Booking">
	</form>
	<div class="main">		
</body>
</html>