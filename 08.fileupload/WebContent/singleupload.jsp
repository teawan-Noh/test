<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>singleupload.jsp</title>
</head>
<body>
	<h1>업로드할 파일을 선택하세요!</h1>
	<form action="singleUpload" method="post" enctype="multipart/form-data">
		작성자: <input type="text" name="author"/><br />
		업로드할 파일: <input type="file" name="filename"/><br />
		<input type="submit" value="업로드"/>
	</form>
</body>
</html>