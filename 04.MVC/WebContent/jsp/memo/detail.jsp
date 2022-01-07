<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-3" >	
	
	<h3>memo</h3>
		<form method="post" action="memo_update">
		메모ID : ${memodetail.memoid}
		<input type="text" name="memoid" value="${memodetail.memoid}" hidden="hidden"/>
		이름 : <input type="text" name="name" value="${memodetail.name}"/>
		나이 : <input type="text" name="age" value="${memodetail.age}"/>
		<input type="submit" value="수정"/>
		</form>
	<a href="memo_delete?memoid=${memodetail.memoid}">삭제</a>
</div>
</body>
</html>