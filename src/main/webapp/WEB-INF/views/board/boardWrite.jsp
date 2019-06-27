<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board}Write Page</h1>
	<form action="${board}Write" method="post">
		<input type="text" name="write" placeholder="write">
		<input type="text" name="title" placeholder="title">
		<textarea rows="" cols="" placeholder="contents"></textarea>
		<button>Write</button>
	</form>
</body>
</html>