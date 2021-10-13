<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include</title>
</head>
<body>
	이 페이지의 어떠한 코드도 forward 액션이 실행되는 순간 
	<jsp:forward page="13-menu.jsp">
		<jsp:param name="text" value="login join" />
	</jsp:forward>
	뒤도 안돌아보고 다음페이지로 이동
</body>
</html>