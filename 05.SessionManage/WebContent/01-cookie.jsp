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
	<h2>Input your address :</h2>
	<form method="post" action="setCookie">
		<input type="text" name="addr"/>
		<input type="submit" value="전송"/>
	</form>
	<c:if test="${!empty cookie}">
		<c:forEach var="ck" items="${cookie}">
			${ck.value.name} : ${ck.value.value} <br/>
		</c:forEach>
	</c:if>
	
	<a href="delCookie">address cookie 삭제</a>
</body>
</html>