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
</body>
</html>