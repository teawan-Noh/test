<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.th{
		background-color : #ccb3ff;
	}
	.td{
		background-color : #eee6ff;
	}
	
	.th2{
		background-color : #009933;
	}
	table {
		border-color : red;
	}
	.table2 {
		border-color : #4dff88;
	}
</style>
</head>
<body>
	<hr/>
	<h3>forEach 사용 예</h3>
	<hr/>
	<!-- for(Employee e : empList)  e 가 subject, empList가 ${subjectList}-->
	<c:forEach var="subject" items="${subjectList}" varStatus="subjectCount">
		${subjectCount.count} ${subject}<br/>
	</c:forEach>	
	
	<hr/>
	<h3>if 사용 예</h3>
	<hr/>
	<c:if test="${userType == 'member'}">
		당신은 회원입니다.
	</c:if>
	
	<hr/>
	<h3>choose, when, otherwies 사용 예</h3>
	<hr/>
	<c:choose>
		<c:when test="${userType == 'member'}">당신은 회원입니다2.<br/></c:when>
		<c:when test="${userType != 'member'}">당신은 회원이 아닙니다.<br/></c:when>
		<c:otherwise>넌 누구니?</c:otherwise>
	</c:choose>	
	
	<hr/>
	<h3>set 사용 예</h3>
	<hr/>
	<c:set var="name" value="javassam"/>
	${name}
	
	<c:set target="${dog}" property="name" value="멍멍이"/>
	${dog.name}
	
	
	<hr/>
	<h3>과제 1</h3>
	
	
	<c:set target="${bookList[0]}" property="name" value="토비의 스프링 3"/>
	<c:set target="${bookList[0]}" property="ISBN" value="9788960771468"/>
	<c:set target="${bookList[1]}" property="name" value="Node.js 노드제이에스 프로그래밍"/>
	<c:set target="${bookList[1]}" property="ISBN" value="9788960772761"/>
	<c:set target="${bookList[2]}" property="name" value="알짜만 골라 배우는 자바 구글앱엔진"/>
	<c:set target="${bookList[2]}" property="ISBN" value="9788960771512"/>
	
	<table border="1">
	간단한 표로 표시한 책 목록
	<th>ISBN</th>
	<th>제목</th>
	
	<c:forEach var="book" items="${bookList}">
		<tr>
	   		<td>${book.ISBN} </td>
	   		<td>${book.name} </td>
		</tr>
	</c:forEach>
    </table>
    
	<br/>
	
	<table border="1" class="table">
	스타일을 입힌 표로 표시한 책 목록
	<th class="th">ISBN</th>
	<th class="th">제목</th>
	
	<c:forEach var="book" items="${bookList}">
		<tr>
	   		<td class="td">${book.ISBN} </td>
	   		<td class="td">${book.name} </td>
		</tr>
	</c:forEach>
    </table>
    
    <br/>
    
    ISBNs만 표시:	
    <c:forEach var="book" items="${bookList}">
	   	${book.ISBN}
	</c:forEach> 
	
	<br/><br/>
	
	<table border="1" class="table2">
	수도
	<th class ="th2">국가</th>
	<th class ="th2">수도</th>
	
	<c:forEach var="nation" items="${nation}">
		<tr>
	   		<td>${nation.key} </td>
	   		<td>${nation.value} </td>
		</tr>
	</c:forEach>
    </table>
    
    <br/>
	
	<table border="1" class="table2">
	대도시
	<th class ="th2">국가</th>
	<th class ="th2">도시</th>
	
	<c:forEach var="citys" items="${city}">
		<tr>
	   		<td>${citys.key} </td>
	   		<td>${citys.value} </td>
		</tr>
	</c:forEach>
    </table>
	
</body>
</html>