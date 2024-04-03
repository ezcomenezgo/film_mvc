<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="CSS/form.css" rel="stylesheet">
</head>
<body>
	<h1>
		Add Films
	</h1>
	<form method="POST" action="./addFilm">
		<label for="title">Title*: </label>
		<input type="text" name="title" placeholder="Title of Movie" required/>
		<label for="year">Year*: </label>
		<input type="number" name="year" placeholder="Year of Movie(number only)" required/>
		<label for="director">Director*: </label>
		<input type="text" name="director" placeholder="Director of Movie" required/>
		<label for="stars">Stars*: </label>
		<input type="text" name="stars" placeholder="Stars of Movie" required/>
		<label for="review">Review*: </label>
		<input type="text" name="review" placeholder="Review of Movie" required/>
		<button type="submit" value="addNew">Submit</button>
	</form>
</body>
</html>