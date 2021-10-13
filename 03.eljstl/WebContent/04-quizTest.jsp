<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
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
	
<div class="container mt-3">	
	<h3>과제 1</h3>
	간단한 표로 표시한 책 목록
	<table border="1" class="table table-bordered table-sm">
		<thead>
		<tr>
			<th>ISBN</th>
			<th>제목</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${bookList}">
		<tr>
	   		<td>${book.isbn} </td>
	   		<td>${book.name} </td>
		</tr>
		</c:forEach>
		</tbody>
    </table>
    
	<br/>
	
	<table border="1" class="table table-dark table-striped">
	스타일을 입힌 표로 표시한 책 목록
		<thead>
		<tr>
			<th>ISBN</th>
			<th>제목</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${bookList}">
		<tr>
	   		<td>${book.isbn} </td>
	   		<td>${book.name} </td>
		</tr>
		</c:forEach>
		</tbody>
    </table>
    
    <br/>
    
    ISBNs만 표시:	
    <c:forEach var="book" items="${bookList}">
	   	${book.isbn}
	</c:forEach> 
	
	<br/><br/>
	
	<table border="1" class="table2">
	수도
		<tr>
			<th>국가</th>
			<th>수도</th>
		</tr>
	<c:forEach var="nation" items="${nation}">
		<tr>
	   		<td>${nation.key} </td>
	   		<td>${nation.value} </td>
		</tr>
	</c:forEach>
    </table>
    
    <br/>
	
	<table border="1" class="table2">
	대도시
		<tr>
			<th>국가</th>
			<th>도시</th>
		</tr>
	<c:forEach var="citys" items="${city}">
		<tr>
	   		<td>${citys.key} </td>
	   		<td>${citys.value} </td>
		</tr>
	</c:forEach>
    </table>
</div>
</body>
</html>