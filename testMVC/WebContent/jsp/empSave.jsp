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
		justify-content: center;
	}
	.button{
	
		width: 30%;
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
		<p class="showList"><a href="emp_search">[사원검색하기]</a><p>
		<table border="1" class="table table-striped">
		<thead class="table-dark">
			<tr>
				<th colspan="2">사원등록</th>
			</tr>
		</thead>
		<tbody>
			<tr class="table-primary">
		   		<td>사원이름 </td>
		   		<td><input type="text" name="ename"> </td>
			</tr>
			<tr class="table-secondary">
		   		<td>업무 </td>
		   		<td><input type="text" name="job"> </td>
			</tr>
			<tr class="table-primary">
		   		<td>급여 </td>
		   		<td><input type="text" name="sal"> </td>
			</tr>
			<tr class="table-secondary">
		   		<td>부서 </td>
		   		<td>
		   			<select name="dname">
		   			<c:forEach var="dept" items="${deptList}">
			  			<option>${dept.dname}</option>
		   			</c:forEach>
					</select> 
				</td>
			</tr>
		</tbody>	
	    </table>
	    <br/>
	    <div id="button">
	    	<input class="button" type="submit" value="등록">
	    </div>
 	</form>
</div>
</body>
</html>