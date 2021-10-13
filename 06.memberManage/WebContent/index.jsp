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
	<a href="customer_join">회원가입</a>
</c:if>

<!-- 로그인 됐을때 -->
<c:if test="${member != null}">
	${member}님 반갑습니다.
	<a href="logout">로그아웃</a>
	<a href="customer_detail">회원정보수정</a>
	<a href="#">주문내역확인</a>
</c:if>

<!-- 필터 filter -->
<!-- <a href="public">누구나 볼 수 있는 페이지 요청</a>
<a href="private/test01">로그인한 사람만 볼 수 있는 페이지 요청A</a>
<a href="private/test02">로그인한 사람만 볼 수 있는 페이지 요청B</a> -->


</body>
</html>