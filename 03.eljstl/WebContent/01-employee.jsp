<%@page import="el.model.Employee"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h4>1-1 객체 변수 값 가져오기</h4>
 ${addr.city}
 <hr>
 ${addr.country}
 <hr>
 ${addr.zipcode}
 <hr>
 ${addr["city"]}
 
 
 <h4>1-2 객체 변수가 참조형인 경우 값 가져오기</h4>
 ${emp.id}
 ${emp.name}
 ${emp.address.streetName}
 ${emp.address.city}
 ${emp.address.zipcode}
 
 <h4>2-1 String 맵</h4>
 ${cap.korea}
 ${cap.china}
 
 <h4>2-2 객체를 포함한 맵</h4>
 ${empInfo.e.name}
 ${empInfo.e.address.streetName}
 
 <h4>3-1 배열</h4>
  ${iArray[2]}
  ${iArray[0]}
 
 <h4>3-2 객체 배열</h4>
  ${eArray[1].name}
  ${eArray[1].address.country}
  
 <h4>4-1 리스트</h4>
  ${strList[2]}
  
 <h4>4-2 객체 리스트</h4>
  ${empList[1].name}
  
  <table border="1">
	<th>id</th>
	<th>name</th>
	<th>주소</th>
	<tr><!-- 첫번째 줄 시작 -->
	    <td>${empList[0].id}</td>
	    <td>${empList[0].name}</td>
	    <td>${empList[0].address.country} ${empList[0].address.streetName} ${empList[0].address.city} </td>
	</tr><!-- 첫번째 줄 끝 -->
	<tr><!-- 두번째 줄 시작 -->
	    <td>${empList[1].id}</td>
	    <td>${empList[1].name}</td>
	    <td>${empList[1].address.country} ${empList[1].address.streetName} ${empList[1].address.city} </td>
	</tr><!-- 두번째 줄 끝 -->
	
	<% 	
		List<Employee> empList = (List<Employee>)request.getAttribute("empList");
		for(Employee e : empList){
	%>	
		<tr>
	   		<td><%= e.getId() %></td>
	   		<td><%= e.getName() %></td>
	   		<td><%= e.getAddress().getCountry()%> <%= e.getAddress().getCity()%></td>
		</tr>
	<% 	
		} 
	%>
  
    </table>
 
 
</body>
</html>