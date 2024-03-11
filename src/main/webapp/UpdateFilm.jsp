<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Film" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film</title>
</head>
<body>
	<h1>
		Update Films
	</h1>
	<table>
		<tr>
			<th>ID</th>
		    <th>Title</th>
		    <th>Year</th>
		    <th>Director</th>
		    <th>Stars</th>
		    <th>Review</th>
		</tr>
			<tr>
				<td> ${film.getId()}</td>
				<td> ${film.title} </td>
				<td> ${film.year} </td>
				<td> ${film.director}</td>
				<td> ${film.stars} </td>
				<td> ${film.review} </td>
			</tr>
	</table>
	
	<form method="POST" action="./updateFilm?id=${film.id}">
		<label for="title">Title: </label>
		<input type="text" name="title" placeholder="Title of Movie" value="${film.title}"/>
		<label for="year">Year: </label>
		<input type="text" name="year" placeholder="Year of Movie" value="${film.year}"/>
		<label for="director">Director: </label>
		<input type="text" name="director" placeholder="Director of Movie" value="${film.director}"/>
		<label for="stars">Stars: </label>
		<input type="text" name="stars" placeholder="Stars of Movie" value="${film.stars}"/>
		<label for="review">Review: </label>
		<input type="text" name="review" placeholder="Review of Movie" value="${film.review}"/>
		<button type="submit" value="addNew">Submit</button>
	</form>
</body>
</html>