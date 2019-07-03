<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${board} Select Page</h1>
	<h1>Title : ${dto.title}</h1>
	<h1>Writer : ${dto.writer}</h1>
	<h1>Contents : ${dto.contents}</h1>
	<c:forEach items="${dto.files}" var="file">
		<a href="../resources/upload/${file.fname}">${file.oname}</a>
	</c:forEach>
	<a href="./${board}Update?num=${dto.num}">Update</a>
	<a href="./${board}Delete?num=${dto.num}">Delete</a>
	<a href="./${board}List?curPage=${pager.curPage}">List</a>
</body>
</html>