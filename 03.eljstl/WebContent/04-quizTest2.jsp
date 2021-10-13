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
	<table border="1" class="table table-bordered table-sm">
	수도
	<tr>
		<th>국가</th>
		<th>수도</th>
	</tr>
	<c:forEach var="capital" items="${capitals}">
		<tr>
	   		<td>${capital.key} </td>
	   		<td>${capital.value} </td>
		</tr>
	</c:forEach>
    </table>
    
    <br/>
	
	<table border="1" class="table table-bordered table-sm">
	대도시
	<tr>
		<th>국가</th>
		<th>도시</th>
	</tr>
	<c:forEach var="country" items="${city}">
		<tr>
	   		<td>${country.key} </td>
	   		<td>
	   			<c:forEach var="citys" items="${country.value}">
	   				${citys}
	   			</c:forEach>
	   		</td>
		</tr>
	</c:forEach>
    </table>
</div>
</body>
</html>