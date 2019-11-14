<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Price</title>
</head>
<body>
Your Ticket Price  = 
<c:out value="${ticketPrice}"/>
<br><br>
<form action="bookingDetail" method="get">
<input type="submit" value="Next">
</form>
</body>
</html>