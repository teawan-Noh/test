<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		out.println("Buffer size: " + response.getBufferSize() + "<br/>");	
		out.println("Session id: " + session.getId() + "<br/>");	
		out.println("Servlet name: " + config.getServletName() + "<br/>");	
		out.println("Servlet info: " + application.getServerInfo() + "<br/>");	
		
		out.println(page.getClass());
		/*out, request, response, session, config, application, page, pageContext, exception */
	%>
</body>
</html>