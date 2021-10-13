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
<div class="container mt-3" >	

	<h3>productList</h3>
	<c:if test="${!empty productList}">
	<table border="1" class="table table-hover table-bordered table-sm">
	<thead>
		<tr>
			<th>상품명</th>
			<th>설명</th>
			<th>가격</th>
			<th>상세보기</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${productList}">
		<tr>
	   		<td>${product.name} </td>
	   		<td>${product.description}</td>
	   		<td>${product.price}</td>
	   		<td><a href="product_detail?productid=${product.productid}">상세보기</a></td>
		</tr>
		</c:forEach>
	</tbody>
    </table>
	</c:if>
	<c:if test="${empty productList}">상품이 없습니다.</c:if>
</div>
</body>
</html>