<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MyPage</h1>
	<h3>ID : ${member.id}</h3>
	<h3>Name : ${member.name}</h3>
	<h3>Email : ${member.email}</h3>
	<h3>Grade : ${member.grade}</h3>
	<img alt="${member.memberfileVO.oname}" src="../resources/member_upload/${member.memberfileVO.fname}">
</body>
</html>