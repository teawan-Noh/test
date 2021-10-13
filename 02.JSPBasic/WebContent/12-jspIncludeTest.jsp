<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="13-menu.jsp">
		<jsp:param name="text" value="login join" />
	</jsp:include>
</body>
</html>


<!-- 
[지시어 include]
<%@ include file="10-copyright.jspf" %>
-매개변수 사용여부: X
-속성이름: file
-jsp container가 페이지를 서블릿으로 변환할 때 내용이 합쳐진다.  //고정된 메뉴를 보여줄때 사용
-확장자: jspf

[액션 include]
<jsp:include page="13-menu.jsp">
	<jsp:param name="text" value="login join" />
</jsp:include>
-매개변수 사용여부: O
-속성이름: page
-요청 시점에 합쳐진다.  //달라지는 메뉴를 보여주고 싶을때사용
-확장자: jsp
 -->