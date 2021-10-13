<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	//라디오 버튼
	var gender = "${gender_val}";
	
	$('input[type=radio]').each(function(){
		if(gender == $(this).val()){
			$(this).attr('checked','checked')
		}
	});
	
	//체크박스
	<c:forEach var="vehicle" items="${vehicle_val}">
		var value = "${vehicle}";
		
		$('input[type=checkbox]').each(function(){
			if(value == $(this).val()){
				$(this).attr('checked','checked')
			}
		});
	</c:forEach>
	
	//select
	var car = "${car_val}";
	
	$('select option').each(function(){
		if(car == $(this).val()){
			$(this).attr('selected','selected')
		}
	});
	
});
</script>
</head>
<body>

	<h4>The input Element 1) - type: text,password, reset, submit</h4>
	<form method="post" action="input_element1">
		User name: <br/><input type="text" name="name" value="${name_val}"/><br/>
		User password: <br/><input type="password" name="password" value="${pwd_val}"/><br/>
	</form>
	
	<h4>The input Element 1) - type: radio</h4>
	<form method="post" action="input_element2">
		<input type="radio" name="gender" value="male" disabled/> Male <br/>
		<input type="radio" name="gender" value="female" disabled/> Female <br/>
		<input type="radio" name="gender" value="other" disabled/> Other <br/>
	</form>
	
	<h4>The input Element 1) - type: checkbox</h4>
	<form method="post" action="input_element3">
		<input type="checkbox" name="vehicle" value="bike" disabled/> 자전거 <br/>
		<input type="checkbox" name="vehicle" value="car" disabled/> 자동차 <br/>
	</form>
	
	<h4>The select Element</h4>
	<form method="post" action="select_element">
		<select name='cars'>
		  	<option value='volvo'>Volvo</option>
		  	<option value='saab'>Saab</option>
		  	<option value='flat'>Flat</option>
		  	<option value='audi'>Audi</option>
		</select>
	</form>
	
	<h4>The textarea Element</h4>
	<form method="post" action="textarea_element">
		<textarea name="message" rows="10" cols="30">${message_val}</textarea>
	</form>
</body>
</html>