<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Date today = new Date(); -->
	<jsp:useBean id="today" class="java.util.Date" />
	<%=today %>
	
	<jsp:useBean id="emp" class="app02.Emp" /> <!-- Emp emp = new Emp(); -->
	<jsp:setProperty name="emp" property="firstName" value="길동" /> <!-- emp.setFristName("길동"); -->
	<jsp:setProperty name="emp" property="lastName" value="홍" /> <!-- emp.setLastName("홍"); -->
	
	<jsp:useBean id="emp2" class="app02.Emp" /> <!-- Emp emp2 = new Emp(); -->
	<jsp:setProperty name="emp2" property="firstName" value="태완" /> <!-- emp.setFristName("태완"); -->
	<jsp:setProperty name="emp2" property="lastName" value="노" /> <!-- emp.setLastName("노"); -->
	
	<jsp:getProperty name="emp2" property="lastName" />
	<jsp:getProperty name="emp2" property="firstName" />
	
</body>
</html>