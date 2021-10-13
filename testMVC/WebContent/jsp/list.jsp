<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"></script>
<style>
	.register{
		text-align: right;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
<div class="container mt-3" >	
	<form method="post" action="emp_search_result">
		<input type="text" name="startDate" placeholder="고용 일자"> ~
		<input type="text" name="endDate" placeholder="고용 일자">
		<button type="submit" class="btn btn-primary">검색</button> <br/>
	</form>
	<p class="register"><a href="emp_input">[사원등록하기]</a><p>
	<c:if test="${!empty empList}">
	<table border="1" class="table table-hover table-bordered table-sm">
	<thead>
		<tr class="table-primary">
			<th>사원번호</th>
			<th>사원이름</th>
			<th>고용일자</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="emp" items="${empList}">
		<tr>
	   		<td>${emp.empno} </td>
	   		<td>${emp.ename}</td>
	   		<fmt:parseDate value="${emp.hiredate}" var="dateFmt" pattern="yyyy-MM-dd HH:mm:ss"/>
	   		<td><fmt:formatDate value="${dateFmt}"  pattern="yyyy-MM-dd"/></td>
		</tr>

		</c:forEach>
	</tbody>
    </table>
	</c:if>
	<c:if test="${empty empList}">
		<span>검색결과가 없습니다.</span>
	</c:if>
</div>
</body>
</html>