<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>${board} Update Form</h1>
		<form action="./${board}Update" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
		  <div class="form-group">
		    <label for="title">Title:</label>
		    <input type="text" class="form-control" id="title" name="title" value="${boardDTO.title}">
		  </div>
		  <div class="form-group">
		    <label for="writer">Writer:</label>
		    <input type="text" class="form-control" id="writer" name="writer" value="${boardDTO.writer}" readonly="readonly">
		  </div>
		  <div class="form-group">
		    <label for="contents">Contents:</label>
		    <textarea rows="5" cols="" class="form-control" name="contents">${boardDTO.contents}</textarea>
		  </div>
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>