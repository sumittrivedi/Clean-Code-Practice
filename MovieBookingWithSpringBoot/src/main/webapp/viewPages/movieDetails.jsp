<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Movie Details</title>
<link rel="stylesheet" type="text/css" href="stylesheets/style.css">
<style type="text/css">
.main {
	max-width:fit-content;
}
</style>
<style type="text/css">
</style>
</head>
<body>
	<div class="main">
	<h1>Movie Details</h1>
	<hr>
	
	<form action="addMovie" method="post">
	<table class="table-design">
	<caption>Add Movie</caption>
	<th scope="row"></th>
	<tr>
		<td><input type="text" name="movieName" placeholder="movie name" required></td>
		<td><input type="number" name="theatreId" placeholder="theatreId" required></td>
		<td><input type="submit" value="Add"></td>
	</tr>
	
	</table>
	</form>
	<table class="table-design">
	<caption>Movie Details</caption>
		<tr><th scope="row">Movie Id</th>	<th scope="row">Movie Name</th> <th scope="row">Theatre Id</th>	</tr>
	
			<c:forEach var="movie" items="${movieList}">
			
			<tr>
			<form action="updateMovie" method="post">
			<td><input type="text" name="movieId" placeholder="${movie.movieId}" value="${movie.movieId}" readonly="readonly"></td>	
			<td><input type="text" name="movieName" placeholder="${movie.movieName}" value="${movie.movieName}"> </td>	
			<td><input type="text" name="theatreId" placeholder="${movie.theatreId}" value="${movie.theatreId}"></td>
			<td>
			<input type="submit" value="Update">
			</form>
			</td> 
			<td>
			<form action="deleteMovie" method="post">
				<input type="hidden" name="movieId" value="${movie.movieId}"> 
				<input type="submit" value="Delete">
			</form>

			</td></tr>
				 
			</c:forEach>
			
	</table>
	
	</div>
	
</body>
</html>