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

.main
{
	width:850px;
	height:600px;
	padding: 3%;
}
input[type="checkbox"] 
{
	width: 5%;
	margin: 7px;
	display: inline-block;
	padding: 10px;
	border: 1px solid black;
	color: black;
	background-color: white;
	margin-bottom: 10px;
}

input[type="checkbox"]:checked 
{
	border: 1px solid white;
  	color: white;
  	background-color: black;
}

</style>

<script type="text/javascript">

function checkSeatSelection(form)
{
	var check = true;
	if(form.querySelectorAll('input[type="checkbox"]:checked').length < 1)
		{
		alert("Please select atleast one seat to book ticket");
		check = false;
		}
	if(form.querySelectorAll('input[type="checkbox"]:checked').length > 6)
	{
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
		<form action="ticketPrice" method="get" onsubmit="return checkSeatSelection(this);">

			<c:forEach var="seatInfo" items="${seatDetails}">
				
				
					<c:if test="${seatInfo.value}">
							${seatInfo.key.seatId}
							<input type="checkbox" name="seatInfos" value="${seatInfo.key.seatId} ${seatInfo.key.cost}" disabled="disabled">	
					</c:if>

					<c:if test="${not seatInfo.value}">
							${seatInfo.key.seatId}
							<input type="checkbox" name="seatInfos" value="${seatInfo.key.seatId} ${seatInfo.key.cost}" >
					</c:if>
				
			</c:forEach>
			<br>
			<p><strong>==== Screen This Way =====</strong>
			<input type="submit" value="Confirm Selection">
		</form>
	</div>
</body>
</html>