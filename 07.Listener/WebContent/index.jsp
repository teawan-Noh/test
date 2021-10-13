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
우리는 리스너를 배우는 중 <br/><br/>

<c:forEach var="countries" items="${countries}">
	${countries.key} : ${countries.value} <br/>
</c:forEach>
${countries.kr} <br/>
${countries.us}
</body>
</html>