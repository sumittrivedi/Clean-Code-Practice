<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
input {
	width: 25%;
}
</style>
<style type="text/css">
</style>
</head>
<body>
	<div class="main">
	<h1>Movie Details</h1>
	<hr>
	
	<form action="" method="post">
		<input type="text" name="movieName" placeholder="movie name">
		<input type="text" name="theatreId" placeholder="theatreId">
		<input type="submit" value="Add Movie">
	</form>
	
	<table>
		<tr><th>Movie Id</th>	<th>Movie Name</th> <th>Theatre Id</th>	<th>Update</th>	<th>Delete</th></tr>
	
			<c:forEach var="movie" items="${movieList}">
			
			<tr><td>${movie.movieId}</td>	<td>${movie.movieName}</td>	<td>${movie.theatreId}</td>	<td></td> <td></td></tr>
				 
			</c:forEach>
			
	</table>
	</div>
	
</body>
</html>