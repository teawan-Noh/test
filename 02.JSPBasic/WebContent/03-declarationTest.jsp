<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.Date"%>

<%! // !: 선언문
	String message = "HI!!"; //선언문안에 선언하면 객체변수 
	
	public String getToday(){
		return new Date().toString();
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	오늘은<%= getToday() %> <!-- = : 표현식 -->
</body>
</html>