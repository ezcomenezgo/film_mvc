<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Film" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Films</title>
	<link href="CSS/list.css" rel="stylesheet">
</head>
<body>
	<div class="nav">
		<h1>
			All Films
		</h1>
		<button onclick="location.href='./addFilm'" type="button">
	         Add a New Film
	    </button>
	    <form method="GET" action="./films">
	    	<label for="title">Search by title: </label>
			<input type="text" name="title" placeholder="Title of Movie"/>
			<button type="submit">Submit</button>
	    </form>
	</div>
	<table>
		<tr>
			<th>ID</th>
		    <th>Title</th>
		    <th>Year</th>
		    <th>Director</th>
		    <th>Stars</th>
		    <th>Review</th>
		    <th>Action</th>
		</tr>
		<c:forEach items="${films}" var="f">
			<tr>
				<td> ${f.id}</td>
				<td> ${f.title} </td>
				<td> ${f.year} </td>
				<td> ${f.director}</td>
				<td> ${f.stars} </td>
				<td> ${f.review} </td>
				<td>
					<button onclick="location.href='./updateFilm?id=${f.id}'" type="button">
				         Update
				    </button>
				    <form method="POST" action="./deleteFilm?id=${f.id}">
				    	<button type="submit">
				         Delete
				    	</button>
				    </form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>