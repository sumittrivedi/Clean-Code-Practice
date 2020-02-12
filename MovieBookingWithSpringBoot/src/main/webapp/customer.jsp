<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<body>
<form action="bookingDetail" method="post">

	<label>Your Name</label>
	<input type="text" name="cus_name" required="required"  pattern="^[a-zA-Z]+$"><br><br>

	<label>Contact Number</label>
	<input type="number" min="100000000" max="9999999999" name="contact_no" required="required" ><br><br>

<input type="submit" value="Get Ticket"> 

</form>

</body>
</html>