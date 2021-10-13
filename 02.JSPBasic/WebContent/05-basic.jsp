<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@page import="app02.Counter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>*스크립틀릿가 표현식 사용법</h5>
	<% out.println(Counter.getCount()); %>
	<%= Counter.getCount() %> 
	
	<hr />
	<h5>*선언문 사용법*</h5>
	<%! static int doubleCount = 1; %>
	<%! static int getDoubleCount(){
			doubleCount = doubleCount*2;
			return doubleCount;
		}  
	%>
	<%= getDoubleCount() %> 
	<%! String email = null; %>
	
	<h5>*서블릿과 jsp 생존범위 비교*</h5>
	<%
		getServletContext().setAttribute("a", "context");
		out.println(getServletContext().getAttribute("a"));
		application.setAttribute("a", "application"); //덮어 쓰기 된다
		out.println(getServletContext().getAttribute("a")); 
		
		request.getSession().setAttribute("b", "session");
		session.setAttribute("b", "session2");
		out.println(session.getAttribute("b")); //session2 불러짐
		
		request.setAttribute("c", "request");
		
		pageContext.setAttribute("d", "d");
	%>
	<hr/>
	<h5>*pageContext 속성 설정하고 읽기*</h5>
	
	<%
		//pageContext.setAttribute("scope", "page"); //page안에서만 사용가능
		pageContext.setAttribute("scope", "request", PageContext.REQUEST_SCOPE);
		pageContext.setAttribute("scope", "session", PageContext.SESSION_SCOPE);
		pageContext.setAttribute("scope", "application", PageContext.APPLICATION_SCOPE);
	%>
	
	<% //pageContext.getAttribute("scope") %>
	<% //pageContext.getAttribute("scope", PageContext.REQUEST_SCOPE) %>
	<% //pageContext.getAttribute("scope", PageContext.SESSION_SCOPE) %>
	<% //pageContext.getAttribute("scope", PageContext.APPLICATION_SCOPE) %>
	
	<%= pageContext.findAttribute("scope") %> <!-- 작은범위부터 가져온다  -->
</body>
</html>