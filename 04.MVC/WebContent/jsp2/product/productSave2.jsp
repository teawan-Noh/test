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
<style type="text/css">
.button{
		width: 49%;
		height: 50px;
		background-color: #64dd17;
		color: white;
		font-weight: bold;
		border: 0;
		}
th{
	text-align:center;
}
h1{
	text-align:center;
	padding: 25px;
}
input{
	border:0;
	}
</style>
</head>
<body>
<div class="container mt-3" >	
	<form method="post" action="product_save">
		<h1>상품 등록</h1>
		<table border="1" class="table table-striped table-bordered" >
		<thead class="table-dark">
			<tr>
				<th colspan="2">상품등록</th>
			</tr>
		</thead>
		<tbody>
			<tr>
		   		<td>상품명 </td>
		   		<td><input type="text" name="name"> </td>
			</tr>
			<tr>
		   		<td>설명 </td>
		   		<td><input type="text" name="description"> </td>
			</tr>
			<tr>
		   		<td>가격 </td>
		   		<td><input type="text" name="price"> </td>
			</tr>
		</tbody>	
	    </table>
	    <div id="button">
		    <input class="button" type="reset" value="원래대로">
	    	<input class="button" type="submit" value="상품 등록">
	    </div>
 	</form>
</div>
</body>
</html>