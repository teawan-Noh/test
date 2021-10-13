<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%
	pageContext.setAttribute("J", 31); 
	pageContext.setAttribute("S", 8); 
	pageContext.setAttribute("P", 22); 
	pageContext.setAttribute("E", null); 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	${J}, ${S}, ${P}, ${E}
	
<h4>산술연산자</h4>
${J + S}
${J - S}
${J * S}
${J / S}
${J % S}

<h4>관계연산자</h4>
&#36{J} :${J}, &#36{S} : ${S} <br>
&#36{J < S} : ${J < S} <br>
&#36{J > S} : ${J > S} <br>
&#36{J >= S} : ${J >= S} <br>
&#36{J <= S} : ${J <= S} <br>
&#36{J == S} : ${J == S} <br>
&#36{J != S} : ${J != S} <br>

<h4>논리연산자</h4>
${J < S && P < S }
${J < S || P < S }
${!(J == S)}

<h4>삼항연산자</h4>
${(J == p) ? "같다" : "다르다" }

<h4>empty : 값이 null이거나 길이가 0인 문자열을 true로 반환</h4>
${empty J}
${empty E}

</body>
</html>