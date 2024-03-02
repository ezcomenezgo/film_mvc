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
	<link href="CSS/style.css" rel="stylesheet">
</head>
<body>
	<h1>
		All Films
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
		<c:forEach items="${films}" var="f">
			<tr>
				<td> ${f.id}</td>
				<td> ${f.title} </td>
				<td> ${f.year} </td>
				<td> ${f.director}</td>
				<td> ${f.stars} </td>
				<td> ${f.review} </td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>