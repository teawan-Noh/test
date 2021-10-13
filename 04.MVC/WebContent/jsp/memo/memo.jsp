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
	<h3>Memo</h3>
	<!-- <form method="post" action="memo_save_v1"> -->
	<form method="post" action="memo_save_v2">
		이름 : <input type="text" name="name" value="${memoForm.name}"/> 
		<sapn style="color: red">${memoErrors.nameErr}</sapn> <br/>
		나이 : <input type="text" name="age" value="${memoForm.age}"/> 
		<sapn style="color: red">${memoErrors.ageErr}</sapn> <br/>
		
		<input type="reset"/>
		<input type="submit" value="메모등록"/>
	</form>
	<!-- 등록이 잘 되었을 경우 -->
	<h1>${message}</h1>
	
	<!-- 입력값이 잘못되었을 경우 뿌려지는 메세지 -->
	<!-- v2에서는 필요없는 부분, v2 돌릴떈 받는 값이 없으므로 작동안함 -->
	<c:if test="${errors != null }">
		<p>입력값 오류</p>
		<ul>
			<c:forEach var="error" items="${errors}">
				<li>${error}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<hr/>
	<a href="memo_search">리스트로 이동</a>
</body>
</html>