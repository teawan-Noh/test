<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/bootstrapInclude.jsp"/>
<style>
	.header{
		display: flex;
		justify-content: space-between;
		padding: 10px 0;
	}
	h1{
		padding: 10px;
		text-align: center;
	}
	.table{
		text-align: center;
	}
</style>
</head>
<body>
	<div class="container mt-3">
	<h1>일반게시판(리스트)</h1>
		<div class="header">
			<div>
				<input type="text" name="search" placeholder="제목으로 검색" />
				<button type="submit">검색</button>
			</div>
			<div>
				<c:if test="${member == null}">
					<a href="../index.jsp">[새글작성]</a>
				</c:if>
				<c:if test="${member != null}">
					<a href="board_save">[새글작성]</a>
				</c:if>
			</div>
		</div>
			<table class="table table-hover table-bordered">
			<thead>
				<tr class="table-dark">
					<th>번호</th>
			      	<th>제목</th>
			      	<th>작성자</th>
			      	<th>작성일자</th>
			      	<th>조회</th>
			    </tr>
		   </thead>
		   <tbody>
		   		<c:forEach var="board" items="${boardList}">
			    <tr>
			      <td>${board.no}</td>
			      <td>${board.subject}</td>
			      <td>${board.id}</td>
			      <td>${board.wdate}</td>
			      <td>${board.cnt}</td>
			    </tr>
			    </c:forEach>
			  </tbody>
			</table>
	</div>
</body>
</html>