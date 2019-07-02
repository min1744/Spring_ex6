<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>
<a href="./notice/noticeList" class="btn">Notice List</a>
<c:choose>
	<c:when test="${not empty member}">
		<a href="./member/memberLogout">Logout</a>
	</c:when>
	<c:otherwise>
		<a href="./member/memberJoin" class="btn">Join</a>
		<a href="./member/memberLogin" class="btn">Login</a>
	</c:otherwise>
</c:choose>
</body>
</html>