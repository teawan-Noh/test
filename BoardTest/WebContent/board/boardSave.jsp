<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/bootstrapInclude.jsp"/>
<style>
	.header{
		display: flex;
		justify-content: space-between;
		padding: 10px 0;
	}
	h1{
		padding: 10px;
		text-align: center;
	}
	.table{
		text-align: center;
	}
	.showList, #button{
		text-align: right;
	}
	textarea, input{
		width: 100%;
	}
</style>
</head>
<body>
<div class="container mt-3" >	
	<form method="post" action="board_save">
		<h1>일반게시판(글작성)</h1>
		<p class="showList"><a href="board_list">[목록보기]</a><p>
		<table border="1" class="table table-striped">
		<thead class="table-dark">
			<tr>
				<th colspan="2">글작성</th>
			</tr>
		</thead>
		<tbody>
			<tr class="table-primary">
		   		<td>작성자 </td>
		   		<td>${customerId}
					<input type="text" name="id" value="${customerId}" hidden="hidden"/> <br/>
				</td>
			</tr>
			<tr>
		   		<td>제목 </td>
		   		<td><input type="text" name="subject"> </td>
			</tr>
			<tr class="table-primary">
		   		<td>내용 </td>
		   		<td>
		   			<textarea cols="50" rows="10" name="content"></textarea>
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