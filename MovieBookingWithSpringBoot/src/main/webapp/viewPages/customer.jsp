<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
</head>
<body>
	<div class="main">
	<form action="bookingDetail" method="post">

		<h1>
			Enter your details
		</h1>
		<hr>
		
		<label>Name</label> 
		<input type="text" name="customerName" pattern="^[a-zA-Z\s]+$" required>
		<br><br>
		
		<label>Mobile Number</label> 
		<input type="text" pattern="^[6-9]{1}[0-9]{9}$" name="mobileNo" required>
		<br><br>
		
		<input type="submit" value="Get Ticket">
		
	</form>
	</div>

</body>
</html>