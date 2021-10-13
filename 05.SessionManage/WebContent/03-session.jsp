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
	<h2>이름 입력:</h2>
	<form method="post" action="sessionInfo">
		<input type="text" name="name"/>
		<input type="submit" value="전송"/>
	</form>
	<hr/>
	<c:if test="${empty wordlist}">None.</c:if>
	<c:if test="${!empty wordlist}">
		<c:forEach var="word" items="${wordlist}">
			${word} <br/>
		</c:forEach>
	</c:if>
</body>
</html>