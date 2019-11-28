<%@page import="com.epam.moviebooking.dto.MovieDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movies</title>
</head>
<body>
	<h1>Select Movie </h1>
	<form action="theatre" method="get">
		<select name="movieChoice">
			<c:forEach var="movie" items="${movieList}">
				<option>${movie.movieName}</option>
			</c:forEach>
		</select> <input type="submit" value="Next">
	</form>
</body>
</html>