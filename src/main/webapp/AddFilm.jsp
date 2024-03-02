<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST" action="./addFilm">
		<label for="title">Title: </label>
		<input type="text" name="title" placeholder="Title of Movie"/>
		<label for="year">Year: </label>
		<input type="text" name="year" placeholder="Year of Movie"/>
		<label for="director">Director: </label>
		<input type="text" name="director" placeholder="Director of Movie"/>
		<label for="stars">Stars: </label>
		<input type="text" name="stars" placeholder="Stars of Movie"/>
		<label for="review">Review: </label>
		<input type="text" name="review" placeholder="Review of Movie"/>
		<button type="submit" value="addNew">Submit</button>
	</form>
</body>
</html>