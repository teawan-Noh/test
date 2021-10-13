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
<style>
	a{
		text-decoration: none;
		color: black;
	}
	.products{
		text-align: right;
	}
	h2{
		text-align: center;
	}
	tfoot{
		border-top: 2px solid black;
	}
</style>
</head>
<body>
<div class="container mt-3" >	

	<h2>장바구니 목록</h2>
	<p class="products"><a href="products">[상품목록으로 이동]</a><p>
	<c:if test="${!empty cartList}">
	<table border="1" class="table table-hover table-bordered table-sm">
	<thead>
		<tr>
			<th>상품명</th>
			<th>수량</th>
			<th>가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="product" items="${cart}">
		<tr>
	   		<td>${product.name} </td>
	   		<td>1</td>
	   		<td>${product.price}</td>
		</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr >
			<td>합계 </td>
	   		<td>${count} </td>
	   		<td>${total} </td>
		</tr>
	</tfoot>
    </table>
	</c:if>
	<c:if test="${empty cartList}">상품이 없습니다.</c:if>
</div>
</body>
</html>