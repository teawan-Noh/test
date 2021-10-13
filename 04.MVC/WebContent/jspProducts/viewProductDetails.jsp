<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	}
 </style>
</head>
<body>
<div class="container mt-3" >	
	<h3>제품 상세정보</h3><br/>
			상품ID : ${productDetail.id} <br/>
			상품명 : ${productDetail.name} <br/>
			설명 : ${productDetail.description} <br/>
			가격 : ${productDetail.price} <br/>
	<br/>
	<a href="addToCart?id=${productDetail.id}">장바구니에 담기</a>
</div>
</body>
</html>