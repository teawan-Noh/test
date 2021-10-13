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
	<form method="post" action="emp_save">
		<h1>사원등록</h1>
		<p class="showList"><a href="emp_search">[사원리스트보기]</a><p>
		<table border="1" class="table table-striped">
		<thead class="table-dark">
			<tr>
				<th colspan="2">사원등록</th>
			</tr>
		</thead>
		<tbody>
			<tr>
		   		<td>사원번호 </td>
		   		<td><input type="text" name="empno" disabled> </td>
			</tr>
			<tr class="table-primary">
		   		<td>사원이름 </td>
		   		<td><input type="text" name="ename"> </td>
			</tr>
			<tr>
		   		<td>업무 </td>
		   		<td><input type="text" name="job"> </td>
			</tr>
			<tr class="table-primary">
		   		<td>매니저 </td>
		   		<td><input type="text" name="mgr"> </td>
			</tr>
			<tr>
		   		<td>고용일 </td>
		   		<td><input type="text" name="hiredate"> </td>
			</tr>
			<tr class="table-primary">
		   		<td>급여 </td>
		   		<td><input type="text" name="sal"> </td>
			</tr>
			<tr>
		   		<td>상여 </td>
		   		<td><input type="text" name="comm"> </td>
			</tr>
			<tr class="table-primary">
		   		<td>부서 </td>
		   		<td>
		   			<select name="dname">
		   			<c:forEach var="dept" items="${deptList}">
			  			<option>${dept.dname }</option>
		   			</c:forEach>
					</select> 
				</td>
			</tr>
		</tbody>	
	    </table>
	    <div id="button">
		    <input class="button" type="reset" value="원래대로">
	    	<input class="button" type="submit" value="등록">
	    </div>
 	</form>
</div>
</body>
</html>