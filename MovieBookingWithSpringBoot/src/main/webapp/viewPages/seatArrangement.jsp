<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seat Arrangement</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
.main {
	width: 850px;
	height:1300px;
	padding: 3%;
}

input[type="checkbox"] {
	margin: 7px;
	display: inline-block;
	padding: 10px;
	border: 1px solid black;
	color: black;
	background-color: white;
	margin-bottom: 10px;
}

input[type="checkbox"]:checked {
	border: 1px solid white;
	color: white;
	background-color: black;
}

input[type="checkbox"]:hover {
	border: 1px solid white;
	color: white;
	background-color: black;
}
span{
	display:inline-block;
	margin :1%;
}
td{
	text-align: center;
}
</style>

<script type="text/javascript">
	function checkSeatSelection(form) {
		var check = true;
		if (form.querySelectorAll('input[type="checkbox"]:checked').length < 1) {
			alert("Please select atleast one seat to book ticket");
			check = false;
		}
		if (form.querySelectorAll('input[type="checkbox"]:checked').length > 6) {
			alert("Hey user you can not book more than six tickets at a time");
			check = false;
		}
		return check;
	}
</script>

</head>
<body>
	<div class="main">
		<h1>Choose Seats</h1>
		<br>
		<form action="ticketPrice" method="get"
			onsubmit="return checkSeatSelection(this);">
			<c:forEach var="seatInfo" items="${seatDetails}">
			<span>
				<c:if test="${seatInfo.value}">
					<table>
					  <tr><td><label for="seatInfos">${seatInfo.key.seatId}</label></td></tr>
					  <tr><td><input type="checkbox" name="seatInfos"
							value="${seatInfo.key.seatId} ${seatInfo.key.cost}"
							disabled="disabled"></td></tr>
					  <tr><td>Rs ${seatInfo.key.cost}</td></tr>
					</table>
				</c:if>
				<c:if test="${not seatInfo.value}">
					<table>
					  <tr><td><label for="seatInfos">${seatInfo.key.seatId}</label></td></tr>
					  <tr><td><input type="checkbox" name="seatInfos"
						value="${seatInfo.key.seatId} ${seatInfo.key.cost}"></td></tr>
					  <tr><td>Rs ${seatInfo.key.cost}</td></tr>
					</table>	
				</c:if>
			</span>
			</c:forEach>
			<br> <br>
			<p>
				<strong>==== Screen This Way =====</strong> <input type="submit"
					value="Get total price">
		</form>
		<br>
	</div>
</body>
</html>
