<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Time Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
.main {
	max-width:fit-content;
}
</style>
</head>
<body>
	<div class="main">
	<h1>Time Details</h1>
	<hr>
	
	<form action="addTime" method="post">
	<table class="table-design">
	<tr>
		<td><input type="time" name="time" placeholder="time" required></td>
		<td><input type="submit" value="Add Time"></td>
	</tr>
	
	</table>
	</form>
	<table class="table-design">
		<tr><th scope="row">Time Id</th>	<th scope="row">Time</th> </tr>
	
			<c:forEach var="time" items="${timeList}">
			
			<tr>
			<form action="updateTime" method="post">
			<td><input type="text" name="timeId" placeholder="${time.timeId}" value="${time.timeId}" readonly="readonly"></td>	
			<td><input type="text" name="time" placeholder="${time.time}" value="${time.time}"> </td>	
			<td>
			<input type="submit" value="Update">
			</form>
			</td> 
			<td>
			<form action="deleteTime" method="post">
				<input type="hidden" name="timeId" value="${time.timeId}"> 
				<input type="submit" value="Delete">
			</form>

			</td></tr>
				 
			</c:forEach>
			
	</table>
	
	</div>
	
</body>
</html>