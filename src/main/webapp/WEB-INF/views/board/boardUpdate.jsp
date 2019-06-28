<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board}Update Page</h1>
	<form action="${board}Update" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
		<input type="text" name="writer" placeholder="writer" value="${boardDTO.writer}">
		<input type="text" name="title" placeholder="title" value="${boardDTO.title}">
		<textarea rows="" cols="" placeholder="contents" ></textarea>
		<button>Update</button>
	</form>
</body>
</html>