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
<!-- 로그인 안됐을때 -->
<c:if test="${member == null}">
	<a href="login_input">로그인</a>
	<a href="board_list">게시판 보기</a>
</c:if>

<c:if test="${member != null}">
	${member}님 반갑습니다.
	<a href="logout">로그아웃</a>
	<a href="board_list">게시판 보기</a>
</c:if>

</body>
</html>