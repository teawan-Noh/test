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

	<h3>empList</h3>
	<c:if test="${!empty empList}">
	<table border="1" class="table table-hover table-bordered table-sm">
	<thead>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>업무</th>
			<th>부서</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="emp" items="${empList}">
		<tr>
	   		<td>${emp.empno} </td>
	   		<td>${emp.ename}</td>
	   		<td>${emp.job}</td>
	   		<c:if test="${emp.deptno eq '10'}">
	   		<td>개발팀</td>
			</c:if>
	   		<c:if test="${emp.deptno eq '20'}">
	   		<td>인사팀</td>
			</c:if>
	   		<c:if test="${emp.deptno eq '30'}">
	   		<td>재무팀</td>
			</c:if>
	   		<td><a href="emp_detail?empno=${emp.empno}">상세보기</a> </td>
		</tr>
		</c:forEach>
	</tbody>
    </table>
	</c:if>
	<c:if test="${empty empList}">메모가 없습니다.</c:if>
</div>
</body>
</html>