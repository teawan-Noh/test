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
	input{
		border: 0; 
		width: 100%;
		background-color: none;
	}
	select{
		border: 0; 
		width: 100%;
		background-color: none;
	}
	h1{
		text-align:center;
	}
	a{
		text-decoration:none;
		color: black;
	}
	.showList{
		text-align:right;
	}
	th{
		text-align:center;
		font-color: white;
		font-size: 20px;
	}
	td{
		width: 50%;
		font-weight: bold;
	}
	#button{
		display: flex;
		justify-content: space-between;
		
	}
	.button{
		width: 49%;
		height: 50px;
		background-color: #64dd17;
		color: white;
		font-weight: bold;
	}
</style>
</head>
<body>
<div class="container mt-3" >	
	<form method="post">
		<h1>사원정보</h1>
		<p class="showList"><a href="emp_search">[사원리스트보기]</a><p>
		<table border="1" class="table table-striped">
		<thead class="table-dark">
			<tr>
				<th colspan="2">사원 정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
		   		<td>사원번호 </td>
		   		<td>${empDetail.empno} </td>
			</tr>
			<tr class="table-primary">
		   		<td>사원이름 </td>
		   		<td>${empDetail.ename} </td>
			</tr>
			<tr>
		   		<td>업무 </td>
		   		<td>${empDetail.job} </td>
			</tr>
			<tr class="table-primary">
		   		<td>매니저 </td>
		   		<td>${empDetail.mgr} </td>
			</tr>
			<tr>
		   		<td>고용일 </td>
		   		<td>${empDetail.hiredate} </td>
			</tr>
			<tr class="table-primary">
		   		<td>급여 </td>
		   		<td>${empDetail.sal} </td>
			</tr>
			<tr>
		   		<td>상여 </td>
		   		<td>${empDetail.comm} </td>
			</tr>
			<tr class="table-primary">
		   		<td>부서 </td>
		   		<td>
		   			<c:if test="${empDetail.deptno eq '10'}">개발팀</c:if>
		   			<c:if test="${empDetail.deptno eq '20'}">인사팀</c:if>
		   			<c:if test="${empDetail.deptno eq '30'}">재무팀</c:if>
				</td>
			</tr>
		</tbody>	
	    </table>
	    <div id="button">
		    <a href="emp_modify?empno=${empDetail.empno}"><button type="button">수정하기</button></a>
	    	<a href="emp_delete?empno=${empDetail.empno}"><button type="button">삭제</button></a>
	    </div>
 	</form>
</div>
</body>
</html>